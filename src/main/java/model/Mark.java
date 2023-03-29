package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Mark {
    @Id
    private String id;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "subject_id")
    private Lesson lesson;
    private int value;
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mark mark = (Mark) o;
        return value == mark.value && Objects.equals(id, mark.id)
                && Objects.equals(lesson, mark.lesson);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lesson, value);
    }

    @Override
    public String toString() {
        return String.format("Mark (ID: %s, Value: %s, Lesson: %s)%n",
                id, value, lesson);
    }
}