package saron.springframework.petclinic.services.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import saron.springframework.petclinic.model.Owner;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceTest {

    private static final Long OWNER_ID = 1L;
    private static final String LAST_NAME = "Saron";
    private OwnerMapService ownerMapService;

    @BeforeEach
    void setUp() {
        PetTypeMapService petTypeService = new PetTypeMapService();
        PetMapService petService = new PetMapService();
        ownerMapService = new OwnerMapService(petTypeService, petService);
        ownerMapService.save(getOwner(OWNER_ID));
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = ownerMapService.findAll();
        assertEquals(1, ownerSet.size());
    }

    @Test
    void deleteById() {
        ownerMapService.deleteById(OWNER_ID);
        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void delete() {
        Owner owner = ownerMapService.findById(OWNER_ID);
        ownerMapService.delete(owner);
        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void save() {
        Owner owner2 = getOwner(2L);
        Owner savedOwner = ownerMapService.save(owner2);
        assertEquals(owner2.getId(), savedOwner.getId());
    }

    @Test
    void saveNoId() {
        Owner owner2 = getOwner(null);
        Owner savedOwner = ownerMapService.save(owner2);
        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
    }

    @Test
    void findById() {
        Owner owner = ownerMapService.findById(OWNER_ID);
        assertEquals(OWNER_ID, owner.getId());
    }

    @Test
    void findByLastName() {
        Owner owner = ownerMapService.findByLastName(LAST_NAME);
        assertEquals(OWNER_ID, owner.getId());
        assertEquals(LAST_NAME, owner.getLastName());
    }

    @Test
    void findByLastName_null() {
        Owner owner = ownerMapService.findByLastName("bla");
        assertNull(owner);
    }

    private Owner getOwner(Long id) {
        Owner owner = new Owner();
        owner.setId(id);
        owner.setLastName(LAST_NAME);
        return owner;
    }

}