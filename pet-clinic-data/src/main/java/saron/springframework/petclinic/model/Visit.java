package saron.springframework.petclinic.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "visits")
public class Visit extends BaseEntity {

    private LocalDate date;
    private String description;
    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

}
