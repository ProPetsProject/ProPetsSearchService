package propets.search.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import propets.search.dto.TagRequestDto;
import propets.search.service.TaggingService;

@RestController
@RequestMapping("/tagging")
public class TaggingController {

	@Autowired
	TaggingService service;
	
	@GetMapping("/request/")
	Set<String> getListTags(@RequestBody TagRequestDto tagRequestDto) {
		return service.getListTags(tagRequestDto);
	}
}