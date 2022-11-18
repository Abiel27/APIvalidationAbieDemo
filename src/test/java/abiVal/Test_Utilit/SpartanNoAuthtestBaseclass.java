package abiVal.Test_Utilit;

import io.restassured.RestAssured;
import org.junit.jupiter.api.*;


public class SpartanNoAuthtestBaseclass {
    @BeforeAll
    public static void init() {
        RestAssured.baseURI = "http://54.236.150.168:8000";
        RestAssured.basePath = "/api";
    }
    @AfterAll
    public static void cleanUpAllAfterDone(){
        RestAssured.reset();
    }





}
