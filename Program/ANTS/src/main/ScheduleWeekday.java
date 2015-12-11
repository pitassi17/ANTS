package main;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import input.Event;
import input.Participant;

/**
 * @author Caleb Piekstra
 * 
 * Manages all of the information for a single day in a week 
 * in the schedule
 *
 */
public class ScheduleWeekday {
	
	private final Date date;
	private Map<Event, ArrayList<Participant>> events;
	
	
	/**
	 * 
	 * @param d
	 */
	public ScheduleWeekday(Date d) {
		this.date = d;
	}
	
	/**
	 * 
	 * @return
	 */
	public Date getDate() {
		return this.date;
	}
	
	/**
	 * 
	 * @return
	 */
	public Set<Event> getEvents() {
		return this.events.keySet();
	}

	/**
	 * @return the events
	 */
	public Map<Event, ArrayList<Participant>> getEventsDict() {
		return this.events;
	}
	
	/**
	 * 
	 * @param e
	 */
	public void addEvent(Event e) {
		this.events.put(e, new ArrayList<Participant>());
	}
	
	/**
	 * 
	 * @param e
	 * @return
	 */
	public ArrayList<Participant> getEventParticipants(Event e) {
		return this.events.get(e);
	}
	
	/**
	 * 
	 * @param e
	 * @param p
	 */
	public void addParticipantToEvent(Event e, Participant p) {
		this.events.get(e).add(p);
	}
	
	

}
