/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest.JSONConverter;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import entity.Cars;
import java.util.List;

/**
 *
 * @author RolfMoikjær
 */
public class JSONConverter {

    public static String CarToJSON(List<Cars> cars) {
        JsonArray carsArr = new JsonArray();
        for (Cars car : cars) {
            carsArr.add(CarToJsonObject(car));
        }

        return new Gson().toJson(carsArr);
    }

    public static JsonObject CarToJsonObject(Cars car) {
        JsonObject obj = new JsonObject();
        obj.addProperty("id", car.getId());
        obj.addProperty("model_year", car.getModel_year());
        obj.addProperty("registered", car.getRegistered());
        obj.addProperty("make", car.getMake());
        obj.addProperty("model", car.getModel());
        obj.addProperty("description", car.getDescription());
        obj.addProperty("price", car.getPrice());
        
        return obj;
    }
}
