package hr.apisit.cinemamvc.controller;

import hr.apisit.cinemamvc.domain.Projection;
import hr.apisit.cinemamvc.domain.Seat;
import hr.apisit.cinemamvc.form.ProjectionTicketsForm;
import hr.apisit.cinemamvc.service.PriceCalculationService;
import hr.apisit.cinemamvc.service.ProjectionService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Optional;

@Controller
@RequestMapping("projection")
@AllArgsConstructor
@Slf4j
public class ProjectionController {

    private ProjectionService projectionService;

    private PriceCalculationService priceCalculationService;

    @GetMapping("{projectionId}")
    public String getProjectionDetails(@PathVariable Integer projectionId, Model model) {
        Optional<Projection> projectionOptional = projectionService.findById(projectionId);

        if(projectionOptional.isPresent()) {
            model.addAttribute("projection", projectionOptional.get());
            model.addAttribute("projectionTicketsForm", new ProjectionTicketsForm());
        }

        return "projection/projectionDetails";
    }

    @PostMapping("{projectionId}/tickets")
    public String buyProjectionTickets(@PathVariable Integer projectionId, Model model,
                                       @ModelAttribute ProjectionTicketsForm form)
    {
        Optional<Projection> projectionOptional = projectionService.findById(projectionId);

        if(projectionOptional.isPresent()) {
            model.addAttribute("projection", projectionOptional.get());

            BigDecimal totalTicketsPrices = BigDecimal.ZERO;

            for(Seat seat : form.getChosenSeats()) {
                BigDecimal partialPrice = priceCalculationService.calculateFilmPrice(projectionOptional.get(), seat);
                totalTicketsPrices = totalTicketsPrices.add(partialPrice);
            }

            model.addAttribute("totalPrice", totalTicketsPrices);
            model.addAttribute("projectionTicketsForm", new ProjectionTicketsForm());

        }
        return "projection/projectionDetails";
    }

}
