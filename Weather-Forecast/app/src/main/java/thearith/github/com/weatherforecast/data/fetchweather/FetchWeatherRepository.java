package thearith.github.com.weatherforecast.data.fetchweather;

import io.reactivex.Observable;
import thearith.github.com.weatherforecast.data.fetchweather.network.model.Weather;

/**
 * Created by Thearith on 11/8/17.
 */

public interface FetchWeatherRepository {

    Observable<Weather> fetchWeatherData();
}
