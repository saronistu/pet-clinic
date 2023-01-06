package saron.springframework.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import saron.springframework.petclinic.model.Owner;

@Repository
public interface OwnerRepository extends CrudRepository<Owner, Long> {



}
