package hotel;

import lombok.NonNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(exclude={"starRating", "manager"})
public class Hotel {
	@NonNull
	private String name;
    @NonNull
	private String address;	
    @NonNull
	private String telephone;
    @NonNull
	private int numberOfRooms;
    private int starRating;
	private String manager;		
}

