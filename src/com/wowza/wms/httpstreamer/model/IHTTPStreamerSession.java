package com.wowza.wms.httpstreamer.model;

public interface IHTTPStreamerSession {

	/**
	 * Never seen it being false, it is true even after you call {@see #rejectSession()}
	 * @return apparently always just true (?)
	 */
	boolean isActive();
	
	/**
	 * It can be used to get rid of the player using this session, the player gets HTTP 403 when it asks for the next media chunk.
	 */
	void rejectSession();
}
