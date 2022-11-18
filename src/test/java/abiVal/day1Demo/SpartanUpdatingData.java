package abiVal.day1Demo;

import abiVal.POJO.Spartan;
import abiVal.Test_Utilit.SpartanNoAuthtestBaseclass;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class SpartanUpdatingData extends SpartanNoAuthtestBaseclass {
    @DisplayName("Put /spartans/{d} body as Map")
    @Test
    public void tstUpdateDataWithMapObjectAsBody() {
        /*{
        "name":"AbieldebeMe",
        "gender":"Female",
        "phone":2029096292
        }
         */
        Map<String, Object> bodyMap = new LinkedHashMap<>();
        bodyMap.put("name", "Maria");
        bodyMap.put("gender", "Female");
        bodyMap.put("phone", 2029096293L);
        System.out.println(bodyMap);

        given()
                .log().all()
                .pathParam("id",392)
                .contentType(ContentType.JSON)
                .body(bodyMap).
        when()
                .put("/spartans/{id}").
        then()
                .statusCode(204);
    }
    @DisplayName("Put /spartans/{d} body as POJO")
    @Test
    public void tstUpdateDataWithMapWithPoJO() {
        Spartan sp = new Spartan("Dawit", "Male", 2029096264);
        given()
                .log().all()
                .pathParam("id",392)
                .contentType(ContentType.JSON)
                .body(sp).
        when()
                .put("/spartans/{id}").
        then()
                .statusCode(204);
    }
    @DisplayName("PATCH /spartans/{id} body as String")
    @Test
    public void tstPartialUpdateDataWithString() {
        String patchBody= "{ \"phone\" : 2029096265}";
        given()
                .log().all()
                .pathParam("id",392)
                .contentType(ContentType.JSON)
                .body(patchBody).
        when()
                .patch("/spartans/{id}").
        then()
                .statusCode(204);
}
    @DisplayName("test DELETE /spartans{id}")
    @Test
    public void testDeleteOne(){
        given()
                .log().all()
                .pathParam("id", 391).
                when()
                .delete("/spartans/{id}").
                then()
                .statusCode(204);


}
}