package hrv.springboot.service.impl;

import hrv.springboot.dao.PersonDAO;
import hrv.springboot.model.Person;
import hrv.springboot.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonDAO personDAO;
    @Override
    public void save(Person person) {
        personDAO.save(person);
    }

    @Override
    public List<Person> findAll() {
        return personDAO.findAll();
    }

    @Override
    public Optional<Person> findById(int id) {
        return personDAO.findById(id);
    }

    @Override
    public void deleteById(int id) {
        personDAO.deleteById(id);
    }

    @Override
    public void flush() {
        personDAO.flush();
    }
}
