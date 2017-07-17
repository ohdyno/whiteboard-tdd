package io.pivotal.michigan.test.doubles;

import io.pivotal.michigan.production.Whiteboard;
import io.pivotal.michigan.production.boundary.WhiteboardRepo;

import java.util.HashMap;
import java.util.Map;

public class FakeWhiteboardRepo implements WhiteboardRepo {
    private Map<String, Whiteboard> whiteboards = new HashMap<>();

    @Override
    public boolean hasWhiteboardWithName(String name) {
        return whiteboards.containsKey(name);
    }

    @Override
    public void save(Whiteboard whiteboard) {
        whiteboards.put(whiteboard.getName(), whiteboard);
    }
}
