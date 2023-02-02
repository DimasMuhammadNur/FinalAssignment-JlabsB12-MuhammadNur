package qaautomation.december2022.task4;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class MainAPITestTask4{	
	@Test
	public void getFakerUsername() {
		Faker fakerForAll = new Faker();
		String username = fakerForAll.name().firstName();
		String password = fakerForAll.internet().password();
		String email = fakerForAll.bothify("?????##@gmail.com");
		String phoneNumber = fakerForAll.phoneNumber().phoneNumber();
		
		System.out.println(username);
		System.out.println(password);
		System.out.println(email);
		System.out.println(phoneNumber);
	}
	

	@Test
	public void signUp() {
		RestAssured.baseURI = "https://api-staging-builder.engineer.ai";
		String payload = "{\"user\":{\"first_name\":\"Janna\","
				+ "\"last_name\":\"\","
				+ "\"email\":\"dvqdc90@gmail.com\","
				+ "\"password\":\"54xrvmz5dn\","
				+ "\"phone_number\":\"+62-10918554360\","
				+ "\"user_type\":\"User\","
				+ "\"currency_id\":2}}";
		Response responseUser = RestAssured.given()
				.contentType("application/json")
				.body(payload)
				.when().post("/users");
		
		assertEquals(responseUser.statusCode(), 200);
	}
}

