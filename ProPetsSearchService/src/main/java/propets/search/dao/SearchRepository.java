package propets.search.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import propets.search.model.PetCard;

public interface SearchRepository extends MongoRepository<PetCard, String> {
	
	List<PetCard> findAllByNameAuthor(String nameAuthor);
	
	List<PetCard> findByLost(boolean lost);

}