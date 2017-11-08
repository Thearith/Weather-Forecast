package thearith.github.com.weatherforecast.data.fetchweather.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Thearith on 11/8/17.
 */

public final class Daily {

    @SerializedName("summary")
    @Expose
    private String summary;

    @SerializedName("icon")
    @Expose
    private WeatherIcon icon;

    @SerializedName("data")
    @Expose
    private List<DailyData> data = null;

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public WeatherIcon getIcon() {
        return icon;
    }

    public void setIcon(WeatherIcon icon) {
        this.icon = icon;
    }

    public List<DailyData> getData() {
        return data;
    }

    public void setData(List<DailyData> data) {
        this.data = data;
    }
}
