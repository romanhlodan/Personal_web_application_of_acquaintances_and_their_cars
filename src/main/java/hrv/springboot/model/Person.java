package hrv.springboot.model;

import hrv.springboot.model.Car;
import hrv.springboot.model.Passport;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@ToString(exclude = {"passport", "cars"})
@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String Fname;
    private String Lname;
    private int age;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "person")
    private Passport passport;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "person")
    private List<Car> cars;

    public Person(String fname, String lname, int age) {
        Fname = fname;
        Lname = lname;
        this.age = age;
    }
}
