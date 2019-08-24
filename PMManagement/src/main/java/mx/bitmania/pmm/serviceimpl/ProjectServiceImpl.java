package mx.bitmania.pmm.serviceimpl;

import java.util.List;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import mx.bitmania.pmm.entities.Project;
import mx.bitmania.pmm.entities.ProjectManager;
import mx.bitmania.pmm.exceptions.BusinessExceptions;
import mx.bitmania.pmm.repository.ProjectManagerRepository;
import mx.bitmania.pmm.repository.ProjectRepository;

public class ProjectServiceImpl implements mx.bitmania.pmm.service.ProjectService {

	@Autowired
	ProjectRepository projectRepository;
	
	@Override
	public List<Project> getAll() {
		return projectRepository.findAll();
	}

	@Override
	public Project getProject(int id) {
		Project project = null;
		try {
			project = projectRepository.findById(id).get();
		}catch(Exception e){
			throw new BusinessExceptions(e.getMessage());
			//System.out.println("Error:" + e.getMessage());
		}
		return project;
	}


	@Override
	public Project createProject(Project project) {
		Project savedProject = projectRepository.save(project);
		return savedProject;
	}

	@Override
	public Response updateProject(Project project) {
		Project updateProject = projectRepository.save(project);
		return Response.ok(updateProject).build();
	}

	@Override
	public Response deleteProject(int id) {
		Response response = null;
		try {
			projectRepository.deleteById(id);
			response = Response.ok("Borrado el registro con id: " + id).build();
			
		}catch(Exception e){
			//response = Response.ok("Error: " + Response.Status.NOT_FOUND.toString()).build();
			//response = Response.ok(Response.status(404) + "no existe el id :" + id).build();
			response = Response.ok("No existe el id :" + id  +"\nError: " + Response.Status.NOT_FOUND.toString()).build();
		}
		return response;
	}

}
