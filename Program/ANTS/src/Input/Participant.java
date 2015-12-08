/**
 * 
 */
package input;

import java.util.ArrayList;
import java.util.Dictionary;

/**
 * @author Caleb Piekstra
 *
 * A participant is a student in the class.
 * 
 * A participant can indicate preferences on assignment due 
 * dates and days of events (i.e. a student can inform the 
 * professor that they prefer to have assignments due Fridays 
 * and cannot have anything due on a Tuesday). 
 * 
 * A participant can indicate that they do not want to work
 * with certain classmates, as well as whether they would prefer
 * to work with certain other classmates. This matters with
 * events that are team-oriented and require multiple 
 * participants to be working together.
 */
public class Participant {
	// The name of the participant
	private final String name;
	
	/**
	 *  A dictionary mapping timeslots to attendance preferences
	 *  
	 *  A value of -3 indicates the participant cannot attend
	 *  events for that timeslot. 
	 *  
	 *  A value of 3 indicates that the participant needs to 
	 *  have events scheduled in that timeslot. 
	 *  
	 *  A value of 0 indicates no preference (default). 
	 *  
	 */
	private Dictionary<Timeslot, Integer> timeslotPreferences;
	
	// A list of participants that this participant does not 
	// want to work with for team-oriented assignments.
	private ArrayList<Participant> badPartners;
	// A list of participants that this participant prefers 
	// to work with for team-oriented assignments.
	private ArrayList<Participant> goodPartners;

	/**
	 * The constructor
	 * 
	 * @param name The name of the student
	 */
	public Participant(String name) {
		this.name = name;
	}

	/**
	 * Gets the name of the participant
	 * 
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}	
		
	/**
	 * Gets the dictionary containing a mapping of timeslots to the
	 * participant's preference for that timeslot.
	 * 
	 * The preference indicates their ability or desire to have or
	 * not have an event in that timeslot.
	 * 
	 * @return the dictionary mapping timeslots to their preferences
	 */
	public Dictionary<Timeslot, Integer> getTimeslotPreferences() {
		return this.timeslotPreferences;
	}
	
	/**
	 * Gets a timeslot preference value.
	 *  
	 * A value of -3 indicates the participant cannot attend
	 * events for that timeslot. 
	 *  
	 * A value of 3 indicates that the participant needs to 
	 * have events scheduled in that timeslot. 
	 * 
	 * A value of 0 indicates no preference (default). 
	 * 
	 * @param timeslot The timeslot 
	 * @return the preference value of the timeslot
	 */
	public Integer getTimeslotPreference(Timeslot timeslot) {
		return this.timeslotPreferences.get(timeslot);
	}
	
	/**
	 * Puts a timeslot preference into the dictionary of timeslot
	 * preferences.
	 * 
	 * The preference indicates the participant's ability or desire 
	 * to have or not have an event in that timeslot.
	 * 
	 * @param timeslot The timeslot
	 * @param preference The preference value of the timeslot
	 */
	public void addTimeslotPreference(Timeslot timeslot, Integer preference) {
		this.timeslotPreferences.put(timeslot, preference);
	}

	/**
	 * Gets the list of participants that this participant does not
	 * want to work with on team assignments.
	 * 
	 * @return the list of bad partners
	 */
	public ArrayList<Participant> getBadPartners() {
		return this.badPartners;
	}

	/**
	 * Adds a participant to the list of participants that this
	 * participant would prefer not to work with for team 
	 * assignments.
	 * 
	 * @param badPartner the participant to add
	 */
	public void addBadPartner(Participant badPartner) {
		this.badPartners.add(badPartner);
	}



	/**
	 * Gets the list of participants that this participant wants
	 * to work with on team assignments.
	 * 
	 * @return the list of good partners
	 */
	public ArrayList<Participant> getGoodPartners() {
		return this.goodPartners;
	}


	/**
	 * Adds a participant to the list of participants that this
	 * participant would prefer to work with for team assignments.
	 * 
	 * @param goodPartner the participant to add
	 */
	public void addGoodPartner(Participant goodPartner) {
		this.goodPartners.add(goodPartner);
	}
}
