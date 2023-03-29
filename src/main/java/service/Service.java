package service;
import DTO.AverageMarkAndStudentCountDTO;
import DTO.StudentMarkDTO;
import model.Group;
import model.Lector;
import model.Student;
import org.flywaydb.core.Flyway;
import repository.GroupRepository;
import repository.LectorRepository;
import repository.LessonRepository;
import repository.StudentRepository;
import utils.UserInput;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

public class Service {
    private static Service instance;
    private final GroupRepository groupRepository;
    private final StudentRepository studentRepository;
    private final LectorRepository lectorRepository;
    private final LessonRepository lessonRepository;

    private static final Random RANDOM = new Random();

    private Service() {
        doMigration();
        groupRepository = GroupRepository.getInstance();
        studentRepository = StudentRepository.getInstance();
        lectorRepository = LectorRepository.getInstance();
        lessonRepository = LessonRepository.getInstance();
    }

    public static Service getInstance() {
        if (instance == null) {
            instance = new Service();
        }
        return instance;
    }

    public Student createStudent() {
        Student.StudentBuilder studentBuilder =
                new Student.StudentBuilder();
        Student student = studentBuilder
                .withId()
                .withFirstName(UserInput.getRandomString())
                .withSurname(UserInput.getRandomString())
                .withAge(RANDOM.nextInt(18, 25))
                .withReceiptDate(LocalDate.now())
                .build();
        studentRepository.save(student);
        return student;
    }

    public List<Group> findGroupByName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Invalid name");
        } else {
            return groupRepository.findGroupByName(name);
        }
    }

    public List<AverageMarkAndStudentCountDTO> countStudentsEveryGroup() {
        return studentRepository.countStudentsEveryGroup();
    }

    public List<AverageMarkAndStudentCountDTO> averageMarkEveryGroup() {
        return groupRepository.averageMarkEveryGroup();
    }

    public List<Lector> findLectorByName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Invalid name");
        } else {
            return lectorRepository.findLectorByName(name);
        }
    }

    public List<AverageMarkAndStudentCountDTO> findLessonWithAverageMark() {
        return lessonRepository.findLessonWithAverageMark();
    }

    public List<StudentMarkDTO> findStudentByAvgMark(double value) {
        if (value < 0 || value >= 100) {
            throw new IllegalArgumentException("Invalid value");
        } else {
            return studentRepository.findStudentByAvgMark(value);
        }
    }

    private static void doMigration() {
        Flyway flyway = Flyway.configure()
                .dataSource("jdbc:postgresql://localhost:5432/module3",
                        "postgres", "root")
                .baselineOnMigrate(true)
                .locations("db.migration")
                .load();
        flyway.migrate();
    }
}
