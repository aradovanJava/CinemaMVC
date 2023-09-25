package hr.apisit.cinemamvc.repository;

import hr.apisit.cinemamvc.domain.Stage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaStageRepository extends JpaRepository<Stage, Integer> {
}
