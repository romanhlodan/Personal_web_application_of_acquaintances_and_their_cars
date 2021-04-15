package hrv.springboot.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@ToString(exclude = "car")
@NoArgsConstructor
@Data
@Entity
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private int staff;
    private String location;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Car> car;

    public Service(String title, int staff, String location) {
        this.title = title;
        this.staff = staff;
        this.location = location;
    }
}
