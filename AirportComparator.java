package assignment13;

import java.util.Comparator;

/**
 * AirportComparator - helps the priority queue determine which airport should 
 * have the highest priority in NetworkGraph.
 * @author Patrick Ekel and Kyle Price
 * 12/6/2016
 */
public class AirportComparator implements Comparator<Airport> {

	@Override
	public int compare(Airport o1, Airport o2) { 
		if (o1.currentBest > o2.currentBest) {
			return 1;
		}
		if (o1.currentBest < o2.currentBest) {
			return -1;
		}
		return 0;
	}
}
