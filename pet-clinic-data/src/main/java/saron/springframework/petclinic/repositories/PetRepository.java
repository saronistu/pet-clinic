package saron.springframework.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import saron.springframework.petclinic.model.Pet;

@Repository
public interface PetRepository extends CrudRepository<Pet, Long> {


}
