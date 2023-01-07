package saron.springframework.petclinic.services.sprintdatajpa;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import saron.springframework.petclinic.model.Vet;
import saron.springframework.petclinic.repositories.VetRepository;
import saron.springframework.petclinic.services.VetService;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Profile("springdatajpa")
@RequiredArgsConstructor
public class VetSpringDataJpaService implements VetService {

    private final VetRepository vetRepository;

    @Override
    public Set<Vet> findAll() {
        return StreamSupport.stream(vetRepository.findAll().spliterator(), false)
                .collect(Collectors.toSet());
    }

    @Override
    public Vet findById(Long id) {
        return vetRepository.findById(id)
                .orElse(null);
    }

    @Override
    public Vet save(Vet object) {
        return vetRepository.save(object);
    }

    @Override
    public void delete(Vet object) {
        vetRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        vetRepository.deleteById(id);
    }

}
