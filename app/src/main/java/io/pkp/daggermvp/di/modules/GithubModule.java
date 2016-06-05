package io.pkp.daggermvp.di.modules;


import dagger.Module;
import dagger.Provides;
import io.pkp.daggermvp.di.scopes.UserScope;
import io.pkp.daggermvp.network.interfaces.GitHubApiInterface;
import retrofit.Retrofit;

@Module
public class GitHubModule {

    @Provides
    @UserScope
    public GitHubApiInterface providesGitHubInterface(Retrofit retrofit) {
        return retrofit.create(GitHubApiInterface.class);
    }
}
