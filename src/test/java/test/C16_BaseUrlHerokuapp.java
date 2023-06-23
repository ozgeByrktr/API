package test;

import baseUrl.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasSize;

public class C16_BaseUrlHerokuapp extends HerOkuAppBaseUrl {
  
    /*
    {"firstname" :"Ahmet ",
"lastname" : "Bulut",
"totalprice" : 500,
"depositpaid" : false,
"bookingdates" :{
"checkin" : "2021-06-01",
"checkout" : "2021-06-10"
}
"additionalneeds" : "wi-fi"}
2
https://restful booker.herokuapp.com/booking
endpointine asagidaki body’ye sahip bir POST
request gonderdigimizde donen response’un
status code’unun 200 oldugunu ve “firstname”
degerinin “Ahmet” oldugunu test edin
     */
    @Test
    public void get01(){
         /*
    Class icinde 2 Test metodu olusturun ve asagidaki testleri yapin
1
https://restful booker.herokuapp.com/booking endpointine bir GET request
gonderdigimizde donen response’un status code’unun 200 oldugunu ve
Response’ta 12 booking oldugunu test edin
*/
        specHerOkuApp.pathParam("pp1","booking");

        Response response=given().spec(specHerOkuApp).when().get("/{pp1}");
        response.then().assertThat()
                .statusCode(200)
                .body("bookingid", hasSize(12));


    }
}
