package baseApi;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PostApiTesting {
    @Test
    public void postmethod(){

        RestAssured.baseURI ="https://reqres.in/api";
        RequestSpecification request = RestAssured.given();
        JSONObject reqObj = new JSONObject();


        reqObj.put("name", "Mohammad");
        reqObj.put("job", "QA");
        request.header("Content-Type", "application/json");
        request.body(reqObj.toJSONString());

        Response response = request.post("/users");

        int statusCode = response.getStatusCode();

        System.out.println(statusCode);
        Assert.assertEquals(statusCode, 201);


    }



}
