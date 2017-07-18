package io.pivotal.michigan.test.doubles;

import io.pivotal.michigan.production.boundary.Gui;

import java.util.Collection;
import java.util.HashSet;

public class GuiSpy implements Gui {

    private HashSet<String> errors = new HashSet<>();

    public Collection<String> getValidationErrors() {
        return errors;
    }

    @Override
    public void validationErrorFound(String error) {
        errors.add(error);
    }
}
