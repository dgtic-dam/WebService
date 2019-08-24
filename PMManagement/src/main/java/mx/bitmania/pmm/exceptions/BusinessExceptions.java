package mx.bitmania.pmm.exceptions;

import javax.ws.rs.WebApplicationException;

public class BusinessExceptions extends WebApplicationException {

	private static final long serialVersionUID = 1L;
	
	public BusinessExceptions(String message) {
		super(message);
	}

}
