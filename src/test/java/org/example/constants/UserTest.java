package org.example.constants;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserTest {

    @Test
    public  void CreateUserWithArray(){
        RestAssured.baseURI ="https://petstore.swagger.io/v2";
        RequestSpecification requestSpecification = RestAssured.given()
                .header("Content-Type" ,"application/json")
                .body("[\n" +
                        "  {\n" +
                        "    \"id\": 0,\n" +
                        "    \"username\": \"madraseye\",\n" +
                        "    \"firstName\": \"string\",\n" +
                        "    \"lastName\": \"string\",\n" +
                        "    \"email\": \"string\",\n" +
                        "    \"password\": \"string\",\n" +
                        "    \"phone\": \"string\",\n" +
                        "    \"userStatus\": 0\n" +
                        "  }\n" +
                        "]");
        Response response =requestSpecification.request(Method.POST ,"/user/createWithArray");
        System.out.println(response.asPrettyString());
        System.out.println(response.statusLine());
        Assertions.assertTrue(response.statusCode()==200);
    }

    @Test
    public void getUserName(){
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        RequestSpecification requestSpecification = RestAssured.given();
        Response response =requestSpecification.request(Method.GET , "/user/madraseye");
        System.out.println(response.asPrettyString());
        System.out.println(response.statusLine());
        Assertions.assertTrue(response.statusCode()==200);

    }

    @Test
    public void userName(){
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        int id =123;
        RequestSpecification requestSpecification =RestAssured.given()
                .header("Content-Type" , "application/json")
                .body("{\n" +
                        "  \"id\": 0,\n" +
                        "  \"username\": \"madraseye\",\n" +
                        "  \"firstName\": \"string\",\n" +
                        "  \"lastName\": \"string\",\n" +
                        "  \"email\": \"string\",\n" +
                        "  \"password\": \"string\",\n" +
                        "  \"phone\": \"string\",\n" +
                        "  \"userStatus\": 0\n" +
                        "}");
        Response response = requestSpecification.request(Method.PUT , "/user/user1");
       // UserTest userTest =response.as(userTest.class);
        System.out.println(response.asPrettyString());
        System.out.println(response.statusLine());
        Assertions.assertTrue(response.statusCode()==200);

    }


    @Test
    public  void deleteUserName(){
        RestAssured.baseURI ="https://petstore.swagger.io/v2";
        RequestSpecification requestSpecification = RestAssured.given();
        Response response = requestSpecification.request(Method.DELETE, "user/madraseye");
        System.out.println(response.asPrettyString());
        System.out.println(response.statusCode());
        Assertions.assertTrue(response.statusCode()==200);


    }
}
