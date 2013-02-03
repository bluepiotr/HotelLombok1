package hotel;

public class HotelTester {
	
	public static void main (String[] args){
		Hotel h1 = new Hotel("Holiday Out", 
				"27St Las Vegas", "020 3333 4444",
				125);
		
		Hotel h2 = new Hotel ("Holiday Out",
				"8th Ave New York", "0203 444 5555", 132);
		
		
        if (h1.equals(h2))
            System.out.println("Hotels "  + 
        h1 + " and " + h2 + " are Duplicates");
        else
            System.out.println("Hotels are different");

		
		System.out.println("hotel1: " + h1.toString());	
		System.out.println("hotel2: " + h2.toString());
	}
}
