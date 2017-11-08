package thearith.github.com.weatherforecast.presentation.presenter.main;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import thearith.github.com.weatherforecast.data.fetchweather.FetchWeatherRepository;
import thearith.github.com.weatherforecast.data.fetchweather.network.model.Weather;
import thearith.github.com.weatherforecast.presentation.presenter.base.BasePresenter;
import thearith.github.com.weatherforecast.presentation.schedulers.PostExecutionThread;
import thearith.github.com.weatherforecast.presentation.schedulers.ThreadExecutor;
import thearith.github.com.weatherforecast.view.activities.main.MainContract;
import thearith.github.com.weatherforecast.view.model.Status;
import thearith.github.com.weatherforecast.view.model.WeatherResponse;

/**
 * Created by Thearith on 11/8/17.
 */

public class MainPresenter extends BasePresenter implements MainContract.Presenter {

    private FetchWeatherRepository mFetchWeatherRepo;

    @Inject
    public MainPresenter(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread,
                         FetchWeatherRepository fetchWeatherRepo) {
        super(threadExecutor, postExecutionThread);
        mFetchWeatherRepo = fetchWeatherRepo;
    }

    @Override
    public Observable<WeatherResponse> fetchWeatherData() {
        return mFetchWeatherRepo.fetchWeatherData()
                .map(this::mapResponse)
                .startWith(new WeatherResponse(Status.IN_PROGRESS))
                .onErrorReturn(e -> new WeatherResponse(Status.ERROR))
                .subscribeOn(Schedulers.from(mThreadExecutor))
                .observeOn(mPostExecutorThread.getScheduler());
    }

    private WeatherResponse mapResponse(Weather weather) {
        if(weather != null
                && weather.getDaily() != null
                && weather.getDaily().getData() != null
                && weather.getDaily().getSummary() != null) {
            return new WeatherResponse(Status.COMPLETE, weather);
        } else {
            return new WeatherResponse(Status.ERROR);
        }
    }

}
