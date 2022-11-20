package abiVal.day4;

import abiVal.POJO.Spartan;
import abiVal.Test_Utilit.SpartanNoAuthtestBaseclass;
import abiVal.spartan_Utile.SpartanUtil;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.*;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

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

    }
