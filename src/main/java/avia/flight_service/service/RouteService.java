package avia.flight_service.service;

import avia.flight_service.entity.Route;
import avia.flight_service.exception.NotFoundException;
import avia.flight_service.repository.RouteRepository;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class RouteService implements ServiceContract<Route> {

    RouteRepository routeRepository;

    @Override
    public void save(Route o) {
        routeRepository.save(o);
    }

    @Override
    public Route getById(Long id) {
        return routeRepository.findById(id).orElseThrow(() ->
                new NotFoundException("Route not found. RouteId: " + id));
    }

    @Override
    public List<Route> getAll() {
        return routeRepository.findAll();
    }

    @Override
    public void update(Route o) {
        save(o);
    }

    @Override
    public void delete(Route o) {
        routeRepository.delete(o);
    }
}
