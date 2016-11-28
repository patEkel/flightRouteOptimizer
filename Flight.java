package assignment13;

public class Flight {
	Airport destination;
	String carrier;
	int delay;
	int canceled;
	int time;
	int distance;
	double cost;
	FlightCriteria flightCriteria;
	
	public Flight(Airport destination, String carrier, int delay, int canceled, int time, int distance, double cost){
		this.destination = destination;
		this.carrier = carrier;
		this.delay = delay;
		this.canceled = canceled;
		this.time = time;
		this.distance = distance;
		this.cost = cost;
	}
}
