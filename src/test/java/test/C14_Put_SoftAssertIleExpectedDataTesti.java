package test;


import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class C14_Put_SoftAssertIleExpectedDataTesti {
     /*
   " https://dummy.restapiexample.com/api/v1/update/21" url’ine asagidaki
    body’ye sahip bir PUT request gonderdigimizde donen response’un asagidaki gibi oldugunu test edin.
            Request Body
            {
                "status":"success",
                "data":{
                        "name":“Ahmet",
                        "salary":"1230",
                        "age":"44",
                        "id":40
                        }
            }
            Response Body
            {
            "status":"success",
            "data":{
                "status":"success",
                "data":{
                        "name":“Ahmet",
                        "salary":"1230",
                        "age":"44",
                        "id":40
                        }
                   },
            "message":"Successfully! Record has been updated."
            }
                 */
    @Test
    public void put01(){

        String url="https://dummy.restapiexample.com/api/v1/update/21";



        JSONObject expData=new JSONObject();
        expData.put("name","Ahmet");
        expData.put("salary","1230");
        expData.put("age","44");
        expData.put("id",40);


        JSONObject reqBody=new JSONObject();
        reqBody.put("status","success");
        reqBody.put("data",expData);


       JSONObject expected=new JSONObject();
       expected.put("status","success");
       expected.put("data",reqBody);
       expected.put("message","Successfully! Record has been updated.");


        Response response=given().contentType(ContentType.JSON).when().body(reqBody.toString()).put(url);

        JsonPath resJP=response.jsonPath();

        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(resJP.get("status"),expected.get("status"));
        softAssert.assertEquals(resJP.get("message"),expected.get("message"));
 softAssert.assertEquals(resJP.get("data.status"),expected.getJSONObject("data").get("status"));
softAssert.assertEquals(resJP.get("data.data.id"),expected.getJSONObject("data").getJSONObject("data").get("id"));
softAssert.assertEquals(resJP.get("data.data.name"),expected.getJSONObject("data").getJSONObject("data").get("name"));
 softAssert.assertEquals(resJP.get("data.data.salary"),expected.getJSONObject("data").getJSONObject("data").get("salary"));
 softAssert.assertEquals(resJP.get("data.data.age"),expected.getJSONObject("data").getJSONObject("data").get("age"));

        softAssert.assertAll();
    }
}
