package qaautomation.december2022;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class APITest {
	@Test
	public void loginAPI() {
		RestAssured.baseURI = "https://api-staging-builder.engineer.ai";
		String payload = "{\"email\":\"testlabs@gmail.com\",\"password\":\"builder123\"}";
		
		//Need to input token
		
		Response responseLogin = RestAssured.given()
				.contentType("application/json")
				.body(payload).when().post("/users/sign_in");
		assertEquals(responseLogin.statusCode(),200);
	}
	
	@Test
	public void userAPI() {
		RestAssured.baseURI = "https://api-staging-builder.engineer.ai";
		Response responseUser = RestAssured.given()
				.contentType("authtoken")
				.when().get("/user");
		assertEquals(responseUser.statusCode(),200);
	}
}
