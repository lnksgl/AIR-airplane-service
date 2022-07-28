package avia.flight_service.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.Instant;

import static javax.persistence.GenerationType.AUTO;
import static lombok.AccessLevel.PRIVATE;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "route")
@FieldDefaults(level = PRIVATE)
public class Route {

    @Id
    @GeneratedValue(strategy = AUTO)
    Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "airplane_id")
    Airplane airplane;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "route_cities_id")
    RouteCities routeCities;

    Instant date;
}
