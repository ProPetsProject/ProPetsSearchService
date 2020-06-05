package propets.search.dto;

import java.util.List;
import java.util.Set;

import lombok.Getter;
import propets.search.model.Location;

@Getter
public class PetCardDto {
	boolean lost;
	String type;
	String sex;
	String breed;
	String color;
	String height;
	String features;
	String description;
	String nameAuthor;
	String phone;
	String email;
	List<String>pictures;
	Set<String>tags;
	Location location;
}