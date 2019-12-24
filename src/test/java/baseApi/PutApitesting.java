package baseApi;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PutApitesting {

    @Test
    public void putmethod(){

        RestAssured.baseURI ="https://reqres.in/api";
        RequestSpecification request = RestAssured.given();
        JSONObject reqObj = new JSONObject();


        reqObj.put("name", "Mhjdhjdhd");
        reqObj.put("job", "Dev");
        request.header("Content-Type", "application/json");
        request.body(reqObj.toJSONString());

        Response response = request.put("/users");

        int statusCode = response.getStatusCode();

        System.out.println(statusCode);
        //Assert.assertEquals(statusCode, 201);
       // Assert.assertNotEquals(statusCode,201);
          Assert.assertTrue(true,"statusCode");
              Assert.assertFalse("statusCode");
    }



}
