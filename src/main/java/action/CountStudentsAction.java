package action;
import DTO.AverageMarkAndStudentCountDTO;

import java.time.LocalDateTime;
import java.util.List;

public class CountStudentsAction implements Action {

    @Override
    public void execute() {
        logger.info("CountStudentsAction was called. Time: " + LocalDateTime.now());
        List<AverageMarkAndStudentCountDTO> countStudentsEveryGroup = service.countStudentsEveryGroup();
        if (countStudentsEveryGroup.size() != 0) {
            countStudentsEveryGroup.forEach(group -> System.out.println("Group name: "
                    + group.getName() + ", count of students: " + group.getValue()));
        } else {
            System.out.println("There are no groups with students");
        }
    }
}