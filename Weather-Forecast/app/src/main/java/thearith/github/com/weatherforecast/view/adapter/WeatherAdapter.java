package thearith.github.com.weatherforecast.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jakewharton.rxbinding2.view.RxView;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;
import thearith.github.com.weatherforecast.R;
import thearith.github.com.weatherforecast.data.fetchweather.network.model.DailyData;
import thearith.github.com.weatherforecast.view.adapter.viewholders.WeatherHeaderViewHolder;
import thearith.github.com.weatherforecast.view.adapter.viewholders.WeatherItemViewHolder;
import thearith.github.com.weatherforecast.view.utils.Constants;

/**
 * Created by Thearith on 11/8/17.
 */

public final class WeatherAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private String mDescription;
    private List<DailyData> mDatas;

    private Subject<DailyData> mRowClickSubject;

    public WeatherAdapter() {
        mDescription = Constants.EMPTY_STRING;
        mDatas = new ArrayList<>();
        mRowClickSubject = PublishSubject.create();
    }

    public void addHeader(String description) {
        mDescription = description;
        notifyItemInserted(0);
    }

    public void addData(List<DailyData> datas) {
        if(datas != null) {
            int toAddPos = mDatas.size() + 1; // including Header
            int addedSize = datas.size();
            mDatas.addAll(datas);

            notifyItemRangeInserted(toAddPos, addedSize);
        }
    }

    public void clearAll() {
        int size = mDatas.size();
        mDescription = Constants.EMPTY_STRING;
        mDatas = new ArrayList<>();

        notifyItemRangeRemoved(0, size + 1);
    }

    public Observable<DailyData> getRowClickStream() {
        return mRowClickSubject;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        switch (viewType) {
            case WeatherHeaderViewHolder.LAYOUT_ID:
                return onCreateWeatherHeaderViewHolder(parent);

            case WeatherItemViewHolder.LAYOUT_ID:
            default:
                return onCreateWeatherItemViewHolder(parent);
        }
    }

    private RecyclerView.ViewHolder onCreateWeatherHeaderViewHolder(ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_weather_header, parent, false);
        return new WeatherHeaderViewHolder(view);
    }

    private RecyclerView.ViewHolder onCreateWeatherItemViewHolder(ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_weather, parent, false);
        WeatherItemViewHolder viewHolder = new WeatherItemViewHolder(view);

        // Attach view clicks
        viewHolder.getRowClickStream()
                .takeUntil(RxView.detaches(parent))
                .subscribe(mRowClickSubject);

        return viewHolder;
    }

    @Override
    public int getItemCount() {
        return !TextUtils.isEmpty(mDescription) ?
                mDatas.size() + 1 :
                0;
    }

    @Override
    public int getItemViewType(int position) {
        if(position == 0) {
            return WeatherHeaderViewHolder.LAYOUT_ID;
        }

        return WeatherItemViewHolder.LAYOUT_ID;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(position == 0) {
            onBindWeatherHeaderViewHolder(holder);
        } else {
            onBindWeatherItemViewHolder(holder, position);
        }
    }

    private void onBindWeatherHeaderViewHolder(RecyclerView.ViewHolder holder) {
        if(holder instanceof WeatherHeaderViewHolder) {
            WeatherHeaderViewHolder headerViewHolder = (WeatherHeaderViewHolder) holder;
            headerViewHolder.bind(mDescription);
        }
    }

    private void onBindWeatherItemViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof WeatherItemViewHolder) {
            WeatherItemViewHolder itemViewHolder = (WeatherItemViewHolder) holder;
            DailyData data = mDatas.get(position - 1); // excluding WeatherHeaderViewHolder
            itemViewHolder.bind(data);
        }
    }

}
