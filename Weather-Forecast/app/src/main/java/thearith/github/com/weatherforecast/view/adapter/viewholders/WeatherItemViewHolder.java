package thearith.github.com.weatherforecast.view.adapter.viewholders;

import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import thearith.github.com.weatherforecast.R;
import thearith.github.com.weatherforecast.data.fetchweather.network.model.DailyData;
import thearith.github.com.weatherforecast.data.fetchweather.network.model.WeatherIcon;
import thearith.github.com.weatherforecast.view.custom.SkyConView;
import thearith.github.com.weatherforecast.view.utils.Constants;
import thearith.github.com.weatherforecast.view.utils.DateUtils;

/**
 * Created by Thearith on 11/8/17.
 */

public final class WeatherItemViewHolder extends RecyclerView.ViewHolder {

    @LayoutRes
    public static final int LAYOUT_ID       = R.layout.item_weather;

    @BindView(R.id.weather_icon)
    SkyConView weatherIcon;

    @BindView(R.id.tv_date)
    TextView tvDate;

    @BindView(R.id.tv_weather_brief)
    TextView tvWeatherBrief;

    @BindView(R.id.tv_weather_degrees)
    TextView tvWeatherDegrees;

    public WeatherItemViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(DailyData data) {
        WeatherIcon icon = data.getIcon();
        weatherIcon.setIcon(icon);

        String iconStr = icon.toString().replace(Constants.HYPHEN, Constants.SPACE);
        tvWeatherBrief.setText(iconStr);

        String date = DateUtils.getDayOfWeek(data.getTime());
        tvDate.setText(date);

        int minTemperature = (int) data.getTemperatureMin();
        int maxTemperature = (int) data.getTemperatureMax();
        String template = itemView.getContext().getResources().getString(R.string.min_max_temperature);
        String temperature = String.format(template, minTemperature, maxTemperature);
        tvWeatherDegrees.setText(temperature);
    }
}
