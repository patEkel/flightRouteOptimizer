package assignment13;

import java.util.HashSet;

/**
 * Class which represents flights (edges) on the graph
 * @author Patrick Ekel and Kyle Price
 * 12/6/2016
 */
public class Flight {
	Airport destination;
	String carrier;
	double delay = 0;
	double canceled = 0;
	double time = 0;
	double distance = 0;
	double cost = 0;
	int count = 0;
	String flightName;
	HashSet<String> carriers = new HashSet<String>();
	
	/**
	 * Constructor for a flight, sets member varibales to arguments
	 * @param destination - destination airport
	 * @param carrier - carrier serving flight
	 * @param delay - value for delay
	 * @param canceled - value for canceled
	 * @param time - value for time
	 * @param distance - value for distance
	 * @param cost - value for cost
	 */
	public Flight(Airport destination, String carrier, int delay, int canceled, int time, int distance, double cost) {
		this.destination = destination;
		this.carriers.add(carrier);
		this.carrier = carrier; // add in Graph class every time, no duplicates
		this.delay = (double) delay;
		this.canceled = (double) canceled;
		this.time = (double) time;
		this.distance = (double) distance;
		this.count = 1;
		this.cost = cost;
		this.flightName = destination.name;
	}
}
