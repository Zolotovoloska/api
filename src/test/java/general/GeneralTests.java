package general;

import api.util.InjectionFlawsUtil;
import okhttp3.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class GeneralTests {

	@Test(groups = "general")
	public void reverseNameTest() throws IOException {
		System.out.println("========================================");
		Response response = InjectionFlawsUtil.reverseName("test");
		System.out.println("test");
		Assert.assertEquals(response.code(), 200, "Response code !=200");
	}
}
