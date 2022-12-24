package Valli;
import java.util.*;

public class TicketBooker {
	static int total = 3;
	static int lower_berth = total/3;
	static int middle_berth = total/3;
	static int upper_berth = total/3;
	
	static LinkedHashMap<Integer, Passenger> map = new LinkedHashMap<>();
	List<Integer> l_List = new LinkedList<>();
	List<Integer> m_List = new LinkedList<>();
	List<Integer> u_List = new LinkedList<>();

	public void bookTicket(Passenger p, String berth) {
		if(total==0) {
			System.out.println("NO TICKETS AVAILABLE**");
		} else {
			if(berth.equals("L")) {
				if(lower_berth >0) {
					System.out.println("PREFERRED BERTH AVAILABLE");
					int id = p.id;
					p.seat = "L";
					map.put(id, p);
					l_List.add(id);
					lower_berth--;
					total--;
					System.out.println("LOWER BERTH GIVEN");
				} 
				else if(middle_berth >0) {
					System.out.println("PREFERRED BERTH NOT AVAILABLE");
					int id = p.id;
					p.seat = "M";
					map.put(id, p);
					m_List.add(id);
					middle_berth--;
					total--;
					System.out.println("MIDDLE BERTH GIVEN");
				}
				else {
					int id = p.id;
					p.seat = "U";
					map.put(id, p);
					u_List.add(id);
					upper_berth--;
					total--;
					System.out.println("UPPER BERTH GIVEN");
				}
			}
			else if(berth.equals("M")) {
				if(middle_berth >0) {
					System.out.println("PREFERRED BERTH AVAILABLE");
					int id = p.id;
					p.seat = "M";
					map.put(id, p);
					m_List.add(id);
					middle_berth--;
					total--;
					System.out.println("MIDDLE BERTH GIVEN");
				} 
				else if(lower_berth >0) {
					System.out.println("PREFERRED BERTH NOT AVAILABLE");
					int id = p.id;
					p.seat = "L";
					map.put(id, p);
					l_List.add(id);
					lower_berth--;
					total--;
					System.out.println("LOWER BERTH GIVEN");
				} 
				else {
					int id = p.id;
					p.seat = "U";
					map.put(id, p);
					u_List.add(id);
					upper_berth--;
					total--;
					System.out.println("UPPER BERTH GIVEN");
				}
			} else if(berth.equals("U")) {
				if(upper_berth>0) {
					int id = p.id;
					p.seat = "U";
					map.put(id, p);
					u_List.add(id);
					upper_berth--;
					total--;
					System.out.println("UPPER BERTH GIVEN");
				}
				else if(lower_berth >0) {
					System.out.println("PREFERRED BERTH NOT AVAILABLE");
					int id = p.id;
					p.seat = "L";
					map.put(id, p);
					l_List.add(id);
					lower_berth--;
					total--;
					System.out.println("LOWER BERTH GIVEN");
				} 
				else if(middle_berth >0) {
					System.out.println("PREFERRED BERTH NOT AVAILABLE");
					int id = p.id;
					p.seat = "M";
					map.put(id, p);
					m_List.add(id);
					middle_berth--;
					total--;
					System.out.println("MIDDLE BERTH GIVEN");
				}
			}
			else {
				System.out.println("SORRY, TICKETS NOT AVAILABLE**");
			}
		}
		
	}

	public void cancelTickets(int id) {
		if(!map.containsKey(id)) {
			System.out.println("ENTER A VALID ID");
		}
		else {
			Passenger p = map.get(id);
			if(p.berth.equals("L")) {
				int idx = l_List.indexOf(id);
				l_List.remove(idx);
				map.remove(idx);
				lower_berth++;
				total++;
				System.out.println("CANCELLED");
			}
			else if(p.berth.equals("M")) {
				int idx = l_List.indexOf(id);
				m_List.remove(idx);
				map.remove(idx);
				middle_berth++;
				total++;
			} 
			else if(p.berth.equals("U")) {
				int idx = l_List.indexOf(id);
				u_List.remove(idx);
				map.remove(idx);
				upper_berth++;
				total++;
			}
		}
	}

}
