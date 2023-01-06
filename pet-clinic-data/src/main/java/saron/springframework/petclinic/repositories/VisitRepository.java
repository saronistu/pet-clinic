package saron.springframework.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import saron.springframework.petclinic.model.Visit;

@Repository
public interface VisitRepository extends CrudRepository<Visit, Long> {


}
