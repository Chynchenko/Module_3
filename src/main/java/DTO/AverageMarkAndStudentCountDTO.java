package DTO;

import lombok.*;
import repository.GroupRepository;
import repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AverageMarkAndStudentCountDTO {
    private String name;
    private long value;
    private double doubleValue;

    public List<AverageMarkAndStudentCountDTO> averageMarkAndStudentCountEveryGroup() {
        List<AverageMarkAndStudentCountDTO> result = new ArrayList<>();

        // Get the average mark for every group
        List<AverageMarkAndStudentCountDTO> averageMarks = GroupRepository.averageMarkEveryGroup();

        // Get the student count for every group
        List<AverageMarkAndStudentCountDTO> studentCounts = StudentRepository.countStudentsEveryGroup();

        // Combine the data into a list of CombinedDTO objects
        for (AverageMarkAndStudentCountDTO avgMark : averageMarks) {
            String name = avgMark.getName();
            double avgMarkValue = avgMark.getDoubleValue();
            long studentCount = 0;

            // Find the student count for this group
            for (AverageMarkAndStudentCountDTO studentCountDTO : studentCounts) {
                if (studentCountDTO.getName().equals(name)) {
                    studentCount = (long) studentCountDTO.getValue();
                    break;
                }
            }

            // Create a new CombinedDTO object and add it to the result list
            AverageMarkAndStudentCountDTO averageMarkAndStudentCountDTO = new AverageMarkAndStudentCountDTO(name, studentCount, avgMarkValue);
            result.add(averageMarkAndStudentCountDTO);
        }

        return result;
    }

    public void setValue(double doubleValue) {
        this.doubleValue = doubleValue;
    }

    public double getValue() {
        return doubleValue;
    }
}
