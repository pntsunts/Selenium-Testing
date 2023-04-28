package Restassured;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;





//run json api json json-server students.json

public class MyApi {
	
	
	void GetStudents() {
		given()
		.when()
			.get(" http://localhost:3000/Students")
		.then()
			.statusCode(200)
			.log().all();
	}
	
	
	void putinHashMap() {
		HashMap data = new HashMap();
		data.put("firstName", "Test1");
		data.put("LastName", "Zwane");
		
		given()
			.contentType("application/json")
			.body(data)
		.when()
			.post(" http://localhost:3000/Students")
		.then()
			.statusCode(201)
			.body("firstName", equalTo("Test1"))
			.body("LastName", equalTo("Zwane"))
			.log().all();
	}
	
	
	void PutingPojo() {
		Pojo_request pojo = new Pojo_request();
		pojo.setFirstName("Nkanyezi");
		pojo.setLastName("Zwane");
		
		given()
			.contentType("application/json")
			.body(pojo)
		.when()
			.post("http://localhost:3000/Students")
		.then()
			.statusCode(201)
			.body("firstName",equalTo("Nkanyezi"))
			.log().all();
	}
	@Test
	void delet() {
		given()
		.when()
			.delete("http://localhost:3000/Students/7")
		.then()
			.statusCode(200);
	}

	
	

}
