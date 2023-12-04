/*
 * 
 * Write a Java Program to implement Singleton pattern for multithread
 * 
 */

package singletonpattern;

// NOTE: This is not thread safe!

public class Singleton {
	private static Singleton uniqueInstance;

	// other useful instance variables here

	private Singleton() {
	}

	public static Singleton getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new Singleton();
		}
		return uniqueInstance;
	}

	public static void main(String args[]) {
		System.out.println(getInstance());
	}

}
