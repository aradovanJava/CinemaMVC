package hr.apisit.cinemamvc.repository;

import hr.apisit.cinemamvc.domain.Film;
import hr.apisit.cinemamvc.domain.Projection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaProjectionRepository extends JpaRepository<Projection, Integer> {
    List<Projection> findAllByFilm(Film film);
}
