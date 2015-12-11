package post_processing;

import main.Schedule;

/**
 * @author Caleb Piekstra
 *
 * Print out any issues with the final schedule to the console
 * as well as output them to a log file.
 * 
 * Handle conversion of a Schedule object to a 2D array of 
 * Strings which can easily be printed to a CSV file.
 *
 */
public class PostProcessor {

	private final Schedule schedule;
	
	/**
	 * 
	 * @param schedule
	 */
	public PostProcessor(Schedule schedule) {
		this.schedule = schedule;
	}
	
	/**
	 * 
	 * @return
	 */
	public String[][] getCSVSchedule() {
		return new ScheduleToCSV(this.schedule).getCSVSchedule();
	}
	
	/**
	 * 
	 */
	private void createLog() {
		
	}
	
	/**
	 * 
	 */
	private void printToCMD() {
		
	}
	
	/**
	 * 
	 * @return
	 */
	private int errorChecking() {
		return 0;
	}
}
