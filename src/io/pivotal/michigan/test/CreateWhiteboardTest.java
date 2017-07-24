package io.pivotal.michigan.test;

import io.pivotal.michigan.production.CreateWhiteBoard;
import io.pivotal.michigan.test.doubles.FakeWhiteboardRepo;
import io.pivotal.michigan.test.doubles.GuiSpy;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.junit.MatcherAssert.assertThat;

public class CreateWhiteboardTest {

    private GuiSpy guiSpy;
    private FakeWhiteboardRepo fakeRepo;

    @BeforeEach
    void setUp() {
        guiSpy = new GuiSpy();
        fakeRepo = new FakeWhiteboardRepo();
    }

    @Test
    @DisplayName("whiteboard name cannot be empty")
    public void emptyNameError() {
        new CreateWhiteBoard().invoke("", guiSpy, fakeRepo);

        assertThat(guiSpy.getValidationErrors(), Matchers.contains("name cannot be empty"));
        assertThat(fakeRepo.size(), is(0));
    }

    @Test
    @DisplayName("can create a whiteboard without raising errors")
    public void nonEmptyNameSuccess() {
        new CreateWhiteBoard().invoke("abc", guiSpy, fakeRepo);

        assertThat(guiSpy.getValidationErrors(), hasSize(0));
        assertThat(fakeRepo.size(), is(1));
    }

    @Test
    @DisplayName("whiteboard name must be unique")
    public void uniqueNamesError() {
        new CreateWhiteBoard().invoke("abc", guiSpy, fakeRepo);
        new CreateWhiteBoard().invoke("abc", guiSpy, fakeRepo);

        assertThat(guiSpy.getValidationErrors(), Matchers.contains("name already in use"));
        assertThat(fakeRepo.size(), is(1));
    }

}
