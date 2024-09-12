package org.example.freelance_project_overone.repos;

import org.example.freelance_project_overone.models.ItemModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepo extends JpaRepository<ItemModel, Long> {
}
