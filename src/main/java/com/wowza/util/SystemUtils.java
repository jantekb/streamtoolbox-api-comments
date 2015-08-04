/**
 * In this package, you can find useful utility classes that are worth checking out if you are developing custom Wowza module.
 */
package com.wowza.util;

import java.util.Map;

/**
 *  A bunch of useful methods that did not fit anywhere else.
 */
public class SystemUtils {
	
	/**
	 * This method is to substitute runtime environment variables into your arbitrary Strings.
	 * 
	 * @param inValue the string that contains the placeholders to be expanded in ${variable} format
	 * @return the inValue with placeholders replaced with runtime values
	 */
	public static String expandEnvironmentVariables(String inValue) {
		return null;
	}
	
	/**
	 * Same as {@link #expandEnvironmentVariables(String)} except that you can feed in extra arbitrary custom variables to resolve on top of the environment variables.
	 * 
	 * @param inValue the string that contains the placeholders to be expanded in ${variable} format
	 * @param valueMap a map keyed with Strings and contains the possible values to be substituted
	 * @return the inValue with placeholders replaced with runtime values
	 */
	public static String expandEnvironmentVariables(String inValue, Map valueMap) {
		return null;
	}
	
	/**
	 * 
	 * @return
	 */
	public static byte[] getMACAddress() {
		return null;
	}
	
	/**
	 * 
	 */
	public static void addBouncyCastleSecurityProvider() {
		
	}
	
	/**
	 * 
	 * @param paramLong
	 * @return
	 */
	public static long toNTPTime(long paramLong) {
		return 0;
	}
	
	/**
	 * 
	 * @return
	 */
	public static long getCpuTime() {
		return 0;
	}
	
	/**
	 * 
	 * @return
	 */
	public static long getUserTime() {
		return 0;
	}
	
	/**
	 * 
	 * @return
	 */
	public static long getSystemTime() {
		return 0;
	}
	
	/**
	 * 
	 * @param paramString
	 * @return
	 */
	public static String getLinuxSocketParam(String paramString) {
		return null;
	}
	
	/**
	 * 
	 * @author Isti
	 *
	 */
	public static class ReplaceItem {
		
	}
}
