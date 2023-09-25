package hr.apisit.cinemamvc.service;

import hr.apisit.cinemamvc.domain.SeatCategory;

import java.util.List;
import java.util.Optional;

public interface SeatCategoryService {
    List<SeatCategory> findAll();

    Optional<SeatCategory> findById(Integer id);
    void save(SeatCategory newSeatCategory);

    SeatCategory update(SeatCategory seatCategory, Integer originalSeatCategoryId);

    void delete(SeatCategory seat);
}
