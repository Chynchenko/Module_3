package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "groups")
@AllArgsConstructor
@NoArgsConstructor
public class Group {
    @Id
    private String id;
    private String name;
    @OneToMany(mappedBy = "group", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    public Set<Student> students;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return Objects.equals(id, group.id) && Objects.equals(name, group.name)
                && Objects.equals(students, group.students);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, students);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        students.forEach(student -> sb.append(student.toString()));
        return String.format("Group (ID: %s, Name: %s)%n, %s",
                id, name, sb);
    }
}