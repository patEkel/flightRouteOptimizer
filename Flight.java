package assignment13;

import java.util.HashSet;
import java.util.LinkedList;

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

	//FlightCriteria flightCriteria;
	
	public Flight(Airport destination, String carrier, double delay, double canceled, double time, double distance, double cost){
	//public Flight(Airport destination,  int delay, int canceled, int time, int distance, double cost){
	this.destination = destination;
		this.carriers.add(carrier);
		this.carrier = carrier; // add in Graph class every time, no duplicates
		this.delay = delay;
		this.canceled = canceled;
		this.time = time;
		this.distance = distance;
		this.cost = cost;
		this.count=1;
		this.flightName = destination.name;
	}
	
	
	
}
