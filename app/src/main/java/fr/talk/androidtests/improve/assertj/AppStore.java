package fr.talk.androidtests.improve.assertj;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class AppStore {
    private final List<App> apps = new ArrayList<>();

    public AppStore(List<App> apps) {
        this.apps.addAll(new LinkedHashSet<>(apps));
    }

    public List<App> getApps() {
        return apps;
    }
}
