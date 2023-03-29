package action;

import java.time.LocalDateTime;
import java.util.List;

public class FindTeacherAction implements Action {

    @Override
    public void execute() {
        logger.info("FindTeacherAction was called. Time: " + LocalDateTime.now());
        final String name = UserInput.inputName();
        List<Teacher> teacherByName = service.findTeacherByName(name);
        if (teacherByName.size() != 0) {
            teacherByName.forEach(teacher ->
                    System.out.println("Found teacher: " + teacher));
        } else {
            System.out.println("There is no teacher with this name or surname");
        }
    }
}