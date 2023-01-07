package saron.springframework.petclinic.services.map;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import saron.springframework.petclinic.model.Owner;
import saron.springframework.petclinic.model.Pet;
import saron.springframework.petclinic.services.OwnerService;
import saron.springframework.petclinic.services.PetService;
import saron.springframework.petclinic.services.PetTypeService;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
@Profile({"default", "map"})
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetTypeService petTypeService;
    private final PetService petService;

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public Owner save(Owner object) {
        if (object == null)
            return null;
        if (!object.getPets().isEmpty())
            object.getPets().forEach(pet -> {
                if (pet.getPetType() == null)
                    throw new RuntimeException("Pet Type is required");
                if (pet.getPetType().getId() == null)
                    pet.setPetType(petTypeService.save(pet.getPetType()));

                if (pet.getId() == null) {
                    Pet savedPet = petService.save(pet);
                    pet.setId(savedPet.getId());
                }
            });
        return super.save(object);
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return findAll().stream()
                .filter(owner -> lastName.equalsIgnoreCase(owner.getLastName()))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Owner> findAllByNameLike(String lastName) {
        return findAll().stream()
                .filter(owner -> owner.getLastName().contains(lastName))
                .collect(Collectors.toList());
    }
}
