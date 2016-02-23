
/**
 * Created by Suraj on 10/2/2015.
 */
/**
 * Model for collecting data about the weather
 * Contains all the get and set methods
 */

package com.example.suraj.myweatherapplication.model;



public class Weather {

    //Create objects of all the inner classes. Each class is a part of weather details.

    public CurrentCondition currentCondition = new CurrentCondition();
    public Temperature temperature = new Temperature();
    public Wind wind = new Wind();
    // public Rain rain = new Rain();
    public Clouds clouds = new Clouds();
    public Location location = new Location();

    // Contains info about current weather conditions
    public class CurrentCondition {
        private String condition;
        private String descr;
        private float pressure;
        private float humidity;

        public String getCondition() {
            return condition;
        }
        public void setCondition(String condition){
            this.condition = condition;
        }
        public String getDescr() {
            return descr;
        }
        public void setDescr(String descr){
            this.descr = descr;
        }
        public float getPressure() {
            return pressure;
        }
        public void setPressure(float pressure) {
            this.pressure = pressure;
        }
        public float getHumidity() {
            return humidity;
        }
        public void setHumidity(float humidity) {
            this.humidity = humidity;
        }

    }

    public class Temperature {

        private float temp;
        private float minTemp;
        private float maxTemp;

        public float getTemp() {
            return temp;
        }
        public void setTemp(float temp) {
            this.temp = temp;
        }
        public float getMinTemp() {
            return minTemp;
        }
        public void setMinTemp(float minTemp) {
            this.minTemp = minTemp;
        }
        public float getMaxTemp() {
            return maxTemp;
        }
        public void setMaxTemp(float maxTemp) {
            this.maxTemp = maxTemp;
        }
    }

    public class Wind {
        private float speed;
        private float deg;
        public float getSpeed() {
            return speed;
        }
        public void setSpeed(float speed) {
            this.speed = speed;
        }
        public float getDeg() {
            return deg;
        }
        public void setDeg(float deg) {
            this.deg = deg;
        }
    }

/*    public class Rain {
        private String time;
        private float amount;
        public String getTime() {
            return time;
        }
        public void setTime(String time) {
            this.time = time;
        }
        public float getAmount() {
            return amount;
        }
        public void setAmount(float amount) {
            this.amount = amount;
        }

    }   */

    public class Clouds {
        private int perc;

        public int getPerc() {
            return perc;
        }

        public void setPerc(int perc) {
            this.perc = perc;
        }

    }

    public class Location {

        private String city;
        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }
    }
}
