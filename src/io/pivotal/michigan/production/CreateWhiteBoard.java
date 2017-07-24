package io.pivotal.michigan.production;

import io.pivotal.michigan.production.boundary.Gui;
import io.pivotal.michigan.production.boundary.WhiteboardRepo;

public class CreateWhiteBoard {
    public void invoke(String name, Gui gui, WhiteboardRepo repo) {
        if (name.isEmpty()) {
            gui.validationErrorFound("name cannot be empty");
            return;
        }

        if (repo.hasWhiteBoardWithName(name)) {
            gui.validationErrorFound("name already in use");
            return;
        }

        Whiteboard whiteboard = new Whiteboard(name);
        repo.save(whiteboard);
    }

}
