package Revise;
import java.util.*;

public class DefaultStaticKeyword implements A,B{
	public static void main(String[] args) {
		DefaultStaticKeyword obj = new DefaultStaticKeyword();
		obj.show();
		B.show();
	}
	public void show() {
		System.out.println("In Show --> ");
	}
}

interface A {
	default void show() {
		System.out.println("In showA --> ");
	}
}

interface B {
	static void show() {
		System.out.println("In showB --> ");
	}
}
