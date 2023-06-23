package test;

import org.json.JSONObject;
import org.junit.Test;

public class C03_JsonObjectOlusturma {

    @Test
    public void jsonObje01(){

         /*
    Asagidaki JSON Objesini olusturup konsolda yazdirin.
    {
        "title":"Ahmet",
        "body":"Merhaba",
        "userId":1      --> {"title":"Ahmet","body":"Merhaba","userID":1}
    }
    */

        JSONObject ilkJSONObje=new JSONObject();
        ilkJSONObje.put("title","Ahmet");
        ilkJSONObje.put("body","Merhaba");
        ilkJSONObje.put("userID",1);
        System.out.println("Ilk Json Object: "+ilkJSONObje);



    }
    @Test
    public void jsonObje02(){

        /*
                {
                 "firstname":"Jim",
                 "additionalneeds":"Breakfast",
                 "bookingdates":{
                         "checkin":"2018-01-01",
                         "checkout":"2019-01-01"
                    },
                  "totalprice":111,
                  "depositpaid":true,
                  "lastname":"Brown"
                  }
         */
        //{
// "firstname":"Jim",
// "additionalneeds":"Breakfast",
// "totalprice":111,
// "bokingdates":{
//      "checkin":"2018-01-01",
//      "checkout":"2019-01-01"
//      },
// "depositpaid":true,
// "lastname":"Brown"
// }

        JSONObject bokingDates=new JSONObject();
        bokingDates.put("checkin","2018-01-01");
        bokingDates.put("checkout","2019-01-01");

        JSONObject outerJson=new JSONObject();
        outerJson.put( "firstname","Jim");
        outerJson.put( "additionalneeds","Breakfast");
        outerJson.put("bokingdates",bokingDates);
        outerJson.put("totalprice",111);
        outerJson.put("depositpaid",true);
        outerJson.put("lastname","Brown");

        System.out.println(outerJson);














    }


}
