package qaautomation.december2022.apitest;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class APITest {
	String token;
	
	@Test(priority = 1)
	public void loginAPI() {
		RestAssured.baseURI = "https://api-staging-builder.engineer.ai";
		String payload = "{\"email\":\"testlabs@gmail.com\",\"password\":\"builder123\"}";
		
		Response responseLogin = RestAssured.given()
				.contentType("application/json")
				.body(payload).when().post("/users/sign_in");
		
		assertEquals(responseLogin.statusCode(),200);
		token = responseLogin.jsonPath().get("user.authtoken");
	}
	
	@Test(priority = 2)
	public void userAPI() {
		RestAssured.baseURI = "https://api-staging-builder.engineer.ai";
		Response responseUser = RestAssured.given()
				.contentType("application/json")
				.header("authtoken",token)
				.when().get("/user");
		
		assertEquals(responseUser.statusCode(), 200);
	}
	
	@Test(priority = 3)
	public void buildCardsAPI() {
		RestAssured.baseURI = "https://api-staging-builder.engineer.ai";
		Response responseBuildCards = RestAssured.given()
				.contentType("application/json")
				//.param("status","completed"); <-- logo ( ? ) merupakan params pada API
				.header("authtoken",token)
				.when().get("/build_cards?status=completed");
		
		assertEquals(responseBuildCards.statusCode(), 200);
	}
	
	
}
