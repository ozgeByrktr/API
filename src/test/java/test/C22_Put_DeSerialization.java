package test;

import baseUrl.JSonPlaceHolderBaseUrl;
import org.junit.Test;
import testData.JSonPlaceTestData;

import java.util.HashMap;

public class C22_Put_DeSerialization extends JSonPlaceHolderBaseUrl {

     /*
    https://jsonplaceholder.typicode.com/posts/70 url'ine asagidaki
    body’e sahip bir PUT request yolladigimizda donen response’in
    response body’sinin asagida verilen ile ayni oldugunu test ediniz
    Request Body
        {
        "title":"Ahmet",
        "body":"Merhaba",
        "userId":10,
        "id":70
        }
    Expected Data :
        {
        "title":"Ahmet",
        "body":"Merhaba",
        "userId":10,
        "id":70
        }
     */
    @Test
    public void put01(){
        // 1- Url ve request body hazirla

        specJsonPlace.pathParams("pp1","posts","pp2",70);

        JSonPlaceTestData testDataJsonPlace = new JSonPlaceTestData();

        HashMap<String, Object> reqBody = testDataJsonPlace.requestBodyOlusturMAP();


    }
}