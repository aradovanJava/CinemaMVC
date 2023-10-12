package hr.apisit.cinemamvc.controller;

import hr.apisit.cinemamvc.domain.Projection;
import hr.apisit.cinemamvc.service.ProjectionService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("projection")
@AllArgsConstructor
@Slf4j
public class ProjectionController {

    private ProjectionService projectionService;

    @GetMapping("{projectionId}")
    public String getProjectionDetails(@PathVariable Integer projectionId, Model model) {
        Optional<Projection> projectionOptional = projectionService.findById(projectionId);

        if(projectionOptional.isPresent()) {
            model.addAttribute("projection", projectionOptional.get());
        }

        return "projection/projectionDetails";
    }

}
