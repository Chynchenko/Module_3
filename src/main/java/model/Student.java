package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    private String id;
    private String firstName;
    private String surname;
    private int age;
    private LocalDate receiptDate;
    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    @OneToMany(mappedBy = "student", cascade = CascadeType.PERSIST,
            fetch = FetchType.EAGER)
    private List<Mark> marks;

    public Student(String id, String firstName, String surname,
                   int age, LocalDate receiptDate) {
        this.id = id;
        this.firstName = firstName;
        this.surname = surname;
        this.age = age;
        this.receiptDate = receiptDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && id.equals(student.id)
                && firstName.equals(student.firstName)
                && surname.equals(student.surname)
                && receiptDate.equals(student.receiptDate)
                && marks.equals(student.marks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName,
                surname, age, receiptDate, marks);
    }

    @Override
    public String toString() {
        return String.format("Student (ID: %s, First name: %s, " +
                        "Surname: %s, Age: %s, Date of receipt: %s)%n",
                id, firstName, surname, age, receiptDate);
    }

    public static class StudentBuilder {
        private String id;
        private String firstName;
        private String surname;
        private int age;
        private LocalDate receiptDate;

        public StudentBuilder withId() {
            this.id = UUID.randomUUID().toString();
            return this;
        }

        public StudentBuilder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public StudentBuilder withSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public StudentBuilder withAge(int age) {
            this.age = age;
            return this;
        }

        public StudentBuilder withReceiptDate(LocalDate receiptDate) {
            this.receiptDate = receiptDate;
            return this;
        }

        public Student build() {
            return new Student(id, firstName,
                    surname, age, receiptDate);
        }
    }
}