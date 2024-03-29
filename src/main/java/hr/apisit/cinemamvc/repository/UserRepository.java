package hr.apisit.cinemamvc.repository;

import hr.apisit.cinemamvc.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
