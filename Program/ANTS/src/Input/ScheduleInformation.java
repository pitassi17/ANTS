/**
 * 
 */
package input;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Caleb Piekstra
 *
 * This class allows for the storage of all information that
 * is written in the program's input file by the end-user.
 * 
 * The program's scheduling algorithm will use this information
 * to generate a schedule matching the constraints and preferences
 * contained here.
 */
public class ScheduleInformation {
	// A list of all events in a semester
	private ArrayList<Event> events = new ArrayList<Event>();
	
	// A list of all of the students in the class
	private ArrayList<Participant> participants = new ArrayList<Participant>();
	
	// A list of timeslots (weekdays)
	private HashMap<String, Timeslot> timeslots = new HashMap<String, Timeslot>();
	
	// A list of special date-ranges (used to override timeslots) 
	private ArrayList<SpecialDaterange> specialDateranges = new ArrayList<SpecialDaterange>();
	
	/**
	 * The constructor
	 */
	public ScheduleInformation() {	
//		// Put weekdays in the timeslots dict
		this.timeslots.put("Monday", null);
		this.timeslots.put("Tuesday", null);
		this.timeslots.put("Wednesday", null);
		this.timeslots.put("Thursday", null);
		this.timeslots.put("Friday", null);
	}
	
	/**
	 * Gets the list of events contained in the schedule 
	 * information
	 * 
	 * @return The list of events
	 */
	public ArrayList<Event> getEvents() {
		return this.events;
	}
	
	/**
	 * Adds an event to the list of events
	 *  
	 * @param event The event to add
	 */
	public void addEvent(Event event) {
		this.events.add(event);
	}
	
	/**
	 * Gets the list of participants contained in the schedule 
	 * information
	 * 
	 * @return The list of participants
	 */
	public ArrayList<Participant> getParticipants() {
		return this.participants;
	}
	
	/**
	 * Adds a participant to the list of participants
	 * 
	 * @param participant The participant to add
	 */
	public void addParticipant(Participant participant) {
		this.participants.add(participant);
	}
	
	/**
	 * Gets the list of special dateranges contained in the 
	 * schedule information
	 * 
	 * @return The list of special dateranges
	 */
	public ArrayList<SpecialDaterange> getSpecialDateranges() {
		return this.specialDateranges;
	}
	
	/**
	 * Adds a special daterange to the list of special dateranges
	 * 
	 * @param specDate The special daterange to add
	 */
	public void addspecialDaterange(SpecialDaterange specDate) {
		this.specialDateranges.add(specDate);
	}
	
	/**
	 * Gets the list of timeslots contained in the schedule 
	 * information
	 * 
	 * @return The list of timeslots
	 */
	public HashMap<String, Timeslot> getTimeslots() {
		return this.timeslots;
	}
	
	/**
	 * Gets a timeslot from the list of timeslots
	 * 
	 * @param weekday The day of the week corresponding to the 
	 * 	desired timeslot
	 * @return The timeslot corresponding to weekday
	 */
	public Timeslot getTimeslot(String weekday) {
		return this.timeslots.get(weekday);
	}	
	
	/**
	 * Sets the timeslot corresponding to the weekday
	 * 
	 * @param weekday The name of the weekday of the timeslot
	 * @param timeslot The timeslot to set
	 */
	public void setTimeslot(String weekday, Timeslot timeslot) {
		this.timeslots.put(weekday, timeslot);
	}
}
