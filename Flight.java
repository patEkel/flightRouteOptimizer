package assignment13;

import java.util.HashSet;
import java.util.LinkedList;

public class Flight {
	Airport destination;
	String carrier;
	int delay = 0;
	int canceled = 0;
	int time = 0;
	int distance = 0;
	double cost = 0;
	int count = 0;
	String flightName;
	HashSet<String> carriers = new HashSet<String>();

	//FlightCriteria flightCriteria;
	
	public Flight(Airport destination, String carrier, int delay, int canceled, int time, int distance, double cost){
	//public Flight(Airport destination,  int delay, int canceled, int time, int distance, double cost){
	this.destination = destination;
		this.carriers.add(carrier);
		this.carrier = carrier; // add in Graph class every time, no duplicates
		this.delay = delay;
		this.canceled = canceled;
		this.time = time;
		this.distance = distance;
		this.cost = cost;
		this.count=0;
		this.flightName = destination.name;
	}
	
	
	
}
