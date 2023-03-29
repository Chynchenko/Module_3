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
public class Lector {
    @Id
    private String id;
    private String firstName;
    private String surname;
    private int age;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
            Lector lector  = (Lector) o;
        return age == lector.age && Objects.equals(id, lector.id)
                && Objects.equals(firstName, lector.firstName)
                && Objects.equals(surname, lector.surname)
                && Objects.equals(lesson, lector.lesson);
    }

    @Override
    public int hashCode() {
        return Objects.hash((Object) id, firstName,
                surname, age, lesson);
    }

    @Override
    public String toString() {
        return String.format("Lector (ID: %s, First name: %s, " +
                        "Surname: %s, Age: %s, Lesson: %s)%n",
                id, firstName, surname, age, lesson);
    }
}