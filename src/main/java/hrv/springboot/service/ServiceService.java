package hrv.springboot.service;

import hrv.springboot.model.Service;

import java.util.List;
import java.util.Optional;

public interface ServiceService {
    void save(Service service);

    List<Service> findAll();

    Optional<Service> findById(int id);

    void deleteById(int id);

    void flush();
}
