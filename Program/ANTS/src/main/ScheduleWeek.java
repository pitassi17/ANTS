package main;

/**
 * @author Caleb Piekstra
 * 
 * Manages all of the data for a single week in the schedule
 *
 */
public class ScheduleWeek {

	private final int weekNumber;
	private final ScheduleWeekday[] weekdays;
	
	/**
	 * 
	 * @param week
	 * @param days
	 */
	public ScheduleWeek(int week, ScheduleWeekday[] days) {
		this.weekNumber = week;
		this.weekdays = days;
	}
	
	/**
	 * 
	 * @return
	 */
	public ScheduleWeekday[] getWeekdays() {
		return this.weekdays;
	}
	
	/**
	 * 
	 * @return
	 */
	public String[] getWeekAsStringArray() {
		return null;
	}
}
