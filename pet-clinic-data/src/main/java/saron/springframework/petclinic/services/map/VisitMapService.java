package saron.springframework.petclinic.services.map;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Component;
import saron.springframework.petclinic.model.Visit;
import saron.springframework.petclinic.services.VisitService;

import java.util.Set;

@Component
@RequiredArgsConstructor
public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService {

    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Visit object) {
        super.delete(object);
    }

    @Override
    public Visit save(Visit object) {
        if (ObjectUtils.anyNull(object.getPet(), object.getPet().getOwner(), object.getPet().getId(), object.getPet().getOwner().getId()))
            throw new RuntimeException("Invalid Visit");
        return super.save(object);
    }

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }
}
