package saron.springframework.petclinic.services.sprintdatajpa;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import saron.springframework.petclinic.model.Visit;
import saron.springframework.petclinic.repositories.VisitRepository;
import saron.springframework.petclinic.services.VisitService;

import java.util.Set;

@Service
@Profile("springdatajpa")
@RequiredArgsConstructor
public class VisitSpringDataJpaService implements VisitService {

    private final VisitRepository visitRepository;

    @Override
    public Set<Visit> findAll() {
        return (Set<Visit>) visitRepository.findAll();
    }

    @Override
    public Visit findById(Long id) {
        return visitRepository.findById(id)
                .orElse(null);
    }

    @Override
    public Visit save(Visit object) {
        return visitRepository.save(object);
    }

    @Override
    public void delete(Visit object) {
        visitRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        visitRepository.deleteById(id);
    }

}
