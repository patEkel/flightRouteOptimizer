package assignment13;

import java.util.ArrayList;

public class Airport {
	String name;
	ArrayList<Flight> flights;
	double currentBest;
	boolean wasVisited;
	Airport cameFrom;
	

	public Airport(String airport, ArrayList<Flight> flights) {
		this.name = airport;
		this.flights = flights;
		this.currentBest = Double.POSITIVE_INFINITY;
		wasVisited = false;
	}

	//	public Airport(String airport, ArrayList<Flight> flights){
	//		this.name = airport;
	//		this.flights = flights;
	//		this.currentBest = Double.POSITIVE_INFINITY;
	//	}
	public Airport(String airport) {
		this.name = airport;
		this.flights = new ArrayList<Flight>(350);
		this.currentBest = Double.POSITIVE_INFINITY;
		wasVisited = false;
		cameFrom = null;

	}
	public Airport getCameFrom() {
		return cameFrom;
	}
	public void setCameFrom(Airport a) {
		this.cameFrom = a;
	}
}
