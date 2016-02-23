package com.example.suraj.myweatherapplication;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.suraj.myweatherapplication.model.Weather;

import org.json.JSONException;

/**
 * A placeholder fragment containing a simple view.
 */
public class WeatherInfoActivityFragment extends Fragment {

    private TextView txtWeatherSummary;

    public WeatherInfoActivityFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_weather_info, container, false);

        txtWeatherSummary = (TextView) view.findViewById(R.id.txtWeatherSummary);

        //Retrieve the zipcode from the previous activity using bundle
        Bundle bundle = getActivity().getIntent().getExtras();
        String zipCode = bundle.getString("zip");

        JSONWeatherTask task = new JSONWeatherTask();
        task.execute(new String[]{zipCode});
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    //This class calls the getWeatherData method and passes the zip code which is needed and sends the get request
    //and receives the JSON data which it then passes to the JSONWeatherParser to parse
    //The parsed data is then displayed on the textview

    private class JSONWeatherTask extends AsyncTask<String, Void, Weather> {

        @Override
        protected Weather doInBackground(String... params) {
            Weather weather = new Weather();
            String data = ((new WeatherHTTPClient()).getWeatherData(params[0]));

            try {
                weather = JSONWeatherParser.getWeather(data);

            } catch (JSONException e) {
                e.printStackTrace();
            }
            return weather;
        }


        @Override
        protected void onPostExecute(Weather weather) {
            super.onPostExecute(weather);

            String weatherSummary = "Location: " + weather.location.getCity() + ",US \n";
            weatherSummary += "Condition: " + weather.currentCondition.getCondition() + "\n";
            weatherSummary += "Description: " + weather.currentCondition.getDescr() + "\n";
            weatherSummary += "Pressure: " + weather.currentCondition.getPressure() + " hPa\n";
            weatherSummary += "Humidity: " + weather.currentCondition.getHumidity() + " %\n";
            weatherSummary += "Temperature: " + weather.temperature.getTemp() + " C\n";
            weatherSummary += "Max Temperature: " + weather.temperature.getMaxTemp() + " C\n";
            weatherSummary += "Min Temperature: " + weather.temperature.getMinTemp() + " C\n";
            weatherSummary += "Wind Speed: " + weather.wind.getSpeed() + "mps\n";
            weatherSummary += "Wind Degree: " + weather.wind.getDeg() + "\n";
            weatherSummary += "Clouds: " + weather.clouds.getPerc() + "%\n";

            txtWeatherSummary.setText(weatherSummary);
        }
    }
}


