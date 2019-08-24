package mx.bitmania.pmm.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import mx.bitmania.pmm.entities.ProjectManager;

@Service
@Path("/projectmanagerservice")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface ProjectManagerService {
	
	@Path("/projectmanagers")
	@GET
	public List<ProjectManager> getAll();
	
	@Path("/projectmanager/{id}")
	@GET
	public ProjectManager getProjectManager(@PathParam(value = "id") int id);
	
	@Path("/projectmanager")
	@POST
	public ProjectManager createProjectManager(ProjectManager projectManager);
	
	@Path("/projectmanager")
	@PUT
	public Response updateProjectManager(ProjectManager projectManager);
	
	@Path("projectmanager/{id}")
	@DELETE
	public Response deleteProjectManager(@PathParam(value = "id")int id);
	
}
