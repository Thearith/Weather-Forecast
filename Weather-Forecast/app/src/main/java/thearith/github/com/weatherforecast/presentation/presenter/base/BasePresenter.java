package thearith.github.com.weatherforecast.presentation.presenter.base;

import android.support.annotation.CallSuper;

import thearith.github.com.weatherforecast.presentation.schedulers.PostExecutionThread;
import thearith.github.com.weatherforecast.presentation.schedulers.ThreadExecutor;

/**
 * [Presenter] that controls communication between views and models of the presentation
 * layer.
 *
 * This class should be the super class of all [Presenter] classes.
 */
public abstract class BasePresenter {

    protected ThreadExecutor mThreadExecutor;
    protected PostExecutionThread mPostExecutorThread;


    public BasePresenter(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        mThreadExecutor = threadExecutor;
        mPostExecutorThread = postExecutionThread;
    }

}
