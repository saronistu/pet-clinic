package saron.springframework.petclinic.services.sprintdatajpa;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import saron.springframework.petclinic.model.Owner;
import saron.springframework.petclinic.repositories.OwnerRepository;
import saron.springframework.petclinic.services.OwnerService;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Profile("springdatajpa")
@RequiredArgsConstructor
public class OwnerSpringDataJpaService implements OwnerService {

    private final OwnerRepository ownerRepository;

    @Override
    public Set<Owner> findAll() {
        return StreamSupport.stream(ownerRepository.findAll().spliterator(), false)
                .collect(Collectors.toSet());
    }

    @Override
    public Owner findById(Long id) {
        return ownerRepository.findById(id)
                .orElse(null);
    }

    @Override
    public Owner save(Owner object) {
        return ownerRepository.save(object);
    }

    @Override
    public void delete(Owner object) {
        ownerRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        ownerRepository.deleteById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return ownerRepository.findByLastName(lastName);
    }

    @Override
    public List<Owner> findAllByNameLike(String searchInput) {
        return ownerRepository.findAllByLastNameContainingOrFirstNameContaining(searchInput, searchInput);
    }
}
