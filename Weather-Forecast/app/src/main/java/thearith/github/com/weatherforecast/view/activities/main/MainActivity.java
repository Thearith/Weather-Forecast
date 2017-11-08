package thearith.github.com.weatherforecast.view.activities.main;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.jakewharton.rxbinding2.support.v4.widget.RxSwipeRefreshLayout;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import thearith.github.com.weatherforecast.R;
import thearith.github.com.weatherforecast.data.fetchweather.network.model.DailyData;
import thearith.github.com.weatherforecast.data.fetchweather.network.model.Weather;
import thearith.github.com.weatherforecast.presentation.presenter.main.MainPresenter;
import thearith.github.com.weatherforecast.view.activities.base.BaseActivity;
import thearith.github.com.weatherforecast.view.adapter.WeatherAdapter;
import thearith.github.com.weatherforecast.view.internal.di.components.ApplicationComponent;
import thearith.github.com.weatherforecast.view.model.WeatherResponse;

public class MainActivity extends BaseActivity implements MainContract.View {

    // Views
    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout mSwipeRefreshLayout;

    @BindView(R.id.rc_fetchWeather)
    RecyclerView rcFetchWeather;

    // Presenter
    @Inject
    MainPresenter mPresenter;

    // Adatper
    private WeatherAdapter mAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initAdapter();
        initRecyclerView();
    }

    @Override
    protected void onStart() {
        super.onStart();
        setUpEventStream();
    }

    @Override
    protected void injectDependencies(ApplicationComponent appComponent) {
        appComponent.inject(this);
    }


    private void initAdapter() {
        mAdapter = new WeatherAdapter();
    }

    private void initRecyclerView() {
        LinearLayoutManager llManager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL);
        rcFetchWeather.setLayoutManager(llManager);
        rcFetchWeather.addItemDecoration(itemDecoration);

        // Add adapter
        rcFetchWeather.setAdapter(mAdapter);
    }

    private void setUpEventStream() {
        setUpRefreshLayoutEventStream();
    }

    private void setUpRefreshLayoutEventStream() {
        Observable<Object> refreshStream =
                RxSwipeRefreshLayout.refreshes(mSwipeRefreshLayout);

        Disposable disposable = refreshStream
                .startWith("Init with refresh")
                .switchMap(event -> mPresenter.fetchWeatherData())
                .subscribe(
                        this::updateUI,
                        error -> handleError()
                );

        addDisposable(disposable);
    }


    @Override
    public void updateUI(WeatherResponse response) {
        switch (response.getStatus()) {
            case IN_PROGRESS:
                showProgressMode();
                break;

            case COMPLETE:
                showCompleteMode(response);
                break;

            case ERROR:
                handleError();
                break;
        }
    }

    private void showProgressMode() {
        mSwipeRefreshLayout.setRefreshing(true);
    }

    private void showCompleteMode(WeatherResponse response) {
        mSwipeRefreshLayout.setRefreshing(false);

        clearPreviousData();
        showHeader(response.getWeather());
        populateList(response.getWeather());
    }

    private void clearPreviousData() {
        mAdapter.clearAll();
    }

    private void showHeader(Weather weather) {
        String summary = weather.getDaily().getSummary();
        mAdapter.addHeader(summary);
    }

    private void populateList(Weather weather) {
        List<DailyData> datas = weather.getDaily().getData();
        mAdapter.addData(datas);
    }

    @Override
    public void handleError() {
        Toast.makeText(this, R.string.error_msg, Toast.LENGTH_SHORT)
                .show();
    }
}
