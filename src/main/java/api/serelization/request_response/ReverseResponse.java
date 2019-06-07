package api.serelization.request_response;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ReverseResponse {
	private Boolean lessonCompleted;
	private String feedback;
	private String output;
}
