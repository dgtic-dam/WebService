package mx.bitmania.pmm.serviceimpl;

import java.util.List;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import mx.bitmania.pmm.entities.ProjectManager;
import mx.bitmania.pmm.repository.ProjectManagerRepository;
import mx.bitmania.pmm.service.ProjectManagerService;

public class ProjectManagerServiceImpl implements ProjectManagerService {
	
	@Autowired
	ProjectManagerRepository projectManagerRepository;

	@Override
	public List<ProjectManager> getAll() {
		return projectManagerRepository.findAll();
	}

	@Override
	public ProjectManager getProjectManager(int id) {
		ProjectManager projectManager = null;
		try {
			projectManager = projectManagerRepository.findById(id).get();
		}catch(Exception e){
			System.out.println("Error:" + e.getMessage());
		}
		return projectManager;
	}

	@Override
	public ProjectManager createProjectManager(ProjectManager projectManager) {
		ProjectManager savedProjectManager = projectManagerRepository.save(projectManager);
		return savedProjectManager;
	}

	@Override
	public Response updateProjectManager(ProjectManager projectManager) {
		ProjectManager updateProjectManager = projectManagerRepository.save(projectManager);
		return Response.ok(updateProjectManager).build();
	}

	@Override
	public Response deleteProjectManager(int id) {
		projectManagerRepository.deleteById(id);
		return Response.ok("Borrado el registro: " + id).build();
	}

}
