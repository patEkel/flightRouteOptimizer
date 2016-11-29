package assignment13;

public class Flight {
	Airport destination;
	String carrier;
	int delay = 0;
	int canceled = 0;
	int time = 0;
	int distance = 0;
	double cost = 0;
	int count = 0;
	//FlightCriteria flightCriteria;
	
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
