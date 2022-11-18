package abiVal.day1Demo;

import abiVal.Test_Utilit.SpartanNoAuthtestBaseclass;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;


import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.IsEqual.equalTo;
public class spartansJsonPath_Test extends SpartanNoAuthtestBaseclass {
    //http://54.236.150.168:8000/spartans/160

    //JsonPath provides location os certain data
    //reuse able methods to extract data
    // Jsonpath() methos of response to get JsonPath obj
    @Test
    public void testONe() {
        Response response =
                given()
                        .pathParam("id", 10).
                        when()
                        .get("spartans/{id}")
                        .prettyPeek();

        //using path method to extract data
        int myId = response.path("id");
        System.out.println("response =" + myId);


        JsonPath jp = response.jsonPath();
        int myId2 = jp.getInt("id");
        System.out.println("Jp Id =" + myId2);
        long phoneNUM = jp.getLong("phone");
        System.out.println("phone =" + phoneNUM);
        String myName = jp.getString("name");
        System.out.println("myName =" + myName);

        //the whole object using getMap
        System.out.println(" obj spartan =" + jp.getMap(""));

        //or the same other way to print in Map
        Map<String, Object> resultJsonInMap = jp.getMap("");
        System.out.println("resultJsonInMap =" + resultJsonInMap);


    }

    @DisplayName(("Extract data from GET /spartans"))
    @Test
    public void testGetAllSpartans() {

        JsonPath jp = get("/spartans").jsonPath();
        System.out.println("my first in the Array = "
                + jp.getInt("id[0]"));

        System.out.println("jp.getString(\"name[0]\") = "
                + jp.getString("name[0]"));

        System.out.println("jp.getMap(\"[10]\") = "
                + jp.getMap("[10]"));

        System.out.println("Lorenz ID = "
                + jp.getInt("[10].id"));


    }

    @Test
    public void testJsonArrayFieldIntoList() {
        JsonPath jp = given()
                .queryParam("name", "Abie")
                .queryParam("gender", "Male")
                .log().all().
                when()
                .get("spartans/search")

                .jsonPath();
        System.out.println("Llist of Id = "
                + jp.getList("content.id"));
        System.out.println("jp.getList(\"content.name\") = "
                + jp.getList("content.name"));
        System.out.println(("List of phone =")
                + jp.getList("content.phone"));

        //getList method has 2 overLoad version ,
        List<Integer> allID = jp.getList("content.id");
        //have a very spesific data type with the class
        List<Integer> allID2 = jp.getList("content.id", Integer.class);
        List<String> allName = jp.getList("content.name", String.class);
        List<Long> allPhone = jp.getList("content.phone", Long.class);


    }
    @DisplayName("Get List /Spartans")
    @Test
    public void testGetListOfSpartans(){
        JsonPath jp = get("/spartans").jsonPath();
        //save the List into List obj and assert the size
        List<Integer> allIDs = jp.getList("id", Integer.class);
        assertThat(allIDs, hasSize(309));


    }
}