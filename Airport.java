package assignment13;

import java.util.ArrayList;

public class Airport {
	String name;
	ArrayList<Flight> flights;
	double currentBest;
	//int indexInList;
	
	public Airport(String airport, ArrayList<Flight> flights){
		this.name = airport;
		this.flights = flights;
		this.currentBest = Double.POSITIVE_INFINITY;
	}
	public Airport(String airport){
		this.name = airport;
		this.flights = new ArrayList<Flight>();
		this.currentBest = Double.POSITIVE_INFINITY;
	}
//	public String getDestinations(){
//		String arr = "";
//		for (int i =0; i < flights.size(); i ++){
//			arr = flights.get(i).destination.toString();
//		}
//		return arr;
//	}
}
