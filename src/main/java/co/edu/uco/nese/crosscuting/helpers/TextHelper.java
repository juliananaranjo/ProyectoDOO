package co.edu.uco.nese.crosscuting.helpers;

public final class TextHelper {
	
	private static final String EMPTY = "";
	
	private TextHelper() {
	}
	
	public static String getDefault() {
		return EMPTY; 
		}
	
    public static String getDefault(final String value) {
    	return ObjectHelper.getDefault(value,getDefault());
    }
    
    public static String getDefaultWithTrim(final String value) {
    	return getDefault(value).trim();
    }
    
    public static boolean isEmpty(final String value) {
    	return value == null || value.trim().isEmpty();
    }
  
}
	
	
