package hrv.springboot.service.impl;

import hrv.springboot.dao.ServiceDAO;
import hrv.springboot.model.Service;
import hrv.springboot.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@org.springframework.stereotype.Service
@Transactional
public class ServiceServiceImpl implements ServiceService {
    @Autowired
    ServiceDAO serviceDAO;
    @Override
    public void save(Service service) {
        serviceDAO.save(service);
    }

    @Override
    public List<Service> findAll() {
        return serviceDAO.findAll();
    }

    @Override
    public Optional<Service> findById(int id) {
        return serviceDAO.findById(id);
    }

    @Override
    public void deleteById(int id) {
        serviceDAO.deleteById(id);
    }

    @Override
    public void flush() {
        serviceDAO.flush();
    }
}
