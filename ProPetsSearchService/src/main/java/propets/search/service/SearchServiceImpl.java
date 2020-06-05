package propets.search.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import propets.search.dao.SearchRepository;
import propets.search.dto.PetCardDto;
import propets.search.dto.PetCardResponseDto;
import propets.search.exception.PetCardNotFoundException;
import propets.search.model.Location;
import propets.search.model.PetCard;

@Service
public class SearchServiceImpl implements SearchServise {

	@Autowired
	SearchRepository repository;

	@Override
	public PetCardResponseDto addPetCard(String author, PetCardDto petCardDTO) {
		PetCard petCard = PetCard.builder().id(UUID.randomUUID().toString()).lost(petCardDTO.isLost())
				.type(petCardDTO.getType()).sex(petCardDTO.getSex()).breed(petCardDTO.getBreed())
				.color(petCardDTO.getColor()).height(petCardDTO.getHeight()).features(petCardDTO.getFeatures())
				.description(petCardDTO.getDescription()).nameAuthor(author).phone(petCardDTO.getPhone())
				.email(petCardDTO.getEmail()).dateCreation(LocalDateTime.now()).pictures(petCardDTO.getPictures())
				.tags(petCardDTO.getTags()).location(petCardDTO.getLocation()).build();

		repository.save(petCard);
		return petCardToPetCardDto(petCard);
	}

	@Override
	public PetCardResponseDto getPetCard(String petCardId) {
		PetCard petCard = repository.findById(petCardId).orElseThrow(() -> new PetCardNotFoundException());
		return petCardToPetCardDto(petCard);
	}

	@Override
	@Transactional
	public PetCardResponseDto updatePetCard(String petCardId, PetCardDto petCardDTO) {
		PetCard petCard = repository.findById(petCardId).orElseThrow(() -> new PetCardNotFoundException());
		String type = petCardDTO.getType();
		if(type != null) {
			petCard.setType(type);
		}
		String sex = petCardDTO.getSex();
		if(sex != null) {
			petCard.setSex(sex);
		}
		String breed = petCardDTO.getBreed();
		if(breed != null) {
			petCard.setBreed(breed);
		}
		String color = petCardDTO.getColor();
		if(color != null) {
			petCard.setColor(color);
		}
		String height = petCardDTO.getHeight();
		if(height != null) {
			petCard.setHeight(height);
		}
		String features = petCardDTO.getFeatures();
		if(features != null) {
			petCard.setFeatures(features);
		}
		String description = petCardDTO.getDescription();
		if(description != null) {
			petCard.setDescription(description);
		}
		String phone = petCardDTO.getPhone();
		if(phone != null) {
			petCard.setPhone(phone);
		}
		String email = petCardDTO.getEmail();
		if(email != null) {
			petCard.setEmail(email);
		}
		List<String>pictures = petCardDTO.getPictures();
		if(pictures != null) {
			pictures.forEach(petCard::addPicture);
		}
		Set<String>tags = petCardDTO.getTags();
		if(tags != null) {
			tags.forEach(petCard::addTag);
		}
		Location location = petCardDTO.getLocation();
		if(location != null) {
			petCard.setLocation(location);
		}
		repository.save(petCard);
		return petCardToPetCardDto(petCard);
	}

	@Override
	@Transactional
	public PetCardResponseDto removePetCard(String petCardId) {
		PetCard petCard = repository.findById(petCardId).orElseThrow(() -> new PetCardNotFoundException());
		repository.deleteById(petCardId);
		return petCardToPetCardDto(petCard);
	}

	@Override
	public List<PetCardResponseDto> getAllPetCards() {
		return repository.findAll()
				.stream()
				.map(this::petCardToPetCardDto)
				.collect(Collectors.toList());
	}

	@Override
	public List<PetCardResponseDto> getAllLostOrFindPetCards(boolean lost) {
		return repository.findByLost(lost)
				.stream()
				.map(this::petCardToPetCardDto)
				.collect(Collectors.toList());
	}

	@Override
	public List<PetCardResponseDto> getAllPetCardsByAuthor(String nameAuthor) {
		return repository.findAllByNameAuthor(nameAuthor)
				.stream()
				.map(this::petCardToPetCardDto)
				.collect(Collectors.toList());
	}

	private PetCardResponseDto petCardToPetCardDto(PetCard petCard) {
		return PetCardResponseDto.builder().
				id(petCard.getId())
				.lost(petCard.isLost())
				.type(petCard.getType())
				.sex(petCard.getSex())
				.breed(petCard.getBreed())
				.color(petCard.getColor())
				.height(petCard.getHeight())
				.features(petCard.getFeatures())
				.description(petCard.getDescription())
				.nameAuthor(petCard.getNameAuthor())
				.phone(petCard.getPhone())
				.email(petCard.getEmail())
				.dateCreation(petCard.getDateCreation())
				.pictures(petCard.getPictures())
				.tags(petCard.getTags())
				.location(petCard.getLocation())
				.build();
	}
}