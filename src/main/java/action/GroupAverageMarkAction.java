package action;

import DTO.AverageMarkAndStudentCountDTO;

import java.time.LocalDateTime;
import java.util.List;

public class GroupAverageMarkAction implements Action {
    @Override
    public void execute() {
        logger.info("GroupAverageMarkAction was called. Time: " + LocalDateTime.now());
        List<AverageMarkAndStudentCountDTO> averageMarkEveryGroup = service.averageMarkEveryGroup();
        if (averageMarkEveryGroup.size() != 0) {
            averageMarkEveryGroup.forEach(group -> System.out.println("Group name: "
                    + group.getName() + ", average mark: " + group.getValue()));
        } else {
            System.out.println("There is no groups with students which have marks");
        }
    }
}