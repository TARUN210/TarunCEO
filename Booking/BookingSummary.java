package Booking;
import java.util.*;

public class BookingSummary 
{
	int booking_no;
	
	BookingSummary()
	{
		Scanner sc = new Scanner(System.in);
		System.out.format("%.40s : ","Enter booking Number : ");
		booking_no = sc.nextInt();
		if(Main.hp.containsKey(booking_no))
			notCancelled();
		else
			cancelled();
	}
	public void cancelled()
	{
		print();
		System.out.format("%.40s : Cancelled\nCost\n","Seats");
		System.out.format("%.40s : Rs %.2f","Cancellation Charge",((double)Booking.info.get(booking_no).get(0)-(double)Booking.info.get(booking_no).get(0)));
	}
	
	public void notCancelled()
	{
		print();
		System.out.format("\n%.40s : ","Seats");
		printSeats();
		System.out.println();
		System.out.println("Cost");
		System.out.format("%.40s : %.2f","Ticket Price",(double)Booking.info.get(booking_no).get(0));
		System.out.format("\n%.40s : %d","Discount",(int)Booking.info.get(booking_no).get(3));
		System.out.format("\n%.40s : %.2f","Total Price",(double)Booking.info.get(booking_no).get(1));
	}
	
	public void printSeats()
	{
		for(int l:Main.hp.get(booking_no))
			System.out.print(l+",");
	}
	
	public void print()
	{
		int t = (int)Booking.info.get(booking_no).get(2);
		if(t==1||t==2)
			System.out.format("%.40s : 4 PM","Screen 1");
		else if(t==4||t==3)
			System.out.format("%.40s : 4 PM","Screen 1");
		else if(t==5||t==6)
			System.out.format("%.40s : 4 PM","Screen 2");
		else if(t==7||t==8)
			System.out.format("%.40s : 8 PM","Screen 2");
	}
}
