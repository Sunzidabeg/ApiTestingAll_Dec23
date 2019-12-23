package baseApi;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestAPI {



 @Test
    public void test(){

        RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
        RequestSpecification a = RestAssured.given();
        Response b = a.request(Method.GET,"/Plano");
        //String s = b.getBody().asString();

     //Status line validation
        //int code=b.getStatusCode();
        String line=b.getStatusLine();
        int code=b.getStatusCode();
     System.out.println("Status line is => " +code);



     System.out.println("Status code is => " + code);



     //header validate
        String hd=b.header("Content-Type");
     String hd2=b.header("Server");
     String hd3=b.header("Content-Encoding");

     System.out.println("Content-Type  is => " +hd);
     System.out.println("Content-Type  is => " +hd2);
     System.out.println("Content-Type  is => " +hd3);

     Assert.assertEquals(hd2,"nginx");
     //body validation

     JsonPath jsonPath = b.jsonPath();


     String city = jsonPath.get("City");
     System.out.println("city   is => " +city);
     Assert.assertEquals(city,"plano");

     String Temperature = jsonPath.get("Temperature");
     System.out.println("Temperature  is => " +Temperature);
     String WindSpeed = jsonPath.get("WindSpeed");
     System.out.println("WindSpeed  is => " +WindSpeed);

    }




}
