package abiVal.spartanUtile;

import abiVal.POJO.Spartan;
import com.github.javafaker.Faker;
import io.cucumber.java.it.Ma;

import java.util.LinkedHashMap;
import java.util.Map;

public class Spartan_Util {
    public static  Faker faker = new Faker();
    /*Used to get valid Ma Obj to represent post body
    *@return Map obj with random name, gender,phone(5000000000 - 1000000000000)
    *
     */
    public static Map<String,Object> getRandomSpartanMap(){



        Map<String,Object> bodyMap =new LinkedHashMap<>();
        bodyMap.put("name", faker.name().firstName());
        bodyMap.put("gender", faker.demographic().sex());
        bodyMap.put("phone", faker.number().numberBetween(5_000_000_000L, 10_000_000_000L));

        return bodyMap;
    }
    /*creat Spartan random generate with POJO and faker obj
    *@return spartan obj random name,gender and phone
     */
    public static Spartan getRandomSpartanPOJO(){
        Spartan sp = new Spartan();
        sp.setName(faker.name().firstName());
        sp.setGender(faker.demographic().sex());
        sp.setPhone(faker.number().numberBetween(5_000_000_000L, 10_000_000_000L));


        return sp;
    }



}
