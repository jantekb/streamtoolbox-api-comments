package com.wowza.wms.mediacache.model;

import com.wowza.wms.application.IApplicationInstance;

public class MediaCache {

	/**
	 * Purges an assed from the cache if it's not being referenced or played by clients.
	 * @param mediaName the asset stream name minus the prefix and after any play aliasing
	 */
	public void flushItemFromCache(String mediaName) {
	}

	/**
	 * Purges an asset from the cache with the prefix. Important: the asset should not be in use!
	 * @param appInstance the application instance that we purge the asset in
	 * @param streamName streamName with prefix, that is run through the aliasing to get resolved to proper media name
	 */
	public void flushStreamNameFromCache(IApplicationInstance appInstance, String streamName) {
	}
	
	/** 
	 * Purges an assed from the cache even if it's being used. The purge happens 30 seconds after the last user of the
	 * asset is disconnected.
	 * 
	 * Note: not included in the official docs, but <a href="http://www.wowza.com/forums/content.php?235-How-to-purge-an-item-from-the-cache-%28MediaCache%29">mentioned here</a>
	 * 
	 * @param mediaName the asset stream name minus the prefix and after any play aliasing
	 * @since 4.3
	 */
	public void flushAndForceItemFromCache(String mediaName) {
	}

	/**
	 * Same as {@link #flushStreamNameFromCache(IApplicationInstance, String)} except that it works with assets in use.
	 * The purge happens 30 seconds after the last user of the asset is disconnected.
	 * 
	 * Note: not included in the official docs, but <a href="http://www.wowza.com/forums/content.php?235-How-to-purge-an-item-from-the-cache-%28MediaCache%29">mentioned here</a>
	 * @param appInstance the application instance that we purge the asset in
	 * @param streamName streamName with prefix, that is run through the aliasing to get resolved to proper media name
	 * @since 4.3
	 */
	public void flushAndForceStreamNameFromCache(IApplicationInstance appInstance, String streamName) {
	}
}
