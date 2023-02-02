package qaautomation.december2022.schemalist;

public class SchemaNegative {
	public String schemaNegative() {
		String s = "{\n"
				+ "  \"$schema\": \"http://json-schema.org/draft-04/schema#\",\n"
				+ "  \"type\": \"object\",\n"
				+ "  \"properties\": {\n"
				+ "    \"message\": {\n"
				+ "      \"type\": \"string\"\n"
				+ "    }\n"
				+ "  },\n"
				+ "  \"required\": [\n"
				+ "    \"message\"\n"
				+ "  ]\n"
				+ "}";
		return s;
	}
	
	public String dashboardWithoutParam() {
		String s = "{\n"
				+ "  \"$schema\": \"http://json-schema.org/draft-04/schema#\",\n"
				+ "  \"type\": \"object\",\n"
				+ "  \"properties\": {\n"
				+ "    \"status\": {\n"
				+ "      \"type\": \"string\"\n"
				+ "    }\n"
				+ "  },\n"
				+ "  \"required\": [\n"
				+ "    \"status\"\n"
				+ "  ]\n"
				+ "}";
		return s;
	}
	
	public String dashboardWrongMethod() {
		String s = "{\n"
				+ "  \"$schema\": \"http://json-schema.org/draft-04/schema#\",\n"
				+ "  \"type\": \"object\",\n"
				+ "  \"properties\": {\n"
				+ "    \"build_card\": {\n"
				+ "      \"type\": \"string\"\n"
				+ "    }\n"
				+ "  },\n"
				+ "  \"required\": [\n"
				+ "    \"build_card\"\n"
				+ "  ]\n"
				+ "}";
		return s;
	}
}
