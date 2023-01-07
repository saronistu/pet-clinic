package saron.springframework.petclinic.services;

import saron.springframework.petclinic.model.Owner;

import java.util.List;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

    List<Owner> findAllByNameLike(String searchInput);

}
