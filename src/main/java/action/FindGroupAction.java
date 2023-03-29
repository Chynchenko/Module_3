package action;
import model.Group;
import utils.UserInput;

import java.time.LocalDateTime;
import java.util.List;

public class FindGroupAction implements Action {

    @Override
    public void execute() {
        logger.info("FindGroupAction was called. Time: " + LocalDateTime.now());
        final String name = UserInput.inputName();
        List<Group> groupsByName = service.findGroupByName(name);
        if (groupsByName.size() != 0) {
            groupsByName.forEach(group ->
                    System.out.println("Found group: " + group));
        } else {
            System.out.println("There is no group with this name");
        }
    }
}