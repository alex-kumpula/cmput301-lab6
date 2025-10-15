package com.example.listycity;

/**
 * This is a class that defines a City.
 */
public class City implements Comparable {
    private String city;
    private String province;

    /**
     * Creates a new city given a city name and province name.
     * @param city The name of the city.
     * @param province The name of the province associated with the city.
     */
    City(String city, String province){
        this.city = city;
        this.province = province;
    }

    /**
     * Gets the name of this city.
     * @return
     * A string representing the name of this city.
     */
    String getCityName(){
        return this.city;
    }

    /**
     * Gets the name of the province associated with this city.
     * @return
     * A string representing the name of the province associated with this city.
     */
    String getProvinceName(){
        return this.province;
    }

    @Override
    public int compareTo(Object o) {
        City city = (City) o;
        return this.city.compareTo(city.getCityName()); // this.city refers to the city name
    }
}
