package Exceptions;

public class SamePassException extends Exception {

	public static final String DEF_MESSAGE = "La nueva contraseña ha de ser diferente a la actual.";
	public SamePassException() {
		super(DEF_MESSAGE);
	}

	public SamePassException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public SamePassException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public SamePassException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public SamePassException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
