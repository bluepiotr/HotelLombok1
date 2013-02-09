package hotel;

public class HotelTester {
	
	public static void main (String[] args){
		Hotel h = new Hotel ("Cosy Quarters", 120, "Louis Boisson");		
		System.out.println("Hotel created " + h.toString());
	}
}
