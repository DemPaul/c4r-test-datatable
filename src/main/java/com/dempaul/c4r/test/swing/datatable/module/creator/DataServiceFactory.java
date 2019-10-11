package com.dempaul.c4r.test.swing.datatable.module.creator;

import com.dempaul.c4r.test.swing.datatable.service.DataService;

public class DataServiceFactory {

    private static DataService instance;

    private DataServiceFactory() {
    }

    public static synchronized DataService getDataService() {
        if (instance == null) {
            instance = new DataService();
        }
        return instance;
    }
}
