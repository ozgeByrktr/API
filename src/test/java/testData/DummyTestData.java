package testData;

import org.json.JSONObject;

import java.util.HashMap;

public class DummyTestData {

    public int basariliStatusCode=200;
    public String contentType ="application/json";

    public JSONObject innerexpDataOlusturmaJSon(){
        JSONObject expData=new JSONObject();
        expData.put("id",3);
        expData.put("employee_name","Ashton Cox");
        expData.put("employee_salary",86000);
        expData.put("employee_age",66);
        expData.put("profile_image","");



        return expData;

    }
    public JSONObject expectedDataOlusturmaJSON() {

        JSONObject expectedData=new JSONObject();
        expectedData.put("status","success");
        expectedData.put("data",innerexpDataOlusturmaJSon());
        expectedData.put("message","Successfully! Record has been fetched.");

        return expectedData;
    }
    public HashMap dataBodyOlusturMap(){

        HashMap <String,Object> data = new HashMap<>();

        data.put("id",3.0);
        data.put("employee_name","Ashton Cox");
        data.put("employee_salary",86000.0);
        data.put("employee_age",66.0);
        data.put("profile_image","");

        return data;
    }
    public HashMap expectedBodyOlusturMap(){

        HashMap <String,Object> expBody = new HashMap<>();

        expBody.put("status","success");
        expBody.put("data",dataBodyOlusturMap());
        expBody.put("message","Successfully! Record has been fetched.");

        return expBody;
    }

}
