package baseApi;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NipaTest {
@Test
    public void TexasWeather() {
    RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
    RequestSpecification requ = RestAssured.given();
    Response resp = requ.request(Method.GET, "/Plano");
    String ss = resp.getBody().asString();
    System.out.println("this is my weather => " + ss);

    String line = resp.statusLine();
    int code = resp.getStatusCode();

    //header validation

    String hd1 = resp.header("Content-Type ");
    Assert.assertEquals(hd1,"Content-Type ");

    //String hd2 = resp.header("Server");
   // String hd3 = resp.header("Content-Encoding");



    //Assert.assertEquals(hd1, "application/json");
   // Assert.assertEquals(hd2,"nginx");
    //Assert.assertEquals(hd3,"gzip");

    System.out.println("ContentType is:" + hd1);
}
}




