package com.dempaul.c4r.test.swing.datatable.handler;

import com.dempaul.c4r.test.swing.datatable.model.preference.FilePreference;
import com.dempaul.c4r.test.swing.datatable.module.creator.FilePreferenceFactory;
import com.dempaul.c4r.test.swing.datatable.service.DataService;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

public class WindowEventAdapter extends WindowAdapter {

    private static final String DEFAULT_VALUE = "nil";

    private static final FilePreference filePreference = FilePreferenceFactory.getFilePreference();
    private static final DataService dataService = new DataService();

    @Override
    public void windowOpened(WindowEvent event) {
        super.windowOpened(event);

        String propertyValue = filePreference.getFilePreference(DEFAULT_VALUE);
        if (new File(propertyValue).isFile()) {
            dataService.loadData(propertyValue);
        }
    }

    @Override
    public void windowClosing(WindowEvent event) {
        super.windowClosing(event);

        String propertyValue = filePreference.getFilePreference(DEFAULT_VALUE);
        if (propertyValue.equals(DEFAULT_VALUE) || !(new File(propertyValue).isFile())) {
            JFrame frame = new JFrame();
            String message = "Attention!\n " +
                    "If you exit your not saved data will be lost!\n " +
                    "Do you want to select a folder to save it?";

            int selection = JOptionPane.showConfirmDialog(frame, message, "Alert", JOptionPane.YES_NO_OPTION);
            if (selection == JOptionPane.YES_OPTION) {
                if (dataService.choseDataFile()) {
                    event.getWindow().setVisible(false);
                    System.exit(0);
                }

            } else if (selection == JOptionPane.NO_OPTION) {
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                event.getWindow().setVisible(false);
                System.exit(0);
            }
        } else {
            if (dataService.saveData(propertyValue)) {
                String message = "Data successfully saved to this file: \n" + propertyValue;

                Icon icon = UIManager.getIcon("OptionPane.informationIcon");
                JOptionPane.showMessageDialog(null, message,
                        "Data saved!", JOptionPane.PLAIN_MESSAGE, icon);
                dataService.saveData(propertyValue);
                event.getWindow().setVisible(false);
                System.exit(0);
            }
        }
    }
}
