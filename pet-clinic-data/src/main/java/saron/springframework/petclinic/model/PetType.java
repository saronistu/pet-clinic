package saron.springframework.petclinic.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "types")
public class PetType extends BaseEntity {

    private String name;

    public String toString() {
        return name;
    }
}
