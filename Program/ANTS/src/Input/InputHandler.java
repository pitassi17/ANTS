package Input;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Reads CSV file and parses relevant information for scheduler.
 * 
 * @author Bryce Matsuda
 * 
 */
public class InputHandler {

	/**
	 * Reads the raw data from the CSV file and barfs it out as a string.
	 * <br>	<br>
	 * TODO: Will eventually filter out data into a ScheduleInformation object.
	 * 
	 * @param filePath the path to the file
	 * @return raw data, or relevant error message
	 * 
	 */
	public String readFile(String filePath) {
		try {
			return new String(Files.readAllBytes(Paths.get(filePath)));
		} catch (FileNotFoundException e) {
			return "File not found.";
		} catch (IOException e) {
			e.printStackTrace();
			return "An unexpected error occured.";
		}

	}
}
