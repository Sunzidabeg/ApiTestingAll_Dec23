package APITesting;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Header {

@Test
    public void CityWeather(){

        RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
        RequestSpecification req = RestAssured.given();
        Response res = req.request(Method.GET, "/Richardson");
        String ss = res.getBody().asString();


        //Initializating:
        int code = res.getStatusCode();
        String line = res.getStatusLine();
       String head1 = res.contentType();
       String head2 = res.header("Server");
       String head3 = res.header("Content-Length");


     //Validating:
    Assert.assertEquals(head2,"nginx");
    Assert.assertEquals(head1,"application/json");
    Assert.assertEquals(head3,"167");//expected 167 but actual 170

     //Printing:
      // System.out.println("The Richardson weather is=>"+ss);
       System.out.println("The status of code is:" + code);



    }



}
