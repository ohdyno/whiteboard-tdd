package io.pivotal.michigan.test;

import io.pivotal.michigan.production.boundary.Gui;
import io.pivotal.michigan.production.boundary.WhiteboardRepo;
import io.pivotal.michigan.test.doubles.GuiSpy;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.junit.MatcherAssert.assertThat;

public class CreateWhiteboardTest {
    @Test
    @DisplayName("whiteboard name cannot be empty")
    public void emptyNameError() {
        GuiSpy guiSpy = new GuiSpy();
        createWhiteBoard("", guiSpy, new FakeWhiteboardRepo());

        assertThat(guiSpy.getValidationErrors(), Matchers.contains("name cannot be empty"));
    }

    @Test
    @DisplayName("can create a whiteboard without raising errors")
    public void nonEmptyNameSuccess() {
        GuiSpy guiSpy = new GuiSpy();
        createWhiteBoard("abc", guiSpy, new FakeWhiteboardRepo());
        assertThat(guiSpy.getValidationErrors(), hasSize(0));
    }

    @Test
    @DisplayName("whiteboard name must be unique")
    public void uniqueNamesError() {
        GuiSpy guiSpy = new GuiSpy();
        WhiteboardRepo fakeRepo = new FakeWhiteboardRepo();
        createWhiteBoard("abc", guiSpy, fakeRepo);
        createWhiteBoard("abc", guiSpy, fakeRepo);
        assertThat(guiSpy.getValidationErrors(), Matchers.contains("name already in use"));
    }

    private void createWhiteBoard(String name, Gui gui, WhiteboardRepo fakeRepo) {
        if(name.isEmpty())
            gui.validationErrorFound("name cannot be empty");
    }

    private class FakeWhiteboardRepo implements WhiteboardRepo {
    }
}
