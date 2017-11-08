package thearith.github.com.weatherforecast.data.fetchweather.network;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import thearith.github.com.weatherforecast.data.fetchweather.network.model.Weather;

/**
 * Created by Thearith on 11/8/17.
 */

public interface FetchWeatherService {

    @GET("forecast/{apiKey}/{latitude},{longitude}")
    Observable<Weather> fetchWeatherData(
        @Path("apiKey") String apiKey,
        @Path("latitude") double latitude,
        @Path("longitude") double longitude,
        @Query("exclude") String blacklists,
        @Query("units") String units
    );
}
