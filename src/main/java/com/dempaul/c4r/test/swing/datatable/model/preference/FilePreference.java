package com.dempaul.c4r.test.swing.datatable.model.preference;

import java.util.prefs.Preferences;

public class FilePreference {

    private Preferences preferences = Preferences.userNodeForPackage(
            com.dempaul.c4r.test.swing.datatable.Main.class);

    private static final String PREFERENCE_NAME = "DATA_FILE";

    public void putFilePreference(String value) {
        preferences.put(PREFERENCE_NAME, value);
    }

    public String getFilePreference(String defaultValue) {
        return preferences.get(PREFERENCE_NAME, defaultValue);
    }
}
