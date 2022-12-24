package Booking;
import java.util.*;

public class Screen {
	int F1_Seats4=5 ,S1_Seats4=10 ,F2_Seats8=5 ,S2_Seats8=10 ;
	int	income_4pm =0 ,income_8pm = 0 ;
	int a[] = new int[16];
	int b[] = new int[16];
	double totalPrice =0 ;
	
	Screen()
	{
		for(int i=1;i<15;i++)
			a[i]=0;
	}
	
	public boolean checkIfAvailable(int t,int start,int end)
	{
		int count=0;
		for(int i=start;i<=end;i++)
		{
			if(a[i]==0)
				count+=1;
		}
		return count>=t;
	}
	
	public void add(int id,int total_num_to_add,int start,int end,int count)
	{
		ArrayList<Integer> b = new ArrayList<>();
		for(int i=start;i<=end && count-->0;i++)
		{
			if(a[i]==0)
			{
				a[i]=1;
				b.add(i);
			}
		}
		Main.hp.put(id,b);
	}	
}
