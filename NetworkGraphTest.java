package assignment13;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class NetworkGraphTest {

	static NetworkGraph airportGraph;
	static NetworkGraph airportGraphSmall;
	BestPath shortestDistancePathTest;

	@BeforeClass
	public static void setUp() throws Exception {
		try {
			airportGraphSmall  = new NetworkGraph("C:/Users/pat/school/Fall16/2420/assignment13/smallFileTest.csv");
			airportGraph = new NetworkGraph("C:/Users/pat/school/Fall16/2420/assignment13/flights-2015-q3.csv");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@After
	public void tearDown() throws Exception {
	}
	@Test
	public void testLargeFileMobToAcv() throws FileNotFoundException {
		BestPath shortestDistancePath = airportGraph.getBestPath("MOB", "ACV", FlightCriteria.DISTANCE);
		shortestDistancePathTest = new BestPath();
		shortestDistancePathTest.path = new ArrayList<String>();
		shortestDistancePathTest.path.add(0, "ACV");
		shortestDistancePathTest.path.add(0, "SFO");
		shortestDistancePathTest.path.add(0, "DFW");
		shortestDistancePathTest.path.add(0, "MOB");
		shortestDistancePathTest.pathLength = 2253;
		assertTrue(shortestDistancePath.pathLength == 2253);
		assertTrue(shortestDistancePath.equals(shortestDistancePathTest));
		System.out.println(shortestDistancePath.toString());
	}
	@Test
	public void testLargeFileSfoToDfw() throws FileNotFoundException {
		BestPath shortestDistancePath = airportGraph.getBestPath("SFO", "DFW", FlightCriteria.DISTANCE, "DL");
		assertTrue(shortestDistancePath.pathLength == 1588);
		System.out.println(shortestDistancePath.toString());
	}
	@Test
	public void testLargeFileMobTPPPPPoAcv() throws FileNotFoundException {
		BestPath shortestDistancePath = airportGraph.getBestPath("MOB", "ACV", FlightCriteria.DISTANCE);
		assertTrue(shortestDistancePath.pathLength == 2253);
		System.out.println(shortestDistancePath.toString());
	}
	@Test
	public void testLargeFileSfoToJfkCost() throws FileNotFoundException {
		BestPath shortestDistancePath = airportGraphSmall.getBestPath("SFO", "JFK", FlightCriteria.COST);
		assertEquals(841.49, shortestDistancePath.pathLength, .01);
		System.out.println(shortestDistancePath.toString());
	}
	@Test
	public void testLargeFileSfoToJfkTime() throws FileNotFoundException {
		BestPath shortestDistancePath = airportGraphSmall.getBestPath("SFO", "JFK", FlightCriteria.TIME);
		assertEquals(604.5, shortestDistancePath.pathLength, .01);
		System.out.println(shortestDistancePath.toString());
	}
	@Test
	public void testLargeFileSfoToJfkDelay() throws FileNotFoundException {
		BestPath shortestDistancePath = airportGraphSmall.getBestPath("SFO", "JFK", FlightCriteria.DELAY);
		assertEquals(56, shortestDistancePath.pathLength, .01);
		System.out.println(shortestDistancePath.toString());
	}
	@Test
	public void testLargeFileSfoToNonExistingDelay() throws FileNotFoundException {
		BestPath shortestDistancePath = airportGraphSmall.getBestPath("SFO", "PFK", FlightCriteria.DELAY);
		assertEquals(0, shortestDistancePath.pathLength, .01);
		System.out.println(shortestDistancePath.toString());
	}
	@Test
	public void testLargeFileSfoFromNonExistingDelay() throws FileNotFoundException {
		BestPath shortestDistancePath = airportGraphSmall.getBestPath("GFO", "JFK", FlightCriteria.DELAY);
		assertEquals(0, shortestDistancePath.pathLength, .01);
		System.out.println(shortestDistancePath.toString());
	}
}
