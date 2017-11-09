package thearith.github.com.weatherforecast.data.fetchweather.network.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Thearith on 11/8/17.
 */

public enum WeatherIcon {

    @SerializedName("clear-day")
    CLEAR_DAY("clear-day"),

    @SerializedName("clear-night")
    CLEAR_NIGHT("clear-night"),

    @SerializedName("rain")
    RAIN("rain"),

    @SerializedName("snow")
    SNOW("snow"),

    @SerializedName("sleet")
    SLEET("sleet"),

    @SerializedName("wind")
    WIND("wind"),

    @SerializedName("fog")
    FOG("fog"),

    @SerializedName("cloudy")
    CLOUDY("cloudy"),

    @SerializedName("partly-cloudy-day")
    PARTY_CLOUDY_DAY("partly-cloudy-day"),

    @SerializedName("partly-cloudy-night")
    PARTY_CLOUDY_NIGHT("partly-cloudy-night");


    private final String mValue;

    WeatherIcon(String value) {
        mValue = value;
    }

    public String toString() {
        return mValue;
    }
}
