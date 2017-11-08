package thearith.github.com.weatherforecast.data.fetchweather.datasource;

import io.reactivex.Observable;
import thearith.github.com.weatherforecast.data.fetchweather.network.model.Weather;

/**
 * Created by Thearith on 11/8/17.
 */

public interface FetchWeatherDataSource {

    Observable<Weather> fetchWeatherData();
}
