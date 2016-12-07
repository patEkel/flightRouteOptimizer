/**
 * 
 */
package assignment13;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * <p>
 * This class represents a graph of flights and airports along with specific
 * data about those flights. It is recommended to create an airport class and a
 * flight class to represent nodes and edges respectively. There are other ways
 * to accomplish this and you are free to explore those.
 * </p>
 * 
 * <p>
 * Testing will be done with different criteria for the "best" path so be sure
 * to keep all information from the given file. Also, before implementing this
 * class (or any other) draw a diagram of how each class will work in relation
 * to the others. Creating such a diagram will help avoid headache and confusion
 * later.
 * </p>
 * 
 * <p>
 * Be aware also that you are free to add any member variables or methods needed
 * to completed the task at hand
 * </p>
 * 
 * @author Kyle Price and Patrick Ekel
 * 12/6/2016
 */
public class NetworkGraph {
	NetworkGraph g;
	String flightInfoPath;
	HashMap<String, Airport> airports;
	ArrayList<Airport> totalAirports;
	BestPath bestPath;
	String airline;
	double weight;
	int currentSize = 0;
	boolean airlineGiven;

	/**
	 * <p>
	 * Constructs a NetworkGraph object and populates it with the information
	 * contained in the given file. See the sample files or a randomly generated
	 * one for the proper file format.
	 * </p>
	 * 
	 * <p>
	 * You will notice that in the given files there are duplicate flights with
	 * some differing information. That information should be averaged and
	 * stored properly. For example some times flights are canceled and that is
	 * represented with a 1 if it is and a 0 if it is not. When several of the
	 * same flights are reported totals should be added up and then reported as
	 * an average or a probability (value between 0-1 inclusive).
	 * </p>
	 * 
	 * @param flightInfoPath - The path to the file containing flight data. This should be a *.csv(comma separated value) file
	 * 
	 * @throws FileNotFoundException - The only exception that can be thrown in this assignment and
	 *             only if a file is not found.
	 */
	public NetworkGraph(String flightInfoPath) throws FileNotFoundException {
		this.flightInfoPath = flightInfoPath;
		currentSize = 0;
		totalAirports = new ArrayList<Airport>();
		populate(flightInfoPath);
		airlineGiven = false; // whether an airline was given
		airline = null; // the airline if given 

	}

	/**
	 * This method returns a BestPath object containing information about the
	 * best way to fly to the destination from the origin. "Best" is defined by
	 * the FlightCriteria parameter <code>enum</code>. This method should throw
	 * no exceptions and simply return a BestPath object with information
	 * dictating the result. If a destination or origin is not contained in this
	 * instance of NetworkGraph simply return a BestPath object with no path
	 * (not a <code>null</code> path). If origin or destination are
	 * <code>null</code>, also return a BestPath object with no path.
	 * 
	 * @param origin - The starting location to find a path from. This should be a
	 *            3 character long string denoting an airport.
	 * 
	 * @param destination - The destination location from the starting airport. Again,
	 *            this should be a 3 character long string denoting an airport.
	 * 
	 * @param criteria - This enum dictates the definition of "best". Based on this
	 *            value a path should be generated and return.
	 * 
	 * @return - An object containing path information including origin,
	 *         destination, and everything in between.
	 */
	public BestPath getBestPath(String origin, String destination, FlightCriteria criteria) {
		bestPath = new BestPath();
		bestPath.path = new ArrayList<String>();
		Airport currentAirport = airports.get(origin);

		// check if null String is passed
		if (origin == null || destination == null) {
			bestPath.pathLength = 0;
			airlineGiven = false;
			airline = null;
			this.resetGraph();
			return bestPath;
		}
		// check if Graph contains the given airports
		if (!airports.containsKey(origin) || !airports.containsKey(destination)) {
			bestPath.pathLength = 0;
			airlineGiven = false;
			airline = null;
			this.resetGraph();
			return bestPath;
		}
		// Dijkstra's shortest path algortihm
		String crit = getWeightType(criteria);
		AirportComparator comp = new AirportComparator();
		PriorityQueue<Airport> pq = new PriorityQueue<Airport>(350, comp);

		pq.add(airports.get(origin));
		airports.get(origin).currentBest = 0;
		while (!pq.isEmpty()) {
			currentAirport = pq.poll();
			if (currentAirport.name.equals(destination)) {
				break;
			}
			airports.get(currentAirport.name).wasVisited = true;
			currentAirport.wasVisited = true;
			for (Flight f : currentAirport.flights) {
				if (airlineGiven) {
					if (f.carriers.contains(airline)) {
						this.checkNeighbors(f, currentAirport, crit, pq);
					}
				} else {
					this.checkNeighbors(f, currentAirport, crit, pq);
				}
			}
		}
		// check if destination was never found
		if (!currentAirport.name.equals(destination)) {
			bestPath.pathLength = 0;
			this.resetGraph();
			airlineGiven = false;
			airline = null;
			return bestPath;
		}
		// was back from destination to origin
		bestPath.pathLength = currentAirport.currentBest;
		while (currentAirport.cameFrom != null) {
			bestPath.path.add(0, currentAirport.name);
			currentAirport = currentAirport.cameFrom;
		}
		bestPath.path.add(0, currentAirport.name);
		this.resetGraph();
		airlineGiven = false;
		airline = null;
		return bestPath;
	}
	/**
	 * Helper method which determines if the cost of getting to an airport is less than the current smallest cost.
	 * @param f - given flight
	 * @param currentAirport - current airport
	 * @param crit - criteria being used for cost
	 * @param pq priority queue
	 */
	public void checkNeighbors(Flight f, Airport currentAirport, String crit, PriorityQueue<Airport> pq) {
		if (!airports.get(f.destination.name).wasVisited) {
			if (this.getWeightValue(f, crit) >= 0) {  // make sure weight is not negative for given criteria
				if (airports.get(f.destination.name).currentBest > (currentAirport.currentBest + this.getWeightValue(f, crit))) {
					pq.remove(airports.get(f.destination.name));
					airports.get(f.destination.name).currentBest = currentAirport.currentBest + this.getWeightValue(f, crit);
					pq.add(airports.get(f.destination.name));
					airports.get(f.destination.name).cameFrom = currentAirport;
				}
			}
		}
	}
	/**
	 * Resets Graph properties
	 */
	public void resetGraph() {
		for (Airport a : totalAirports) {
			a.cameFrom = null;
			a.wasVisited = false;
			a.currentBest = Double.POSITIVE_INFINITY;
		}
	}

	/**
	 * <p>
	 * This overloaded method should do the same as the one above only when
	 * looking for paths skip the ones that don't match the given airliner.
	 * </p>
	 * 
	 * @param origin - The starting location to find a path from. This should be a
	 *            3 character long string denoting an airport.
	 * 
	 * @param destination - The destination location from the starting airport. Again,
	 *            this should be a 3 character long string denoting an airport.
	 * 
	 * @param criteria - This enum dictates the definition of "best". Based on this
	 *            value a path should be generated and return.
	 * 
	 * @param airliner - a string dictating the airliner the user wants to use
	 *            exclusively. Meaning no flights from other airliners will be
	 *            considered.
	 * 
	 * @return - An object containing path information including origin,
	 *         destination, and everything in between.
	 */
	public BestPath getBestPath(String origin, String destination, FlightCriteria criteria, String airliner) {
		airlineGiven = true;
		airline = airliner;
		return getBestPath(origin, destination, criteria);
	}
	/**
	 * Helper method which sets up the graph based on a given file path
	 * @param flightInfo - the file path
	 * @throws FileNotFoundException - thrown if given file is not found
	 */
	@SuppressWarnings("resource")
	public void populate(String flightInfo) throws FileNotFoundException {
		File f = new File(flightInfo);
		String currentLine;
		String[] currentLineArray;
		Airport origin;
		Airport dst;
		Flight thisFlight;
		airports = new HashMap<String, Airport>();
		Scanner s = new Scanner(f);
		currentLine = s.nextLine();
		// read file line by line, parsing values to correct data type
		while (s.hasNextLine()) {
			currentLine = s.nextLine();
			currentLineArray = currentLine.split(","); // check ENUMS somewhere and add to correct airport
			origin = new Airport(currentLineArray[0]);
			dst = new Airport(currentLineArray[1]);
			thisFlight = new Flight(dst, currentLineArray[2], Integer.parseInt(currentLineArray[3]),
					Integer.parseInt(currentLineArray[4]), Integer.parseInt(currentLineArray[5]),
					Integer.parseInt(currentLineArray[6]), Double.parseDouble(currentLineArray[7]));
			// determine if graph does not compare a given origin
			if (!airports.containsKey(origin.name)) {
				airports.put(origin.name, origin);
				totalAirports.add(origin);
			}
			// determine if graph does not contain a given destination
			if (!airports.containsKey(dst.name)) {
				airports.put(dst.name, dst);
				totalAirports.add(dst);
			}
			// check if origin -> destination already exits.
			int flightIndex = checkFlightsIndex(origin.name, thisFlight);
			if (flightIndex >= 0) {
				// if flight exists, add value of new flight so values can be averaged.
				Flight tempFlight = airports.get(origin.name).flights.get(flightIndex);
				tempFlight.carriers.add(thisFlight.carrier);
				this.averageValues(tempFlight, thisFlight);
				tempFlight.count++;
			} else {
				// the flight is new, add it to graph
				(airports.get(origin.name)).flights.add(thisFlight);
			}
		}
	}
	/**
	 * Helper method for averaging values for a particular flight
	 * @param tempFlight - the flight already in graph
	 * @param thisFlight - the new flight with values to be averaged into existing
	 */
	public void averageValues(Flight tempFlight, Flight thisFlight) {
			tempFlight.canceled = (((tempFlight.canceled * tempFlight.count) + thisFlight.canceled)	/ (tempFlight.count + 1.0));
			tempFlight.time = (((tempFlight.time * tempFlight.count) + thisFlight.time) / (tempFlight.count + 1.0));
			tempFlight.cost = (((tempFlight.cost * tempFlight.count) + thisFlight.cost) / (tempFlight.count + 1.0));
			tempFlight.delay = (((tempFlight.delay * tempFlight.count) + thisFlight.delay) / (tempFlight.count + 1.0));
			tempFlight.distance = (((tempFlight.distance * tempFlight.count) + thisFlight.distance)	/ (tempFlight.count + 1.0));
	}
	/**
	 * Helper for getting index of flight if it is already in graph
	 * @param origin - origin of flight
	 * @param dst - destination of flight
	 * @return index if flight exists, -1 otherwise
	 */
	public int checkFlightsIndex(String origin, Flight dst) {
		for (int i = 0; i < airports.get(origin).flights.size(); i++) {
			if (airports.get(origin).flights.get(i).flightName.equals(dst.flightName)) {
				return i;
			}
		}
		return -1;
	}
	/**
	 * Helper for getting criteria used
	 * @param criteria - criteria given
	 * @return name of criteria as String
	 */
	public String getWeightType(FlightCriteria criteria) {
		switch (criteria) {
		case DELAY:
			return "delay";
		case CANCELED:
			return "canceled";
		case COST:
			return "cost";
		case DISTANCE:
			return "distance";
		default:
			return "time";
		}
	}
	/**
	 * Helper for getting criteria as double
	 * @param flight - given flight
	 * @param criteria - criteria given
	 * @return value of particular flight's criteria
	 */
	public double getWeightValue(Flight flight, String criteria) {
		switch (criteria) {
		case "delay":
			return flight.delay;
		case "canceled":
			return flight.canceled;
		case "cost":
			return flight.cost;
		case "distance":
			return flight.distance;
		default:
			return flight.time;
		}
	}
}