package abiVal.day1Demo;

import abiVal.Test_Utilit.SpartanNoAuthtestBaseclass;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.is;

@DisplayName("sparatan contetType Test")
public class ContentType_Test extends SpartanNoAuthtestBaseclass {

    @DisplayName("Get /hello")
    @Test
    public void testHelloContetType(){
        when()
                .get("/hello").
                then()
                .contentType(ContentType.TEXT)
                .body(is("Hello from Sparta"))

        ;

    }
    @DisplayName("Get /spartans in json")
    @Test
    public void testSpartanJsonContentType(){
        given()
                //asking json result from server
                .accept(ContentType.JSON).
        when()
                .get("/spartans").
        then()
                //verfigin the response
                .contentType(ContentType.JSON)
                ;

    }
    @DisplayName("Get /spartanss in xml")
    @Test
    public void testSpartanXmlContentType(){
        given()
                //asking json result from server
                .accept(ContentType.XML).
                when()
                .get("/spartans").prettyPeek().
                then()
                //verfigin the response
                .contentType(ContentType.XML)

        ;

    }


}
