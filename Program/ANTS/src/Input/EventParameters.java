/**
 * 
 */
package input;

/**
 * @author Caleb Piekstra
 *
 * Pairs an event with constraints on the number of times 
 * it can occur in a timeslot.
 */
public class EventParameters {
	// An event that is able to be scheduled in a timeslot
	private final Event event;
	// The preferred minimum number of participants 
	// that can be scheduled for the event
	private final int softMin;
	// The preferred maximum number of participants 
	// that can be scheduled for the event
	private final int softMax;
	// The absolute minimum number of participants 
	// that can be scheduled for the event
	private final int hardMin;
	// The absolute maximum number of participants 
	// that can be scheduled for the event
	private final int hardMax;

	/**
	 * The constructor
	 * 
	 * @param event The event that can be scheduled in a timeslot
	 * @param softMin The preferred minimum number of times the event can occur in a timeslot
	 * @param softMax The preferred maximum number of times the event can occur in a timeslot
	 * @param hardMin The absolute minimum number of times the event can occur in a timeslot
	 * @param hardMax The absolute maximum number of times the event can occur in a timeslot
	 */
	public EventParameters(Event event, int softMin, int softMax, int hardMin, int hardMax) {
		this.event = event;			
		this.softMin = softMin;			
		this.softMax = softMax;			
		this.hardMin = hardMin;			
		this.hardMax = hardMax;			
	}

	/**
	 * Gets the event tied to a timeslot
	 * 
	 * @return the event
	 */
	public Event getEvent() {
		return this.event;
	}

	/**
	 * Gets the preferred minimum number of participants that can be scheduled for the event
	 * 
	 * @return the soft minimum
	 */
	public int getSoftMin() {
		return this.softMin;
	}

	/**
	 * Gets the preferred maximum number of participants that can be scheduled for the event
	 * 
	 * @return the soft maximum
	 */
	public int getSoftMax() {
		return this.softMax;
	}

	/**
	 * Gets the absolute minimum number of participants that can be scheduled for the event
	 * 
	 * @return the hard minimum
	 */
	public int getHardMin() {
		return this.hardMin;
	}

	/**
	 * Gets the absolute maximum number of participants that can be scheduled for the event
	 * 
	 * @return the hard maximum
	 */
	public int getHardMax() {
		return this.hardMax;
	}
}
