package sqlinjection;

import api.util.InjectionFlawsUtil;
import okhttp3.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class SqlInjectionsTests {

	@Test(groups = {"sql", "introduction"})
	public void selectUserDepartmentTest() throws IOException {
		System.out.println("========================================");
		Response response = InjectionFlawsUtil.selectDepartment("Bob");

		Assert.assertEquals(response.code(), 200, "Response code !=200");
		System.out.println(response.body().string());
	}

	@Test(groups = {"sql", "introduction"})
	public void updateUserDepartmentTest() throws IOException {
		System.out.println("========================================");
		Response response = InjectionFlawsUtil.updateDepartment("Tobi", "Sales");

		Assert.assertEquals(response.code(), 200, "Response code !=200");
		System.out.println(response.headers());
	}

	@Test(groups = {"sql", "introduction"})
	public void alterTableTest() throws IOException {
		System.out.println("========================================");
		Response response = InjectionFlawsUtil.alterTable("employee", "phone2", "varchar(20)");

		Assert.assertEquals(response.code(), 200, "Response code !=200");
		System.out.println(response.protocol());
	}

	@Test(groups = {"sql", "introduction"})
	public void grantRightToTest() throws IOException {
		System.out.println("========================================");
		Response response = InjectionFlawsUtil.grantTo("UnauthorizedUser", "alter");

		Assert.assertEquals(response.code(), 200, "Response code !=200");
		System.out.println(response.networkResponse());
	}

	@Test(groups = {"sql", "injection", "introduction"})
	public void getDepartmentTest() throws IOException {
		System.out.println("========================================");
		Response response = InjectionFlawsUtil.getDepartment();

		Assert.assertEquals(response.code(), 200, "Response code !=200");
		System.out.println(response.headers());
	}
}