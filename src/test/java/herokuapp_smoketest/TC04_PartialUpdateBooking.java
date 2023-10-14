package herokuapp_smoketest;

import baseUrl.HerokuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.HerokuAppTestData;

import java.util.HashMap;
import java.util.Map;

import static herokuapp_smoketest.TC01_CreateBooking.bookingId;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class TC04_PartialUpdateBooking extends HerokuAppBaseUrl {

    /*
    Given
    https://restful-booker.herokuapp.com/booking/:id
    And
    {
    "firstname" : "Hadi",
    "lastname" : "ARICI"
    }'


{
    "firstname" : "Hadi",
    "lastname" : "ARICI",
    "totalprice" : 111,
    "depositpaid" : true,
    "bookingdates" : {
        "checkin" : "2018-01-01",
        "checkout" : "2019-01-01"
    },
    "additionalneeds" : "Breakfast"
}
      */

    @Test
    public void PartialUpdateBooking() {

        spec.pathParams("first","booking","second", bookingId);

        HerokuAppTestData obj=new HerokuAppTestData();
        Map<String, Object> payLoad = obj.getPayLoad("Hadi", "ARICI", null, null, null,null);



        Response response = given(spec).body(payLoad).when().patch("{first}/{second}");
        response.prettyPrint();

        Map<String, Object> actualData = response.as(HashMap.class);
        assertEquals(200, response.statusCode());
        assertEquals(payLoad.get("firstname"), actualData.get("firstname"));
        assertEquals(payLoad.get("lastname"), actualData.get("lastname"));

    }
}
