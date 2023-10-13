package hr.apisit.cinemamvc.service;

import hr.apisit.cinemamvc.domain.Projection;
import hr.apisit.cinemamvc.domain.Seat;

import java.math.BigDecimal;

public interface PriceCalculationService {
    BigDecimal calculateFilmPrice(Projection projection, Seat seat);
}
