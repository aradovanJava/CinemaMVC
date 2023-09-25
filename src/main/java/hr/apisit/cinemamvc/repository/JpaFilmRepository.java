package hr.apisit.cinemamvc.repository;

import hr.apisit.cinemamvc.domain.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaFilmRepository extends JpaRepository<Film, Integer> {
}
