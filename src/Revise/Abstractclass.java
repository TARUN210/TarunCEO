package Revise;
import java.util.*;

public class Abstractclass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Iphone obj = new Iphone();
		Samphone obj1 = new Samphone();
		showConfig(obj);
		showConfig(obj1);
		

	}
	public static void showConfig(Phone obj ) {
		obj.show();
	}
	
//	public static void showConfig(Iphone obj ) {
//		obj.show();
//	}
//	public static void showConfig(Samphone obj ) {
//		obj.show();
//	}
}

abstract class Phone {
	abstract void show();
}
class Iphone extends Phone{
	public void show() {
		System.out.println("Iphone Config**");
	}
}
class Samphone extends Phone{
	public void show() {
		System.out.println("Samsung Config**");
	}
}
