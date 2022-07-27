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

import static javax.persistence.GenerationType.AUTO;
import static lombok.AccessLevel.PRIVATE;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "airplane")
@FieldDefaults(level = PRIVATE)
public class Airplane {

    @Id
    @GeneratedValue(strategy = AUTO)
    Long id;

    Short capacity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "model_id")
    Model model;
}
