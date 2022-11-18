package abiVal.day1Demo;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.*;
import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.reset;

public class breakingBadTest {
    //https://www.breakingbadapi.com/api/characters?name=Walter

    @BeforeAll
    public static void init(){

    RestAssured.baseURI = "https://www.breakingbadapi.com";
        RestAssured.basePath = "/api";




    }
    @AfterAll
    public static void cleanup(){
        reset();
    }
@Test
    public void filterCharachterName(){
        given()
                .log().uri()
                .queryParam("name", "Walter").
        when()
                .get("/characters").
        then()
                .log().all()
                .statusCode(200)
                .header("Content-Type","application/json; charset=utf-8")
                .contentType("application/json; charset=utf-8")
                ;

}
@DisplayName("Test GET /character_id")
    @Test
    public void testCharacter(){
        given()
                .pathParam("char_id",1)
                .log().uri().
         when()
                .get("/characters/{char_id}").
         then()
                .log().all()
                .statusCode(200)
                .header("content-Type","application/json; charset=utf-8")
                .contentType("application/json; charset=utf-8")
                ;

}
//episodes/60
    @DisplayName("Test GET /episode/{epesode_id}")
    @Test
    public void test1Episode(){
        given()
                .pathParam("episode_id",60)
                .log().all().
        when()
                .get("episodes/{episode_id}").
        then()
                .log().all()
                .statusCode(200)
                .contentType(ContentType.JSON);




    }

}
