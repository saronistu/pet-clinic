package saron.springframework.petclinic.services.map;

import org.springframework.stereotype.Component;
import saron.springframework.petclinic.model.Pet;
import saron.springframework.petclinic.services.PetService;

import java.util.Set;

@Component
public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetService {

    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Pet object) {
        super.delete(object);
    }

    @Override
    public Pet save(Pet object) {
        return super.save(object.getId(), object);
    }

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }
}
