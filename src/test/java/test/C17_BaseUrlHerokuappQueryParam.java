package test;

import baseUrl.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.lessThan;

public class C17_BaseUrlHerokuappQueryParam extends HerOkuAppBaseUrl {
// Class icinde 3 Test metodu olusturun ve asagidaki testleri yapin



    @Test
    public void get01(){
        /*
        1-  https://restful-booker.herokuapp.com/booking endpointine bir GET
        request gonderdigimizde donen response’un status code’unun 200 oldugunu
        ve Response’ta 33071 id'ye sahip bir booking oldugunu test edin 1509
     */

        specHerOkuApp.pathParam("pp1","booking");

        Response response=given().spec(specHerOkuApp).when().get("/{pp1}");
        response.prettyPrint();
        response.then().assertThat()
                .statusCode(200)
                .body("bookingid", Matchers.hasItem(1509));


    }
    @Test
    public void get02(){
/*
        2- https://restful-booker.herokuapp.com/booking endpointine gerekli
        Query parametrelerini yazarak “firstname” degeri “Eric” olan rezervasyon
        oldugunu test edecek bir GET request gonderdigimizde, donen response’un
        status code’unun 200 oldugunu ve “Eric” ismine sahip en az bir booking oldugunu test edin
    */
        specHerOkuApp.pathParam("pp1","booking")
                     .queryParam("firstname","Eric");

        Response response=given().spec(specHerOkuApp).when().get("/{pp1}");
        response.prettyPrint();
        response.then().assertThat()
                .statusCode(200)
                .body("bookingid",Matchers.hasSize(greaterThanOrEqualTo(2)));
    }
    @Test
    public void get03(){

  /*
        3- https://restful-booker.herokuapp.com/booking endpointine gerekli Query
         parametrelerini yazarak “firstname” degeri “Jim” ve “lastname” degeri
         “Jackson” olan rezervasyon oldugunu test edecek bir GET request gonderdigimizde,
         donen response’un status code’unun 200 oldugunu ve “Jim Jackson” ismine sahip
         en az bir booking oldugunu test edin.
    */
        specHerOkuApp.pathParam("pp1","booking")
                .queryParams("firstname","Jim","lastname","Jackson");
        Response response=given().spec(specHerOkuApp).when().get("/{pp1}");
        response.prettyPrint();
      response.then().assertThat()
              .statusCode(200)
                 .body("bookingid",Matchers.hasSize(greaterThanOrEqualTo(1)));


    }


}
