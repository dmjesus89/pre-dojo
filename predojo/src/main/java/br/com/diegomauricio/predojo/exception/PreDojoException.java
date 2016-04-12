package br.com.diegomauricio.predojo.exception;

/**
 * Classe que representa as excpetion esperadas no sistema
 * 
 * @author Diego Mauricio
 *
 */
public class PreDojoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PreDojoException(String msg) {
		super(msg);
	}

	public PreDojoException(Throwable exc) {
		super(exc);
	}

	public PreDojoException(String msg, Throwable exc) {
		super(msg, exc);
	}

}