package unit_tests;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import input.*;

public class InputHandlerTests {
	private InputHandler testIH;
	private ScheduleInformation testSI;
	
	@Before
	public void setUp() {
		testIH = new InputHandler(new File("unitTest_InputHandler.csv"));
		testIH.readFile();
		testIH.createScheduleInformation();
		testSI = testIH.getScheduleInformation();
		
	}
	
	@After
	public void tearDown(){
		testIH = null;
	}
	
	@Test
	public void testFileNotNull() {
		assertNotNull("Unit test input not found or input is null!", testIH);
	}
	
	@Test
	public void testScheduleInformationNotNull(){
		assertNotNull("Unit test input schedule info is null!", testSI);
	}
	
	@Test
	public void testInformationNotNull(){
		assertNotNull("Events should not be null.", testSI.getEvents());
		assertNotNull("Participants should not be null.", testSI.getParticipants());
		assertNotNull("SpecialDateRanges should not be null", testSI.getSpecialDateranges());
		assertNotNull("Timeslots should not be null", testSI.getTimeslots());
	}
	
	
}
