package hr.apisit.cinemamvc.controller;

import hr.apisit.cinemamvc.domain.Film;
import hr.apisit.cinemamvc.domain.Genre;
import hr.apisit.cinemamvc.domain.Rating;
import hr.apisit.cinemamvc.service.FilmService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("film")
@AllArgsConstructor
public class FilmController {

    private FilmService filmService;

    @GetMapping
    public String getAllFilms(Model model) {
        List<Film> filmList = filmService.findAll();
        model.addAttribute("films", filmList);
        return "filmList";
    }

    @GetMapping("/details/")
    public String getFilmById(Model model, @RequestParam Integer id) {
        Film film = filmService.findById(id);
        model.addAttribute("film", film);
        return "filmDetails";
    }

    @GetMapping("/new")
    public String getScreenForNewFilm(Model model) {
        model.addAttribute("film", new Film());
        model.addAttribute("genreList", Genre.values());
        model.addAttribute("ratingList", Rating.values());
        return "newFilm";
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
        return "updateFilm";
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
