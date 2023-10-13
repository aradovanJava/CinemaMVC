package hr.apisit.cinemamvc.form;

import hr.apisit.cinemamvc.domain.Seat;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class ProjectionTicketsForm {
    private List<Seat> chosenSeats;

}
