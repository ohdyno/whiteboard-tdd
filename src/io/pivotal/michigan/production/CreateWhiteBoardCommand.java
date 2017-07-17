package io.pivotal.michigan.production;

import io.pivotal.michigan.production.boundary.UI;
import io.pivotal.michigan.production.boundary.WhiteboardRepo;

public class CreateWhiteBoardCommand {
    public void createWhiteboard(String name, UI ui, WhiteboardRepo repo) {
        if (name == null || name.isEmpty()) {
            ui.validationErrorFound("name required");
        }

        Whiteboard whiteboard = new Whiteboard(name);
        if (repo.hasWhiteboardWithName(name)) {
            ui.validationErrorFound("name is not unique");
        }

        repo.save(whiteboard);
    }
}
