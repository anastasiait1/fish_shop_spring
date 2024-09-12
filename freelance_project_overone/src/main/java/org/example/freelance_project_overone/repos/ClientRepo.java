package org.example.freelance_project_overone.repos;

import org.example.freelance_project_overone.models.ClientModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepo extends JpaRepository<ClientModel, Long> {
    List<ClientModel> findClientModelsByActual(boolean actual);
}
