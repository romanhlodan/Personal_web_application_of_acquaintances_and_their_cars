package hrv.springboot.service;

import hrv.springboot.model.Passport;

import java.util.List;
import java.util.Optional;

public interface PassportService {
    void save(Passport passport);

    List<Passport> findAll();

    Optional<Passport> findById(int id);

    void deleteById(int id);

    void flush();
}
