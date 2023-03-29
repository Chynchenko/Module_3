package action;
import DTO.AverageMarkAndStudentCountDTO;

import java.time.LocalDateTime;
import java.util.List;

public class FindLessonAction implements Action {
    @Override
    public void execute() {
        logger.info("FindLessonAction was called. Time: " + LocalDateTime.now());
        List<AverageMarkAndStudentCountDTO> lessonsWithMarks = service.findLessonWithAverageMark();
        if (lessonsWithMarks.size() != 0) {
            System.out.println("Lesson with the lowest average mark: "
                    + lessonsWithMarks.get(0).getName() + ", mark: "
                    + lessonsWithMarks.get(0).getValue());
            System.out.println("Lesson with the highest average mark: "
                    + lessonsWithMarks.get(1).getName() + ", mark: "
                    + lessonsWithMarks.get(1).getValue());
        } else {
            System.out.println("There are no lessons with marks");
        }
    }
}