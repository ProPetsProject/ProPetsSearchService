package propets.search.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Location {
	String country;
	String city;
	String street;
	Integer	building;
	Integer latitude;
	Integer longitude;
}
