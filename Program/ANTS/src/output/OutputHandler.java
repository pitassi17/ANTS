package output;

import java.io.File;


/**
 * @author Caleb Piekstra
 *
 * Writes a schedule to an output CSV file
 * 
 */
public class OutputHandler {
	
	private final File file;
	private final String[][] csvSchedule;

	/**
	 * The constructor
	 * 
	 * @param stringSchedule 
	 * @param file 
	 */
	public OutputHandler(String[][] csvSchedule, File file) {
		this.csvSchedule = csvSchedule;
		this.file = file;
	}

	/**
	 * 
	 */
	public void writeScheduleToCSV() {
		
	}
}
