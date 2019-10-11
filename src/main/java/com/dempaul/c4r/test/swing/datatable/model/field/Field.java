package com.dempaul.c4r.test.swing.datatable.model.field;

public interface Field {

    String getName();

    String getValue();

    void setValue(String value);

    String getInfoMessage();

    boolean isValid();
}
