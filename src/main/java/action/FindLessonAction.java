package action;
import java.time.LocalDateTime;
import java.util.List;

public class FindSubjectAction implements Action {
    @Override
    public void execute() {
        logger.info("FindSubjectAction was called. Time: " + LocalDateTime.now());
        List<StringDoubleDTO> subjectsWithMarks = service.findSubjectWithAverageMark();
        if (subjectsWithMarks.size() != 0) {
            System.out.println("Subject with the lowest average mark: "
                    + subjectsWithMarks.get(0).getName() + ", mark: "
                    + subjectsWithMarks.get(0).getValue());
            System.out.println("Subject with the highest average mark: "
                    + subjectsWithMarks.get(1).getName() + ", mark: "
                    + subjectsWithMarks.get(1).getValue());
        } else {
            System.out.println("There are no subjects with marks");
        }
    }
}