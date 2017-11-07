package thearith.github.com.weatherforecast.view.internal.di.components;


import android.content.Context;

import dagger.Component;
import thearith.github.com.weatherforecast.MainActivity;
import thearith.github.com.weatherforecast.data.internal.di.modules.DataModule;
import thearith.github.com.weatherforecast.presentation.internal.di.modules.DomainModule;
import thearith.github.com.weatherforecast.view.internal.di.ApplicationScope;
import thearith.github.com.weatherforecast.view.internal.di.modules.ApplicationModule;

/**
 * A component whose lifetime is the life of the application.
 */

@ApplicationScope
@Component(modules = {ApplicationModule.class, DomainModule.class, DataModule.class})
public interface ApplicationComponent {

    Context context();

    void inject(MainActivity activity);
}
