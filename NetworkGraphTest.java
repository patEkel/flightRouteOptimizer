package assignment13;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class NetworkGraphTest {

	NetworkGraph j;

	@Before
	public void setUp() throws Exception {


		 j = new NetworkGraph("smallerFlights.csv");

//		NetworkGraph ng = new NetworkGraph("smallFlights.csv");
		System.out.println("bitch");

	//	NetworkGraph ng = new NetworkGraph("smallFlights.csv");
		System.out.println("sup");


	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws FileNotFoundException {

//		assertTrue(j.airports.get("SFO").flights.size()==1);

//		NetworkGraph ng = new NetworkGraph("smallFlights.csv");


	}

}
