package com.dempaul.c4r.test.swing.datatable.handler;

import com.dempaul.c4r.test.swing.datatable.service.DataService;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectFileButtonEventListener implements ActionListener {

    private static final DataService dataService = new DataService();

    public void actionPerformed(ActionEvent event) {
        dataService.choseDataFile();
    }
}
