package org.example;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.File;

import static org.example.constants.Constants.baseUri;

public class PetTest {
    @Test
    public void getAllPets() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2/pet/";
        RequestSpecification requestSpecification = RestAssured.given();
        Response response = requestSpecification.request(Method.GET);
        System.out.println(response.asPrettyString());
    }
    @Test
    public void createPet(){
        RestAssured.baseURI = baseUri;

        RequestSpecification requestSpecification = RestAssured.given()
                .header("Content-Type" ,"application/json")
                .body("{\n" +
                "  \"category\": {\n" +
                "    \"id\": 0,\n" +
                "    \"name\": \"string\"\n" +
                "  },\n" +
                "  \"name\": \"doggie\",\n" +
                "  \"photoUrls\": [\n" +
                "    \"string\"\n" +
                "  ],\n" +
                "  \"tags\": [\n" +
                "    {\n" +
                "      \"id\": 0,\n" +
                "      \"name\": \"string\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": \"available\"\n" +
                "}");
        Response response = requestSpecification.request(Method.POST,"pet");
        System.out.println(response.asPrettyString());
        System.out.println(response.statusLine());
        Assertions.assertTrue(response.statusCode()==200);
    }

@Test
  public void uploadImage()
{
    System.setProperty("mail.mime.multipart.ignoreexistingboundaryparameter", "true");

    ClassLoader classLoader = getClass().getClassLoader();
    File file = new File(classLoader.getResource("dummy1.jpeg").getFile());
    RestAssured.baseURI = "https://petstore.swagger.io/v2/";
    RequestSpecification requestSpecification = RestAssured.given()
            .header("Content-Disposition","form-data; name=file; filename=\"dummy1.jpeg\"")
            .header("Content-Type","image/jpeg")
            .body(file);
    System.out.println(requestSpecification.request(Method.POST, "/pet/111/uploadImage").asPrettyString());




    }

  @Test
    public void updatePet(){
         RestAssured.baseURI="https://petstore.swagger.io/v2";
         int id=111;
      RequestSpecification requestSpecification = RestAssured.given()
              .header("Content-Type" ,"application/json")
                 .body("{\n" +
                         "  \"id\":"+id+",\n" +
                         "  \"category\": {\n" +
                         "    \"id\": 0,\n" +
                         "    \"name\": \"rui\"\n" +
                         "  },\n" +
                         "  \"name\": \"doggie\",\n" +
                         "  \"photoUrls\": [\n" +
                         "    \"string\"\n" +
                         "  ],\n" +
                         "  \"tags\": [\n" +
                         "    {\n" +
                         "      \"id\": 0,\n" +
                         "      \"name\": \"string\"\n" +
                         "    }\n" +
                         "  ],\n" +
                         "  \"status\": \"available\"\n" +
                         "}");
         Response response= requestSpecification.request(Method.PUT,"pet");
         Pet pet = response.as(Pet.class);
         Assertions.assertTrue(id==pet.getId());
      System.out.println(response.asPrettyString());
  }

  @Test
    public void deletePetSuccess(){
        RestAssured.baseURI="https://petstore.swagger.io/v2";
        RequestSpecification requestSpecification = RestAssured.given();
      Response response = requestSpecification.request(Method.DELETE, "pet/11");
      System.out.println(response.asPrettyString());
      System.out.println(response.statusCode());
        Assertions.assertTrue(response.statusCode()==200);

  }
    @Test
    public void deletePetNotFound(){
        RestAssured.baseURI="https://petstore.swagger.io/v2";
        RequestSpecification requestSpecification = RestAssured.given();
        Response response = requestSpecification.request(Method.DELETE, "pet/0");
        System.out.println(response.asPrettyString());
        System.out.println(response.statusCode());
        Assertions.assertTrue(response.statusCode()==404);

    }


    @Test
    public void getPetById() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2/";
        RequestSpecification requestSpecification = RestAssured.given();
        Response response = requestSpecification.request(Method.GET,"pet/1");
        System.out.println(response.asPrettyString());
    }
}
