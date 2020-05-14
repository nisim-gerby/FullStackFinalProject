package helpers;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class temp
{
    String url="http://localhost:3000";
    RequestSpecification httpRequest;
    Response response;

    @Test
    public void testing()
    {
        JSONObject params=new JSONObject();
        params.put("name","WTeam");
        params.put("email","XpathTeam@grafana.com");

        RestAssured.baseURI= url;
        httpRequest = RestAssured.given().auth().preemptive().basic("admin","admin");
        httpRequest.header("Content-Type","application/json");

        httpRequest.body(params.toJSONString());
        //response=httpRequest.put("/api/teams/3");
        response=httpRequest.delete("/api/teams/3");
        //response=httpRequest.post("/api/teams");
        //response =httpRequest.get("/api/teams/search?perpage=50&page=1");
       // System.out.println(response.getBody().asString());
        System.out.println(response.prettyPrint());
    }
}
