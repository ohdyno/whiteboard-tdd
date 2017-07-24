package io.pivotal.michigan.test;

import io.pivotal.michigan.production.Whiteboard;
import io.pivotal.michigan.production.boundary.WhiteboardRepo;
import io.pivotal.michigan.test.doubles.FakeWhiteboardRepo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.junit.MatcherAssert.assertThat;

public class WhiteboardRepoContract {

    @Test
    @DisplayName("repo keeps track of saved whiteboards")
    public void repoSave() {
        WhiteboardRepo repo = new FakeWhiteboardRepo();
        Whiteboard board = new Whiteboard("abc");

        repo.save(board);
        assertThat(repo.hasWhiteBoardWithName("abc"), is(true));
    }

    @Test
    @DisplayName("repo does not find non-existent whiteboard")
    public void repoLookup() {
        WhiteboardRepo repo = new FakeWhiteboardRepo();
        assertThat(repo.hasWhiteBoardWithName("abc"), is(false));
    }

    @Test
    @DisplayName("repo should return the number of whiteboards saved")
    public void size() {
        WhiteboardRepo repo = new FakeWhiteboardRepo();
        Whiteboard ny = new Whiteboard("New York");
        Whiteboard sf = new Whiteboard("San Francisco");

        repo.save(ny);
        repo.save(sf);

        assertThat(repo.size(), is(2));
    }

    @Test
    @DisplayName("repo should allow two whiteboards with the same name")
    public void uniqueRepos() {
        WhiteboardRepo repo = new FakeWhiteboardRepo();
        repo.save(new Whiteboard("new york"));
        repo.save(new Whiteboard("new york"));

        assertThat(repo.size(), is(2));
    }

}
