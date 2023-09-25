package hr.apisit.cinemamvc.repository;

import hr.apisit.cinemamvc.domain.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JpaSeatRepository extends JpaRepository<Seat, Integer> {
    @Query("SELECT s from Seat s WHERE s.stage.id = :stageId")
    List<Seat> findByStageId(@Param("stageId") Integer stageId);

}
