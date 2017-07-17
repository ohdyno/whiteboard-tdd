package io.pivotal.michigan.production.boundary;

import io.pivotal.michigan.production.Whiteboard;

public interface WhiteboardRepo {
    boolean hasWhiteboardWithName(String name);

    void save(Whiteboard whiteboard);
}
