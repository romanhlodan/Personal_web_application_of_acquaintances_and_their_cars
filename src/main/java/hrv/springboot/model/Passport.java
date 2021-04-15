package hrv.springboot.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@ToString(exclude = "person")
@NoArgsConstructor
@Entity
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String SerialNumber;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Person person;

    public Passport(String SerialNumber) {

        this.SerialNumber = SerialNumber;
    }
}
