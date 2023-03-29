package action;

import model.Lector;
import utils.UserInput;

import java.time.LocalDateTime;
import java.util.List;

public class FindLectorAction implements Action {

    @Override
    public void execute() {
        logger.info("FindTeacherAction was called. Time: " + LocalDateTime.now());
        final String name = UserInput.inputName();
        List<Lector> lectorByName = service.findLectorByName(name);
        if (lectorByName.size() != 0) {
            lectorByName.forEach(lector ->
                    System.out.println("Found lector: " + lector));
        } else {
            System.out.println("There is no lector with this name or surname");
        }
    }
}