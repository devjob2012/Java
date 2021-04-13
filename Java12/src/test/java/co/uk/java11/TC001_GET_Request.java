package co.uk.java11;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TC001_GET_Request {
    @Test
    void getWetherDetails() {
        RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
        RequestSpecification httpRequest = given();

        Response response = httpRequest.request(Method.GET, "/dehradun");

        System.out.println(response.getBody().asString());

    }

    @Test
    void getWeatherDetails() {


        given()
                .when()
                .get("http://restapi.demoqa.com/utilities/weather/city/london")
                .then()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .assertThat().body("City", equalTo("London"));
    }

    @Test
    void postData() {
        RestAssured.baseURI = "http://restapi.demoqa.com/customer";
        RestAssured.basePath = "/register";

        Map map = new HashMap();
        map.put("FirstName", "John");
        map.put("LastName", "Mills");
        map.put("UserName", "userName");
        map.put("Password", "password");
        map.put("Email", "mail@mail.coom");

        given()
                .contentType("application/json")
                .body(map)
                .when()

                .post()
                .then()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .assertThat().body("City", equalTo("London"));
    }
}
