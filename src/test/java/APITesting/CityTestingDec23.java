package APITesting;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;



@Test
public class CityTestingDec23 {

    public void DhakaWeather(){

        RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
        RequestSpecification req = RestAssured.given();
        Response res = req.request(Method.GET,"/Dhaka");
        //String body1 = res.getBody().asString();


        JsonPath jsonPath = res.jsonPath();

        String City = jsonPath.get("City");
        System.out.println("The name of city : "+ City);
        Assert.assertEquals(City,"Dhaka");


        }
  @Test
        public void RichardsonWeather(){

        RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
        RequestSpecification req = RestAssured.given();
        Response resp = req.request(Method.GET,"/Richardson");

        JsonPath jsonPath = resp.jsonPath();

        String City2 = jsonPath.get("City");
        System.out.println("the name of city is:" +City2);
        Assert.assertEquals(City2,"Richardson");

       }
@Test
   public void ChittagongWeather(){

        RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
        RequestSpecification reque = RestAssured.given();
        Response resp = reque.request(Method.GET,"/Chittagong");

        JsonPath jsonPath = resp.jsonPath();

        String City3 = jsonPath.get("City");
        System.out.println("the name of city: "+ City3);
        Assert.assertEquals(City3,"Chittagong");


   }


}
