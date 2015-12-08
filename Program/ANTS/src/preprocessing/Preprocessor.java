package preprocessing;

import input.ScheduleInformation;
import main.Schedule;

/**
 * @author Caleb Piekstra
 * 
 * Organizes the schedule information in a way that prepares it
 * for the scheduling algorithm to use more efficiently
 * 
 * Generates an empty schedule
 *
 */
public class Preprocessor {
	
	private final ScheduleInformation scheduleInfo;
	private final DataOrganizer dataOrganizer;
	
	/**
	 * 
	 * @param info
	 */
	public Preprocessor(ScheduleInformation info) {
		this.scheduleInfo = info;
		this.dataOrganizer = new DataOrganizer(this.scheduleInfo);
	}
	
	/**
	 * 
	 * @return
	 */
	private int errorChecking() {
		return 0;
	}
	
	/**
	 * 
	 */
	private void prepareScheduleInformation() {
		this.dataOrganizer.setupData();
	}
	
	/**
	 * 
	 * @return
	 */
	public Schedule generateEmptySchedule() {
		return null;
	}
}
