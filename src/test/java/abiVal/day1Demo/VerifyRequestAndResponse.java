package abiVal.day1Demo;

import abiVal.Test_Utilit.SpartanNoAuthtestBaseclass;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.Is.is;

public class VerifyRequestAndResponse extends SpartanNoAuthtestBaseclass{
    @DisplayName("verifing the Get /spartans/{id}")
    @Test
   public void testOneSpartanInOneShot(){

        given()
                .log().all()
                .pathParam("id",3).
        when()
                .get("/spartans/{id}").prettyPeek().
        then()
                .log().all()
                .statusCode(200)
                .header("Content-Type", is("application/json"))
                .body("id", is(3))
                .body("name", is("Hello Patch"))
                .body("gender", is("Male"))


                ;
    }
}
