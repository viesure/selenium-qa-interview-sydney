package util;

import model.APIResponse;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import io.restassured.response.Response;

import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

public class Utils {
    public static String keyValueToJson(String key, Integer value){
        Map<String,Integer> map= new HashMap<>();
        map.put(key,value);
        Gson gson = new Gson();
        return gson.toJson(map);

    }

    public static APIResponse responseToObject(Response response){
        Gson gson = new Gson();
        String responseString = response.asString();
        System.out.println(responseString);
        JsonReader jsonReader = new JsonReader(new StringReader(responseString));
        APIResponse apiResponse = gson.fromJson(jsonReader, APIResponse.class);
        return apiResponse;
    }
}