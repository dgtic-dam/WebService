package mx.bitmania.pmm.exceptions;

import java.util.Formatter;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class BusinessExceptionMapper implements ExceptionMapper<BusinessExceptions> {

	@Override
	public Response toResponse(BusinessExceptions exception) {
		StringBuilder sb = new StringBuilder();
		Formatter  fmt  = new Formatter(sb);
		fmt.format("{\"Status\":\"Error\",\"Message\":\"%s\"}", exception.getMessage());
		fmt.close();
		return Response.serverError().entity(sb.toString()).build();
	}
	
}
