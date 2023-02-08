package qaautomation.december2022.task4APITestSignUp;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class BaseAPITestTask4 {
	RequestSpecification commonJsonSpec = new RequestSpecBuilder()
			.setBaseUri("https://api-staging-builder.engineer.ai")
			.setContentType(ContentType.JSON)
			.build().log().all();
	
	public String strPayload(String username, String email, String password, String phNumber) {
		String getPayload = "{\"user\":{\"first_name\":\""+username+"\","
				+ "\"last_name\":\"\","
				+ "\"email\":\""+email+"\","
				+ "\"password\":\""+password+"\","
				+ "\"phone_number\":\"+62-"+phNumber+"\","
				+ "\"user_type\":\"User\","
				+ "\"currency_id\":2}}";
		return getPayload;
	}
}
