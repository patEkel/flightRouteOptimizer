package assignment13;

import java.util.ArrayList;

/**
 * Class which represents airports (vertices) on graph
 * @author Patrick Ekel and Kyle Price
 * 12/6/2016
 */
public class Airport {
	String name;
	ArrayList<Flight> flights;
	double currentBest;
	boolean wasVisited;
	Airport cameFrom;
	
	/**
	 * Constructor with list of flights for airport
	 * @param airport - name of airport
	 * @param flights - list of flights that leave from airport
	 */
	public Airport(String airport, ArrayList<Flight> flights) {
		this.name = airport;
		this.flights = flights;
		this.currentBest = Double.POSITIVE_INFINITY;
		wasVisited = false;
		cameFrom = null;
	}
	/**
	 * Constructor for airport with no flights
	 * @param airport - name of airport
	 */
	public Airport(String airport) {
		this.name = airport;
		this.flights = new ArrayList<Flight>(350);
		this.currentBest = Double.POSITIVE_INFINITY;
		wasVisited = false;
		cameFrom = null;

	}
	/**
	 * Getter method for getting where an airport came from
	 * @return the airport which the given airport came from
	 */
	public Airport getCameFrom() {
		return cameFrom;
	}
}
