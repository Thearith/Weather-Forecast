package thearith.github.com.weatherforecast.data.fetchweather.network.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Thearith on 11/8/17.
 */

public enum WeatherIcon {

    @SerializedName("clear-day")
    CLEAR_DAY,

    @SerializedName("clear-night")
    CLEAR_NIGHT,

    @SerializedName("rain")
    RAIN,

    @SerializedName("snow")
    SNOW,

    @SerializedName("sleet")
    SLEET,

    @SerializedName("wind")
    WIND,

    @SerializedName("fog")
    FOG,

    @SerializedName("cloudy")
    CLOUDY,

    @SerializedName("partly-cloudy-day")
    PARTY_CLOUDY_DAY,

    @SerializedName("partly-cloudy-night")
    PARTY_CLOUDY_NIGHT
}
