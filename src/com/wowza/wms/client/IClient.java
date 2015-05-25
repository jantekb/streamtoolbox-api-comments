package com.wowza.wms.client;

public interface IClient {

	/**
	 * From the official release notes: "enable removal of the clientid item from the onConnect result for RTMP connections (default is to send clientid)"
	 * @since 4.1.1
	 * @return true if client id sending is on
	 */
	boolean isAcceptConnectionSendClientId();
	
	/**
	 * From the official release notes: "enable removal of the clientid item from the onConnect result for RTMP connections (default is to send clientid)"
	 * @since 4.1.1
	 * @param acceptConnectionSendClientId true if client id sending is switched on
	 */
	void setAcceptConnectionSendClientId(boolean acceptConnectionSendClientId);
}
