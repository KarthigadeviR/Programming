package getRequest;

import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import java.util.HashMap;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class TestProductCatalogue {

	@Test
	public void testPostMethod() {

		String data = "{\"name\":\"BobbiBBrown\",\"description\":\"CreateNewProduct\", \"price\":\"45.85\",\"itemCount\":\"2\", \"active\" : true}";

		Response res =

				given().contentType("application/json").body(data)

						.when().post("https://schqarecruitment.azurewebsites.net/v1/product")

						.then().statusCode(200).log().body().extract().response();

	}

	@Test
	public void testPutMethod() {

		String data = "{\"name\":\"MacBBobBrown\",\"description\":\"CreateNewProduct\", \"price\":\"45.85\",\"itemCount\":\"2\", \"active\" : true}";

		Response res =

				given().contentType("application/json").body(data)

						.when().put("https://schqarecruitment.azurewebsites.net/v1/product/68a5141e-6d9c-4944-9679-ec3ef6b0279e")

						.then().statusCode(200).log().body().extract().response();

	}

	@Test
	public void testGetMethod() {

		int code = get("https://schqarecruitment.azurewebsites.net/v1/product/68a5141e-6d9c-4944-9679-ec3ef6b0279e")
				.getStatusCode();

		Assert.assertEquals(code, 200);

	}

	@Test
	public void testGetAllMethod() {

		int code = get("https://schqarecruitment.azurewebsites.net/v1/products").getStatusCode();

		Assert.assertEquals(code, 200);
	}

	@Test
	public void testDeletetMethod() {

		given()

		.when().delete("https://schqarecruitment.azurewebsites.net/v1/product/7b2ede43-3eb9-4f6d-a1f5-466327069c6f")

		.then().statusCode(200).log().body().extract().response();

	}

}
