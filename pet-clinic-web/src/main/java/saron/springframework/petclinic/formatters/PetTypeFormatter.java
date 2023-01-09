package saron.springframework.petclinic.formatters;

import lombok.RequiredArgsConstructor;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;
import saron.springframework.petclinic.model.PetType;
import saron.springframework.petclinic.services.PetTypeService;

import java.text.ParseException;
import java.util.Locale;

@Component
@RequiredArgsConstructor
public class PetTypeFormatter implements Formatter<PetType> {

    private final PetTypeService petTypeService;

    @Override
    public String print(PetType petType, Locale locale) {
        return petType.getName();
    }

    @Override
    public PetType parse(String text, Locale locale) throws ParseException {
        return petTypeService.findAll().stream()
                .filter(petType -> petType.getName().equals(text))
                .findFirst()
                .orElseThrow(() -> new ParseException("type not found: " + text, 0));

    }
}