package io.pkp.daggermvp.di.components;

import dagger.Component;
import io.pkp.daggermvp.MainActivity;
import io.pkp.daggermvp.di.modules.GitHubModule;
import io.pkp.daggermvp.di.scopes.UserScope;

@UserScope
@Component(dependencies = NetComponent.class, modules = GitHubModule.class)
public interface GitHubComponent {
    void inject(MainActivity activity);
}
