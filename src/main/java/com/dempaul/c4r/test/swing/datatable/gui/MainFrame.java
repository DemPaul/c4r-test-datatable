package com.dempaul.c4r.test.swing.datatable.gui;

import com.dempaul.c4r.test.swing.datatable.gui.panel.FormPanel;
import com.dempaul.c4r.test.swing.datatable.gui.panel.TablePanel;
import com.dempaul.c4r.test.swing.datatable.handler.WindowEventAdapter;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private static final FormPanel formPanel = new FormPanel();
    private static final TablePanel tablePanel = new TablePanel();

    public MainFrame() {
        super("Test task for C4R");
        setLayout(null);
        setSize(760, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        Container container = getContentPane();

        JLabel title = new JLabel("'DataTable' Test task for C4R");
        title.setFont(new Font("SanSerif", Font.BOLD, 20));
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setBounds(200, 25, 300, 50);
        title.setBorder(BorderFactory.createLineBorder(Color.black, 1, true));
        container.add(title);

        container.add(formPanel);
        container.add(tablePanel);

        addWindowListener(new WindowEventAdapter());
    }
}
