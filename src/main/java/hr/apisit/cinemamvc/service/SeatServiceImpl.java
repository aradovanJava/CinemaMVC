package hr.apisit.cinemamvc.service;

import hr.apisit.cinemamvc.domain.Seat;
import hr.apisit.cinemamvc.repository.JpaSeatRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SeatServiceImpl implements SeatService {

    @Qualifier("jdbcSeatRepository")
    private JpaSeatRepository seatRepository;

    @Override
    public List<Seat> getAllSeats() {

        List<Seat> allSeats = seatRepository.findAll();

        for(Seat seat : allSeats) {
            seat.getStage().setSeatList(seatRepository.findByStageId(seat.getStage().getId()));
        }

        return allSeats;
    }

    @Override
    public Optional<Seat> getSeatById(Integer id) {
        return seatRepository.findById(id);
    }

    @Override
    public void saveNewSeat(Seat newSeat) {
        seatRepository.save(newSeat);
    }

    @Override
    public Optional<Seat> updateSeat(Seat updatedSeat, Integer id) {

        Optional<Seat> managedSeatObject = seatRepository.findById(id);

        if(managedSeatObject.isPresent()) {
            Seat seat = managedSeatObject.get();
            seat.setSeatCategory(updatedSeat.getSeatCategory());
            seat.setStage(updatedSeat.getStage());
            seat.setRowName(updatedSeat.getRowName());
            seat.setPositionInRow(updatedSeat.getPositionInRow());
            Seat updatedManagedBeanSeat = seatRepository.save(seat);
            return Optional.of(updatedManagedBeanSeat);
        }
        else {
            return Optional.empty();
        }
    }

    @Override
    public void deleteSeat(Integer id) {
        Optional<Seat> managedSeatObject = seatRepository.findById(id);

        if(managedSeatObject.isPresent()) {
            seatRepository.delete(managedSeatObject.get());
        }
    }


}
