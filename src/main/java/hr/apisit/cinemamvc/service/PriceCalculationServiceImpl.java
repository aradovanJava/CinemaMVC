package hr.apisit.cinemamvc.service;

import hr.apisit.cinemamvc.domain.Projection;
import hr.apisit.cinemamvc.domain.Seat;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PriceCalculationServiceImpl implements PriceCalculationService {
    @Override
    public BigDecimal calculateFilmPrice(Projection projection, Seat seat) {

        Short filmDuration = projection.getFilm().getDuration();

        BigDecimal price = new BigDecimal(5);

        if(filmDuration > 120) {
            price = price.multiply(new BigDecimal(filmDuration / 120));
        }

        BigDecimal coef = switch(seat.getSeatCategory().getName()) {
            case "LOVE_SEAT" -> {
                yield new BigDecimal(2);
            }
            case "RELAX_SEAT" -> {
                yield new BigDecimal(1.2);
            }
            case "VIP_SEAT" -> {
                yield new BigDecimal(1.4);
            }
            default -> {
                yield new BigDecimal(1);
            }
        };

        price = price.multiply(coef);

        return price;
    }
}
