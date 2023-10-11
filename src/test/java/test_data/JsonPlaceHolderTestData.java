package test_data;

import java.util.HashMap;
import java.util.Map;

public class JsonPlaceHolderTestData {

    public Map<String, Object> getPayLoad(Integer userId, String title, Boolean completed){
        Map<String, Object> payLoad = new HashMap<>();
        payLoad.put("userId", userId);
        payLoad.put("title", title);
        payLoad.put("completed", completed);
        return payLoad;


    /*
    Map<String, Object> payLoad = new HashMap<>();
        payLoad.put("userId", 21);
        payLoad.put("title", "Wash the dishes");
        payLoad.put("completed", false);

     */
    }
}