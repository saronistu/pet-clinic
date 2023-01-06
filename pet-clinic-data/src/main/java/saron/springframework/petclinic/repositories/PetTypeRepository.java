package saron.springframework.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import saron.springframework.petclinic.model.PetType;

@Repository
public interface PetTypeRepository extends CrudRepository<PetType, Long> {


}
