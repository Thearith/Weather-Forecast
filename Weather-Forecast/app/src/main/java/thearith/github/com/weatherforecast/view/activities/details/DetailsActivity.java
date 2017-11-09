package thearith.github.com.weatherforecast.view.activities.details;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.TextView;

import butterknife.BindView;
import thearith.github.com.weatherforecast.R;
import thearith.github.com.weatherforecast.data.fetchweather.network.model.DailyData;
import thearith.github.com.weatherforecast.data.fetchweather.network.model.WeatherIcon;
import thearith.github.com.weatherforecast.view.activities.base.BaseActivity;
import thearith.github.com.weatherforecast.view.custom.SkyConView;
import thearith.github.com.weatherforecast.view.internal.di.components.ApplicationComponent;
import thearith.github.com.weatherforecast.view.utils.DateUtils;

/**
 * Created by Thearith on 11/9/17.
 */

public class DetailsActivity extends BaseActivity {

    public static final String DETAILS_DAILY_DATA   = "details_daily_data";

    // Data
    private DailyData mDailyData;

    // View
    @BindView(R.id.tv_summary)
    TextView tvSummary;

    @BindView(R.id.weather_icon)
    SkyConView weatherIcon;

    @BindView(R.id.tv_temperature)
    TextView tvTemperature;

    @BindView(R.id.tv_date)
    TextView tvDate;

    @BindView(R.id.tv_max_temperature)
    TextView tvMaxTemperature;

    @BindView(R.id.tv_min_temperature)
    TextView tvMinTemperature;

    @BindView(R.id.tv_pressure)
    TextView tvPressure;

    @BindView(R.id.tv_wind_speed)
    TextView tvWindSpeed;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        if(getIntent() != null) {
            Object data = getIntent().getSerializableExtra(DETAILS_DAILY_DATA);

            if(!(data instanceof DailyData)) {
                finish();
                return;
            }

            mDailyData = (DailyData) data;
        }

        populateUI(mDailyData);
    }

    @Override
    protected void injectDependencies(ApplicationComponent appComponent) {
        // DO NOTHING
    }

    private void populateUI(@NonNull DailyData data) {
        String date = DateUtils.getFullDate(data.getTime());
        tvDate.setText(date);

        WeatherIcon icon = data.getIcon();
        weatherIcon.setIcon(icon);

        String summary = data.getSummary();
        tvSummary.setText(summary);

        int minTemperature = (int) data.getTemperatureMin();
        int maxTemperature = (int) data.getTemperatureMax();

        int averageTemperature = (minTemperature + maxTemperature) / 2;
        String temperatureTemplate = getString(R.string.temperature);
        String temperature = String.format(temperatureTemplate, averageTemperature);
        tvTemperature.setText(temperature);

        String maxTemperatureTemplate = getString(R.string.max_temperature);
        String maxTemperatureStr = String.format(maxTemperatureTemplate, maxTemperature);
        tvMaxTemperature.setText(maxTemperatureStr);

        String minTemperatureTemplate = getString(R.string.min_temperature);
        String minTemperatureStr = String.format(minTemperatureTemplate, minTemperature);
        tvMinTemperature.setText(minTemperatureStr);


        String pressureTemplate = getString(R.string.pressure_template);
        double pressure = data.getPressure();
        String pressureStr = String.format(pressureTemplate, pressure);
        tvPressure.setText(pressureStr);

        String windSpeedTemplate = getString(R.string.wind_speed_template);
        double windSpeed = data.getWindSpeed();
        String windSpeedStr = String.format(windSpeedTemplate, windSpeed);
        tvWindSpeed.setText(windSpeedStr);
    }
}
