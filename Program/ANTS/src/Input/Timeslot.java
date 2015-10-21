/**
 * 
 */
package Input;

import java.util.ArrayList;

/**
 * @author Caleb Piekstra
 *
 * A timeslot is simply a way to indicate which
 * events and how many participants can be scheduled on
 * a given weekday.
 * 
 * For example, it may be that all "Essay" events may
 * only be scheduled on a "Friday" timeslot and only
 * one or two participants can have "Oral Presentations"
 * scheduled on a "Wednesday" timeslot.
 */
public class Timeslot {
	/* Instance Variables */
	// The weekday of the timeslot
	public final String day;
	// The events that can be scheduled in this timeslot
	private ArrayList<EventParameters> allowedEvents = null;
	
	public Timeslot(String day) {
		this.day = day;
	}
	
	/**
	 * 
	 * @return
	 */
	public ArrayList<EventParameters> getAllowedEvents() {
		return this.allowedEvents;
	}
	
	/**
	 * 
	 * @param event
	 * @param softMin
	 * @param softMax
	 * @param hardMin
	 * @param hardMax
	 */
	public void addAllowedEvent(Event event, int softMin, int softMax, int hardMin, int hardMax) {
		this.allowedEvents.add(new EventParameters(event, softMin, softMax, hardMin, hardMax));
	}	

	/**
	 * 
	 * @author Caleb Piekstra
	 *
	 */
	private class EventParameters {
		// TODO
		public final Event event;
		// The preferred minimum number of participants 
		// that can be scheduled for this event
		public final int softMin;
		// The preferred maximum number of participants 
		// that can be scheduled for this event
		public final int softMax;
		// The absolute minimum number of participants 
		// that can be scheduled for this event
		public final int hardMin;
		// The absolute maximum number of participants 
		// that can be scheduled for this event
		public final int hardMax;

		/**
		 * 
		 * @param event
		 * @param softMin
		 * @param softMax
		 * @param hardMin
		 * @param hardMax
		 */
		public EventParameters(Event event, int softMin, int softMax, int hardMin, int hardMax) {
			this.event = event;			
			this.softMin = softMin;			
			this.softMax = softMax;			
			this.hardMin = hardMin;			
			this.hardMax = hardMax;			
		}
	}
}
