package testData;

import org.json.JSONObject;

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
}
