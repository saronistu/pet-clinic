package saron.springframework.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import saron.springframework.petclinic.model.Vet;

@Repository
public interface VetRepository extends CrudRepository<Vet, Long> {


}
