package test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class C13_Get_SoftAssertIleExpectedDataTesti {

     /*
    http://dummy.restapiexample.com/api/v1/employee/3 url’ine bir GET request
    gonderdigimizde donen response’un asagidaki gibi oldugunu test edin.
        Response Body
        {
        "status":"success",
        "data":{
                "id":3,
                "employee_name":"Ashton Cox",
                "employee_salary":86000,
                "employee_age":66,
                "profile_image":""
                },
        "message":"Successfully! Record has been fetched."
        }
     */
    @Test
    public void get01(){
    String url="http://dummy.restapiexample.com/api/v1/employee/3";

   JSONObject expData=new JSONObject();
   expData.put("id",3);
   expData.put("employee_name","Ashton Cox");
   expData.put("employee_salary",86000);
   expData.put("employee_age",66);
   expData.put("profile_image","");

   JSONObject expected=new JSONObject();
   expected.put("status","success");
   expected.put("data",expData);
   expected.put("message","Successfully! Record has been fetched.");

        Response response=given().when().get(url);

        JsonPath resp=response.jsonPath();

        SoftAssert softassert=new SoftAssert();
        softassert.assertEquals(resp.get("status"),expected.get("status"));
        softassert.assertEquals(resp.get("message"),expected.get("message"));
        softassert.assertEquals(resp.get("data.id"),expected.getJSONObject("data").get("id"));
        softassert.assertEquals(resp.get("data.employee_name"),expected.getJSONObject("data").get("employee_name"));
        softassert.assertEquals(resp.get("data.employee_salary"),expected.getJSONObject("data").get("employee_salary"));
        softassert.assertEquals(resp.get("data.employee_age"),expected.getJSONObject("data").get("employee_age"));
        softassert.assertEquals(resp.get("data.profile_image"),expected.getJSONObject("data").get("profile_image"));

        softassert.assertAll();
    }
}
