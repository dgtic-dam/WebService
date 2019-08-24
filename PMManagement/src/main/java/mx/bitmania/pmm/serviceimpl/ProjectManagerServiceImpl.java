package mx.bitmania.pmm.serviceimpl;

import java.util.List;

import javax.transaction.Status;
import javax.ws.rs.core.Response;

import org.apache.cxf.BusException;
import org.springframework.beans.factory.annotation.Autowired;

import mx.bitmania.pmm.entities.ProjectManager;
import mx.bitmania.pmm.exceptions.BusinessExceptions;
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
			throw new BusinessExceptions(e.getMessage());
			//System.out.println("Error:" + e.getMessage());
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
		Response response = null;
		try {
			projectManagerRepository.deleteById(id);
			response = Response.ok("Borrado el registro con id: " + id).build();
			
		}catch(Exception e){
			//response = Response.ok("Error: " + Response.Status.NOT_FOUND.toString()).build();
			//response = Response.ok(Response.status(404) + "no existe el id :" + id).build();
			response = Response.ok("No existe el id :" + id  +"\nError: " + Response.Status.NOT_FOUND.toString()).build();
		}
		return response;
	}

}
