package thearith.github.com.weatherforecast.view.activities.main;

import io.reactivex.Observable;
import thearith.github.com.weatherforecast.view.model.WeatherResponse;

/**
 * Created by Thearith on 11/8/17.
 */

public interface MainContract {

    interface View {
        void updateUI(WeatherResponse response);
        void handleError();
    }

    interface Presenter {
        Observable<WeatherResponse> fetchWeatherData();
    }
}
