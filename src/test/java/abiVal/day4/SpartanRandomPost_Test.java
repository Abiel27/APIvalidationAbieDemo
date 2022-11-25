package abiVal.day4;

import abiVal.POJO.Spartan;
import abiVal.Test_Utilit.SpartanNoAuthtestBaseclass;
import abiVal.spartan_Utile.SpartanUtil;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.*;

import java.util.Map;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SpartanRandomPost_Test extends SpartanNoAuthtestBaseclass {

    @DisplayName("/POST /spartans with random data")
    @Test
    public void addOneRandomSpartanTest() {
        Map<String, Object> randomRequestBodyMap = SpartanUtil.getRandomSpartanMap();

        given()
                .log().body()
                .contentType(ContentType.JSON)
                .body(randomRequestBodyMap).
        when()
                .post("/spartans").

        then()
                .log().all()
                .statusCode(is(201))
                .body("data.name",is(randomRequestBodyMap.get("name")))
                .body("data.gender",is(randomRequestBodyMap.get("gender")))
                .body("data.phone",is(randomRequestBodyMap.get("phone")))
                ;
    }
    @DisplayName("/POST /spartans with random Spartans POJO")
    @Test
    public void addOneRandomSpartanPOJO() {
        Spartan randomPOJO = SpartanUtil.getRandomSpartanPOJO();

        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(randomPOJO).
        when()
                .post("/spartans").

        then()
                .log().all()
                .body("data.name",is(randomPOJO.getName()))
                .body("data.gender",is(randomPOJO.getGender()))
               ;


    }
    @DisplayName("POST /spartans then GET IT TO VERIFY")
    @Test
    public void testAddOneDataThenGetONeDataToVerify(){
        /*
        *Send post request, save the generated ID
        *check statuse code is 2001
        * send get request using the id saved from above
        * check statuse code is 200
         */
        Spartan randomPOJO = SpartanUtil.getRandomSpartanPOJO();
        Response response = given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(randomPOJO).
        when()
                .post("/spartans").prettyPeek();// looking to ID
       int newID= response.path("data.id");
        System.out.println(newID);
//        int newID = response.jsonPath().getInt("data.id");
        assertThat(response.statusCode(), is(201));

    }
    @DisplayName("POST /spartans then GET IT TO VERIFY 2 WITH EXTRACT METHOD")
    @Test
    public void testAddOneDataThenGetONeDataToVerifyDirectInChainMethod(){
        // get a data with in the chain using extract method
        Spartan randomPOJO = SpartanUtil.getRandomSpartanPOJO();
        int newID = given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(randomPOJO).
                when()
                .post("/spartans").
        then()
                .log().all()
                .statusCode(201)
                .extract()
                .path("data.id");
        System.out.println("newID = " + newID);


    }
    @DisplayName("POST /spartans then GET IT TO VERIFY 3 WITH EXTRACT METHOD")
    @Test
    public void testAddOneDataThenExtractHeader(){
        //check statuse code 201 and extract location header
        Spartan randomPOJO = SpartanUtil.getRandomSpartanPOJO();
        String locationHeader = given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(randomPOJO).
        when()
                .post("/spartans").
        then()
                .statusCode(201).
        extract()
                .header("Location");
        System.out.println("locationHeader = " + locationHeader);

        //sending for request using above url which is extracted
        get(locationHeader).prettyPeek();


    }


    }
