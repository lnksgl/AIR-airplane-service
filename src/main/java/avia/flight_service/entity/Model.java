package avia.flight_service.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import static javax.persistence.GenerationType.AUTO;
import static lombok.AccessLevel.PRIVATE;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "model")
@FieldDefaults(level = PRIVATE)
public class Model {

    @Id
    @GeneratedValue(strategy = AUTO)
    Long id;

    String name;
}
