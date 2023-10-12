package hr.apisit.cinemamvc.controller;

import hr.apisit.cinemamvc.domain.Film;
import hr.apisit.cinemamvc.domain.Genre;
import hr.apisit.cinemamvc.domain.Projection;
import hr.apisit.cinemamvc.domain.Rating;
import hr.apisit.cinemamvc.service.FilmService;
import hr.apisit.cinemamvc.service.ProjectionService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("film")
@AllArgsConstructor
@Slf4j
public class FilmController {

    private FilmService filmService;
    private ProjectionService projectionService;

    @GetMapping
    public String getAllFilms(Model model) {
        List<Film> filmList = filmService.findAll();
        model.addAttribute("films", filmList);
        return "film/filmList";
    }

    @GetMapping("/details/")
    public String getFilmById(Model model, @RequestParam Integer id) {

        Optional filmOptional = Optional.empty();

        try {
            Film film = filmService.findById(id);
            filmOptional = Optional.of(film);
            model.addAttribute("film", filmOptional.get());

            List<Projection> projectionList = projectionService.findAllByFilm(film);
            model.addAttribute("projectionList", projectionList);
            for(Projection projection : projectionList) {
                log.info("Projection " + projection.getFilm().getName() + " - available seats: "
                        + projection.getStage().getSeatList().size());
            }
        }
        catch(RuntimeException ex) {
            log.error("Error while getting the film by ID!", ex);
        }

        return "film/filmDetails";
    }

    @GetMapping("/new")
    public String getScreenForNewFilm(Model model) {
        model.addAttribute("film", new Film());
        model.addAttribute("genreList", Genre.values());
        model.addAttribute("ratingList", Rating.values());
        return "film/newFilm";
    }

    @PostMapping("/new")
    public String saveNewFilm(Model model, @ModelAttribute Film film) {
        filmService.save(film);
        return "redirect:/film";
    }

    @GetMapping("/update/")
    public String getUpdateScreen(Model model, @RequestParam Integer id) {
        Film filmToUpdate = filmService.findById(id);
        model.addAttribute("film", filmToUpdate);
        model.addAttribute("genreList", Genre.values());
        model.addAttribute("ratingList", Rating.values());
        return "film/updateFilm";
    }

    @PostMapping("/update")
    public String updateFilm(@ModelAttribute Film film) {
        filmService.save(film);
        return "redirect:/film";
    }

    @GetMapping("/delete/")
    public String deleteFilm(@RequestParam Integer id) {
        filmService.deleteById(id);
        return "redirect:/film";
    }

}
