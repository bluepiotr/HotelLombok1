package hotel;

import lombok.Getter;
import lombok.Setter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.AccessLevel;
import lombok.ToString;

@ToString (exclude="address")	 	  
@RequiredArgsConstructor
public class Hotel {
	
	@Getter (AccessLevel.PACKAGE) private final String name;	
	@Getter @Setter private String address;	
	@Getter @Setter private String telephone;
	@Getter @Setter @NonNull private int numberOfRooms;
	@Getter @Setter private int starRating;
	@Getter @Setter @NonNull private String manager;		
}

