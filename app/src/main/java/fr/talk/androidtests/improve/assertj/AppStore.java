package fr.talk.androidtests.improve.assertj;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class AppStore {

    private final List<App> apps = new ArrayList<>();

    AppStore(List<App> apps) {
        this.apps.addAll(new HashSet<>(apps));
    }

    List<App> getApps() {
        return apps;
    }
}
