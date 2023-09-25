package hr.apisit.cinemamvc.repository;

import hr.apisit.cinemamvc.domain.SeatCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaSeatCategoryRepository extends JpaRepository<SeatCategory, Integer> {
}
