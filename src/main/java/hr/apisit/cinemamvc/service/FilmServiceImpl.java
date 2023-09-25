package hr.apisit.cinemamvc.service;

import hr.apisit.cinemamvc.domain.Film;
import hr.apisit.cinemamvc.repository.JpaFilmRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FilmServiceImpl implements FilmService {

    private JpaFilmRepository jpaFilmRepository;

    @Override
    public List<Film> findAll() {
        return jpaFilmRepository.findAll();
    }

    @Override
    public Film findById(Integer id) {
        return jpaFilmRepository.findById(id).get();
    }

    @Override
    public void save(Film film) {
        jpaFilmRepository.save(film);
    }

    @Override
    public void deleteById(Integer id) {
        jpaFilmRepository.deleteById(id);
    }
}
