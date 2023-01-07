package saron.springframework.petclinic.services.sprintdatajpa;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import saron.springframework.petclinic.model.Pet;
import saron.springframework.petclinic.repositories.PetRepository;
import saron.springframework.petclinic.services.PetService;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Profile("springdatajpa")
@RequiredArgsConstructor
public class PetSpringDataJpaService implements PetService {

    private final PetRepository petRepository;

    @Override
    public Set<Pet> findAll() {
        return StreamSupport.stream(petRepository.findAll().spliterator(), false)
                .collect(Collectors.toSet());
    }

    @Override
    public Pet findById(Long id) {
        return petRepository.findById(id)
                .orElse(null);
    }

    @Override
    public Pet save(Pet object) {
        return petRepository.save(object);
    }

    @Override
    public void delete(Pet object) {
        petRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        petRepository.deleteById(id);
    }

}
