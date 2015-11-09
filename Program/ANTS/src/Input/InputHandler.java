package Input;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Dictionary;
import java.util.HashMap;
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
	private ArrayList<SpecialDaterange> specialDateranges;
	private Dictionary <String, Timeslot> timeslots;
	private ScheduleInformation scheduleInfo;

	public InputHandler(File file) {
		this.inputfile = file;
	}

	/**
	 * Reads the raw data from the CSV file and barfs it out as a string.
	 * <br>	<br>
	 * TODO: Will eventually filter out data into a ScheduleInformation object.
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

	private ArrayList<SpecialDaterange> parseSpecialDateRanges() {
		return null;
	}

	private Dictionary<String, Timeslot> parseTimeSlots() {
		return null;
	}

	public void createScheduleInformation() {
	}

	public ScheduleInformation getScheduleInformation() {
		return null;
	}
}
