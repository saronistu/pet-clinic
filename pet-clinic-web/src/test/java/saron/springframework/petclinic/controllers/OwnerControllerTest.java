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
import saron.springframework.petclinic.services.OwnerService;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {

    @InjectMocks
    private OwnerController controller;
    @Mock
    private OwnerService ownerService;
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders
                .standaloneSetup(controller)
                .build();
    }

    @Test
    void listOwners() throws Exception {
        when(ownerService.findAll()).thenReturn(new HashSet<>(Set.of(getOwner())));
        mockMvc.perform(get("/owners/index"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/index"))
                .andExpect(model().attributeExists("owners"));
    }

//    @Test
//    void processFindFormReturnMany() throws Exception {
//        when(ownerService.findByLastName(anyString()))
//                .thenReturn(Arrays.asList(getOwner(),getOwner()));
//
//        mockMvc.perform(get("/owners"))
//                .andExpect(status().isOk())
//                .andExpect(view().name("owners/ownersList"))
//                .andExpect(model().attribute("selections", hasSize(2)));
//    }
//
//    @Test
//    void processFindFormReturnOne() throws Exception {
//        when(ownerService.findByLastName(anyString())).thenReturn(Arrays.asList(getOwner()));
//
//        mockMvc.perform(get("/owners"))
//                .andExpect(status().is3xxRedirection())
//                .andExpect(view().name("redirect:/owners/1"));
//    }
//
//    @Test
//    void processFindFormEmptyReturnMany() throws Exception {
//        when(ownerService.findByLastName(anyString())).thenReturn(Arrays.asList(getOwner(),getOwner()));
//        mockMvc.perform(get("/owners")
//                        .param("lastName", ""))
//                .andExpect(status().isOk())
//                .andExpect(view().name("owners/ownersList"))
//                .andExpect(model().attribute("selections", hasSize(2)));
//    }

    @Test
    void displayOwner() throws Exception {
        when(ownerService.findById(anyLong())).thenReturn(getOwner());
        mockMvc.perform(get("/owners/123"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/ownerDetails"))
                .andExpect(model().attribute("owner", hasProperty("id", is(1L))));
    }

//    @Test
//    void initCreationForm() throws Exception {
//        mockMvc.perform(get("/owners/new"))
//                .andExpect(status().isOk())
//                .andExpect(view().name("owners/createOrUpdateOwnerForm"))
//                .andExpect(model().attributeExists("owner"));
//        verifyNoInteractions(ownerService);
//    }

//    @Test
//    void processCreationForm() throws Exception {
//        when(ownerService.save(any())).thenReturn(getOwner());
//        mockMvc.perform(post("/owners/new"))
//                .andExpect(status().is3xxRedirection())
//                .andExpect(view().name("redirect:/owners/1"))
//                .andExpect(model().attributeExists("owner"));
//        verify(ownerService).save(any());
//    }

//    @Test
//    void initUpdateOwnerForm() throws Exception {
//        when(ownerService.findById(anyLong())).thenReturn(getOwner());
//        mockMvc.perform(get("/owners/1/edit"))
//                .andExpect(status().isOk())
//                .andExpect(view().name("owners/createOrUpdateOwnerForm"))
//                .andExpect(model().attributeExists("owner"));
//        verifyNoInteractions(ownerService);
//    }

//    @Test
//    void processUpdateOwnerForm() throws Exception {
//        when(ownerService.save(any())).thenReturn(getOwner());
//        mockMvc.perform(post("/owners/1/edit"))
//                .andExpect(status().is3xxRedirection())
//                .andExpect(view().name("redirect:/owners/1"))
//                .andExpect(model().attributeExists("owner"));
//        verify(ownerService).save(any());
//    }

    private Owner getOwner() {
        Owner owner = new Owner();
        owner.setId(1L);
        owner.setLastName("Saron");
        return owner;
    }

}