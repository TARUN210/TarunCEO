package Booking;
import java.util.*;

public class Main 
{
	Screen s1 = new Screen();
	Screen s2 = new Screen();
	int booking_id=0;
	static Map<Integer,ArrayList<Integer>> hp = new HashMap<>();
	
	public Screen getScreen1()
	{
		return s1;
	}
	
	public Screen getScreen2()
	{
		return s2;
	}
	
	public static void main(String[] args) 
	{
		int option;
		String wish;
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			System.out.print("\nEnter 1 for Booking, 2 for Cancel, 3 for Booking Summary, 4 for Over All Summary?");
			option = sc.nextInt();
			if(option==1)
			{
				Booking b = new Booking();
				b.booking();
			}
			else if(option==2)
			{
				Cancel c = new Cancel();
			}
			else if(option==3)
			{
				BookingSummary bs = new BookingSummary();
			}
			else if(option==4)
			{
				
			}
			else
			{
				System.out.println("Enter a valid option");
				continue;
			}
			System.out.print("\n\nDo you want to continue ? ");
			sc.nextLine();
			wish = sc.nextLine();
			if(wish.equals("N"))
				break;
			System.out.println();
		}
	}
}
