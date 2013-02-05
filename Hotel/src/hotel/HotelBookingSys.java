package hotel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class HotelBookingSys implements Serializable {
	private static final String EXIT = "x";
	
	enum ACCESS_LEVELS { MANAGER, CUSTOMER, NOTHING};
    enum SCREEN_LAYOUT {LEFT, RIGHT, CENTRE};

	private String name;

	private ArrayList<Hotel> hotels;
	//private ArrayList<Booking> bookings;
	//private Map<Showing,Booking> bookings;

	private static HotelBookingSys sys;
	private static Scanner sc;

	public static void main(String[] args) {
		new HotelBookingSys().run();
	}

	public HotelBookingSys() {
		this("default");
	}

	void run() {
		sc = new Scanner(System.in);
		String action;
		sys = (HotelBookingSys) Utilities.initialise();
//		loginScreen();
//		performActions();
		System.out.println("<< " + sys + " >>");
		Utilities.save(sys);
	}

	/**
	 * 
	 * @param s
	 */
	public HotelBookingSys(String s) {
		name = s;
//		cinemas = new ArrayList<Cinema>();
//        users = new ArrayList<Person>();
	}

	/**
	 * 
	 */
	


	

}
