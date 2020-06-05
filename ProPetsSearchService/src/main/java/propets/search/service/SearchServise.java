package propets.search.service;

import java.util.List;

import propets.search.dto.PetCardDto;
import propets.search.dto.PetCardResponseDto;

public interface SearchServise {
	
	PetCardResponseDto addPetCard(String author, PetCardDto petCardDTO);
	
	PetCardResponseDto getPetCard(String petCardId);
	
	PetCardResponseDto updatePetCard(String petCardId, PetCardDto petCardDTO);
	
	PetCardResponseDto removePetCard(String petCardId);
	
	List<PetCardResponseDto> getAllPetCards();
	
	List<PetCardResponseDto> getAllLostOrFindPetCards(boolean isLost);
	
	List<PetCardResponseDto> getAllPetCardsByAuthor(String userId);
}