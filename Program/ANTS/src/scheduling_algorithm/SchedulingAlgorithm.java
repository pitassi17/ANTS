package scheduling_algorithm;

import input.Participant;
import input.ScheduleInformation;
import main.Schedule;


/**
 * @author Caleb Piekstra
 *
 * Uses a backtracking algorithm to generate a schedule that satisfies
 * as many of the user-specified constraints as possible in a limited
 * amount of time
 * 
 */
public class SchedulingAlgorithm {
	
	private final Schedule emptySchedule;
	private Schedule currentBestSchedule;
	private final ScheduleInformation scheduleInformation;

	/**
	 * The constructor
	 * 
	 */
	public SchedulingAlgorithm(Schedule emptySchedule, ScheduleInformation info) {
		this.emptySchedule = emptySchedule;
		this.scheduleInformation = info;
	}

	/**
	 * 
	 */
	private void backtracking() {
		
	}

	/**
	 * 
	 */
	private int evaluateSchedule(Schedule schedule) {
		return 0;
	}

	/**
	 * 
	 */
	private Schedule root() {
		return null;
	}

	/**
	 * 
	 */
	private boolean reject(Schedule schedule) {
		return false;
	}

	/**
	 * 
	 */
	private boolean accept(Schedule schedule) {
		return false;
	}

	/**
	 * 
	 */
	private Schedule next(Schedule schedule, Participant participant) {
		return null;
	}

	/**
	 * 
	 */
	public Schedule getSchedule() {
		return this.currentBestSchedule;
	}

}
