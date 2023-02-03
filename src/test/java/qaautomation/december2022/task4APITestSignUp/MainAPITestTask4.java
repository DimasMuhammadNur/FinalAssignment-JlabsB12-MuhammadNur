package qaautomation.december2022.task4APITestSignUp;

import java.util.Locale;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class MainAPITestTask4{	
	@Test(priority = 1)
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

	@Test(priority = 2)
	public void signUp() {
		Faker fakerForAll = new Faker(Locale.US);
		String username = fakerForAll.name().firstName();
		String password = fakerForAll.internet().password();
		String email = fakerForAll.bothify("?????##@gmail.com");
		String phNumber = fakerForAll.phoneNumber().phoneNumber();
		phNumber = phNumber.replaceAll("-","");
		
		System.out.println(username);
		System.out.println(password);
		System.out.println(email);
		System.out.println(phNumber);
		
		RestAssured.baseURI = "https://api-staging-builder.engineer.ai";
		String payload = "{\"user\":{\"first_name\":\""+username+"\","
				+ "\"last_name\":\"\","
				+ "\"email\":\""+email+"\","
				+ "\"password\":\""+password+"\","
				+ "\"phone_number\":\"+62-"+phNumber+"\","
				+ "\"user_type\":\"User\","
				+ "\"currency_id\":2}}";
		Response responseUser = RestAssured.given()
				.contentType("application/json")
				.body(payload)
				.when().post("/users");
		
		AssertJUnit.assertEquals(responseUser.statusCode(), 200);
	}
	
	@Test(priority = 3)
	public void signUpError() {
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
		
		AssertJUnit.assertEquals(responseUser.statusCode(), 422);
	}
}

