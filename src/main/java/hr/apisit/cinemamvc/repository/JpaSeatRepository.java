package hr.apisit.cinemamvc.repository;

import hr.apisit.cinemamvc.domain.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaSeatRepository extends JpaRepository<Seat, Integer> {
    @Query("SELECT s from Seat s WHERE s.stage.id = :stageId")
    List<Seat> findByStageId(@Param("stageId") Integer stageId);

}
