package Revise;
import java.util.*;

public class AggNComp {

	public static void main(String[] args) {
		Car maruti = new Car();
		maruti.setMaxSpeed(12);
		maruti.setColor("WHITE");
		maruti.getDetails();
		Hyundai obj = new Hyundai();
		obj.HyundaiDemo();
	}
}

class Car {
	private int maxSpeed;
	private String color;
	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	public int getMaxSpeed() {
		return maxSpeed;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getColor() {
		return color;
	}
	public void getDetails() {
		System.out.println("CAR INFO: "+getMaxSpeed()+" ,"+getColor());
	}
}

class Hyundai extends Car{
	public void HyundaiDemo() {
		Engine HyundaiEngine = new Engine();
		HyundaiEngine.start();
		HyundaiEngine.stop();
	}
}

class Engine {
	public void start() {
		System.out.println("Engine STARTED**");
	}
	public void stop() {
		System.out.println("Engine STOPPED**");
	}
}
