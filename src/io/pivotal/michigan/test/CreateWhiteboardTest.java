package io.pivotal.michigan.test;

import io.pivotal.michigan.production.CreateWhiteBoardCommand;
import io.pivotal.michigan.production.boundary.WhiteboardRepo;
import io.pivotal.michigan.test.doubles.FakeWhiteboardRepo;
import io.pivotal.michigan.test.doubles.GuiSpy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.junit.MatcherAssert.assertThat;

public class CreateWhiteboardTest {
    private WhiteboardRepo repo;
    private GuiSpy gui;

    @BeforeEach
    public void setUp() {
        gui = new GuiSpy();
        repo = new FakeWhiteboardRepo();
    }

    @Test
    @DisplayName("whiteboard requires name")
    public void requiresName() {
        new CreateWhiteBoardCommand().createWhiteboard("", gui, repo);
        assertThat(gui.getErrors().contains("name required"), is(equalTo(true)));
    }

    @Test
    @DisplayName("whiteboard name must be unique")
    public void testNameIsUnique() {
        new CreateWhiteBoardCommand().createWhiteboard("abc", gui, repo);
        assertThat(gui.getErrors().contains("name is not unique"), is(equalTo(false)));
        new CreateWhiteBoardCommand().createWhiteboard("abc", gui, repo);
        assertThat(gui.getErrors().contains("name is not unique"), is(equalTo(true)));
    }
}
