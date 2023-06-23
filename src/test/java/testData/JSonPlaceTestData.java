package testData;

import baseUrl.JSonPlaceHolderBaseUrl;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.Request;

import java.util.HashMap;
import java.util.Map;

public class JSonPlaceTestData extends JSonPlaceHolderBaseUrl {
    public int basariliStatusCode=200;
    public String contentType ="application/json; charset=utf-8";
    public String connectionHeader = "keep-alive";
    public JSONObject expectedBodyOlustur() {

        JSONObject expectedData = new JSONObject();
        expectedData.put("userId", 3);
        expectedData.put("id", 22);
        expectedData.put("title", "dolor sint quo a velit explicabo quia nam");
        expectedData.put("body", "eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse");

       return expectedData;

    }
    public JSONObject requestBodyOlusturJSON(){

          /*
        {
        "title":"Ali",
        "body":"Merhaba",
        "userId":10,
        "id":70
        }
         */

        JSONObject reqBody = new JSONObject();

        reqBody.put("title","Ali");
        reqBody.put("body","Merhaba");
        reqBody.put("userId",10);
        reqBody.put("id",70);

        return reqBody;
    }

    public HashMap requestBodyOlusturMAP(){
        HashMap<String,Object> reqBody=new HashMap<>();
        reqBody.put("title","Ahmet");
        reqBody.put("body","Merhaba");
        reqBody.put("userId",10);
        reqBody.put("id",70);


        return reqBody;

    }




}
