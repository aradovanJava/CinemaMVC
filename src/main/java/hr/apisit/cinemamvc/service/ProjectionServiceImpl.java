package hr.apisit.cinemamvc.service;

import hr.apisit.cinemamvc.domain.Film;
import hr.apisit.cinemamvc.domain.Projection;
import hr.apisit.cinemamvc.repository.JpaProjectionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProjectionServiceImpl implements ProjectionService {

    private JpaProjectionRepository jpaProjectionRepository;
    @Override
    public List<Projection> findAll() {
        return jpaProjectionRepository.findAll();
    }

    @Override
    public Projection saveNewProjection(Projection projection) {
        return jpaProjectionRepository.save(projection);
    }

    @Override
    public List<Projection> findAllByFilm(Film film) {
        return jpaProjectionRepository.findAllByFilm(film);
    }

    @Override
    public Optional<Projection> findById(Integer id) {
        return jpaProjectionRepository.findById(id);
    }
}
