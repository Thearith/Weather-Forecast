package thearith.github.com.weatherforecast.view.utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import io.reactivex.annotations.Nullable;

import static java.util.Calendar.getInstance;

/**
 * Utility class for converting date
 */

public final class DateUtils {

    private static final String     DAY_OF_WEEK_FORMAT      = "EEEE";
    private static final String     FULL_DATE_FORMAT        = "EEE, dd MM, yyyy";


    public static String getDayOfWeek(long timestamp) {
        return getDateWithFormat(timestamp, DAY_OF_WEEK_FORMAT);
    }

    public static String getFullDate(long timestamp) {
        return getDateWithFormat(timestamp, FULL_DATE_FORMAT);
    }

    private static String getDateWithFormat(long timestamp, String format) {
        DateFormat formatter = new SimpleDateFormat(format);
        formatter.setTimeZone(TimeZone.getDefault());
        Date date = getDate(timestamp);
        return date != null ? formatter.format(date) : Constants.EMPTY_STRING;
    }

    @Nullable
    private static Date getDate(long time) {
        if(time > 0) {
            Timestamp timestamp = new Timestamp(time*1000);
            return new Date(timestamp.getTime());
        }

        return null;
    }
}
