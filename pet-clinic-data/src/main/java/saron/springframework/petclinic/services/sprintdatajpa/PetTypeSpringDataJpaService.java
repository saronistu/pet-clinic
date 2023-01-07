package saron.springframework.petclinic.services.sprintdatajpa;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import saron.springframework.petclinic.model.PetType;
import saron.springframework.petclinic.repositories.PetTypeRepository;
import saron.springframework.petclinic.services.PetTypeService;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Profile("springdatajpa")
@RequiredArgsConstructor
public class PetTypeSpringDataJpaService implements PetTypeService {

    private final PetTypeRepository petTypeRepository;

    @Override
    public Set<PetType> findAll() {
        return StreamSupport.stream(petTypeRepository.findAll().spliterator(), false)
                .collect(Collectors.toSet());
    }

    @Override
    public PetType findById(Long id) {
        return petTypeRepository.findById(id)
                .orElse(null);
    }

    @Override
    public PetType save(PetType object) {
        return petTypeRepository.save(object);
    }

    @Override
    public void delete(PetType object) {
        petTypeRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        petTypeRepository.deleteById(id);
    }

}
