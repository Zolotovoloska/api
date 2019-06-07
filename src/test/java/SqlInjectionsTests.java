import api.util.InjectionFlawsUtil;
import okhttp3.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class SqlInjectionsTests {

	@Test(groups = "general")
	public void reverseNameTest() throws IOException {
		Response response = InjectionFlawsUtil.reverseName("test");

		Assert.assertEquals(response.code(), 200, "Response code !=200");
	}

	@Test(groups = {"sql", "introduction"})
	public void selectUserDepartmentTest() throws IOException {
		Response response = InjectionFlawsUtil.selectDepartment("Bob");

		Assert.assertEquals(response.code(), 200, "Response code !=200");
		System.out.println(response.body().string());
	}

	@Test(groups = {"sql", "introduction"})
	public void updateUserDepartmentTest() throws IOException {
		Response response = InjectionFlawsUtil.updateDepartment("Tobi", "Sales");

		Assert.assertEquals(response.code(), 200, "Response code !=200");
		System.out.println(response.headers());
	}

	@Test(groups = {"sql", "introduction"})
	public void alterTableTest() throws IOException {
		Response response = InjectionFlawsUtil.alterTable("employee", "phone2", "varchar(20)");

		Assert.assertEquals(response.code(), 200, "Response code !=200");
		System.out.println(response.protocol());
	}

	@Test(groups = {"sql", "introduction"})
	public void grantRightToTest() throws IOException {
		Response response = InjectionFlawsUtil.grantTo("UnauthorizedUser", "alter");

		Assert.assertEquals(response.code(), 200, "Response code !=200");
		System.out.println(response.networkResponse());
	}

	@Test(groups = {"sql", "injection", "introduction"})
	public void getDepartmentTest() throws IOException {
		Response response = InjectionFlawsUtil.getDepartment();

		Assert.assertEquals(response.code(), 200, "Response code !=200");
		System.out.println(response.headers());
	}
}