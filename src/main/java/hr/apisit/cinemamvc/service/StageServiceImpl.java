package hr.apisit.cinemamvc.service;

import hr.apisit.cinemamvc.domain.Seat;
import hr.apisit.cinemamvc.domain.Stage;
import hr.apisit.cinemamvc.repository.JpaStageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StageServiceImpl implements StageService {

    private JpaStageRepository stageRepository;
    @Override
    public List<Stage> getAllStages() {
        return stageRepository.findAll();
    }

    @Override
    public Optional<Stage> getStageById(Integer id) {
        return stageRepository.findById(id);
    }
    @Override
    public void saveNewStage(Stage newStage) {
        stageRepository.save(newStage);
    }

    @Override
    public Optional<Stage> updateStage(Stage updatedStage, Integer id) {

        Optional<Stage> managedStageObject = stageRepository.findById(id);

        if(managedStageObject.isPresent()) {
            Stage stage = managedStageObject.get();
            stage.setName(updatedStage.getName());
            stage.setDescription (updatedStage.getDescription());
            stage.setSeatList(updatedStage.getSeatList());
            stage.setCinema(updatedStage.getCinema());
            Stage updatedManagedBeanStage = stageRepository.save(stage);
            return Optional.of(updatedManagedBeanStage);
        }
        else {
            return Optional.empty();
        }
    }

    @Override
    public void deleteStage(Integer id) {
        Optional<Stage> managedStageBean = stageRepository.findById(id);
        stageRepository.delete(managedStageBean.get());
    }
}
