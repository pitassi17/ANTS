/**
 * 
 */
package input;

import java.util.Date;

/**
 * @author Caleb Piekstra
 *
 * Special date ranges are blocks of time, in days, that
 * allow for an override to timeslot constraints. 
 * 
 * Special date ranges can be a single day or more, as the
 * dates in the range are inclusive.
 */
public class SpecialDaterange {
	// The first date (inclusive) in the date range
	private final Date startDate;
	// The final date (inclusive) in the date range
	private final Date endDate;
	
	/*
	 *  Whether or not events may be scheduled during the date range.
	 *  
	 *  Some special dates or date ranges (like holidays that are not
	 *  actual breaks from class) may still have events scheduled.
	 */
	private final boolean noEvents;
	
	// The 'name' of the special date range, i.e. "Fall Break"
	private final String name;
	
	/**
	 * The constructor
	 * 
	 * @param startDate The first date in the date range
	 * @param endDate The last date in the date range
	 * @param noEvents Whether or not events may be scheduled in 
	 * 	this date range
	 * @param name The name of the date range
	 */
	public SpecialDaterange(Date startDate, Date endDate, 
			boolean noEvents, String name) {
		this.startDate = startDate;
		this.endDate = endDate;
		this.noEvents = noEvents;
		this.name = name;
	}

	/**
	 * Gets the first date in the date range
	 * 
	 * @return the start date
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * Gets the last date in the date range
	 * 
	 * @return the end date
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * Gets whether or not events may be scheduled in this date range
	 * 
	 * @return A boolean indicating whether events may be scheduled 
	 * 	in this date range
	 */
	public boolean isNoEvents() {
		return noEvents;
	}

	/**
	 * Gets the name of the date range (i.e. "Fall Break")
	 * 
	 * @return the name of the date range
	 */
	public String getName() {
		return name;
	}		
}
