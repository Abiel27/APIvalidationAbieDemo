package abiVal.Test_Utilit;

import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

//https://webgate.ec.europa.eu/api/tedapi/v2/api-docs
public abstract class webBaseEurope {
    @BeforeAll
    public static void init() {
        RestAssured.baseURI = "https://webgate.ec.europa.eu";
        RestAssured.basePath = "/api/tedapi";
    }
    @AfterAll
    public static void cleanUpAllAfterDone(){
        RestAssured.reset();
    }




}
