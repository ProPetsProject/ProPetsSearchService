package propets.search.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@EqualsAndHashCode(of = {"id"})
@Document(collection = "petcards")
public class PetCard {
	String id;
	boolean lost;
	@Setter
	String type;
	@Setter
	String sex;
	@Setter
	String breed;
	@Setter
	String color;
	@Setter
	String height;
	@Setter
	String features;
	@Setter
	String description;
	String nameAuthor;
	@Setter
	String phone;
	@Setter
	String email;
	LocalDateTime dateCreation;
	List<String>pictures;
	Set<String>tags;
	@Setter
	Location location;

	public void addPicture(String picture) {
		pictures.add(picture);
	}
	
	public void removePicture(String picture) {
		pictures.remove(picture);
	}
	
	public void addTag(String tag) {
		tags.add(tag);
	}
	
	public void removeTag(String tag) {
		tags.remove(tag);
	}
}