package hrv.springboot.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@ToString(exclude = {"person", "services"})
@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String brand;
    private String model;
    private int graduation_year;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Person person;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "car")
    private List<Service> services;

    public Car(String brand, String model, int graduation_year) {
        this.brand = brand;
        this.model = model;
        this.graduation_year = graduation_year;
    }
}
