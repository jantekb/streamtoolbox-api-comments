package com.wowza.wms.httpstreamer.model;

public interface IHTTPStreamerSession {

	/**
	 * Never seen it being false, it is true even after you call @see #rejectSession()
	 * @return apparently always just true (?)
	 */
	boolean isActive();
	
	/**
	 * It can be used to get rid of the player using this session, the player gets HTTP 403 when it asks for the next media chunk.
	 */
	void rejectSession();
	
	/**
	 * Returns true if the HTTP streaming happens over SSL
	 * @since 4.1.1
	 * @return true if SSL is used
	 */
	boolean isSecure();
	
	/**
	 * I guess makes no sense for you to call it, this is called by the HTTP Streamers itself to set the flag to true if SSL is used.
	 * @since 4.1.1
	 * @param isSecure the secure flag
	 * @return the return value is not documented
	 */
	boolean setSecure(boolean isSecure);
	
}
