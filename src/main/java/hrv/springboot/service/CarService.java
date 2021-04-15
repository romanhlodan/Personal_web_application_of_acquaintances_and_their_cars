package hrv.springboot.service;

import hrv.springboot.model.Car;

import java.util.List;
import java.util.Optional;

public interface CarService {
    void save(Car car);

    List<Car> findAll();

    Optional<Car> findById(int id);

    void deleteById(int id);

    void flush(Car car);
}
