package org.example;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StoreTest {
    @Test
    public void placeOrder(){
        RestAssured.baseURI ="https://petstore.swagger.io/v2/";
        int id = 102;
        RequestSpecification requestSpecification = RestAssured.given()
                .header("Content-Type" ,"application/json")
                .body("{\n" +
                        "  \"id\": 198,\n" +
                        "  \"petId\": 0,\n" +
                        "  \"quantity\": 0,\n" +
                        "  \"shipDate\": \"2023-10-05T06:43:51.600Z\",\n" +
                        "  \"status\": \"placed\",\n" +
                        "  \"complete\": true\n" +
                        "}");


        Response response = requestSpecification.request(Method.POST, "/store/order");
        System.out.println(response.asPrettyString());
        System.out.println(response.statusLine());
        Assertions.assertTrue(response.statusCode()==200);

    }


    @Test
    public void getOrderByIdFound(){
        RestAssured.baseURI="https://petstore.swagger.io/v2/";
        RequestSpecification requestSpecification=RestAssured.given();
        Response response=requestSpecification.request(Method.GET,"/store/order/198");
        System.out.println(response.asPrettyString());
        System.out.println(response.statusLine());
        Assertions.assertTrue(response.statusCode()==200);

    }

    @Test
    public  void deleteStore(){
        RestAssured.baseURI="https://petstore.swagger.io/v2/";
        RequestSpecification requestSpecification =RestAssured.given();
        Response response = requestSpecification.request(Method.DELETE , "/store/order/198");
        System.out.println(response.asPrettyString());
        System.out.println(response.statusLine());
        Assertions.assertTrue(response.statusCode()==200);

    }


    @Test
    public void getByInventory(){
        RestAssured.baseURI ="https://petstore.swagger.io/v2/";
        RequestSpecification requestSpecification = RestAssured.given();
        Response response = requestSpecification.request(Method.GET, "store/inventory");
        System.out.println(response.asPrettyString());
        System.out.println(response.statusLine());

    }
    }
