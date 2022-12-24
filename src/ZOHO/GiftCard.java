package ZOHO;
import java.util.*;

import ZOHO.GiftCard.Pair;

public class GiftCard {
	int t;
	static LinkedHashMap<Integer, Pair> cardMap = new LinkedHashMap<>();
	static int cardNo = 0;
	Pair p;
	GiftCard() {
		
	}
	GiftCard(Pair p) {
		cardNo++;
		this.p = p;
	}
	static class Pair {
		int customerId;
		int PIN;
		int giftCardBalance;
		String status;
		Pair(int customerId, int PIN, int giftCardBalance, String status) {
			this.customerId = customerId;
			this.PIN = PIN;
			this.giftCardBalance = giftCardBalance;
			this.status = status;
		}
	}
	
	GiftCard(int t) {
		this.t = t;
//		cardNo++;
	}
	
	public void createCardMap(GiftCard gc) {
		cardMap.put(cardNo, new Pair(gc.p.customerId, gc.p.PIN, gc.p.giftCardBalance, gc.p.status));
//		for(int i:cardMap.keySet()) {
//			System.out.println("CARD NO: "+cardNo+", CUSTOMER ID: "+cardMap.get(i).customerId+", PIN: "+cardMap.get(i).PIN+", GIFT CARD BALANCE: "+cardMap.get(i).giftCardBalance+", STATUS: "+cardMap.get(i).status);
//		}
	}
	
	public void printGiftCardDetails() {
		System.out.println("GIFT CARD DETAILS: ");
		for(int i:cardMap.keySet()) {
			System.out.println("CARD NO: "+i+", CUSTOMER ID: "+cardMap.get(i).customerId+", PIN: "+cardMap.get(i).PIN+", GIFT CARD BALANCE: "+cardMap.get(i).giftCardBalance+", STATUS: "+cardMap.get(i).status);
		}
	}

	
	
	public static void purchaseGiftCard(int customerId, HashMap<Integer, Integer> customerMap) {
		if(customerMap.containsKey(customerId) && cardMap.containsKey(customerId)) {
			for(int i:cardMap.keySet()) {
				if(cardMap.get(i).customerId==customerId && cardMap.get(i).status.equals("A")) {
					int newBalance = customerMap.get(customerId) - cardMap.get(i).giftCardBalance;
					if(newBalance<0 ||newBalance<customerMap.get(customerId)) {
						System.out.println("BALANCE CANNOT BE NEGATIVE**");
						//customerMap.put(customerId, 0);
						break;
					} else {
						customerMap.put(customerId, newBalance);
					}
					
				}
			}
		} else {
			System.out.println("ENTER A VALID CUSTOMER ID: ");
		}
	}
	
	static void cardDetailsWRtoCustId(int id) {
		if(!cardMap.containsKey(id)) {
			System.out.println("ENETR AN VALID CUSTOMER ID");
		} else {
			for(int i:cardMap.keySet()) {
				if(cardMap.get(i).customerId==id) {
					System.out.println("RESULTS FOR CUSTOMER ID: "+id+" is");
					System.out.println("CARD NO: "+i+", CUSTOMER ID: "+cardMap.get(i).customerId+", PIN: "+cardMap.get(i).PIN+", GIFT CARD BALANCE: "+cardMap.get(i).giftCardBalance+", STATUS: "+cardMap.get(i).status);
				}
			}
		}
		
	}
}
