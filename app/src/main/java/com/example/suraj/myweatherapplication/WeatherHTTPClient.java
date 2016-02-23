package com.example.suraj.myweatherapplication;

/**
 * Created by Suraj on 10/2/2015.
 *
 * This is used to send request to the URL and get the JSON data which is then parsed in JSONWeatherParser
 */

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherHTTPClient {
    //URL to which we are going to send the get request
    private static String base_URL = "http://api.openweathermap.org/data/2.5/weather?zip=";

    // argument zipCode to be appended to the Base URL to get the weather of that location
    public String getWeatherData(String zipCode) {

        HttpURLConnection con = null;
        InputStream is = null;

        try{
            //set up connection

            con = (HttpURLConnection) ( new URL( base_URL + zipCode + ",us&APPID=f5dfc4cfeadb862325cb3fe9fd4ad6e4")).openConnection();
            con.setRequestMethod("GET");
            con.setDoInput(true);
            con.setDoOutput(true);
            con.connect();

            //store the received data from the URL

            StringBuffer buffer = new StringBuffer();
            is = con.getInputStream();                                         //Data we get from the connection
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line;

            // while there is a line in the bufferedReader object, add it to String buffer
            while (  (line = br.readLine()) != null )
                buffer.append(line + "\r\n");

            is.close();
            con.disconnect();
            return buffer.toString();       //return data in stringbuffer
        }
        catch(Exception e){
            e.printStackTrace();
        }

        // If there is an exception, close the connection and input stream and return null.
        finally {
            try { is.close(); } catch(Throwable t) {}
            try { con.disconnect(); } catch(Throwable t) {}
        }

        return null;
    }
}
