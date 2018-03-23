package web.servisas;

import lombok.Data;

/**
 * Created by liutri on 2017-03-30.
 */
@Data
public class CityData {
    private int id;
    private double temperature;
    private String city;
    private String date;

    public CityData(int id, double temperature, String city, String date) {
        this.id = id;
        this.temperature = temperature;
        this.city = city;
	this.date = date;
    }
}
