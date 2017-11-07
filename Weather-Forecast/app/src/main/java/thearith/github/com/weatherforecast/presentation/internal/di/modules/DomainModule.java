package thearith.github.com.weatherforecast.presentation.internal.di.modules;

import dagger.Module;
import dagger.Provides;
import thearith.github.com.weatherforecast.presentation.schedulers.ThreadExecutor;
import thearith.github.com.weatherforecast.presentation.schedulers.impl.JobExecutor;
import thearith.github.com.weatherforecast.presentation.schedulers.impl.UIThread;
import thearith.github.com.weatherforecast.presentation.schedulers.PostExecutionThread;
import thearith.github.com.weatherforecast.view.internal.di.ApplicationScope;
import thearith.github.com.weatherforecast.view.internal.di.modules.ApplicationModule;


/**
 * A module that controls all dependencies of Domain
 */

@Module(includes = {ApplicationModule.class})
public class DomainModule {

    @Provides
    @ApplicationScope
    ThreadExecutor provideThreadExecutor(JobExecutor jobExecutor) {
        return jobExecutor;
    }

    @Provides
    @ApplicationScope
    PostExecutionThread providePostExecutionThread(UIThread uiThread) {
        return uiThread;
    }


    // ---------------------------------------------------------
    // @Provide Dependency methods related to Domain layer
    // should be provided here
    // ---------------------------------------------------------

}
