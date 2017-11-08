package thearith.github.com.weatherforecast.presentation.schedulers.impl;

import javax.inject.Inject;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import thearith.github.com.weatherforecast.presentation.schedulers.PostExecutionThread;

/**
 * MainThread (UI Thread) implementation based on a {@link Scheduler}
 * which will execute actions on the Android UI thread
 */
public class UIThread implements PostExecutionThread {

    @Inject
    public UIThread() {

    }

    @Override
    public Scheduler getScheduler() {
        return AndroidSchedulers.mainThread();
    }


}
