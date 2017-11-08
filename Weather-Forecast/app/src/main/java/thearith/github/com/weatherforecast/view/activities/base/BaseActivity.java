package thearith.github.com.weatherforecast.view.activities.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import thearith.github.com.weatherforecast.view.internal.di.components.ApplicationComponent;

/**
 * Base Activity class for every Activity in this application.
 *
 */
public abstract class BaseActivity extends AppCompatActivity {

    private CompositeDisposable mDisposables;

    protected abstract void injectDependencies(ApplicationComponent appComponent);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initCompositeDisposables();

        ApplicationComponent appComponent = getApplicationComponent();
        injectDependencies(appComponent);
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.bind(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        destroyDisposables();
    }

    protected ApplicationComponent getApplicationComponent() {
        return ((BaseApplication) getApplication()).getApplicationComponent();
    }

    private void initCompositeDisposables() {
        mDisposables = new CompositeDisposable();
    }

    protected void addDisposable(Disposable disposable) {
        mDisposables.add(disposable);
    }

    private void destroyDisposables() {
        if(!mDisposables.isDisposed()) {
            mDisposables.dispose();
        }
    }

}
