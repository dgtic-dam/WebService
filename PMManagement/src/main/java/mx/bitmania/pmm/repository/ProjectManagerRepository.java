package mx.bitmania.pmm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.bitmania.pmm.entities.ProjectManager;

@Repository
public interface ProjectManagerRepository extends JpaRepository<ProjectManager, Integer> {

}
