package unit_tests;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;

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
		testSI = null;
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
	
	@Test
	public void testScheduleInformationHasCorrectEvents(){
		ArrayList<String> eventNames = new ArrayList<String>();
		
		for (Event event : testSI.getEvents()){
			eventNames.add(event.getEventName());
		}
		
		assertTrue("Expected Plantiff in list of events", eventNames.contains("Plaintiff"));
		assertTrue("Expected Oral Presentation in list of events", eventNames.contains("Oral Presentation"));
		assertTrue("Expected Term Paper in list of events", eventNames.contains("Term Paper"));
		assertTrue("Expected Defendant in list of events", eventNames.contains("Defendant"));
		assertTrue("Expected Essay in list of events", eventNames.contains("Essay"));

	}
	
	@Test
	public void testScheduleInformationHasCorrectParticipants(){
		ArrayList<String> participants = new ArrayList<String>();
		
		for (Participant p : testSI.getParticipants()){
			participants.add(p.getName());
		}
		
		assertTrue("Expected Bob in list of events", participants.contains("Bob"));
		assertTrue("Expected Joe Presentation in list of events", participants.contains("Joe"));
		assertTrue("Expected Susan in list of events", participants.contains("Susan"));
		assertTrue("Expected Jane in list of events", participants.contains("Jane"));
		
	}
}
