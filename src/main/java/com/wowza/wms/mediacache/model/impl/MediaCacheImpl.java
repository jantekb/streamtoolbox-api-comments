package com.wowza.wms.mediacache.model.impl;

import com.wowza.wms.mediacache.model.MediaCache;

public class MediaCacheImpl {

	/**
	 * This is not documented in the 4.3 Server Side API, but <a href="http://www.wowza.com/forums/content.php?235-How-to-purge-an-item-from-the-cache-%28MediaCache%29">mentioned here</a>.
	 * Looks like it is a static getter that allows you to get a reference to the MediaCache implementation
	 * @return
	 */
	public static MediaCache getMediaCache() {
		return null;
	};
	
}
