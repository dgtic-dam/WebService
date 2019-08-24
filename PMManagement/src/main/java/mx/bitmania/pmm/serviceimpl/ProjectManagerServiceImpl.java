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
		return projectManagerRepository.findById(id).get();
	}

	@Override
	public ProjectManager createProjectManager(ProjectManager projectManager) {
		ProjectManager savedProjectManager = projectManagerRepository.save(projectManager);
		return savedProjectManager;
	}

	@Override
	public Response updateProjectManager(ProjectManager projectManager) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response deleteProjectManager(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
