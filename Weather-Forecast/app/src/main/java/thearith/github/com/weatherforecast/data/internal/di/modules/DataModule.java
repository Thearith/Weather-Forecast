package thearith.github.com.weatherforecast.data.internal.di.modules;

import android.content.Context;

import java.io.File;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import thearith.github.com.weatherforecast.data.fetchweather.FetchWeatherRepository;
import thearith.github.com.weatherforecast.data.fetchweather.repository.FetchWeatherRepositoryImpl;
import thearith.github.com.weatherforecast.data.utils.Constants;
import thearith.github.com.weatherforecast.view.internal.di.ApplicationScope;
import thearith.github.com.weatherforecast.view.internal.di.modules.ApplicationModule;

/**
 * Module that controls dependencies for Data
 */

@Module(includes = {ApplicationModule.class})
public class DataModule {

    @Provides
    @ApplicationScope
    FetchWeatherRepository providesFetchWeatherRepository(FetchWeatherRepositoryImpl fetchWeatherImpl) {
        return fetchWeatherImpl;
    }

    // ---------------------------------------------------------
    // @Provide Dependency methods related to DOMAIN layer
    // should be provided here
    // ---------------------------------------------------------

    @Provides
    @ApplicationScope
    Converter.Factory providesConverterFactory() {
        return GsonConverterFactory.create();
    }

    @Provides
    @ApplicationScope
    CallAdapter.Factory providesAdapterFactory() {
        return RxJava2CallAdapterFactory.create();
    }

    @Provides
    @ApplicationScope
    HttpLoggingInterceptor providesHttpLogInterceptor() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        return loggingInterceptor;
    }

    @Provides
    @ApplicationScope
    File providesCacheFile(Context context) {
        return new File(context.getCacheDir(), Constants.CACHE_FILE_NAME);
    }

    @Provides
    @ApplicationScope
    Cache providesCache(File cacheFile) {
        return new Cache(cacheFile, Constants.CACHE_SIZE);
    }


    @Provides
    @ApplicationScope
    OkHttpClient providesHttpClient(HttpLoggingInterceptor loggingInterceptor,
                                    Cache cache) {
        return new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .cache(cache)
                .build();
    }

    @Provides
    @ApplicationScope
    Retrofit.Builder providesRetrofitBuilder(OkHttpClient httpClient,
                                             Converter.Factory converterFactory,
                                             CallAdapter.Factory adatperFactory) {
        return new Retrofit.Builder()
                .client(httpClient)
                .addConverterFactory(converterFactory)
                .addCallAdapterFactory(adatperFactory);
    }

}
