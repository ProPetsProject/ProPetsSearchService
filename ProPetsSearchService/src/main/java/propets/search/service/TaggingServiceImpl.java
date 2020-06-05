package propets.search.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import propets.search.dto.ResponseDto;
import propets.search.dto.TagDto;
import propets.search.dto.TagRequestDto;

@Service
public class TaggingServiceImpl implements TaggingService {

	@Override
	public Set<String> getListTags(TagRequestDto tagRequestDto) {
		List<String> requests = tagRequestDto.getUrlImages();
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Basic YWNjXzFhOGNlMjA1NWExOGZkNzpjMzIwMTgzMWY4MzEyNjk0MGE3MDFhMGRlNjQ3OWRmMg==");
		String urlForTagging = "https://api.imagga.com/v2/tags";
		List<TagDto> tagsDto = null;
		Set<String> tags = new HashSet<String>();
		
		for (String req : requests) {
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(urlForTagging)
					.queryParam("image_url", req)
					.queryParam("limit", 5);
			RequestEntity<String> request = new RequestEntity<>(headers, HttpMethod.GET, builder.build().toUri());
			ResponseEntity<ResponseDto> response = restTemplate.exchange(request, ResponseDto.class);
			tagsDto = response.getBody().getResult().getTags();
			for (TagDto tagDto : tagsDto) {
				tags.addAll(tagDto.getTag().values());
			}
		}
		return tags;
	}
}