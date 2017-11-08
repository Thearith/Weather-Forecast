package thearith.github.com.weatherforecast.view.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.thbs.skycons.library.CloudFogView;
import com.thbs.skycons.library.CloudHvRainView;
import com.thbs.skycons.library.CloudMoonView;
import com.thbs.skycons.library.CloudRainView;
import com.thbs.skycons.library.CloudSnowView;
import com.thbs.skycons.library.CloudSunView;
import com.thbs.skycons.library.CloudView;
import com.thbs.skycons.library.MoonView;
import com.thbs.skycons.library.SkyconView;
import com.thbs.skycons.library.SunView;
import com.thbs.skycons.library.WindView;

import thearith.github.com.weatherforecast.R;
import thearith.github.com.weatherforecast.data.fetchweather.network.model.WeatherIcon;
import thearith.github.com.weatherforecast.view.utils.ViewConstants;

/**
 * Created by Thearith on 11/8/17.
 */

public class SkyConView extends FrameLayout {

    private int strokeColor;
    private int bgColor;

    public SkyConView(@NonNull Context context) {
        super(context);
    }

    public SkyConView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        TypedArray typedArrays = getContext().obtainStyledAttributes(attrs, R.styleable.SkyConViewAttrs);
        strokeColor = typedArrays.getColor(R.styleable.SkyConViewAttrs_strokeColor, Color.BLACK);
        bgColor = typedArrays.getColor(R.styleable.SkyConViewAttrs_bgColor, Color.WHITE);
    }

    public void setIcon(WeatherIcon icon) {
        SkyconView skyconView = getSkyCon(icon);

        LayoutParams params = new LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.MATCH_PARENT);
        skyconView.setLayoutParams(params);

        addView(skyconView);
    }

    private SkyconView getSkyCon(WeatherIcon icon) {
        switch (icon) {
            case CLEAR_NIGHT:
                return new MoonView(getContext(), ViewConstants.IS_STATIC,
                        ViewConstants.IS_ANIMATED, strokeColor, bgColor);

            case RAIN:
                return new CloudRainView(getContext(), ViewConstants.IS_STATIC,
                        ViewConstants.IS_ANIMATED, strokeColor, bgColor);

            case SNOW:
                return new CloudSnowView(getContext(), ViewConstants.IS_STATIC,
                        ViewConstants.IS_ANIMATED, strokeColor, bgColor);

            case SLEET:
                return new CloudHvRainView(getContext(), ViewConstants.IS_STATIC,
                        ViewConstants.IS_ANIMATED, strokeColor, bgColor);

            case WIND:
                return new WindView(getContext(), ViewConstants.IS_STATIC,
                        ViewConstants.IS_ANIMATED, strokeColor, bgColor);

            case FOG:
                return new CloudFogView(getContext(), ViewConstants.IS_STATIC,
                        ViewConstants.IS_ANIMATED, strokeColor, bgColor);

            case CLOUDY:
                return new CloudView(getContext(), ViewConstants.IS_STATIC,
                        ViewConstants.IS_ANIMATED, strokeColor, bgColor);

            case PARTY_CLOUDY_DAY:
                return new CloudSunView(getContext(), ViewConstants.IS_STATIC,
                        ViewConstants.IS_ANIMATED, strokeColor, bgColor);

            case PARTY_CLOUDY_NIGHT:
                return new CloudMoonView(getContext(), ViewConstants.IS_STATIC,
                        ViewConstants.IS_ANIMATED, strokeColor, bgColor);

            case CLEAR_DAY:
            default:
                return new SunView(getContext(), ViewConstants.IS_STATIC,
                        ViewConstants.IS_ANIMATED, strokeColor, bgColor);
        }
    }
}
