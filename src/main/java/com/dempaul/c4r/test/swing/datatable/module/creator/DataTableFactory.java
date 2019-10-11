package com.dempaul.c4r.test.swing.datatable.module.creator;

import com.dempaul.c4r.test.swing.datatable.model.field.Field;

import javax.swing.table.DefaultTableModel;

public class DataTableFactory {

    private static final Field[] fields = FormCreator.getFields();

    private static DefaultTableModel instance;

    public static DefaultTableModel getDataTable() {
        if (instance == null) {
            instance = new DefaultTableModel();

            Object[] columns = new Object[fields.length];
            for (int i = 0; i < fields.length; i++) {
                columns[i] = fields[i].getName();
            }
            instance.setColumnIdentifiers(columns);
        }
        return instance;
    }
}
