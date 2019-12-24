import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class TestDec23 {

    public void CityOfQueens(){
        RestAssured.baseURI= "http://restapi.demoqa.com/utilities/weather/city";
        RequestSpecification reqs = RestAssured.given();
        Response resp = reqs.request(Method.GET,"/Queens");
        String ss = resp.getBody().asString();
        System.out.println("the name of city: " + ss);


    }
   @Test
    public void CityOfBangkok(){

        RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
        RequestSpecification reqs = RestAssured.given();
        Response resp = reqs.request(Method.GET, "Bangkok");

        String ss = resp.getBody().asString();
        ss.contains("Bang");


        System.out.println("the city name is: "+ss.contains("Bangkok"));

        int code = resp.getStatusCode();
        Assert.assertEquals(code,200);

       System.out.println("the status is: "+code);

       //validating head
       String head = resp.header("Content-Type");


       Assert.assertEquals(head,"application/json");

       System.out.println("the contentTyps is:" +head);

    }
}
