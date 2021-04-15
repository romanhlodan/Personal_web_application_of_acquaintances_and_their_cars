package hrv.springboot.dao;

import hrv.springboot.model.Passport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassportDAO extends JpaRepository<Passport,Integer> {
}
