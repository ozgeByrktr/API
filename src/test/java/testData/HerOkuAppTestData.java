package testData;

import org.json.JSONObject;

import java.util.HashMap;

public class HerOkuAppTestData {

    public int basariliStatusCode=200;
    public String contentType ="application/json";
    public JSONObject bookingDatesOlusturmaJSON() {
        JSONObject bookingdates = new JSONObject();

        bookingdates.put("checkin", "2021-06-01");
        bookingdates.put("checkout", "2021-06-10");


        return bookingdates;
    }

    public JSONObject bookingOlusturmaJSON() {

        JSONObject booking = new JSONObject();

        booking.put("firstname", "Ali");
        booking.put("lastname", "Bak");
        booking.put("totalprice", 500);
        booking.put("depositpaid", false);
        booking.put("additionalneeds", "wi-fi");
        booking.put("bookingdates", bookingDatesOlusturmaJSON());

        return booking;
    }

    public JSONObject expectedDataOlusturmaJSON() {
        JSONObject expData = new JSONObject();

        expData.put("bookingid", 24);
        expData.put("booking", bookingOlusturmaJSON());


        return expData;
    }

    public HashMap bookingdatesMap(){

        HashMap<String,Object> bookingdates = new HashMap<>();

        bookingdates.put("checkin" , "2021-06-01");
        bookingdates.put("checkout" , "2021-06-10");

        return bookingdates;
    }
    /*
         Request body
       {
            "firstname" : "Ali",
            "lastname" : "Bak",
            "totalprice" : 500,
            "depositpaid" : false,
            "bookingdates" : {
                     "checkin" : "2021-06-01",
                     "checkout" : "2021-06-10"
                              },
            "additionalneeds" : "wi-fi"
        }
         */
    public HashMap reqBodyMap(){

        HashMap<String,Object> booking = new HashMap<>();

        booking.put("firstname" , "Ali");
        booking.put("lastname" , "Bak");
        booking.put("totalprice" , 500.0);
        booking.put("depositpaid" , false);
        booking.put("additionalneeds" , "wi-fi");
        booking.put("bookingdates" , bookingdatesMap());

        return booking;
    }
    /*
      Response Body
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
    public HashMap expBodyMap(){

        HashMap<String,Object> expBody = new HashMap<>();

        expBody.put("bookingid" , 24);
        expBody.put("booking" , reqBodyMap());

        return expBody;
    }

}