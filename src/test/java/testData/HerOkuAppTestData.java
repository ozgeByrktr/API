package testData;

import org.json.JSONObject;

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
}