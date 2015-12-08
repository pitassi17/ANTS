package post_processing;

import main.Schedule;

/**
 * @author Caleb Piekstra
 * 
 * Takes a schedule and converts it into a 2D array of
 * strings which can be written to a CSV file
 *
 */
public class ScheduleToCSV {
	
	private final Schedule schedule;
	private String[][] csvSchedule;
	
	/**
	 * 
	 * @param schedule
	 */
	public ScheduleToCSV(Schedule schedule) {
		this.schedule = schedule;
	}
	
	/**
	 * 
	 */
	private void convertSchedule() {
		
	}
	
	/**
	 * 
	 * @return
	 */
	public String[][] getCSVSchedule() {
		return null;
	}
}
