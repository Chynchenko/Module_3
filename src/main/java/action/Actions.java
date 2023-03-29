package action;

import lombok.Getter;

@Getter
public enum Actions {
    FIND_GROUP("Find group by name", new FindGroupAction()),
    COUNT_STUDENTS("Count students in every group", new CountStudentsAction()),
    AVERAGE_MARK("Find an average mark of every group", new GroupAverageMarkAction()),
    FIND_LECTOR("Find the lector by name or surname", new FindLectorAction()),
    FIND_LESSON("Find the lesson with the lowest and highest average mark",
            new FindLessonAction()),
    FIND_STUDENT("Find students whose average score is higher than the specified value",
            new FindStudentAction()),
    CREATE_RANDOM_STUDENT("Create random student", new CreateStudentAction()),
    EXIT("Finish program", new ExitAction());

    private final String name;
    private final Action action;

    Actions(final String name, final Action action) {
        this.name = name;
        this.action = action;
    }

    public void execute() {
        action.execute();
    }
}