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

import mx.bitmania.pmm.entities.Project;

@Path("/projectservice")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public interface ProjectService {
	
	@Path("/projects")
	@GET
	public List<Project> getAll();
	
	@Path("/project/{id}")
	@GET
	public Project getProject(@PathParam(value = "id") int id);
	
	@Path("/project")
	@POST
	public Project createProject(Project project);
	
	@Path("/project")
	@PUT
	public Response updateProject(Project project);
	
	@Path("project/{id}")
	@DELETE
	public Response deleteProject(@PathParam(value = "id")int id);

}
