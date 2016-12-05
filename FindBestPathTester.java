package assignment13;

/**
 * <p>An example of how a user will use your best flight API.</p>
 * <p>You will still be required to writed JUnit tests to test your program.</p>
 *
 * @author CS2420 Teaching Staff - Spring 2016
 *
 */
public class FindBestPathTester {

	public static void main(String[] args) {
		NetworkGraph airportGraph = null;
		try {
//			airportGraph = new NetworkGraph("C:/Users/pat/Desktop/school/Fall16/2420/assignment13/flights-2015-q3.csv");
//			airportGraph = new NetworkGraph("C:/Users/pat/Desktop/test.csv");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// Returns the shortest distance path of flights from MOB to ACV
		// Solution: a path of ['MOB', 'DFW', 'SFO', 'ACV'] and distance of 2253
	//	BestPath shortestDistancePath = airportGraph.getBestPath("MOB", "ACV", FlightCriteria.DISTANCE);
	//	System.out.println(shortestDistancePath.toString());
		
		// Returns the shortest distan//		BestPath shortestTimePath = airportGraph.getBestPath("MOB", "SLC", FlightCriteria.TIME);
//		System.out.println(shortestTimePath.toString());ce path of flights from SFO to DWF when flying with DL
		// Solution: a path of ['SFO', 'SLC', 'DFW'] and distance of 1588
	//	BestPath shortestDistancePath2 = airportGraph.getBestPath("SFO", "DFW", FlightCriteria.DISTANCE, "DL");
	//	System.out.println(shortestDistancePath2.toString());
		
		// Returns the shortest flight time path from MOB to SLC
//		 Solution: a path of ['MOB', 'DFW', 'SLC'] and time of ~269.25

		
		// Returns the fiscally cheapest path of flights from LAS to LAX
		// Solution: a path of ['LAS', 'LAX'] and cost of ~138.39
	//	System.out.println(cheapestPath.toString());
		
//		BestPath cheapestPath = airportGraph.getBestPath("SFO", "JFK", FlightCriteria.TIME);
//		System.out.println(cheapestPath.toString());
	
		//BestPath shortestDistancePath2 = airportGraph.getBestPath("SFO", "DFW, FlightCriteria.TIME, "DL")
		
	}
}
