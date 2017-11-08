package thearith.github.com.weatherforecast.data.utils;

/**
 * Created by Thearith on 11/7/17.
 */

public final class Constants {

    public static final int CACHE_SIZE              = 10 * 1024 * 1024;
    public static final String CACHE_FILE_NAME      = "weather-forecast-cache";

    public static final String DARK_SKY_BASE_URL    = "https://api.darksky.net";
    public static final double SG_LATITUDE          = 1.3521;
    public static final double SG_LONGITUDE         = 103.8198;
    public static final String API_BLACKLIST        = "currently,hourly,flags,minutely";
    public static final String UNITS                = "si";
}
