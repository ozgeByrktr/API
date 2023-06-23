package test;

import baseUrl.JSonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import testData.JSonPlaceTestData;

import static io.restassured.RestAssured.given;

public class C19_Put_TestDataClassKullanimi extends JSonPlaceHolderBaseUrl {

    /*
    https://jsonplaceholder.typicode.com/posts/70 url'ine asagidaki body’e sahip bir PUT
    request yolladigimizda donen response’in
    status kodunun 200, content type’inin “application/json; charset=utf-8”,
    Connection header degerinin “keep-alive”
    ve response body’sinin asagida verilen ile ayni oldugunu test ediniz
    Request Body
        {
        "title":"Ali",
        "body":"Merhaba",
        "userId":10,
        "id":70
        }
    Expected Data
        {
        "title":"Ali",
        "body":"Merhaba",
        "userId":10,
        "id":70
        }
  */
    @Test
    public void put01(){

        //1- URL ve RqBody Hazirla

        specJsonPlace.pathParams("pp1","posts","pp2",70);

        JSonPlaceTestData testDataJsonPlace = new JSonPlaceTestData();

        JSONObject reqBody = testDataJsonPlace.requestBodyOlusturJSON();

        //'-Expected data hazırla

        JSONObject expData = testDataJsonPlace.requestBodyOlusturJSON();
        //3-Response'ı kaydet
        Response response=given()
                .spec(specJsonPlace)
                .contentType(ContentType.JSON)
                .when()
                .body(reqBody.toString()).put("/{pp1}/{pp2}");
        response.prettyPrint();

        //4- assertion
        JsonPath resJP=response.jsonPath();
        Assert.assertEquals(testDataJsonPlace.basariliStatusCode,response.getStatusCode());
        Assert.assertEquals(testDataJsonPlace.contentType,response.getContentType());
        Assert.assertEquals(testDataJsonPlace.connectionHeader,response.getHeader("Connection"));
        Assert.assertEquals(expData.get("userId"),resJP.get("userId"));
        Assert.assertEquals(expData.get("id"),resJP.get("id"));
        Assert.assertEquals(expData.get("title"),resJP.get("title"));
        Assert.assertEquals(expData.get("body"),resJP.get("body"));





    }
}
