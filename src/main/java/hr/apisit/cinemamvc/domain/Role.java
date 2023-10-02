package hr.apisit.cinemamvc.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Role extends BaseEntity {
    @Column(name="ROLE_NAME")
    private String roleName;
}
