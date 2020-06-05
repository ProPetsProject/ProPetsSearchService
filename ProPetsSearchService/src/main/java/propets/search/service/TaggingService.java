package propets.search.service;

import java.util.Set;

import propets.search.dto.TagRequestDto;

public interface TaggingService {

	Set<String> getListTags(TagRequestDto tagRequestDto);
	
}