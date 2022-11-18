package abiVal.day1Demo;

import abiVal.Test_Utilit.SpartanNoAuthtestBaseclass;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;


import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.core.IsEqual.equalTo;

public class getOnespartan extends SpartanNoAuthtestBaseclass {

    @DisplayName("get Spartan with path variable and query param")

    @Test
    public void get_one_spartan_by_ID() {
        Response response =
                given()
                        .log().all()
                        .accept("application/json")
                        .pathParam("id", 2).
                        when()
                        .get("/spartans/{id}")
                        .prettyPeek();
        assertThat(response.statusCode(), equalTo(200));
        assertThat(response.contentType(), equalTo("application/json"));

        //=========== using query param =====================

        Response response1 =
                given()
                        .log().all()
                        .queryParam("nameContains", "Abi")
                        .queryParam("gender", "Male").
                        when()
                        .get("spartans/search")
                        .prettyPeek();
        System.out.println("response1.path(\"totalElement\") = " + response1.path("totalElement"));

    }/*{
    "id": 2,
    "name": "Nels",
    "gender": "Male",
    "phone": 4567891230
}*/
}