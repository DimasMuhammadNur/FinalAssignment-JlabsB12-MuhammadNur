package qaautomation.december2022.apitest;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import qaautomation.december2022.schemalist.SchemaDashboard;
import qaautomation.december2022.schemalist.SchemaNegative;
import qaautomation.december2022.utils.DataUtility;

public class DashboardAPI extends BaseAPITest{
	@Test
	public void dashboardAPIUsingSchemaInCode() {
		SchemaDashboard schema = new SchemaDashboard();
		RestAssured.baseURI = "https://api-staging-builder.engineer.ai";
		//Response responseDashboard = given().spec(loginJsonSpec)
		//		.when().get("/build_cards?status=completed");
		Response responseDashboard = given().spec(loginJsonSpec)
				.when().get(DataUtility.getDataFromExcel("path", "dashboard"));
		
		responseDashboard.then().assertThat().body(matchesJsonSchema(schema.dashboardSchema()));
		assertEquals(responseDashboard.statusCode(), 200);
	}
	
	@Test
	public void dashboardAPIWithoutToken() {
		SchemaNegative schema = new SchemaNegative();
		RestAssured.baseURI = "https://api-staging-builder.engineer.ai";
		//Response responseDashboard = given().spec(loginJsonSpec)
		//		.when().get("/build_cards?status=completed");
		Response responseDashboard = given().spec(commonJsonSpec)
				.when().get("/build_cards?status=completed");
		
		responseDashboard.then().assertThat().body(matchesJsonSchema(schema.schemaNegative()));
		//assertEquals(responseDashboard.statusCode(), 401);
	}
	
	@Test
	public void dashboardAPIWithoutParam() {
		SchemaNegative schema = new SchemaNegative();
		RestAssured.baseURI = "https://api-staging-builder.engineer.ai";
		//Response responseDashboard = given().spec(loginJsonSpec)
		//		.when().get("/build_cards?status=completed");
		Response responseDashboard = given().spec(loginJsonSpec)
				.when().get("/build_cards");
		
		responseDashboard.then().assertThat().body(matchesJsonSchema(schema.dashboardWithoutParam()));
		//assertEquals(responseDashboard.statusCode(), 401);
	}
	
	@Test
	public void dashboardAPIWithoutMethod() {
		SchemaNegative schema = new SchemaNegative();
		RestAssured.baseURI = "https://api-staging-builder.engineer.ai";
		Response responseDashboard = given().spec(loginJsonSpec)
				.when().post("/build_cards?status=completed");
		
		responseDashboard.then().assertThat().body(matchesJsonSchema(schema.dashboardWrongMethod()));
	}
}
