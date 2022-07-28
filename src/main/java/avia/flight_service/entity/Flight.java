package avia.flight_service.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.Instant;

import static javax.persistence.GenerationType.AUTO;
import static lombok.AccessLevel.PRIVATE;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "flight")
@FieldDefaults(level = PRIVATE)
public class Flight {

    @Id
    @GeneratedValue(strategy = AUTO)
    Long id;

    String name;

    String place;

    BigDecimal price;

    @Column(name = "user_id")
    Long userId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "route_id")
    Route route;
}
