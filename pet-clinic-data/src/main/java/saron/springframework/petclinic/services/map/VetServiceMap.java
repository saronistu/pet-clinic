package saron.springframework.petclinic.services.map;

import org.springframework.stereotype.Component;
import saron.springframework.petclinic.model.Vet;
import saron.springframework.petclinic.services.VetService;

import java.util.Set;

@Component
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public Vet save(Vet object) {
        return super.save(object);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
