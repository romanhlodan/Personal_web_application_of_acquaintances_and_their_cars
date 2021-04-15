package hrv.springboot.service.impl;

import hrv.springboot.dao.CarDAO;
import hrv.springboot.model.Car;
import hrv.springboot.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class CarServiceImpl implements CarService {

    @Autowired
    CarDAO carDAO;
    @Override
    public void save(Car car) {
        carDAO.save(car);
    }

    @Override
    public List<Car> findAll() {
        return carDAO.findAll();
    }

    @Override
    public Optional<Car> findById(int id) {
        return carDAO.findById(id);
    }

    @Override
    public void deleteById(int id) {
        carDAO.deleteById(id);
    }

    @Override
    public void flush(Car car) {
        carDAO.flush();
    }


}
