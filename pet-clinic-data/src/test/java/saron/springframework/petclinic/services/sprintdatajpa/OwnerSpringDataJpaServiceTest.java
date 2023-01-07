package saron.springframework.petclinic.services.sprintdatajpa;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import saron.springframework.petclinic.model.Owner;
import saron.springframework.petclinic.repositories.OwnerRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerSpringDataJpaServiceTest {

    private static final Long OWNER_ID = 1L;
    private static final String LAST_NAME = "Saron";

    @InjectMocks
    private OwnerSpringDataJpaService service;
    @Mock
    private OwnerRepository ownerRepository;

    @Test
    void findAll() {
        Set<Owner> returnOwnersSet = new HashSet<>(Set.of(getOwner(OWNER_ID), getOwner(2L)));
        when(ownerRepository.findAll()).thenReturn(returnOwnersSet);
        Set<Owner> owners = service.findAll();
        assertNotNull(owners);
        assertEquals(2, owners.size());
    }

    @Test
    void findById() {
        Owner owner = getOwner(OWNER_ID);
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(owner));
        Owner retrievedOwner = service.findById(1L);
        assertNotNull(retrievedOwner);
    }

    @Test
    void findByIdNotFound() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());
        Owner owner = service.findById(1L);
        assertNull(owner);
    }

    @Test
    void save() {
        Owner ownerToSave = getOwner(OWNER_ID);
        when(ownerRepository.save(any())).thenReturn(ownerToSave);
        Owner savedOwner = service.save(ownerToSave);
        assertNotNull(savedOwner);
        verify(ownerRepository).save(any());
    }

    @Test
    void delete() {
        service.delete(getOwner(OWNER_ID));
        verify(ownerRepository).delete(any());
    }

    @Test
    void deleteById() {
        service.deleteById(1L);
        verify(ownerRepository).deleteById(anyLong());
    }

    @Test
    void findByLastName() {
        Owner owner = getOwner(OWNER_ID);
        when(ownerRepository.findByLastName(LAST_NAME)).thenReturn(owner);
        Owner retrievedOwner = service.findByLastName(LAST_NAME);
        assertEquals(owner, retrievedOwner);
    }

    private Owner getOwner(Long id) {
        Owner owner = new Owner();
        owner.setId(id);
        owner.setLastName(LAST_NAME);
        return owner;
    }

}