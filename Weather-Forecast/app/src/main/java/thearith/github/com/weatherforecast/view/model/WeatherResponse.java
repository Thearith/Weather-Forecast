package thearith.github.com.weatherforecast.view.model;

import thearith.github.com.weatherforecast.data.fetchweather.network.model.Weather;

/**
 * Created by Thearith on 11/8/17.
 */

public class WeatherResponse {

    private Status status;
    private Weather weather;

    public WeatherResponse(Status status) {
        this(status, null);
    }

    public WeatherResponse(Status status, Weather weather) {
        this.status = status;
        this.weather = weather;
    }

    public Status getStatus() {
        return status;
    }

    public Weather getWeather() {
        return weather;
    }
}
