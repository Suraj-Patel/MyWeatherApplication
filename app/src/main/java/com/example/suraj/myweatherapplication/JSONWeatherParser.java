

/**
 * Created by Suraj on 10/2/2015.
 */

/**
 * Used for parsing the JSON data received from the URL so that it can be displayed in the app.
 */

package com.example.suraj.myweatherapplication;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.suraj.myweatherapplication.model.Weather;


public class JSONWeatherParser {

    //The method takes the JSON data in form of string as an argument, parses the data and
    //stores the parsed data in various properties of the object of the Weather class and returns that object.

    public static Weather getWeather(String data) throws JSONException {
        Weather weather = new Weather();

        // We create JSONobject with the data
        JSONObject jObj = new JSONObject(data);

        //We get the name of the city
        weather.location.setCity(jObj.getString("name"));

        //We start extracting the weather details which is an array
        JSONArray jArr = jObj.getJSONArray("weather");

        //We only want the first value
        JSONObject JSONWeather = jArr.getJSONObject(0);

        weather.currentCondition.setCondition(JSONWeather.getString("main"));
        weather.currentCondition.setDescr(JSONWeather.getString("description"));

        JSONObject mainObj = jObj.getJSONObject("main");
        weather.currentCondition.setHumidity(mainObj.getInt("humidity"));
        weather.currentCondition.setPressure(mainObj.getInt("pressure"));

        //temperature   The temperature received is in kelvin
        // To convert it to celsius subtract 273.15 from the value
        float maxTemp = (float) (mainObj.getDouble("temp_max") - 273.15);
        float minTemp = (float) (mainObj.getDouble("temp_min") - 273.15);
        float temp = (float) (mainObj.getDouble("temp") - 273.15);
        weather.temperature.setMaxTemp(maxTemp);
        weather.temperature.setMinTemp(minTemp);
        weather.temperature.setTemp(temp);

        // Wind
        JSONObject wObj = jObj.getJSONObject("wind");
        weather.wind.setSpeed((float) wObj.getDouble("speed"));
        weather.wind.setDeg((float) wObj.getDouble("deg"));

        // Clouds
        JSONObject cObj = jObj.getJSONObject("clouds");
        weather.clouds.setPerc(cObj.getInt("all"));

    /*    //rain
        JSONObject rObj = jObj.getJSONObject("rain");   */

        return weather;
    }

}
