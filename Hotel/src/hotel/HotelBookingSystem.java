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

public class HotelBookingSystem implements Serializable {
	private static final String EXIT = "x";
	
	enum ACCESS_LEVELS { MANAGER, CUSTOMER, NOTHING};
    enum SCREEN_LAYOUT {LEFT, RIGHT, CENTRE};

	private String name;

	private ArrayList<Hotel> hotels;
	private ArrayList<Person> users;
	private Movie movie; // should these be ArrayLists or arrays
	private Screen screen;
	private ArrayList<Showing> schedule;
	private ArrayList<Booking> bookings;
	//private Map<Showing,Booking> bookings;

	private static BookingSystem sys;
	private static Scanner sc;

	public static void main(String[] args) {
		new BookingSystem().run();
	}

	public BookingSystem() {
		this("default");
	}

	void run() {
		sc = new Scanner(System.in);
		String action;
		sys = (BookingSystem) Utilities.initialise();
		loginScreen();
		performActions();
		System.out.println("<< " + sys + " >>");
		Utilities.save(sys);
	}

	/**
	 * 
	 * @param s
	 */
	public BookingSystem(String s) {
		name = s;
		cinemas = new ArrayList<Cinema>();
        users = new ArrayList<Person>();
	}

	/**
	 * 
	 */
	public String toString() {
		return name + " " + cinemas + users;
	}

	private void loginScreen() {
		String name, pw;
        System.out.println(users);
		do {
			System.out.print("User Id: ");
			name = sc.nextLine();
			System.out.print("Password:");
			pw = sc.nextLine();
		} while (!users.contains(new Person(name,pw)));
	}

	private void performActions() {
		String str;
		do {
			System.out.println("\tMenu");
			System.out.println();
			System.out.println("\tp - Display Booking System Contents");
			System.out.println("\tc - Operations on Cinema");
			System.out.println("\tx - exit");
			System.out.print("\t>>");
			str = sc.next();

			if (str.equals("p"))
				System.out.println(this);
			else if (str.equals("c"))
				processCinema();
			else if (str.equals(EXIT))
				return;
			else
				System.out.println("oops, invalid reply [" + str + "]");
		} while (true);
	}

	private void processCinema() {
		String reply;
		do {
			System.out.println("in process Cinema");
			System.out.println("\tMenu");
			System.out.println();
			System.out.println("\tc - Create a cinema");
			System.out.println("\tr - Display a specific cinema");
			System.out.println("\tu - Update a cinema");
			System.out.println("\td - Delete a cinema");
			System.out.println("\tx - return to previous menu");
			System.out.print("\t>> ");
			reply = sc.next();

			if (reply.equals("c")) { // validation on inputs
				System.out.print("Name of cinema: ");
				String name = sc.next();
				System.out.print("Number of screens: ");
				int number = sc.nextInt();
				addCinema(new Cinema(name, number)); // check to see if routine
														// succeeded
				return;
			} // else other options
			else
				System.out.println("oops, invalid reply [" + reply + "]");
		} while (true);
	}

	boolean addCinema(Cinema cinema) {
		// check to make sure that cinema hasn't already been added
		cinemas.add(cinema);
		//
		return true;
	}

	boolean deleteCinema(String name) {
		return cinemas.remove(new Cinema(name, 0));
	}

	
	boolean addManager(String name, String pw){
			users.add(new Person(name, pw, BookingSystem.ACCESS_LEVELS.MANAGER));
			return true;
	}

}
