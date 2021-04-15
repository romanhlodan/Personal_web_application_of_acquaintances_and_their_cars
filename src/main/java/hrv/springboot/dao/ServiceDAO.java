package hrv.springboot.dao;

import hrv.springboot.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceDAO extends JpaRepository<Service, Integer> {
}
