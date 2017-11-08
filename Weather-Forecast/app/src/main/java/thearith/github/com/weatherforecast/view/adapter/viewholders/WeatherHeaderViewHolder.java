package thearith.github.com.weatherforecast.view.adapter.viewholders;

import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import thearith.github.com.weatherforecast.R;

/**
 * Created by Thearith on 11/8/17.
 */

public final class WeatherHeaderViewHolder extends RecyclerView.ViewHolder {

    @LayoutRes
    public static final int LAYOUT_ID       = R.layout.item_weather_header;

    @BindView(R.id.tv_weather_description)
    TextView tvWeatherDescription;

    public WeatherHeaderViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(String description) {
        tvWeatherDescription.setText(description);
    }
}
