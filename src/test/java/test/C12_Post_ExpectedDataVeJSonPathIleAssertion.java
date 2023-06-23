package test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C12_Post_ExpectedDataVeJSonPathIleAssertion {

    @Test
    public void test01(){
        /*
    https://restful-booker.herokuapp.com/booking url’ine
    asagidaki body'ye sahip bir POST request gonderdigimizde
    donen response’un id disinda asagidaki gibi oldugunu test edin.
                        Request body
                   {
                        "firstname" : "Ahmet",
                        "lastname" : “Bulut",
                        "totalprice" : 500,
                        "depositpaid" : false,
                        "bookingdates" : {
                                 "checkin" : "2021-06-01",
                                 "checkout" : "2021-06-10"
                                          },
                        "additionalneeds" : "wi-fi"
                    }
                        Response Body - Expected Body
                   {
                    "bookingid":24,
                    "booking":{
                        "firstname":"Ahmet",
                        "lastname":"Bulut",
                        "totalprice":500,
                        "depositpaid":false,
                        "bookingdates":{
                            "checkin":"2021-06-01",
                            "checkout":"2021-06-10"
                                        }
                        ,
                        "additionalneeds":"wi-fi"
                             }
                    }
*///    1-URL ve Request Body hazırla
        String url="https://restful-booker.herokuapp.com/booking";
        JSONObject innerreqBody=new JSONObject();
        innerreqBody.put("checkin" , "2021-06-01");
        innerreqBody.put("checkout" , "2021-06-10");
        JSONObject outerreqBody=new JSONObject();
        outerreqBody.put("firstname" , "Ahmet");
        outerreqBody.put("lastname" , "Bulut");
        outerreqBody.put("totalprice",500);
        outerreqBody.put("depositpaid",false);
        outerreqBody.put("bookingdates",innerreqBody);
        outerreqBody.put("additionalneeds","wi-fi");

        //2-Expected data hazırla

        JSONObject expectedData=new JSONObject();
        expectedData.put("bookingid" , 24);
        expectedData.put("booking" , outerreqBody);
        //3- Response kaydet

        Response response=given()
                    .contentType(ContentType.JSON)
                         .when()
                    .body(outerreqBody.toString())
                    .post(url);

        //4-Assertion

        JsonPath respJP=response.jsonPath();

        assertEquals(expectedData.getJSONObject("booking").get("firstname"), respJP.get("booking.firstname") );
        assertEquals(expectedData.getJSONObject("booking").get("lastname"), respJP.get("booking.lastname") );
        assertEquals(expectedData.getJSONObject("booking").get("totalprice"), respJP.get("booking.totalprice"));
        assertEquals(expectedData.getJSONObject("booking").get("depositpaid"), respJP.get("booking.depositpaid"));
        assertEquals(expectedData.getJSONObject("booking").get("additionalneeds"), respJP.get("booking.additionalneeds"));
        assertEquals(expectedData.getJSONObject("booking").getJSONObject("bookingdates").get("checkin") ,
                respJP.get("booking.bookingdates.checkin") );
        assertEquals(expectedData.getJSONObject("booking").getJSONObject("bookingdates").get("checkout") ,
                respJP.get("booking.bookingdates.checkout") );



    }
}
