package hr.apisit.cinemamvc.domain;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class SeatCategory extends BaseEntity {
    private String name;
    private String description;
    public SeatCategory(Integer id, String name, String description) {
        super(id);
        this.name = name;
        this.description = description;
    }

    /*
    @Id
    public Integer getId() {
        return super.getId();
    }

     */
}
