package co.edu.uco.nese.crosscuting.helpers;

public final class BooleanHelper {
	
	private BooleanHelper() {
	}
	
	public static boolean getDefault() {
		return false;
	}
	
	public static boolean getDefault(final Boolean value) {
		return ObjectHelper.getDefault(value, getDefault());
	}

}
