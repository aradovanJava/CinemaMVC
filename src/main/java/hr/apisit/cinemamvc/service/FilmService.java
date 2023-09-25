package hr.apisit.cinemamvc.service;

import hr.apisit.cinemamvc.domain.Film;

import java.util.List;

public interface FilmService {

    List<Film> findAll();

    Film findById(Integer id);

    void save(Film film);

    void deleteById(Integer id);

}
