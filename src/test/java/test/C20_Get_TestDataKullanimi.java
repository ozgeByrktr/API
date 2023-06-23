package test;

import baseUrl.DummyBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import testData.DummyTestData;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C20_Get_TestDataKullanimi extends DummyBaseUrl {
    /*
    http://dummy.restapiexample.com/api/v1/employee/3
url’ine bir GET request
gonderdigimizde donen response’un status code’unun 200, content Type’inin
application/json ve body’sinin asagidaki gibi oldugunu test edin.

Response Body
{
"status":success"
"data":{
"id":3
"employee_name":"Ashton Cox"
"employee_salary": 86000
"employee_age":66
"profile_image":""
},
"message" :" Successfully! Record has been fetched."
}
     */
    @Test
    public  void get01(){

        DummyTestData dummyTestData=new DummyTestData();

        specDummy.pathParams("pp1","api","pp2","v1","pp3","employee","pp4",3);

        Response response=given().spec(specDummy).when().get("/{pp1}/{pp2}/{pp3}/{pp4}");
        JSONObject expData=dummyTestData.expectedDataOlusturmaJSON();
        JsonPath respJP=response.jsonPath();
        response.prettyPrint();

        assertEquals(expData.get("status"),respJP.get("status"));
        assertEquals(expData.get("message"),respJP.get("message"));
        assertEquals(expData.getJSONObject("data").get("id"),respJP.get("data.id"));
        assertEquals(expData.getJSONObject("data").get("employee_name"),respJP.get("data.employee_name"));
        assertEquals(expData.getJSONObject("data").get("employee_salary"),respJP.get("data.employee_salary"));
        assertEquals(expData.getJSONObject("data").get("employee_age"),respJP.get("data.employee_age"));
        assertEquals(expData.getJSONObject("data").get("profile_image"),respJP.get("data.profile_image"));



    }
}
