package main;

import java.util.Date;

import input.SpecialDateRange;

/**
 * @author Caleb Piekstra
 * 
 * Used to store a class schedule
 * 
 * Can convert an array of ScheduleWeek objects to a
 * 2D array of String objects
 *
 */
public class Schedule {
	
	private ScheduleWeek[] weeks;
	private final Date startDate;
	private final Date endDate;
	private SpecialDateRange[] specialDateranges;
	
	
	/**
	 * 
	 * @param startDate
	 * @param endDate
	 */
	public Schedule(Date startDate, Date endDate) {
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	/**
	 * 
	 * @param sdr
	 */
	public void setSpecialDateranges(SpecialDateRange[] sdr) {
		this.specialDateranges = sdr;
	}
	
	/**
	 * 
	 */
	private void initWeeks() {
		
	}
	
	/**
	 * 
	 * @return
	 */
	public ScheduleWeek[] getWeeks() {
		return this.weeks;
	}
	
	/**
	 * 
	 * @return
	 */
	public String[][] getWeeksAsStringArrays() {
		return null;
	}

}
