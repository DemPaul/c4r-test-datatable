package com.dempaul.c4r.test.swing.datatable.module.creator;

import com.dempaul.c4r.test.swing.datatable.model.field.Field;
import org.reflections.Reflections;

import java.util.Set;

public class FormCreator {

    private static Field[] fields;

    private FormCreator() {
    }

    public static Field[] getFields(){
        if (fields == null) {
            Reflections reflections = new Reflections("com.dempaul.c4r.test.swing.datatable");
            Set<Class<? extends Field>> classes = reflections.getSubTypesOf(Field.class);
            fields = new Field[classes.size()];
            for (int i = 0; i < classes.size(); i++) {
                Class<? extends Field> clazz = (Class<? extends Field>) classes.toArray()[i];
                try {
                    fields[i] = clazz.newInstance();
                } catch (InstantiationException | IllegalAccessException e) {
                    e.getMessage();
                }
            }
        }
        return fields;
    }
}
