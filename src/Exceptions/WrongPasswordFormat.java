package Exceptions;

public class WrongPasswordFormat extends Exception {

	
	public static final String DEF_MESSAGE = "El formato de la contraseña es incorrrecto. La contraseña debe tener al menos 8, entre los cuales debe haber una letra, un número y un carácter especial.";
	public WrongPasswordFormat() {
		super(DEF_MESSAGE);
	}

	public WrongPasswordFormat(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public WrongPasswordFormat(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public WrongPasswordFormat(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public WrongPasswordFormat(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
