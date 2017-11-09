package thearith.github.com.weatherforecast.presentation.presenter.main;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.observers.TestObserver;
import thearith.github.com.weatherforecast.data.fetchweather.FetchWeatherRepository;
import thearith.github.com.weatherforecast.data.fetchweather.network.model.Daily;
import thearith.github.com.weatherforecast.data.fetchweather.network.model.DailyData;
import thearith.github.com.weatherforecast.data.fetchweather.network.model.Weather;
import thearith.github.com.weatherforecast.presentation.schedulers.ThreadExecutor;
import thearith.github.com.weatherforecast.view.model.Status;
import thearith.github.com.weatherforecast.view.model.WeatherResponse;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class MainPresenterTest {

    private static final String SUMMARY         = "It is going to rain tonight";
    private static final long TIMESTAMP         = 137979989;

    @Mock
    private FetchWeatherRepository mFetchWeatherRepository;

    @InjectMocks
    private MainPresenter mPresenter;

    private Weather mCompleteResult;
    private Weather mErrorResult;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }


    @Before
    public void setUpCompleteResultMock() {
        mCompleteResult = new Weather();

        Daily daily = new Daily();
        daily.setSummary(SUMMARY);

        List<DailyData> list = new ArrayList<>();
        DailyData dailyData = new DailyData();
        dailyData.setTime(TIMESTAMP);
        list.add(dailyData);
        daily.setData(list);

        mCompleteResult.setDaily(daily);
    }

    @Before
    public void setUpErrorResult() {
        mErrorResult = new Weather(); // Empty object
    }

    @Test
    public void testFetchWeatherWithResult() {
        when(mFetchWeatherRepository.fetchWeatherData()).thenReturn(
                Observable.just(mCompleteResult)
        );

        Observable<WeatherResponse> observable = mPresenter.fetchWeatherDataWithNoSchedulers();
        TestObserver<WeatherResponse> testObserver = new TestObserver<>();

        // Start calling
        observable.subscribe(testObserver);

        // Test OnComplete
        testObserver.assertComplete();
        testObserver.assertNoErrors();

        // Test Data not null
        List<WeatherResponse> datas = testObserver.values();
        testObserver.assertValueCount(2);

        // Test Response Status
        assertEquals(datas.get(0).getStatus(), Status.IN_PROGRESS);
        assertEquals(datas.get(1).getStatus(), Status.COMPLETE);

        WeatherResponse data = datas.get(1);
        assertNotNull(data.getWeather().getDaily());

        Daily daily = data.getWeather().getDaily();
        assertEquals(daily.getSummary(), SUMMARY);
    }

    @Test
    public void testFetchWeatherWithError() {
        when(mFetchWeatherRepository.fetchWeatherData()).thenReturn(
                Observable.just(mErrorResult)
        );

        Observable<WeatherResponse> observable = mPresenter.fetchWeatherDataWithNoSchedulers();
        TestObserver<WeatherResponse> testObserver = new TestObserver<>();

        // Start calling
        observable.subscribe(testObserver);

        List<WeatherResponse> datas = testObserver.values();
        testObserver.assertValueCount(2);

        // Test Response Status
        assertEquals(datas.get(0).getStatus(), Status.IN_PROGRESS);
        assertEquals(datas.get(1).getStatus(), Status.ERROR);

    }
}
