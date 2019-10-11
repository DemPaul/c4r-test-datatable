package com.dempaul.c4r.test.swing.datatable.gui.panel;

import com.dempaul.c4r.test.swing.datatable.handler.SelectFileButtonEventListener;
import com.dempaul.c4r.test.swing.datatable.module.creator.DataTableFactory;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class TablePanel extends JPanel {

    private static final DefaultTableModel tableModel = DataTableFactory.getDataTable();

    public TablePanel(){
        setBounds(370, 110, 340, 320);
        setLayout(null);
        setBorder(BorderFactory.createLineBorder(Color.black, 1, true));

        JTable table = new JTable();
        table.setModel(tableModel);
        table.setBackground(Color.white);
        table.setPreferredScrollableViewportSize(new Dimension(250, 100));
        table.setFillsViewportHeight(true);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(25, 25, 290, 190);
        scrollPane.setBorder(BorderFactory.createLineBorder(Color.black, 1, true));
        add(scrollPane);

        JButton selectFileButton = new JButton("Select file to save data");
        selectFileButton.setBounds(70, 240, 200, 35);
        selectFileButton.addActionListener(new SelectFileButtonEventListener());
        add(selectFileButton);
    }
}
