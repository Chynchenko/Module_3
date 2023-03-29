package action;
import DTO.StudentMarkDTO;
import utils.UserInput;

import java.time.LocalDateTime;
import java.util.List;

public class FindStudentAction implements Action {
    @Override
    public void execute() {
        logger.info("FindStudentAction was called. Time: " + LocalDateTime.now());
        double number = UserInput.getDouble();
        List<StudentMarkDTO> studentByAvgMark =
                service.findStudentByAvgMark(number);
        if (studentByAvgMark.size() != 0) {
            studentByAvgMark.forEach(student ->
                    System.out.println("Students which has average mark higher than "
                            + number + " - name: " + student.getFirstName() +
                            ", surname: " + student.getSurname() +
                            ", average mark: " + student.getValue()));
        } else {
            System.out.println("There aren't students which " +
                    "has average mark higher " + number);
        }
    }
}