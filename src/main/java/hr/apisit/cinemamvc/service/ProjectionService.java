package hr.apisit.cinemamvc.service;

import hr.apisit.cinemamvc.domain.Film;
import hr.apisit.cinemamvc.domain.Projection;

import java.util.List;
import java.util.Optional;

public interface ProjectionService {
    List<Projection> findAll();

    Projection saveNewProjection(Projection projection);

    List<Projection> findAllByFilm(Film film);

    Optional<Projection> findById(Integer id);
}
