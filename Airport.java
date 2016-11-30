package assignment13;

import java.util.ArrayList;

public class Airport {
	String name;
	ArrayList<Flight> flights;
	double currentBest;
	
	public Airport(String airport, ArrayList<Flight> flights){
		this.name = airport;
		this.flights = flights;
		this.currentBest = Double.POSITIVE_INFINITY;
	}
	
}