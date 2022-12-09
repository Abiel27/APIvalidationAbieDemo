package abiVal.Day5;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.*;

public class starWarAPI_Test {


    /*
   Send request to GET https://swapi.dev/api/people/?page=2
   find out averege height all people showed up int the
   response
     */
    @BeforeAll
    public static void init(){
        baseURI ="https://swapi.dev";
        basePath = "/api";
    }
    @DisplayName("GET average height from GET /people response")
    @Test
    public void testGETAverageHeight(){
        List<Integer> allHeights = get("/people")
                .jsonPath()
                .getList("results.height", Integer.class);

        System.out.println("allHeights = " + allHeights);

        int total = 0;
        for (Integer height :allHeights) {
            total = height;

        }
        int average = total/(allHeights.size());
        System.out.println("average = " + average);


    }
    @AfterAll
    public static void sleanup(){
        reset();
    }

}
