package abiVal.LibraryAooTest;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;

import static io.restassured.RestAssured.*;


@DisplayName("Library app simple test")
public class libraryAppTest {
    @BeforeAll
    public static void init(){

        baseURI = "https://library2.cybertekschool.com";
        basePath = "/rest/v1";
    }
    @AfterAll
    public static void cleanUp(){
        reset();
    }
}
