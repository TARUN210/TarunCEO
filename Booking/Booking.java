package Booking;
import java.util.*;

public class Booking {
	
	int option,tickets;
	double ticketPrice;
	String coupon;
	
	static Map<Integer,ArrayList> info = new HashMap<>();
	Main m = new Main();
	Screen s1 = m.getScreen1();
	Screen s2 = m.getScreen2();
	Scanner sc = new Scanner(System.in);
	
	public void booking()
	{
		System.out.print("\nEnter the number of tickets?");
		tickets = sc.nextInt();
		System.out.println("\n\t1.  Screen 1 : 4 PM : "+s1.F1_Seats4+" ( First Class )");
		System.out.println("\t2.  Screen 1 : 4 PM : "+s1.S1_Seats4+" ( Second Class )");
		System.out.println("\t3.  Screen 1 : 8 PM : "+s1.F2_Seats8+" ( First Class )");
		System.out.println("\t4.  Screen 1 : 8 PM : "+s1.S2_Seats8+" ( Second Class )");
		System.out.println("\t5.  Screen 2 : 4 PM : "+s2.F1_Seats4+" ( First Class )");
		System.out.println("\t6.  Screen 2 : 4 PM : "+s2.S1_Seats4+" ( Second Class )");
		System.out.println("\t7.  Screen 2 : 8 PM : "+s2.F2_Seats8+" ( First Class )");
		System.out.println("\t8.  Screen 2 : 8 PM : "+s2.S2_Seats8+" ( Second Class )\n");

		while(true)
		{
			System.out.print("Enter your Option (1/2/3/4/5/6/7/8) : ");
			option = sc.nextInt();sc.nextLine();
			if(option==1)
			{
				if ( s1.F1_Seats4<tickets && s1.checkIfAvailable(tickets,1,5))				
				{
					print();
					continue;
				}
				else
				{
					m.booking_id+=1;
//					m.hp.put(m.booking_id,new ArrayList<Integer>());
					s1.add(m.booking_id, tickets,1,5,tickets);
					break;
				}
			}
			else if(option==2)
			{
				if(s1.S1_Seats4<tickets && (s1.checkIfAvailable(tickets,6,10) || s1.checkIfAvailable(tickets,11,15)))
				{
					print();
					continue;
				}
				else
				{
					m.booking_id+=1;
//					m.hp.put(m.booking_id,new ArrayList<Integer>());
					if(s1.checkIfAvailable(tickets,6,10))
						s1.add(m.booking_id, tickets,6,10,tickets);
					else
						s1.add(m.booking_id, tickets,10,15,tickets);	
					break;
				}
			}
			else if(option==3)
			{
				if(s1.F2_Seats8<tickets && s1.checkIfAvailable(tickets,1,5))
				{
					print();
					continue;
				}
				else
				{
					m.booking_id+=1;
//					m.hp.put(m.booking_id,new ArrayList<Integer>());
					s1.add(m.booking_id, tickets,1,5,tickets);
					break;
				}
			}
			else if(option==4)
			{
				if(s1.S2_Seats8<tickets && (s1.checkIfAvailable(tickets,6,10) || s1.checkIfAvailable(tickets,11,15)))
				{
					print();
					continue;
				}
				else
				{
					m.booking_id+=1;
//					m.hp.put(m.booking_id,new ArrayList<Integer>());
					if(s1.checkIfAvailable(tickets,6,10))
						s1.add(m.booking_id, tickets,6,10,tickets);
					else
						s1.add(m.booking_id, tickets,11,15,tickets);
					break;
				}
			}
			else if(option==5)
			{
				if(s2.F1_Seats4<tickets && s2.checkIfAvailable(tickets,1,5))
				{
					print();
					continue;
				}
				else
				{
					m.booking_id+=1;
//					m.hp.put(m.booking_id,new ArrayList<Integer>());
					s2.add(m.booking_id, tickets,1,5,tickets);
					break;
				}
			}
			else if(option==6)
			{
				if(s2.S1_Seats4<tickets && (s2.checkIfAvailable(tickets,6,10) || s1.checkIfAvailable(tickets,11,15)))
				{
					print();
					continue;
				}
				else
				{
					m.booking_id+=1;
//					m.hp.put(m.booking_id,new ArrayList<Integer>());
					if(s1.checkIfAvailable(tickets,6,10))
						s2.add(m.booking_id, tickets,6,10,tickets);
					else
						s2.add(m.booking_id, tickets,10,15,tickets);
					break;
				}
			}
			else if(option==7)
			{
				if(s2.F2_Seats8<tickets && s2.checkIfAvailable(tickets,1,5))
				{
					print();
					continue;
				}
				else
				{
					m.booking_id+=1;
//					m.hp.put(m.booking_id,new ArrayList<Integer>());
					s2.add(m.booking_id, tickets,1,5,tickets);
					break;
				}
			}
			else if(option==8)
			{
				if(s2.S2_Seats8<tickets && (s2.checkIfAvailable(tickets,6,10) || s1.checkIfAvailable(tickets,11,15)))
				{
					print();
					continue;
				}
				else
				{
					m.booking_id+=1;
//					m.hp.put(m.booking_id,new ArrayList<Integer>());
					if(s2.checkIfAvailable(tickets,6,10))
						s2.add(m.booking_id, tickets,6,10,tickets);
					else
						s2.add(m.booking_id, tickets,10,15,tickets);
					break;
				}
			}
			else
			{
				System.out.println("Enter a valid Option");
			}
		}
		System.out.print("Enter Coupon Code if any Else 0 ? ");
		coupon = sc.nextLine();
		bookingDetails();
	}
	
	public void bookingDetails()
	{
		ArrayList k = new ArrayList<>();
		System.out.format("%.30s : %d\n","Booking Number",m.booking_id);
		System.out.format("%.30s : ","Seats Allotted");
		for(int l:m.hp.get(m.booking_id))
		System.out.print(l+",");
		System.out.println();
		findScreenAndTime();
		System.out.println("\nCost");
		k.add(ticketPrice);
		System.out.format("%.30s : Rs %.2f\n","Ticket Price",ticketPrice);
		int discount = (coupon.equals("0"))?0:Integer.parseInt(coupon.substring(1));
		String g = "Discount (" + discount + "%)";
		System.out.format("%.30s : Rs %.2f\n",g,(discount==0)?0:(ticketPrice/discount));
		ticketPrice = (discount==0)?ticketPrice:(ticketPrice-(ticketPrice/discount));
		System.out.format("%.30s : Rs %.2f","Total",ticketPrice);
		addTotalIncome();
		k.add(ticketPrice);
		k.add(option);
		k.add(discount);
		info.put(m.booking_id,k);
	}
	
	public void addTotalIncome()
	{
		if(option==1||option==2)
			s1.income_4pm+=ticketPrice;
		else if(option==3||option==4)
			s1.income_8pm+=ticketPrice;
		else if(option==5||option==6)
			s1.income_4pm+=ticketPrice;
		else if(option==7||option==8)
			s1.income_8pm+=ticketPrice;
	}
	
	public void	findScreenAndTime()
	{
		switch(option)
		{
		case 1:
			System.out.format("%.30s : 4PM","Screen 1");
			ticketPrice = tickets*120;
			break;
		case 2:
			System.out.format("%.30s : 4PM","Screen 1");
			ticketPrice = tickets*120;
			break;
		case 3:
			System.out.format("%.30s : 8PM","Screen 1");
			ticketPrice = tickets*120;
			break;
		case 4:
			System.out.format("%.30s : 8PM","Screen 1");
			ticketPrice = tickets*120;
			break;
		case 5:
			System.out.format("%.30s : 4PM","Screen 2");
			ticketPrice = tickets*120;
			break;
		case 6:
			System.out.format("%.30s : 4PM","Screen 2");
			ticketPrice = tickets*120;
			break;
		case 7:
			System.out.format("%.30s : 8PM","Screen 2");
			ticketPrice = tickets*120;
			break;
		case 8:
			System.out.format("%.30s : 8PM","Screen 2");
			ticketPrice = tickets*120;
			break;
		}
	}
	
	public void print()
	{
		System.out.print("Sorry, Tickets are not available. ");
	}
	
}
