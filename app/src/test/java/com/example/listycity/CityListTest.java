package com.example.listycity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }
    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    @Test
    void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    void testAddException() {
        CityList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    void testGetCities() {
        CityList cityList = mockCityList();

        // This line checks if the first city in the cityList (retrieved by cityList.getCities().get(0))
        // is the same as the city returned by mockCity()
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));

        // This pushes down the original city
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);

        // Now the original city should be at position 1
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    @Test
    void testHasCity() {
        // Create a new city list
        CityList cityList = new CityList();

        // Add two cities to the list
        City city0 = new City("Charlottetown", "Prince Edward Island");
        City city1 = this.mockCity();
        cityList.add(city0);
        cityList.add(city1);

        // Assert that the hasCity method returns true for both
        assertTrue(cityList.hasCity(city0));
        assertTrue(cityList.hasCity(city1));

        // Create another city, but do not add it to the list
        City city2 = this.mockCity();

        // Assert that the list hasCity method does not return
        // true for city2 which is not in the list
        assertFalse(cityList.hasCity(city2));
    }

    @Test
    void testDeleteCity() {
        // Create a new city list
        CityList cityList = new CityList();

        // Add two cities to the list
        City city0 = new City("Charlottetown", "Prince Edward Island");
        City city1 = this.mockCity();
        cityList.add(city0);
        cityList.add(city1);

        // Assert that the city list has two cities, which are
        // also the ones we added
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city0));
        assertTrue(cityList.getCities().contains(city1));

        // Delete city0
        cityList.delete(city0);

        // Assert that the city list only has city1 now
        // and is also of length 1
        assertEquals(1, cityList.getCities().size());
        assertFalse(cityList.getCities().contains(city0));
        assertTrue(cityList.getCities().contains(city1));
    }

    @Test
    void testDeleteException() {
        // Create a new city list with one city
        CityList cityList = mockCityList();

        // Create a new city
        City city = new City("Yellowknife", "Northwest Territories");

        // Make sure cityList.delete throws an exception when
        // we try to delete a city it does not contain
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(city);
        });
    }

    @Test
    void testCountCities() {
        // Create a new city list with zero cities
        CityList cityList = new CityList();

        // Assert that the city count is 0
        assertEquals(0, cityList.countCities());

        int numCitiesToAdd = 42;
        for (int i = 0; i < numCitiesToAdd; i++) {
            cityList.add(this.mockCity());
        }

        // Assert that the city count equals numCitiesToAdd
        assertEquals(numCitiesToAdd, cityList.countCities());
    }
}