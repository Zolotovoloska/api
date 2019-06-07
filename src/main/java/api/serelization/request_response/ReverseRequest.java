package api.serelization.request_response;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ReverseRequest {
	private String person;
}
