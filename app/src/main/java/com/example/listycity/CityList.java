package com.example.listycity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This is a class that keeps a list of city objects
 */
public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * This adds a city to the list if the city does not exist
     * @param city
     * This is a candidate city to add
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * This returns a sorted list of cities
     * @return
     * Return the sorted list
     */
    public List<City> getCities() {
        List<City> list = this.cities;
        Collections.sort(list);
        return list;
    }

    /**
     * When given a city, returns whether or not it belongs in the list.
     * @param city
     * The city to check.
     * @return
     * True if the city is in the list, else, false.
     */
    public boolean hasCity(City city) {
        return this.cities.contains(city);
    }

    /**
     * Check if a city is present in the list. If it does then remove
     * it from the list, if not then throws an exception.
     * @param city
     * The city to delete from the list.
     */
    public void delete(City city) {
        // Throw an exception if the given city does not exist in the list.
        if (!this.hasCity(city)) {
            throw new IllegalArgumentException();
        }
        this.cities.remove(city);
    }

    /**
     * Returns how many cities are in the list.
     * @return
     * How many cities are in the list.
     */
    public int countCities() {
        return this.cities.size();
    }
}
