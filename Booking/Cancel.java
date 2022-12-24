package Booking;
import java.util.*;

public class Cancel 
{
	int booking_no;
	double amount;
	
	Scanner sc = new Scanner(System.in);
	Cancel()
	{
		System.out.print("\nEnter Booking Number ? ");
		booking_no = sc.nextInt();
		amount = (double)Booking.info.get(booking_no).get(1);
//		remove()
		Main.hp.remove(booking_no);
		System.out.println("Tickets Cancelled . Refund Details");
		System.out.format("%.40s : Rs %.2f\n","Ticket Cost",amount);
		System.out.format("%.40s : Rs %.2f","Cancellation Charge (10%)\n",amount/10);
		System.out.format("%.40s : Rs %.2f","Returned Amount",amount-(amount/10));
	}
	
}
