package hr.apisit.cinemamvc.service;

import hr.apisit.cinemamvc.domain.Seat;

import java.util.List;
import java.util.Optional;

public interface SeatService {
    List<Seat> getAllSeats();

    Optional<Seat> getSeatById(Integer id);

    void saveNewSeat(Seat newSeat);

    Optional<Seat> updateSeat(Seat updatedSeat, Integer id);

    void deleteSeat(Integer id);
}
