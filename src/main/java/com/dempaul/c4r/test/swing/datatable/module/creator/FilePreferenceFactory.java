package com.dempaul.c4r.test.swing.datatable.module.creator;

import com.dempaul.c4r.test.swing.datatable.model.preference.FilePreference;

public class FilePreferenceFactory {

    private static FilePreference instance;

    private FilePreferenceFactory() {
    }

    public static FilePreference getFilePreference() {
        if (instance == null) {
            instance = new FilePreference();
        }
        return instance;
    }
}
