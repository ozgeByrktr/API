package test;

import baseUrl.HerOkuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import testData.HerOkuAppTestData;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C21_Post_TestDataKullanimi extends HerOkuAppBaseUrl {

   /*
    Request body
          {
          "firstname" : "Ali",
          "lastname" : “Bak",
          "totalprice" : 500,
          "depositpaid" : false,
          "bookingdates" : {
                      "checkin" : "2021-06-01",
                      "checkout" : "2021-06-10"
                        },
          "additionalneeds" : "wi-fi"
           }
    Expected Body
    {
    "bookingid":24,
    "booking":{
            "firstname":"Ali",
            "lastname":"Bak",
            "totalprice":500,
            "depositpaid":false,
            "bookingdates":{
                            "checkin":"2021-06-01",
                            "checkout":"2021-06-10"
                            },
            "additionalneeds":"wi-fi"
               }
    }
     */
    @Test
    public void post01(){
         /*
    https://restful-booker.herokuapp.com/booking url’ine asagidaki body'ye sahip
    bir POST request gonderdigimizde donen response’un status kodunu ve id haric
    body'sinin asagidaki gibi oldugunu test edin.*/
        specHerOkuApp.pathParam("pp1","booking");

        HerOkuAppTestData herOkuAppTestData=new HerOkuAppTestData();

        JSONObject rqBody=herOkuAppTestData.bookingOlusturmaJSON();
        JSONObject expData=herOkuAppTestData.expectedDataOlusturmaJSON();
        Response response=given().spec(specHerOkuApp).contentType(ContentType.JSON).when().body(rqBody.toString())
                        .post("/{pp1}");
        JsonPath resJP=response.jsonPath();
        assertEquals(herOkuAppTestData.basariliStatusCode,response.getStatusCode());

        assertEquals(expData.getJSONObject("booking").get("firstname"), resJP.get("booking.firstname") );
        assertEquals(expData.getJSONObject("booking").get("lastname"), resJP.get("booking.lastname") );
        assertEquals(expData.getJSONObject("booking").get("totalprice"), resJP.get("booking.totalprice"));
        assertEquals(expData.getJSONObject("booking").get("depositpaid"), resJP.get("booking.depositpaid"));
        assertEquals(expData.getJSONObject("booking").get("additionalneeds"), resJP.get("booking.additionalneeds"));
        assertEquals(expData.getJSONObject("booking").getJSONObject("bookingdates").get("checkin") ,
                resJP.get("booking.bookingdates.checkin") );
        assertEquals(expData.getJSONObject("booking").getJSONObject("bookingdates").get("checkout") ,
                resJP.get("booking.bookingdates.checkout") );

    }


}
