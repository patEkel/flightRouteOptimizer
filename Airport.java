package assignment13;

import java.util.ArrayList;

public class Airport {
	String airport;
	ArrayList<Flight> flights;
	double currentBest;
	
	public Airport(String airport, ArrayList<Flight> flights){
		this.airport = airport;
		this.flights = flights;
		this.currentBest = Double.POSITIVE_INFINITY;
	}
	
}
