package propets.search.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import lombok.Builder;
import lombok.Getter;
import propets.search.model.Location;

@Getter
@Builder
public class PetCardResponseDto {
	String id;
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
	LocalDateTime dateCreation;
	List<String>pictures;
	Set<String>tags;
	Location location;
}