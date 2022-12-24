package Valli;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		Passenger p = new Passenger("Valli",21,"l");
		TicketBooker t1 = new TicketBooker();
		
		while(true) {
			System.out.println("ENTER UR CHOICE: 1.BOOK TICKETS / 2.CANCEL TICKETS / 3.DISPLAY TICKETS / 4.");
			int choice = sc.nextInt();
			switch(choice) {
			case 1:
				System.out.print("ENTER UR NAME:");
				String name = sc.next();
				System.out.print("ENTER UR AGE:");
				int age = sc.nextInt();
				System.out.print("ENTER UR BERTH PREFERNCE:");
				String berth = sc.next();
//				TicketBooker t = new TicketBooker();
				t1.bookTicket(new Passenger(name, age, berth), berth);
				break;
			case 2:
				System.out.println("ENTER PASSENGER ID: ");
				int id = sc.nextInt();
				
				t1.cancelTickets(id);
			}
		}

	}

}
