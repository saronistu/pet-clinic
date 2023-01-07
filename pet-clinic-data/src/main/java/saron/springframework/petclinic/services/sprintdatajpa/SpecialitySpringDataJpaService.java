package saron.springframework.petclinic.services.sprintdatajpa;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import saron.springframework.petclinic.model.Speciality;
import saron.springframework.petclinic.repositories.SpecialityRepository;
import saron.springframework.petclinic.services.SpecialityService;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Profile("springdatajpa")
@RequiredArgsConstructor
public class SpecialitySpringDataJpaService implements SpecialityService {

    private final SpecialityRepository specialityRepository;

    @Override
    public Set<Speciality> findAll() {
        return StreamSupport.stream(specialityRepository.findAll().spliterator(), false)
                .collect(Collectors.toSet());
    }

    @Override
    public Speciality findById(Long id) {
        return specialityRepository.findById(id)
                .orElse(null);
    }

    @Override
    public Speciality save(Speciality object) {
        return specialityRepository.save(object);
    }

    @Override
    public void delete(Speciality object) {
        specialityRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        specialityRepository.deleteById(id);
    }

}
