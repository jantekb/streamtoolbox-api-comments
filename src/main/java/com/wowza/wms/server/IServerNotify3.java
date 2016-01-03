package com.wowza.wms.server;

/**
 * This is the third extension of the IServerNotify interface family adding two
 * new lifecycle methods.
 * 
 * {@link ServerNotifyBase} provides a simple adapter implementation that you
 * can use to override only the necessary methods.
 */
public interface IServerNotify3 extends IServerNotify2 {

	/**
	 * This method is invoked when the vhosts are just about to be started
	 * 
	 * @param server
	 *            the {@link IServer} instance
	 */
	void onServerBeforeVHostStartup(IServer server);

	/**
	 * This method is invoked when the vhosts have been started
	 * 
	 * @param server
	 *            the {@link IServer} instance
	 */
	void onServerAfterVHostStartup(IServer server);
}
