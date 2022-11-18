package abiVal.day1Demo;

import abiVal.POJO.Spartan;
import abiVal.Test_Utilit.SpartanNoAuthtestBaseclass;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class PostingData_Test extends SpartanNoAuthtestBaseclass {
    @DisplayName("Post /spartans with String")
    @Test
    public void tstPostDataWithStringBody() {
        /*{
        "name":"Abieldebe",
        "gender":"Female",
        "phone":2029096292
        }
         */
        String postSTRBody = "{\n" +
                "        \"name\":\"Abieldebe\",\n" +
                "        \"gender\":\"Male\",\n" +
                "        \"phone\":2029096292\n" +
                "        }";

        given()
                .log().all()
                /*.header("Content-Type","application/json")
                .contentType("application/json")*/
                .contentType(ContentType.JSON)
                .body(postSTRBody).
        when()
                .post("/spartans").
        then()
                .log().all()
                .statusCode(is(201))
                //this is asserting respons header
                .contentType(ContentType.JSON)
                .body("success", is("A Spartan is Born!"))
                .body("data.name", is("Abieldebe"))
        ;


    }

    @DisplayName("Post /spartans with external File")
    @Test
    public void tstPostDataWithJsonFile() {
        /*{
        "name":"AbieldebeMe",
        "gender":"Female",
        "phone":2029096292
        }
         */
        File jsonFile = new File("singleSpartan.json");
        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(jsonFile).
        when()
                .post("/spartans").
        then()
                .log().all()
                .statusCode(201);


    }

    @DisplayName("Post /spartans with Map object")
    @Test
    public void tstPostDataWithMapObjectAsBody() {
        /*{
        "name":"AbieldebeMe",
        "gender":"Female",
        "phone":2029096292
        }
         */
        Map<String, Object> bodyMap = new LinkedHashMap<>();
        bodyMap.put("name", "AbieldebeMe");
        bodyMap.put("gender", "Female");
        bodyMap.put("phone", 2029096292L);
        System.out.println(bodyMap);

        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(bodyMap).
        when()
                .post("/spartans").
        then()
                .log().all()
                .statusCode(201);

    }
    @DisplayName("Post /spartans with POJO")
    @Test
    public void tstPostDataWithPOJO() {
         Spartan sp = new Spartan("AbieldebeMe","Female",2029096292L);

        /*{
        "name":"AbieldebeMe",
        "gender":"Female",
        "phone":2029096292L
        }
         */
        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(sp).
        when()
                .post("/spartans").
        then()
                .log().all()
                .statusCode(201);

    }}