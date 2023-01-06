package saron.springframework.petclinic.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "specialities")
public class Speciality extends BaseEntity {

    private String description;

}
