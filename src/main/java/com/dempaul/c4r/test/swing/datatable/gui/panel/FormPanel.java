package com.dempaul.c4r.test.swing.datatable.gui.panel;

import com.dempaul.c4r.test.swing.datatable.model.field.Field;
import com.dempaul.c4r.test.swing.datatable.module.creator.DataTableFactory;
import com.dempaul.c4r.test.swing.datatable.module.creator.FormCreator;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormPanel extends JPanel {

    private static final DefaultTableModel dataTable = DataTableFactory.getDataTable();

    private final Field[] fields = FormCreator.getFields();
    private final JLabel[] fieldLabels = new JLabel[fields.length];
    private final JTextField[] fieldInputs = new JTextField[fields.length];

    public FormPanel() {
        setLayout(null);
        setBorder(BorderFactory.createLineBorder(Color.black, 1, true));

        JPanel fieldsPanel = new JPanel();
        fieldsPanel.setLayout(new GridLayout(fields.length, 2, 0, 25));
        fieldsPanel.setBorder(new EmptyBorder(new Insets(15, 15, 15, 15)));
        for (int i = 0; i < fields.length; i++) {
            fieldLabels[i] = new JLabel(fields[i].getName() + ":");
            fieldLabels[i].setFont(new Font("SanSerif", Font.BOLD, 15));
            fieldLabels[i].setToolTipText(fields[i].getInfoMessage());
            fieldsPanel.add(fieldLabels[i]);

            fieldInputs[i] = new JTextField("");
            fieldInputs[i].setFont(new Font("SanSerif", Font.PLAIN, 15));
            fieldsPanel.add(fieldInputs[i]);
        }

        JButton submitButton = new JButton("Add to table");
        if(fields.length > 3) {
            setBounds(40, 110, 290, 320);
            JScrollPane scrollPane = new JScrollPane(fieldsPanel);
            scrollPane.setBounds(25, 25, 240, 190);
            add(scrollPane);
            submitButton.setBounds(70, 240, 140, 35);
        } else {
            setBounds(40, 110, 290, fields.length * (25 + 35) + 100);
            fieldsPanel.setBounds(25, 25, 240, fields.length * 50 + 20);
            add(fieldsPanel);
            submitButton.setBounds(70, fields.length * (25 + 35) + 40, 140, 35);
        }
        submitButton.addActionListener(new SubmitButtonEventListener());
        add(submitButton);
    }

    private class SubmitButtonEventListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {

            StringBuilder message = new StringBuilder("Data:\n");
            for (int i = 0; i < fields.length; i++) {
                message.append(String.format("%s  %s", fieldLabels[i].getText(), (fieldInputs[i].getText())))
                        .append("\n");
            }

            for (int i = 0; i < fields.length; i++) {
                Field field = fields[i];
                field.setValue(fieldInputs[i].getText());
                if (!field.isValid()) {
                    message.append("do not added into the table!");
                    Icon icon = UIManager.getIcon("OptionPane.warningIcon");
                    JOptionPane.showMessageDialog(null, message.toString(),
                            String.format("Something wrong!(%s)", field.getName()),  JOptionPane.PLAIN_MESSAGE, icon);
                    return;
                }
            }

            Object[] row = new Object[fields.length];
            for (int i = 0; i < fields.length; i++) {
                row[i] = fieldInputs[i].getText();
                fieldInputs[i].setText("");
            }
            dataTable.addRow(row);

            message.append("successfully added into the table!");
            Icon icon = UIManager.getIcon("OptionPane.informationIcon");
            JOptionPane.showMessageDialog(null, message.toString(),
                    "Success!", JOptionPane.PLAIN_MESSAGE, icon);
        }
    }
}
