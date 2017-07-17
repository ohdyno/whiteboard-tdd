package io.pivotal.michigan.test.doubles;

import io.pivotal.michigan.production.boundary.UI;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GuiSpy implements UI {
    private List<String> errors = new ArrayList<>();

    public Collection<String> getErrors() {
        return errors;
    }

    @Override
    public void validationErrorFound(String error) {
        errors.add(error);
    }
}
