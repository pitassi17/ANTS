package input;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * Reads CSV file and parses relevant information for scheduler.
 * 
 * @author Bryce Matsuda
 * 
 */
public class InputHandler {

	private File inputfile;
	private Map<Event, EventParameters> events;
	private ArrayList<Participant> participants;
	private ArrayList<SpecialDateRange> specialDateranges;
	private Map<String, Timeslot> timeslots;
	private ScheduleInformation scheduleInfo;

	public InputHandler(File file) {
		this.inputfile = file;
	}

	/**
	 * Reads the raw data from the CSV file.
	 * 
	 * TODO: Remove debug print info eventually.
	 * 
	 */
	public void readFile() {
		events = parseEvents();	
		if (events != null) {
			System.out.println("List of Events");
			System.out.println("----------------");
			for (Map.Entry<Event, EventParameters> entry : events.entrySet()) {
				System.out.println(entry.getKey().getEventName());
			}
		}
		System.out.println("\n");
		participants = parseParticipants();
		if (!participants.isEmpty()){
			System.out.println("List of Participants");
			System.out.println("----------------");
			for (Participant p : participants){
				System.out.println(p.getName());
			}
		}
		System.out.println("\n");
		
		specialDateranges = parseSpecialDateRanges();
		
		if (!specialDateranges.isEmpty()) {
			System.out.println("List of Special Date Ranges");
			System.out.println("----------------");
			for (SpecialDateRange sdr : specialDateranges){
				System.out.println(sdr.getStartDate());
			}
		System.out.println("\n");
		}
		
		timeslots = parseTimeSlots();
		if (timeslots != null) {
			System.out.println("List of Timeslots");
			System.out.println("----------------");
			for (Map.Entry<String, Timeslot> timeslot : timeslots.entrySet()) {
				System.out.println(timeslot.getKey());
			}
		}
		
	}

	private Map<Event, EventParameters> parseEvents(){
		HashMap<Event, EventParameters> events = new HashMap<Event, EventParameters>();
		try {

			String eventStrLine;
			FileInputStream fstream = new FileInputStream(inputfile);
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

			while ((eventStrLine = br.readLine()) != null && !eventStrLine.contains("EVENT_NAME")) {
				// Skip until we find event names
			}

			String[] eventData = br.readLine().split(",");
			while (eventData.length != 0) {
				Event event = new Event(eventData[0], // event title
						Integer.parseInt(eventData[1]),  // quantity
						Integer.parseInt(eventData[2]), // max per week
						Integer.parseInt(eventData[3])); // priority

				EventParameters ep = new EventParameters(event, 0, 0, 0, 0);
				events.put(event, ep);
				eventData = br.readLine().split(",");
			}

			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return events;
	}

	private ArrayList<Participant> parseParticipants() {
		ArrayList<Participant> partList = new ArrayList<Participant>();
		try {

			String partStrLine;
			FileInputStream fstream = new FileInputStream(inputfile);
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

			while ((partStrLine = br.readLine()) != null && !partStrLine.contains("PERSON_NAME")) {
				// Skip until we find participants
			}

			String[] participantData = br.readLine().split(",");
			while (participantData.length != 0) {
				Participant part = new Participant(participantData[0]);
				partList.add(part);
				participantData = br.readLine().split(",");
			}

			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return partList;
	}

	private ArrayList<SpecialDateRange> parseSpecialDateRanges() {
		ArrayList<SpecialDateRange> sdrList = new ArrayList<SpecialDateRange>();
		try {

			String sdrStrLine;
			FileInputStream fstream = new FileInputStream(inputfile);
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

			while ((sdrStrLine = br.readLine()) != null && !sdrStrLine.contains("SPECIAL_DATE_START")) {
				// Skip until we find special date ranges section
			}

			String[] specialDateRangeData = br.readLine().split(",");
			while (specialDateRangeData.length != 0) {
				DateFormat format = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
				SpecialDateRange sdr = 
						new SpecialDateRange(format.parse(specialDateRangeData[0]),
											format.parse(specialDateRangeData[1]),
											 Boolean.parseBoolean(specialDateRangeData[2]),
											 "");
				sdrList.add(sdr);
				// TODO NullPointExceptions here after reading last date. Dunno why.
				specialDateRangeData = br.readLine().split(",");
			}

			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NullPointerException e) { // TODO Remove NPE catch after figuring out why it does that.
			return sdrList;
		}
		return sdrList;
	}

	private Map<String, Timeslot> parseTimeSlots() {
		HashMap<String, Timeslot> timeslots = new HashMap<String, Timeslot>();
		try {

			String timeslotStrLine;
			FileInputStream fstream = new FileInputStream(inputfile);
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

			while ((timeslotStrLine = br.readLine()) != null && !timeslotStrLine.contains("TIMESLOT_DAY")) {
				// Skip until we find timeslot section
			}

			/**
			 * When splitting strings with inner quotes, this ugly regex
			 * is the only way to keep the data intact.
			 * 
			 * Source: http://stackoverflow.com/a/1757107
			 */
			String[] timeslotData = br.readLine().split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)", -1);
			String[] softLimits = timeslotData[2].split(",");
			String[] hardLimits = timeslotData[3].split(",");
			
			while (softLimits.length > 1 && hardLimits.length > 1) {
				// When inner quotes are split, min comes out as "#
				// and max comes out as #", so we need to delete extra quote.
				String softmin = softLimits[0].replace("\"", "");
				String softmax = softLimits[1].replace("\"", "");
				String hardmin = hardLimits[0].replace("\"", "");
				String hardmax = hardLimits[1].replace("\"", "");
				
				Timeslot ts = new Timeslot(timeslotData[0],
										   Integer.parseInt(softmin),
										   Integer.parseInt(softmax),
										   Integer.parseInt(hardmin),
										   Integer.parseInt(hardmax));
				timeslots.put(timeslotData[0], ts);
				timeslotData = br.readLine().split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)", -1);
				softLimits = timeslotData[2].split(",");
				hardLimits = timeslotData[3].split(",");
			}

			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return timeslots;
	}

	public void createScheduleInformation() {
		scheduleInfo = new ScheduleInformation();
		
		for (Map.Entry<Event, EventParameters> entry : events.entrySet()) {
			scheduleInfo.addEvent(entry.getKey());
		}
		
		for (Participant p : participants){
			scheduleInfo.addParticipant(p);
		}
		
		for (SpecialDateRange sdr : specialDateranges){
			scheduleInfo.addspecialDaterange(sdr);
		}
		
		for (Map.Entry<String, Timeslot> timeslot : timeslots.entrySet()) {
			scheduleInfo.setTimeslot(timeslot.getKey(), timeslot.getValue());
		}
		
	}

	public ScheduleInformation getScheduleInformation() {
		return scheduleInfo;
	}
}
