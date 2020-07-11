package model.exceptions;

public class FaturaException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public FaturaException(String msg) {
		super(msg);
	}
}
