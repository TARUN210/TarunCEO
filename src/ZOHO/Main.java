package ZOHO;
import java.util.*;

import ZOHO.GiftCard.Pair;

public class Main {
	static List<Customers> customerList = new LinkedList<>();
	static List<GiftCard> giftCardList = new LinkedList<>();
//	static LinkedHashMap<Integer, Pair> cardMap = new LinkedHashMap<>();
	
//	 Customers c = new Customers();
	
	public static List<Customers> noOfCustomers(int n) {
		Customers c = new Customers();
		List<Customers> list = new LinkedList<>();
		Scanner sc = new Scanner(System.in);
		for(int i=0;i<n;i++) {
			System.out.println("ENTER BALANCE AMOUNT FOR THE CUSTOMER");
			int balance = sc.nextInt();
			Customers obj = new Customers(balance);
			c.createCustomers(obj);
			list.add(obj);
		}
		return list;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
//		System.out.println("ENTER NO OF CUSTOMERS: ");
//		int n = sc.nextInt();
//		customerList = noOfCustomers(n);
//		Customers c = new Customers();
//		for(Customers c1:customerList) {
//			c.createCustomers(customerList);
//		}
		
		while(true) {
			System.out.println("ENTER YOUR CHOICE: 1.SHOW CUSTOMER TRANSACTION // 2.CREATE CUSTOMER // 3.CREATE GIFTCARD // 4.SHOW GIFT CARD // 5.SHOW CARD DETAILS W.R.TO CUSTOMER ID// 6.COMBINATION: // 7.EXIT");
			int choice = sc.nextInt();
			switch(choice) {
//				case 1:
//					System.out.println("ENTER NO OF CUSTOMERS: ");
//					int n = sc.nextInt();
//					customerList = noOfCustomers(n);
//					Customers c1 = new Customers();
//					c1.printCustomerTransaction();
//					break;
//				case 2:
//					GiftCard gc = new GiftCard();
//					System.out.println("SET A PIN FOR UR CARD: ");
//					int pin = sc.nextInt();
//					System.out.println(" CUSTOMER ID FOR YOUR PIN");
//					int cid = sc.nextInt();
//					System.out.println("ENTER YOUR GIFT CARD BALANCE: ");
//					int GCB = sc.nextInt();
//					System.out.println("ENTER YOUR STATUS => (A/C):");
//					String status = sc.next();
//					cardMap.put(gc.cardNo, new Pair(cid, pin, GCB, status));
//					break;
				case 1:
					Customers c2 = new Customers();
					c2.printCustomerTransaction();
					break;
				case 2:
					System.out.println("ENTER BALANCE AMOUNT FOR THE CUSTOMER");
					int balance = sc.nextInt();
					Customers c3 = new Customers(balance);
					customerList.add(c3);
					c3.createCustomers(c3);
					break;
				case 3:
					System.out.println("SET A PIN FOR UR CARD:");
					int pin = sc.nextInt();
					System.out.println(" CUSTOMER ID FOR YOUR PIN");
					int cid = sc.nextInt();
					System.out.println("ENTER YOUR GIFT CARD BALANCE: ");
					int GCB = sc.nextInt();
					System.out.println("ENTER YOUR STATUS => (A/C):");
					String status = sc.next();
					GiftCard gc = new GiftCard(new Pair(cid, pin, GCB, status));
//					GiftCard gc4 = new GiftCard(2);
					giftCardList.add(gc);
					gc.createCardMap(gc);
//					
					break;
				case 4:
					GiftCard gc1 = new GiftCard(2);
					gc1.printGiftCardDetails();
					break;
				case 5:
					System.out.println("ENTER CUSTOMER ID: ");
					int customerId = sc.nextInt();
					GiftCard gc2 = new GiftCard(2);
					gc2.cardDetailsWRtoCustId(customerId);
					break;
				case 6:
					System.out.println("ENTER CUSTOMER ID: ");
					int custId = sc.nextInt();
					GiftCard o = new GiftCard();
					Customers obj = new Customers();
					HashMap<Integer, Integer> customerMap = obj.returnMap();
					o.purchaseGiftCard(custId, customerMap);
					obj.printCustomerTransaction();
					o.printGiftCardDetails();
					break;
				case 7:
					System.out.println("EXITING->>");
					System.exit(0);
			}
		}
	}

}
