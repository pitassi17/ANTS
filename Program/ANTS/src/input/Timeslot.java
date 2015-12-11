/**
 * 
 */
package input;

import java.util.ArrayList;

/**
 * @author Caleb Piekstra
 *
 * A timeslot is simply a way to indicate which
 * events and how many participants can be scheduled on
 * a given weekday.
 * 
 * For example, it may be that all "Essay" events may
 * only be scheduled on a "Friday" timeslot, and only
 * one to two participants can have "Oral Presentations"
 * scheduled on a "Wednesday" timeslot.
 * 
 * Note: There are only five timeslots, one for each weekday. 
 * These timeslots define the general structure of preferences
 * for how events can be scheduled for every week of the
 * semester. Any exceptions to these timeslots are handled with
 * the SpecialDaterange class.
 * 
 */
public class Timeslot {
	// The weekday of the timeslot
	private final String day;
	
	// The preferred minimum number of event occurrences for this timeslot 
	private final int overallSoftMin;
	// The preferred maximum number of event occurrences for this timeslot 
	private final int overallSoftMax;
	// The absolute minimum number of event occurrences for this timeslot
	private final int overallHardMin;
	// The absolute maximum number of event occurrences for this timeslot
	private final int overallHardMax;

	// A list of the events that can be scheduled in this timeslot along with
	// hard and soft limits on the number of occurrences of those events
	private ArrayList<EventParameters> allowedEvents = null;
	
	/**
	 * The constructor 
	 * 
	 * @param day The day of the timeslot (i.e. "Monday")
	 * @param overallSoftMin The preferred minimum number of occurrences between all events
	 * @param overallSoftMax The preferred maximum number of occurrences between all events
	 * @param overallHardMin The absolute minimum number of occurrences between all events
	 * @param overallHardMax The absolute maximum number of occurrences between all events
	 */
	public Timeslot(String day, int overallSoftMin, int overallSoftMax, int overallHardMin, int overallHardMax) {
		this.day = day;
		this.overallSoftMin = overallSoftMin;
		this.overallSoftMax = overallSoftMax;
		this.overallHardMin = overallHardMin;
		this.overallHardMax = overallHardMax;
	}
	
	/**
	 * Gets the name of the timeslot (a weekday name i.e. "Monday").
	 * 
	 * @return the day
	 */
	public String getDay() {
		return this.day;
	}

	/**
	 * Gets the preferred minimum number of event occurrences
	 * 
	 * @return the overall soft minimum
	 */
	public int getOverallSoftMin() {
		return this.overallSoftMin;
	}

	/**
	 * Gets the preferred maximum number of event occurrences
	 *  
	 * @return the overall soft maximum
	 */
	public int getOverallSoftMax() {
		return overallSoftMax;
	}

	/**
	 * Gets the absolute minimum number of event occurrences
	 *  
	 * @return the overall hard minimum
	 */
	public int getOverallHardMin() {
		return this.overallHardMin;
	}

	/**
	 * Gets the absolute maximum number of event occurrences
	 *  
	 * @return the overall hard maximum
	 */
	public int getOverallHardMax() {
		return this.overallHardMax;
	}
	
	/**
	 * Gets the list of events that are allowed to be scheduled in this
	 * timeslot by the scheduling algorithm.
	 * 
	 * @return The list of events that can be scheduled in this timeslot
	 */
	public ArrayList<EventParameters> getAllowedEvents() {
		return this.allowedEvents;
	}
	
	/**
	 * Adds an event to the list of events that are able to be scheduled in this timeslot
	 * 
	 * @param event The event that can be scheduled in this timeslot
	 * @param softMin The preferred minimum number of times this event can occur in this timeslot
	 * @param softMax The preferred maximum number of times this event can occur in this timeslot
	 * @param hardMin The absolute minimum number of times this event can occur in this timeslot
	 * @param hardMax The absolute maximum number of times this event can occur in this timeslot
	 */
	public void addAllowedEvent(Event event, int softMin, int softMax, int hardMin, int hardMax) {
		this.allowedEvents.add(new EventParameters(event, softMin, softMax, hardMin, hardMax));
	}	
}
