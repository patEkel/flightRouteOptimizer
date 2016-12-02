package assignment13;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class NetworkGraphTest {

	NetworkGraph j;

	@Before
	public void setUp() throws Exception {

		 j = new NetworkGraph("C:/Users/pat/Desktop/test.csv");

//		NetworkGraph ng = new NetworkGraph("smallFlights.csv");
		System.out.println("bitch");


	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws FileNotFoundException {

		assertTrue(j.airports.get("SFO").flights.size()==1);

//		NetworkGraph ng = new NetworkGraph("smallFlights.csv");


	}

}
