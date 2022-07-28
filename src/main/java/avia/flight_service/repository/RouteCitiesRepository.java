package avia.flight_service.repository;

import avia.flight_service.entity.RouteCities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteCitiesRepository extends JpaRepository<RouteCities, Long> {
}
