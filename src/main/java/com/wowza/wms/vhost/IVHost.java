package com.wowza.wms.vhost;

public interface IVHost {

	/**
	 * Returns the path of the Wowza installation, e.g. <code>c:\Wowza</code>
	 * @return the Wowza installation home path
	 */
	String getHomePath();
}
