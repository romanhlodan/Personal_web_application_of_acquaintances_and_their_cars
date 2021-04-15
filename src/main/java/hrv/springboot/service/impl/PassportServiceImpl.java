package hrv.springboot.service.impl;

import hrv.springboot.dao.PassportDAO;
import hrv.springboot.model.Passport;
import hrv.springboot.service.PassportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class PassportServiceImpl implements PassportService {

    @Autowired
    PassportDAO passportDAO;
    @Override
    public void save(Passport passport) {
        passportDAO.save(passport);
    }

    @Override
    public List<Passport> findAll() {
        return passportDAO.findAll();
    }

    @Override
    public Optional<Passport> findById(int id) {
        return passportDAO.findById(id);
    }

    @Override
    public void deleteById(int id) {
        passportDAO.deleteById(id);
    }
}
