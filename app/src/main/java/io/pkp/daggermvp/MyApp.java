package io.pkp.daggermvp;

import android.app.Application;

import io.pkp.daggermvp.di.components.DaggerGitHubComponent;
import io.pkp.daggermvp.di.components.DaggerNetComponent;
import io.pkp.daggermvp.di.components.GitHubComponent;
import io.pkp.daggermvp.di.components.NetComponent;
import io.pkp.daggermvp.di.modules.AppModule;
import io.pkp.daggermvp.di.modules.GitHubModule;
import io.pkp.daggermvp.di.modules.NetModule;

/**
 * Created by praveen on 6/5/16.
 */
public class MyApp extends Application {

    private NetComponent mNetComponent;
    private GitHubComponent mGitHubComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        // specify the full namespace of the component
        // Dagger_xxxx (where xxxx = component name)
        mNetComponent = DaggerNetComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule("https://api.github.com"))
                .build();

        mGitHubComponent = DaggerGitHubComponent.builder()
                .netComponent(mNetComponent)
                .gitHubModule(new GitHubModule())
                .build();

    }

    public NetComponent getNetComponent() {
        return mNetComponent;
    }

    public GitHubComponent getGitHubComponent() {
        return mGitHubComponent;
    }
}
