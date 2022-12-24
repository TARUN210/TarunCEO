package Railway_Reservation_System;
import java.util.*;

public class TicketBooker {
	static int availableLowerBerths = 1;
	static int availableMiddleBerths = 1;
	static int availableUpperBerths = 1;
	static int availableRacTickets = 1;
	static int availableWaitingList = 1;
	
	static Queue<Integer> waitingList = new LinkedList<>();
	static Queue<Integer> racList = new LinkedList<>();
	static List<Integer> bookedTicketList = new ArrayList<>();
	
	static List<Integer> lowerBerthPositions = new ArrayList<>(Arrays.asList(1));
	static List<Integer> middleBerthPositions = new ArrayList<>(Arrays.asList(1));
	static List<Integer> upperBerthPositions = new ArrayList<>(Arrays.asList(1));
	static List<Integer> racPositions = new ArrayList<>(Arrays.asList(1));
	static List<Integer> waitingListPositions = new ArrayList<>(Arrays.asList(1));
	
	static Map<Integer, Passenger> passengers = new HashMap<>();
	
	public void bookTicket(Passenger p, int berthInfo, String allotedBerth) {
		p.number = berthInfo;
		p.alloted = allotedBerth;
		passengers.put(p.passengerId, p);
		bookedTicketList.add(p.passengerId);
		System.out.println("**********Booked Successfully");
	}
	
	public void addToRAC(Passenger p, int racInfo, String allotedRAC) {
		p.number = racInfo;
		p.alloted = allotedRAC;
		
		racList.add(p.passengerId);
		availableRacTickets--;
		System.out.println("**********Added To RAC Successfully");
	}
	
	public void addToWaitingList(Passenger p, int waitingListInfo, String allotedWL) {
		p.number = waitingListInfo;
		p.alloted = allotedWL;
		
		waitingList.add(p.passengerId);
		availableWaitingList--;
		System.out.println("**********Added To Waiting List Successfully");
	}

	public void cancelTicket(int passengerId) {
		Passenger p = passengers.get(passengerId);
		passengers.remove(passengerId);
		bookedTicketList.remove(passengerId);
		
		int positionBooked = p.number;
		
		System.out.println("**********Cancelled Successfully");
		
		if(p.alloted.equals("L")) {
			lowerBerthPositions.add(positionBooked);
			availableLowerBerths++;
		} 
		else if(p.alloted.equals("M")) {
			middleBerthPositions.add(positionBooked);
			availableMiddleBerths++;
		} 
		else if(p.alloted.equals("U")) {
			upperBerthPositions.add(positionBooked);
			availableUpperBerths++;
		}
		
		if(racList.size()>0) {
			Passenger passengerFromRAC = passengers.get(racList.poll());
			int positionRAC = passengerFromRAC.number;
			racPositions.add(positionRAC);
			racList.remove(passengerFromRAC.passengerId);
			availableRacTickets++;
			
			if(waitingList.size()>0) {
				Passenger passengerFromWaitingList = passengers.get(waitingList.poll());
				int positionWL = passengerFromWaitingList.number;
				waitingListPositions.add(positionWL);
				waitingList.remove(passengerFromWaitingList.passengerId);
				
				passengerFromWaitingList.number = racPositions.get(0);
				passengerFromWaitingList.alloted = "RAC";
				racPositions.remove(0);
				racList.add(passengerFromWaitingList.passengerId);
				
				
				availableWaitingList++;
				availableRacTickets--;
			}
			
			Main.bookTicket(passengerFromRAC);
		}
	}

	public void printAvailable() {
		System.out.println("Available Lower Berths: " +availableLowerBerths);
		System.out.println("Available Middle Berths: " +availableMiddleBerths);
		System.out.println("Available Upper Berths: " +availableUpperBerths);
		System.out.println("Available RAC's: " +availableRacTickets);
		System.out.println("Available Waiting List: " +availableWaitingList);
	}

	public void printPassengers() {
		if(passengers.size()==0) {
			System.out.println("No Details Of Passengers***");
			return;
		}
		for(Passenger p : passengers.values()) {
			System.out.println("PASSENGER ID: "+p.passengerId);
			System.out.println(" Name: "+p.name);
			System.out.println(" Age: "+p.age);
			System.out.println(" Status: "+p.number +p.alloted);
			System.out.println("---------------------------------");
		}
		
	}
	
}
