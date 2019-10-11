package com.dempaul.c4r.test.swing.datatable.model.field.impl;

import com.dempaul.c4r.test.swing.datatable.model.field.Field;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NameField implements Field {

    private static final String name = "Name";

    private static final String infoMessage = "The name should only contain Latin letters, " +
            "it can also consist of no more than four words separated by spaces";

    private String value;

    public NameField() {
    }

    public NameField(String value) {
        this.value = value;
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
        final Pattern pattern = Pattern.compile("^[a-zA-Z]+$");
        Matcher matcher;
        String[] words = value.split("\\s+");
        if (words.length == 0 || words.length > 4) {
            return false;
        } else {
            for (String word : words) {
                matcher = pattern.matcher(word);
                if (!matcher.find()) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NameField that = (NameField) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "NameField{" +
                "value='" + value + '\'' +
                '}';
    }
}
