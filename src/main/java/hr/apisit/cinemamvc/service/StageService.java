package hr.apisit.cinemamvc.service;

import hr.apisit.cinemamvc.domain.Stage;

import java.util.List;
import java.util.Optional;

public interface StageService {

    List<Stage> getAllStages();

    Optional<Stage> getStageById(Integer id);

    void saveNewStage(Stage newStage);

    Optional<Stage> updateStage(Stage updatedStage, Integer id);

    void deleteStage(Integer id);

}
