package propets.search.dto;

import java.util.Map;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString

public class TagDto {
	double confidense;
	Map<String, String> tag;
}