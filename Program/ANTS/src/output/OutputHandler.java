package output;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;


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
	 * @param csvSchedule - The schedule to write to a file
	 * @param file - The file to write the schedule to
	 */
	public OutputHandler(String[][] csvSchedule, File file) {
		this.csvSchedule = csvSchedule;
		this.file = file;
	}

	/**
	 * Writes a 2D array of strings to a file in CSV format
	 * 
	 */
	public void writeScheduleToCSV() {
		try {
			PrintWriter outFile = new PrintWriter(file);
			/*
			 *  loop through the schedule and print out each row
			 *  on its own line with columns seperated by commas
			 */
			for (int i = 0; i < csvSchedule.length; i++) {
				for (int j = 0; j < csvSchedule[i].length; j++) {
					outFile.print(csvSchedule[i][j] + ",");					
				}
				outFile.println("");
			}
			outFile.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Unit tests
	 */
	public static void main(String[] args) {
		// initialize a mock schedule to write to a file
		String[][] scheduleStr = {{"Week", "Topic", "Monday", "Oral Presentation Speakers", "", "Wednesday", "Debate Plaintiffs", "Debate Defendants", "", "Friday", "Essays Due"},
				{"3", "Bionics", "41531", "James and John", "", "9/16/2013", "William and Patricia", "Charles", "", "9/18/2013", "\"Donald, Daniel, David, Mary, Joseph, Michael, Mark\""},
				{"4", "Copyright", "9/21/2013", "Robert", "", "9/23/2013", "Richard and Christopher", "George and Thomas", "", "9/25/2013", "\"Kenneth, Mary, Patricia, William\""},
				{"5", "Race and Gender Equality in Tech", "9/28/2013", "Michael", "", "9/30/2013", "Daniel and Mark", "Joseph and Donald", "", "10/2/2013", "\"Richard, Christopher, Charles, Thomas, Patricia, George\""},
				{"6", "Society of Leisure", "10/5/2013", "William and David", "", "10/7/2013", "Robert and George", "Mary and Kenneth", "", "10/9/2013", "\"Richard, Donald, Christopher, Charles, Daniel, James, Joseph, Thomas, John, Mark\""},
				{"7", "Privacy", "10/12/2013", "Richard", "", "10/14/2013", "James and Thomas", "Daniel", "", "10/16/2013", "\"Donald, Kenneth, Patricia, John, George, Mark\""},
				{"8", "", "10/19/2013", "FALL BREAK", "", "10/21/2013", "FALL", "BREAK", "", "10/23/2013", ""},
				{"9", "AI Effect on Society", "10/26/2013", "Charles and Joseph", "", "10/28/2013", "David and Christopher", "John", "", "10/30/2013", "\"Daniel, Mary, James, Patricia, Robert, Michael\""},
				{"10", "Net Neutrality", "11/2/2013", "Thomas", "", "11/4/2013", "Donald and Kenneth", "Michael and Mark", "", "11/6/2013", "\"Mary, Robert, George, William\""},
				{"11", "Changing Educational Needs", "11/9/2013", "Christopher and Daniel", "", "11/11/2013", "Patricia and Richard", "James", "", "11/13/2013", "\"Kenneth, David, John, William\""},
				{"12", "Hacktivism", "11/16/2013", "Mary and Mark", "", "11/18/2013", "Michael", "Robert", "", "11/20/2013", "\"Richard, Donald, Kenneth, Charles, David, Joseph, John, George, William\""},
				{"13", "Internet of Things", "11/23/2013", "Donald and Patricia", "", "11/25/2013", "Thanksgiving", "Break", "", "11/27/2013", "\"Christopher, Charles, David, James, Joseph, Thomas, Robert, Michael\""},
				{"14", "Digital Currency and the Dark Net", "11/30/2013", "George and Kenneth", "", "12/2/2013", "Joseph and John", "William", "", "12/4/2013", "\"Richard, Christopher, Daniel, James, Thomas, Robert, Michael, Mark\""},
				{"15", "", "12/7/2013", "(Exception - Debates on this day)", "", "(Exception)", "Charles and Mary", "David", "", "", ""}};
		// Create an output handler
		OutputHandler oh = new OutputHandler(scheduleStr, new File("unitTest_OutputHandler.csv"));
		// Write the schedule to a CSV file
		oh.writeScheduleToCSV();
	}
}
