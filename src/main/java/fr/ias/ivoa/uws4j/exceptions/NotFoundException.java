package fr.ias.ivoa.uws4j.exceptions;

public class NotFoundException extends Exception {

	public NotFoundException(Class<?> class1, String name) {
		super("Object "+class1.getSimpleName()+" with name "+name+" not found");
	}

}
