package mx.bitmania.pmm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.bitmania.pmm.entities.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {

}
