package co.edu.uco.nese.crosscuting.exception;

import co.edu.uco.nese.crosscuting.helpers.ObjectHelper;
import co.edu.uco.nese.crosscuting.helpers.TextHelper;

public final class NeseException extends RuntimeException {

	private static final long serialVersionUID = -433023700129543247L;
	private Throwable rootException;
	private String userMessage;
	private String technicalMessage;
	
	private NeseException(final Throwable rootException, final String userMessage, final String technicalMessage) {
		setRootException(rootException);
		setUserMessage(userMessage);
		setTechnicalMessage(technicalMessage);
	}
	
	public static NeseException create(final String userMessage) {
		return new NeseException(new Exception(), userMessage, userMessage);
	}
	
	public static NeseException create(final String userMessage, final String technicalMessage) {
		return new NeseException(new Exception(), userMessage, technicalMessage);
	}
	
	public static NeseException create(final Throwable rootException, final String userMessage, final String technicalMessage) {
		return new NeseException(rootException, userMessage, technicalMessage);
	}
	
	public Throwable getRootException() {
		return rootException;
	}
	private void setRootException(final Throwable rootException) {
		this.rootException = ObjectHelper.getDefault(rootException, new Exception());
	}
	public String getUserMessage() {
		return userMessage;
	}
	private void setUserMessage(final String userMessage) {
		this.userMessage = TextHelper.getDefaultWithTrim(userMessage);
	}
	public String getTechnicalMessage() {
		return technicalMessage;
	}
	private void setTechnicalMessage(final String technicalMessage) {
		this.technicalMessage = TextHelper.getDefaultWithTrim(technicalMessage);
	}
	
}