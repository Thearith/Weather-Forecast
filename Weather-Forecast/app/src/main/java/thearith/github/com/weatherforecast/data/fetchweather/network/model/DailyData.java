package thearith.github.com.weatherforecast.data.fetchweather.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Thearith on 11/8/17.
 */

public final class DailyData implements Serializable {

    @SerializedName("time")
    @Expose
    private long time;
    @SerializedName("summary")
    @Expose
    private String summary;
    @SerializedName("icon")
    @Expose
    private WeatherIcon icon;
    @SerializedName("sunriseTime")
    @Expose
    private int sunriseTime;
    @SerializedName("sunsetTime")
    @Expose
    private int sunsetTime;
    @SerializedName("moonPhase")
    @Expose
    private double moonPhase;
    @SerializedName("precipIntensity")
    @Expose
    private double precipIntensity;
    @SerializedName("precipIntensityMax")
    @Expose
    private double precipIntensityMax;
    @SerializedName("precipIntensityMaxTime")
    @Expose
    private int precipIntensityMaxTime;
    @SerializedName("precipProbability")
    @Expose
    private double precipProbability;
    @SerializedName("precipType")
    @Expose
    private String precipType;
    @SerializedName("temperatureHigh")
    @Expose
    private double temperatureHigh;
    @SerializedName("temperatureHighTime")
    @Expose
    private long temperatureHighTime;
    @SerializedName("temperatureLow")
    @Expose
    private double temperatureLow;
    @SerializedName("temperatureLowTime")
    @Expose
    private long temperatureLowTime;
    @SerializedName("apparentTemperatureHigh")
    @Expose
    private double apparentTemperatureHigh;
    @SerializedName("apparentTemperatureHighTime")
    @Expose
    private long apparentTemperatureHighTime;
    @SerializedName("apparentTemperatureLow")
    @Expose
    private double apparentTemperatureLow;
    @SerializedName("apparentTemperatureLowTime")
    @Expose
    private long apparentTemperatureLowTime;
    @SerializedName("dewPoint")
    @Expose
    private double dewPoint;
    @SerializedName("humidity")
    @Expose
    private double humidity;
    @SerializedName("pressure")
    @Expose
    private double pressure;
    @SerializedName("windSpeed")
    @Expose
    private double windSpeed;
    @SerializedName("windGust")
    @Expose
    private double windGust;
    @SerializedName("windGustTime")
    @Expose
    private long windGustTime;
    @SerializedName("windBearing")
    @Expose
    private int windBearing;
    @SerializedName("cloudCover")
    @Expose
    private double cloudCover;
    @SerializedName("uvIndex")
    @Expose
    private int uvIndex;
    @SerializedName("uvIndexTime")
    @Expose
    private long uvIndexTime;
    @SerializedName("visibility")
    @Expose
    private double visibility;
    @SerializedName("ozone")
    @Expose
    private double ozone;
    @SerializedName("temperatureMin")
    @Expose
    private double temperatureMin;
    @SerializedName("temperatureMinTime")
    @Expose
    private long temperatureMinTime;
    @SerializedName("temperatureMax")
    @Expose
    private double temperatureMax;
    @SerializedName("temperatureMaxTime")
    @Expose
    private long temperatureMaxTime;
    @SerializedName("apparentTemperatureMin")
    @Expose
    private double apparentTemperatureMin;
    @SerializedName("apparentTemperatureMinTime")
    @Expose
    private long apparentTemperatureMinTime;
    @SerializedName("apparentTemperatureMax")
    @Expose
    private double apparentTemperatureMax;
    @SerializedName("apparentTemperatureMaxTime")
    @Expose
    private long apparentTemperatureMaxTime;

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

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

    public int getSunriseTime() {
        return sunriseTime;
    }

    public void setSunriseTime(int sunriseTime) {
        this.sunriseTime = sunriseTime;
    }

    public int getSunsetTime() {
        return sunsetTime;
    }

    public void setSunsetTime(int sunsetTime) {
        this.sunsetTime = sunsetTime;
    }

    public double getMoonPhase() {
        return moonPhase;
    }

    public void setMoonPhase(double moonPhase) {
        this.moonPhase = moonPhase;
    }

    public double getPrecipIntensity() {
        return precipIntensity;
    }

    public void setPrecipIntensity(double precipIntensity) {
        this.precipIntensity = precipIntensity;
    }

    public double getPrecipIntensityMax() {
        return precipIntensityMax;
    }

    public void setPrecipIntensityMax(double precipIntensityMax) {
        this.precipIntensityMax = precipIntensityMax;
    }

    public int getPrecipIntensityMaxTime() {
        return precipIntensityMaxTime;
    }

    public void setPrecipIntensityMaxTime(int precipIntensityMaxTime) {
        this.precipIntensityMaxTime = precipIntensityMaxTime;
    }

    public double getPrecipProbability() {
        return precipProbability;
    }

    public void setPrecipProbability(double precipProbability) {
        this.precipProbability = precipProbability;
    }

    public String getPrecipType() {
        return precipType;
    }

    public void setPrecipType(String precipType) {
        this.precipType = precipType;
    }

    public double getTemperatureHigh() {
        return temperatureHigh;
    }

    public void setTemperatureHigh(double temperatureHigh) {
        this.temperatureHigh = temperatureHigh;
    }

    public long getTemperatureHighTime() {
        return temperatureHighTime;
    }

    public void setTemperatureHighTime(long temperatureHighTime) {
        this.temperatureHighTime = temperatureHighTime;
    }

    public double getTemperatureLow() {
        return temperatureLow;
    }

    public void setTemperatureLow(double temperatureLow) {
        this.temperatureLow = temperatureLow;
    }

    public long getTemperatureLowTime() {
        return temperatureLowTime;
    }

    public void setTemperatureLowTime(long temperatureLowTime) {
        this.temperatureLowTime = temperatureLowTime;
    }

    public double getApparentTemperatureHigh() {
        return apparentTemperatureHigh;
    }

    public void setApparentTemperatureHigh(double apparentTemperatureHigh) {
        this.apparentTemperatureHigh = apparentTemperatureHigh;
    }

    public long getApparentTemperatureHighTime() {
        return apparentTemperatureHighTime;
    }

    public void setApparentTemperatureHighTime(long apparentTemperatureHighTime) {
        this.apparentTemperatureHighTime = apparentTemperatureHighTime;
    }

    public double getApparentTemperatureLow() {
        return apparentTemperatureLow;
    }

    public void setApparentTemperatureLow(double apparentTemperatureLow) {
        this.apparentTemperatureLow = apparentTemperatureLow;
    }

    public long getApparentTemperatureLowTime() {
        return apparentTemperatureLowTime;
    }

    public void setApparentTemperatureLowTime(long apparentTemperatureLowTime) {
        this.apparentTemperatureLowTime = apparentTemperatureLowTime;
    }

    public double getDewPoint() {
        return dewPoint;
    }

    public void setDewPoint(double dewPoint) {
        this.dewPoint = dewPoint;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public double getWindGust() {
        return windGust;
    }

    public void setWindGust(double windGust) {
        this.windGust = windGust;
    }

    public long getWindGustTime() {
        return windGustTime;
    }

    public void setWindGustTime(long windGustTime) {
        this.windGustTime = windGustTime;
    }

    public int getWindBearing() {
        return windBearing;
    }

    public void setWindBearing(int windBearing) {
        this.windBearing = windBearing;
    }

    public double getCloudCover() {
        return cloudCover;
    }

    public void setCloudCover(double cloudCover) {
        this.cloudCover = cloudCover;
    }

    public int getUvIndex() {
        return uvIndex;
    }

    public void setUvIndex(int uvIndex) {
        this.uvIndex = uvIndex;
    }

    public long getUvIndexTime() {
        return uvIndexTime;
    }

    public void setUvIndexTime(long uvIndexTime) {
        this.uvIndexTime = uvIndexTime;
    }

    public double getVisibility() {
        return visibility;
    }

    public void setVisibility(double visibility) {
        this.visibility = visibility;
    }

    public double getOzone() {
        return ozone;
    }

    public void setOzone(double ozone) {
        this.ozone = ozone;
    }

    public double getTemperatureMin() {
        return temperatureMin;
    }

    public void setTemperatureMin(double temperatureMin) {
        this.temperatureMin = temperatureMin;
    }

    public long getTemperatureMinTime() {
        return temperatureMinTime;
    }

    public void setTemperatureMinTime(long temperatureMinTime) {
        this.temperatureMinTime = temperatureMinTime;
    }

    public double getTemperatureMax() {
        return temperatureMax;
    }

    public void setTemperatureMax(double temperatureMax) {
        this.temperatureMax = temperatureMax;
    }

    public long getTemperatureMaxTime() {
        return temperatureMaxTime;
    }

    public void setTemperatureMaxTime(long temperatureMaxTime) {
        this.temperatureMaxTime = temperatureMaxTime;
    }

    public double getApparentTemperatureMin() {
        return apparentTemperatureMin;
    }

    public void setApparentTemperatureMin(double apparentTemperatureMin) {
        this.apparentTemperatureMin = apparentTemperatureMin;
    }

    public long getApparentTemperatureMinTime() {
        return apparentTemperatureMinTime;
    }

    public void setApparentTemperatureMinTime(long apparentTemperatureMinTime) {
        this.apparentTemperatureMinTime = apparentTemperatureMinTime;
    }

    public double getApparentTemperatureMax() {
        return apparentTemperatureMax;
    }

    public void setApparentTemperatureMax(double apparentTemperatureMax) {
        this.apparentTemperatureMax = apparentTemperatureMax;
    }

    public long getApparentTemperatureMaxTime() {
        return apparentTemperatureMaxTime;
    }

    public void setApparentTemperatureMaxTime(long apparentTemperatureMaxTime) {
        this.apparentTemperatureMaxTime = apparentTemperatureMaxTime;
    }
}
