package thearith.github.com.weatherforecast.data.fetchweather.repository;

import javax.inject.Inject;

import io.reactivex.Observable;
import thearith.github.com.weatherforecast.data.fetchweather.FetchWeatherRepository;
import thearith.github.com.weatherforecast.data.fetchweather.network.FetchWeatherApi;
import thearith.github.com.weatherforecast.data.fetchweather.network.model.Weather;

/**
 * Created by Thearith on 11/8/17.
 */

public final class FetchWeatherRepositoryImpl implements FetchWeatherRepository {

    private FetchWeatherApi mApiSource;

    @Inject
    FetchWeatherRepositoryImpl(FetchWeatherApi apiSource) {
        mApiSource = apiSource;
    }

    @Override
    public Observable<Weather> fetchWeatherData() {
        return mApiSource.fetchWeatherData();
    }
}
