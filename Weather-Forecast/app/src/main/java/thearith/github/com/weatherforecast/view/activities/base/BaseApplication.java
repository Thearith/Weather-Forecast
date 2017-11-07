package thearith.github.com.weatherforecast.view.activities.base;

import android.app.Application;

import com.squareup.leakcanary.BuildConfig;
import com.squareup.leakcanary.LeakCanary;

import thearith.github.com.weatherforecast.view.internal.di.components.ApplicationComponent;
import thearith.github.com.weatherforecast.view.internal.di.components.DaggerApplicationComponent;
import thearith.github.com.weatherforecast.view.internal.di.modules.ApplicationModule;

/**
 * Android Main Application
 */
public class BaseApplication extends Application {

    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        initLeakCanary();
        initDependencies();
    }

    /**
     * Initializes Leak Canary (for monitoring leak memory)
     * */
    private void initLeakCanary() {
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }

        if(BuildConfig.DEBUG) {
            LeakCanary.install(this);
        }
    }


    /**
     * Initializes Dagger 2 dependencies
     * */
    private void initDependencies() {
        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }


    public ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }
}
