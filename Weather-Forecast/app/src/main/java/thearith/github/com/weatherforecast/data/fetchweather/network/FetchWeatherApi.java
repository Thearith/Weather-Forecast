package thearith.github.com.weatherforecast.data.fetchweather.network;

import javax.inject.Inject;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import thearith.github.com.weatherforecast.BuildConfig;
import thearith.github.com.weatherforecast.data.fetchweather.datasource.FetchWeatherDataSource;
import thearith.github.com.weatherforecast.data.fetchweather.network.model.Weather;
import thearith.github.com.weatherforecast.data.utils.Constants;

/**
 * Created by Thearith on 11/8/17.
 */

public final class FetchWeatherApi implements FetchWeatherDataSource {

    private Retrofit.Builder mBuilder;

    @Inject
    FetchWeatherApi(Retrofit.Builder builder) {
        mBuilder = builder;
    }

    @Override
    public Observable<Weather> fetchWeatherData() {
        Retrofit retrofit = mBuilder
                .baseUrl(Constants.DARK_SKY_BASE_URL)
                .build();
        FetchWeatherService service = retrofit.create(FetchWeatherService.class);

        return service.fetchWeatherData(
                BuildConfig.DARK_SKY_API_KEY,
                Constants.SG_LATITUDE,
                Constants.SG_LONGITUDE,
                Constants.API_BLACKLIST
        );
    }
}
