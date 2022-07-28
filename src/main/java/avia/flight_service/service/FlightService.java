package avia.flight_service.service;

import avia.flight_service.entity.Flight;
import avia.flight_service.exception.NotFoundException;
import avia.flight_service.repository.FlightRepository;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class FlightService implements ServiceContract<Flight> {

    FlightRepository flightRepository;

    @Override
    public void save(Flight o) {
        flightRepository.save(o);
    }

    @Override
    public Flight getById(Long id) {
        return flightRepository.findById(id).orElseThrow(() ->
                new NotFoundException("Flight not found. FlightId: " + id));
    }

    @Override
    public List<Flight> getAll() {
        return flightRepository.findAll();
    }

    @Override
    public void update(Flight o) {
        save(o);
    }

    @Override
    public void delete(Flight o) {
        flightRepository.delete(o);
    }
}
