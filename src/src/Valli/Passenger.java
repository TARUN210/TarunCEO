package Valli;

public class Passenger {
	String name;
	int age;
	String berth;
	static int id = 0;
	String seat = "";
	Passenger(String name, int age, String berth) {
		this.name = name;
		this.age = age;
		this.berth = berth;
		id++;				
	}
}
