package action;
import model.Student;

import java.time.LocalDateTime;

public class CreateStudentAction implements Action {
    @Override
    public void execute() {
        logger.info("CreateStudentAction was called. Time: " + LocalDateTime.now());
        Student student = service.createStudent();
        System.out.println("Created student: " + student);
    }
}