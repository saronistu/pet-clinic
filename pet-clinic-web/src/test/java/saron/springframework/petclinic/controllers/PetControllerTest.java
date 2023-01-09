package saron.springframework.petclinic.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import saron.springframework.petclinic.model.Owner;
import saron.springframework.petclinic.model.Pet;
import saron.springframework.petclinic.model.PetType;
import saron.springframework.petclinic.services.OwnerService;
import saron.springframework.petclinic.services.PetService;
import saron.springframework.petclinic.services.PetTypeService;

import java.util.Set;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class PetControllerTest {

    @InjectMocks
    private PetController petController;
    @Mock
    private PetService petService;
    @Mock
    private OwnerService ownerService;
    @Mock
    private PetTypeService petTypeService;

    private MockMvc mockMvc;


    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders
                .standaloneSetup(petController)
                .build();
    }

    @Test
    void initCreationForm() throws Exception {
        when(ownerService.findById(anyLong())).thenReturn(getOwner());
        when(petTypeService.findAll()).thenReturn(getPetTypes());
        mockMvc.perform(get("/owners/1/pets/new"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("owner"))
                .andExpect(model().attributeExists("pet"))
                .andExpect(view().name("pets/createOrUpdatePetForm"));
    }

    @Test
    void processCreationForm() throws Exception {
        when(ownerService.findById(anyLong())).thenReturn(getOwner());
        when(petTypeService.findAll()).thenReturn(getPetTypes());
        mockMvc.perform(post("/owners/1/pets/new"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/owners/1"));
        verify(petService).save(any());
    }

    @Test
    void initUpdateForm() throws Exception {
        when(ownerService.findById(anyLong())).thenReturn(getOwner());
        when(petTypeService.findAll()).thenReturn(getPetTypes());
        when(petService.findById(anyLong())).thenReturn(getPet());
        mockMvc.perform(get("/owners/1/pets/2/edit"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("owner"))
                .andExpect(model().attributeExists("pet"))
                .andExpect(view().name("pets/createOrUpdatePetForm"));
    }

    @Test
    void processUpdateForm() throws Exception {
        when(ownerService.findById(anyLong())).thenReturn(getOwner());
        when(petTypeService.findAll()).thenReturn(getPetTypes());
        mockMvc.perform(post("/owners/1/pets/2/edit"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/owners/1"));
        verify(petService).save(any());
    }

    private Pet getPet() {
        Pet pet = new Pet();
        pet.setId(2L);
        return pet;
    }


    private PetType getPetType(Long id, String name) {
        PetType petType = new PetType();
        petType.setId(id);
        petType.setName(name);
        return petType;
    }

    private Owner getOwner() {
        Owner owner = new Owner();
        owner.setId(1L);
        owner.setLastName("Saron");
        return owner;
    }

    private Set<PetType> getPetTypes() {
        return Set.of(getPetType(1L, "Ham"), getPetType(2L, "Kitty"));
    }

}