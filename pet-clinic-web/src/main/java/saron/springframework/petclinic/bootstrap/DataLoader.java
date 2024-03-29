package saron.springframework.petclinic.bootstrap;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import saron.springframework.petclinic.model.*;
import saron.springframework.petclinic.services.*;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final VisitService visitService;

    @Override
    public void run(String... args) {
        int count = petTypeService.findAll().size();
        if (count == 0)
            loadData();
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("Saron");
        owner1.setLastName("Ciupe");
        owner1.setAddress("Dacia 8");
        owner1.setCity("Hunedoara");
        owner1.setTelephone("0765561965");

        Pet saronsDog = new Pet();
        saronsDog.setPetType(savedDogPetType);
        saronsDog.setOwner(owner1);
        saronsDog.setBirthDate(LocalDate.now());
        saronsDog.setName("Rosco");
        owner1.getPets().add(saronsDog);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Patri");
        owner2.setLastName("Ciupe");
        owner2.setAddress("Stelutei 1");
        owner2.setCity("Cluj-Napoca");
        owner2.setTelephone("0765454343");

        Pet patrisCat = new Pet();
        patrisCat.setName("Meow");
        patrisCat.setOwner(owner2);
        patrisCat.setBirthDate(LocalDate.now());
        patrisCat.setPetType(savedCatPetType);
        owner2.getPets().add(patrisCat);
        ownerService.save(owner2);

        Visit catVisit = new Visit();
        catVisit.setPet(patrisCat);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Sneezy Kitty");

        visitService.save(catVisit);

        System.out.println("Loaded Owners....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialities().add(savedRadiology);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");
        vet2.getSpecialities().add(savedSurgery);
        vetService.save(vet2);

        System.out.println("Loaded Vets....");
    }

}
