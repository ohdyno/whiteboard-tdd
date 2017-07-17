package io.pivotal.michigan.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import io.pivotal.michigan.production.Whiteboard;
import io.pivotal.michigan.test.doubles.FakeWhiteboardRepo;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.junit.MatcherAssert.assertThat;

public class WhiteboardRepoContract {
    private FakeWhiteboardRepo fakeWhiteboardRepo;

    @BeforeEach
    public void setUpRepo() {
        fakeWhiteboardRepo = new FakeWhiteboardRepo();
    }

    @AfterEach
    public void tearDownRepo() {
        fakeWhiteboardRepo = null;
    }

    @Test
    @DisplayName("repo should return true if whiteboard with name has been saved previously")
    public void testFindByName() {
        Whiteboard whiteboard = new Whiteboard("New York");
        fakeWhiteboardRepo.save(whiteboard);
        assertThat(fakeWhiteboardRepo.hasWhiteboardWithName("New York"), is(equalTo(true)));
    }

    @Test
    @DisplayName("repo should return false if whiteboard with name has not been saved previously")
    public void testFindByNameShouldReturnFalse() {
        assertThat(fakeWhiteboardRepo.hasWhiteboardWithName("New York"), is(equalTo(false)));
    }
}