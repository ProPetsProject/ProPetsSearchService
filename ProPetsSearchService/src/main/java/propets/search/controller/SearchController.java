package propets.search.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import propets.search.dto.PetCardDto;
import propets.search.dto.PetCardResponseDto;
import propets.search.service.SearchServise;

@RestController
@RequestMapping("/search")
public class SearchController {

	@Autowired
	SearchServise service;
	
	@PostMapping("/addPetCard/{author}")
	public PetCardResponseDto addPetCard(@PathVariable String author, @RequestBody PetCardDto petCardDTO) {
		return service.addPetCard(author, petCardDTO);
	}
	
	@GetMapping("/getPetCard/{petCardId}")
	public PetCardResponseDto getPetCard(@PathVariable String petCardId) {
		return service.getPetCard(petCardId);
	}
	
	@PutMapping("/updatePetCard/{petCardId}")
	public PetCardResponseDto updatePetCard(@PathVariable String petCardId, @RequestBody PetCardDto petCardDTO) {
		return service.updatePetCard(petCardId, petCardDTO);
	}
	
	@DeleteMapping("/removePetCard/{petCardId}")
	public PetCardResponseDto removePetCard(@PathVariable String petCardId) {
		return service.removePetCard(petCardId);
	}
	
	@GetMapping("/getAllPetCards")
	public List<PetCardResponseDto> getAllPetCards() {
		return service.getAllPetCards();
	}
	
	@GetMapping("/getPetCards/{lost}")
	public List<PetCardResponseDto> getAllLostOrFindPetCards(@PathVariable("lost")boolean lost) {
		return service.getAllLostOrFindPetCards(lost);
	}
	
	@GetMapping("/getPetCardsByAuthor/{userId}")
	public List<PetCardResponseDto> getAllPetCardsByAuthor(@PathVariable String userId) {
		return service.getAllPetCardsByAuthor(userId);
	}
}