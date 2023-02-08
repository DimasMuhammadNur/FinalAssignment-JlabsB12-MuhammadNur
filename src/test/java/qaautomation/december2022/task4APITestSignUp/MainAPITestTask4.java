package qaautomation.december2022.task4APITestSignUp;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import qaautomation.december2022.utils.DataUtility;

public class MainAPITestTask4 extends BaseAPITestTask4{	 
	Faker fakerForAll = new Faker();
	String username = fakerForAll.name().firstName();
	String password = fakerForAll.internet().password();
	String email = fakerForAll.bothify("?????##@gmail.com");
	String phNumber = "+62-87824393567";

	@Test
	public void getFakerUsername() {
		Faker fakerForAll = new Faker();
		String username = fakerForAll.name().firstName();
		String password = fakerForAll.internet().password();
		String email = fakerForAll.bothify("?????##@gmail.com");
		String phoneNumber = "+62-87824393567";
		
		System.out.println(username);
		System.out.println(password);
		System.out.println(email);
		System.out.println(phoneNumber);
	}

	@Test
	public void signUp() {
		RestAssured.baseURI = "https://api-staging-builder.engineer.ai";
		String payload = strPayload(username,email,password,phNumber);
		Response responseUser = RestAssured.given()
				.contentType("application/json")
				.body(payload)
				.when().post("/users");
		AssertJUnit.assertEquals(responseUser.statusCode(), 200);
	}
	
	@Test
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
	
	@Test
	public void dashboardAPI() {
		RestAssured.baseURI = "https://api-staging-builder.engineer.ai";
		//Response responseDashboard = given().spec(loginJsonSpec)
		//		.when().get("/build_cards?status=completed");
		Response responseDashboard = RestAssured.given()
				.contentType("application/json")
				.body(DataUtilityTask4.getDataFromExcel("requestbody", "signinBody"))
				.when().post(DataUtilityTask4.getDataFromExcel("path", "signup"));
		responseDashboard.then().assertThat().body(matchesJsonSchema(DataUtility.getDataFromExcel("schemas", "dashboardschema")));
		//assertEquals(responseDashboard.statusCode(), 422);
	}
}

