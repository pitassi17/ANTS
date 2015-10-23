/**
 * 
 */
package Input;

/**
 * @author Caleb Piekstra
 *
 * An event to be scheduled 1 or more times in a semester.
 * 
 * Each participant will have to "attend" or "complete" this
 * event as many times as specified in the quantity variable.
 * 
 */
public class Event {
	// The name of the event (i.e. "Oral Presentation")
	private final String eventName;
	
	// The number of times this event occurs in a semester per participant
	private final int quantity;
	
	// The maximum number of times this event can be scheduled in any given week
	private final int maxPerWeek;
	
	// The priority for which this event is scheduled (lower value is higher priority)
	private final int priority;

	// An event that comes before this event
	private Event pairedWith = null;
	// Number of days this event occurs after the 'pairedWith' event
	// The value should be > 0 when in use
	private int pairingOffset = 0;
	
	/**
	 * The constructor
	 * 
	 * @param eventName The name of the event
	 * @param quantity The number of times the event occurs in a semester
	 * @param maxPerWeek The maximum number of times the event may occur in a week
	 * @param priority The priority of the event
	 */
	public Event(String eventName, int quantity, int maxPerWeek, int priority) {
		this.eventName = eventName;
		this.quantity = quantity;
		this.maxPerWeek = maxPerWeek;
		this.priority = priority;
	}
	
	/**
	 * Gets the name of the event
	 * 
	 * @return the event name
	 */
	public String getEventName() {
		return this.eventName;
	}

	/**
	 * Gets the number of times this event is scheduled in a semester
	 * per participant.
	 * 
	 * @return the number of times the event occurs for every participant
	 */
	public int getQuantity() {
		return this.quantity;
	}

	/**
	 * Gets the maximum number of times this event can occur in a
	 * single week.
	 * 
	 * @return the maximum per week
	 */
	public int getMaxPerWeek() {
		return this.maxPerWeek;
	}

	/**
	 * Gets the priority of the event.
	 * 
	 * @return the priority
	 */
	public int getPriority() {
		return this.priority;
	}

	/**
	 * Gets the event that this event is paired with. A paired event
	 * is an event that occurs prior to this event by an exact number
	 * of days.
	 * 
	 * @return the event this event is paired with
	 */
	public Event getPairedWith() {
		return this.pairedWith;
	}

	/**
	 * Sets the event that this event is paired with. A paired event
	 * is an event that occurs prior to this event by an exact number
	 * of days.
	 * 
	 * @param pairedWith the event to pair with this event
	 */
	public void setPairedWith(Event pairedWith) {
		this.pairedWith = pairedWith;
	}

	/**
	 * Gets the number of days between this event and the event it is
	 * paired with.
	 * 
	 * @return the number of days between this event and the paired event
	 */
	public int getPairingOffset() {
		return this.pairingOffset;
	}

	/**
	 * Sets the number of days between this event and the event it is
	 * paired with.
	 * 
	 * @param pairingOffset number of days between this event and the 
	 * paired event
	 */
	public void setPairingOffset(int pairingOffset) {
		this.pairingOffset = pairingOffset;
	}
}
