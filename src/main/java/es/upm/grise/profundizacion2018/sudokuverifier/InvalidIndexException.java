package es.upm.grise.profundizacion2018.sudokuverifier;

public class InvalidIndexException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5728210249664314802L;

	public InvalidIndexException() {
		super();
		
	}

	public InvalidIndexException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		
	}

	public InvalidIndexException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		
	}

	public InvalidIndexException(String arg0) {
		super(arg0);
		
	}

	public InvalidIndexException(Throwable arg0) {
		super(arg0);
		
	}
	
	

}
