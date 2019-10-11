package com.dempaul.c4r.test.swing.datatable;

import com.dempaul.c4r.test.swing.datatable.model.field.Field;
import com.dempaul.c4r.test.swing.datatable.model.field.impl.EmailField;
import com.dempaul.c4r.test.swing.datatable.model.field.impl.NameField;
import org.junit.Assert;
import org.junit.Test;

public class FieldValidationTest {

    private static Field nameField = new NameField();
    private static Field emailField = new EmailField();

    @Test
    public void validNameFieldTest() {
        nameField.setValue("");
        Assert.assertFalse(nameField.isValid());

        nameField.setValue("");
        Assert.assertFalse(nameField.isValid());

        nameField.setValue("name With More Than four Words");
        Assert.assertFalse(nameField.isValid());

        nameField.setValue("Name_With 0ther Symb0ls");
        Assert.assertFalse(nameField.isValid());

        nameField.setValue("Name");
        Assert.assertTrue(nameField.isValid());

        nameField.setValue("name with Four Words");
        Assert.assertTrue(nameField.isValid());
    }

    @Test
    public void validEmailFieldTest() {
        emailField.setValue("");
        Assert.assertFalse(emailField.isValid());

        emailField.setValue(" ");
        Assert.assertFalse(emailField.isValid());

        emailField.setValue("3mail.starts@by_number");
        Assert.assertFalse(emailField.isValid());

        emailField.setValue("Email.without_At.sign");
        Assert.assertFalse(emailField.isValid());

        emailField.setValue("Separated by space@Email");
        Assert.assertFalse(emailField.isValid());

        emailField.setValue(("Emai1.starts@by_letter"));
        Assert.assertTrue(emailField.isValid());

        emailField.setValue("s@1d.1");
        Assert.assertTrue(emailField.isValid());
    }
}
