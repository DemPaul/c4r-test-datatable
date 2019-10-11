package com.dempaul.c4r.test.swing.datatable.model.field.impl;

import com.dempaul.c4r.test.swing.datatable.model.field.Field;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailField implements Field {

    private static final String name = "Email";

    private static final String infoMessage = "The email address must consist of two parts, " +
            "separated by the '@' symbol, the parts must begin only with Latin letters, " +
            "but may contain the characters: '-', '_', '.'";

    private String value;

    public EmailField() {
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String getInfoMessage() {
        return infoMessage;
    }

    @Override
    public boolean isValid() {
        final Pattern pattern = Pattern.compile(
                "^[A-Z]+[A-Z0-9._-]*@[A-Z0-9]+[A-Z0-9._-]*$", Pattern.CASE_INSENSITIVE);

        Matcher matcher = pattern.matcher(value);
        return matcher.find();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmailField that = (EmailField) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "EmailField{" +
                "value='" + value + '\'' +
                '}';
    }
}
