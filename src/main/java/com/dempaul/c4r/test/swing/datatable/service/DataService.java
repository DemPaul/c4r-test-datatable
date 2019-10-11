package com.dempaul.c4r.test.swing.datatable.service;

import com.dempaul.c4r.test.swing.datatable.model.preference.FilePreference;
import com.dempaul.c4r.test.swing.datatable.module.creator.DataTableFactory;
import com.dempaul.c4r.test.swing.datatable.module.creator.FilePreferenceFactory;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DataService {

    private static final FilePreference filePreference = FilePreferenceFactory.getFilePreference();
    private static final DefaultTableModel tableModel = DataTableFactory.getDataTable();

    public boolean saveData(String filePath) {
        File fileToSave = new File(filePath);
        try (FileWriter fileWriter = new FileWriter(fileToSave)) {
            int rowCount = tableModel.getRowCount();
            int columnCount = tableModel.getColumnCount();
            for (int i = 0; i < rowCount; i++) {
                for (int j = 0; j < columnCount; j++) {
                    fileWriter.write(String.format("%s|", tableModel.getValueAt(i, j)));
                }
                fileWriter.write("\r\n");
            }
            fileWriter.flush();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public boolean loadData(String filePath) {
        File fileToLoad = new File(filePath);
        try (FileReader fileReader = new FileReader(fileToLoad)) {
            Scanner scan = new Scanner(fileReader);
            while (scan.hasNext()) {
                String line = scan.nextLine();
                Object[] row = line.trim().split("\\|");
                tableModel.addRow(row);
            }
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public boolean choseDataFile() {
        JFrame choiceFrame = new JFrame();
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Specify a file to save data");

        int userSelection = fileChooser.showSaveDialog(choiceFrame);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            String message;
            try {
                File fileToSave = fileChooser.getSelectedFile();
                if (!fileToSave.isFile()) {
                    String[] nameStrings = fileToSave.getAbsolutePath().split("\\.");
                    fileToSave = new File(nameStrings[0] + ".txt");
                    fileToSave.createNewFile();
                }

                String value = fileToSave.getAbsolutePath();
                filePreference.putFilePreference(value);
                message = "Storage file successfully selected! \n" +
                        "Data will be saved to this file: \n" +
                        value;

                Icon icon = UIManager.getIcon("OptionPane.informationIcon");
                JOptionPane.showMessageDialog(null, message,
                        "Success!", JOptionPane.PLAIN_MESSAGE, icon);
                return true;

            } catch (IOException e) {
                    message = "Storage file don`t selected!";

                    Icon icon = UIManager.getIcon("OptionPane.warningIcon");
                    JOptionPane.showMessageDialog(null, message,
                            "Attention!", JOptionPane.PLAIN_MESSAGE, icon);
            }
        }
        return false;
    }
}
