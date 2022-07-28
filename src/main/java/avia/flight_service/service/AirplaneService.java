package avia.flight_service.service;

import avia.flight_service.entity.Airplane;
import avia.flight_service.exception.NotFoundException;
import avia.flight_service.repository.AirplaneRepository;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class AirplaneService implements ServiceContract<Airplane> {

    AirplaneRepository airplaneRepository;

    @Override
    public void save(Airplane o) {
        airplaneRepository.save(o);
    }

    @Override
    public Airplane getById(Long id) {
        return airplaneRepository.findById(id).orElseThrow(() ->
                new NotFoundException("Airplane not found. AirplaneId: " + id));
    }

    @Override
    public List<Airplane> getAll() {
        return airplaneRepository.findAll();
    }

    @Override
    public void update(Airplane o) {
        save(o);
    }

    @Override
    public void delete(Airplane o) {
        airplaneRepository.delete(o);
    }
}
