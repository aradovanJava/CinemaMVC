package hr.apisit.cinemamvc.service;

import hr.apisit.cinemamvc.domain.Cinema;

import java.util.List;
import java.util.Optional;

public interface CinemaService {
    List<Cinema> findAll();

    Optional<Cinema> findById(Integer id);

    void save(Cinema newCinema);

    Optional<Cinema> update(Cinema cinemaToUpdate, Integer id);

    void deleteById(Integer id);

    List<Cinema> findByEmployee(Integer employeeId);

}
