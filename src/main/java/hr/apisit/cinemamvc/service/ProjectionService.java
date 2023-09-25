package hr.apisit.cinemamvc.service;

import hr.apisit.cinemamvc.domain.Projection;

import java.util.List;

public interface ProjectionService {
    List<Projection> findAll();

    Projection saveNewProjection(Projection projection);
}
