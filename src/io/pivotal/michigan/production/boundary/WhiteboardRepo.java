package io.pivotal.michigan.production.boundary;

import io.pivotal.michigan.production.Whiteboard;

public interface WhiteboardRepo {
    boolean hasWhiteBoardWithName(String name);

    void save(Whiteboard board);

    int size();
}
