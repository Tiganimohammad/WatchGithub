package io.fisache.watchgithub.data.github;

import dagger.Module;
import dagger.Provides;
import io.fisache.watchgithub.data.cache.CacheRepositoriesManager;
import io.fisache.watchgithub.data.cache.CacheService;
import io.fisache.watchgithub.data.model.User;
import io.fisache.watchgithub.scope.UserScope;

@Module
public class GithubUserModule {
    private User user;

    public GithubUserModule(User user) {
        this.user = user;
    }

    @Provides
    @UserScope
    User provideUser() {
        return user;
    }

    @Provides
    @UserScope
    GithubRepositoriesManager provideGithubRepositoriesManager(User user) {
        return new GithubRepositoriesManager(user);
    }

    @Provides
    @UserScope
    CacheRepositoriesManager provideCacheRepositoriesManager(CacheService cacheService) {
        return new CacheRepositoriesManager(user, cacheService);
    }
}