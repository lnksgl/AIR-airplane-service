package avia.flight_service.service;

import avia.flight_service.entity.RouteCities;
import avia.flight_service.exception.NotFoundException;
import avia.flight_service.repository.RouteCitiesRepository;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class RouteCitiesService implements ServiceContract<RouteCities> {

    RouteCitiesRepository routeCitiesRepository;


    @Override
    public void save(RouteCities o) {
        routeCitiesRepository.save(o);
    }

    @Override
    public RouteCities getById(Long id) {
        return routeCitiesRepository.findById(id).orElseThrow(() ->
                new NotFoundException("Route cities not found. RouteCitiesId: " + id));
    }

    @Override
    public List<RouteCities> getAll() {
        return routeCitiesRepository.findAll();
    }

    @Override
    public void update(RouteCities o) {
        save(o);
    }

    @Override
    public void delete(RouteCities o) {
        routeCitiesRepository.delete(o);
    }
}
