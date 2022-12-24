package ZOHO;
import java.util.*;

public class Customers {
	static LinkedHashMap<Integer, Integer> customerMap = new LinkedHashMap<>();
	static int id=0;
	int balance;
	public Customers() {
		
	}
	Customers(int balance) {
		id++;
		this.balance = balance;
	}
	
	static void createCustomers(Customers c)
	{
//		for(Customers c:list) {
			customerMap.put(id, c.balance);
//		}
	}
	static void printCustomerTransaction() {
		System.out.println("CUSTOMER TRANSACTION: ");
		for(int i : customerMap.keySet()) {
			System.out.println("CUSTOMER ID: "+i+" CUSTOMER BALANCE: "+customerMap.get(i));
		}
	}
	
	public HashMap<Integer, Integer> returnMap() {
		return customerMap;
	}
	
}
