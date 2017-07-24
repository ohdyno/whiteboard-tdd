package io.pivotal.michigan.test.doubles;

import io.pivotal.michigan.production.Whiteboard;
import io.pivotal.michigan.production.boundary.WhiteboardRepo;

import java.util.ArrayList;
import java.util.List;

public class FakeWhiteboardRepo implements WhiteboardRepo {
    private List<Whiteboard> whiteboards = new ArrayList<>();

    @Override
    public boolean hasWhiteBoardWithName(String name) {

        for (Whiteboard whiteboard : whiteboards) {
            if (whiteboard.getName().equals(name))
                return true;
        }
        return false;
    }

    @Override
    public void save(Whiteboard board) {
        whiteboards.add(board);
    }

    @Override
    public int size() {
        return whiteboards.size();
    }
}
