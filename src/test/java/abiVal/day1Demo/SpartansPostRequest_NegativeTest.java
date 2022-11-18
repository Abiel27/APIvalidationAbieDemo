package abiVal.day1Demo;

import abiVal.POJO.Spartan;
import abiVal.Test_Utilit.SpartanNoAuthtestBaseclass;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class SpartansPostRequest_NegativeTest extends SpartanNoAuthtestBaseclass {
    @DisplayName("Post request with out content type expect 415")
    @Test
    public void test1() {
        Spartan sp = new Spartan("Abie","male",2029096292L);
        given()
                .log().all()
                .body(sp).
                when()
                .post("/spartans").
                then()
                .log().all()
                .statusCode(415);

    }

    @DisplayName("Post request with out json expect 400")
    @Test
    public void test2() {
        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body("Bad Json Structure here").
        when()
                .post("/spartans").
        then()
                .log().all()
                .statusCode(400)    ;

    }

    @DisplayName("Post request with validjson, bad name expect 400 detail name error")
    @Test
    public void test3() {
    }

    @DisplayName("Post request with validjson, bad name, phone expect 400 detail name and phone error message")
    @Test
    public void test4(){
    }
    @DisplayName("Post request with validjson, bad name, phone,gender expect 400 with 3 errors")
    @Test
    public void test5(){
}}