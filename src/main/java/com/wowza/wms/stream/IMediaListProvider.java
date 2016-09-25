package com.wowza.wms.stream;

import org.w3c.dom.stylesheets.MediaList;

/**
 * Custom media list provider interface that can catch all requests to streams with the amlst: prefix (for API based MediaList).
 * This allows you to programmatically define the streams in a stream name group with all relevant parameters. For further information and example check out:
 * https://www.wowza.com/forums/content.php?330-How-to-use-Java-API-calls-to-resolve-SMIL-file-requests
 * 
 * You need to use IApplicationInstance.setMediaListProvider to register your code in the application.
 */
public interface IMediaListProvider {

	public MediaList resolveMediaList(IMediaListReader mediaListReader, IMediaStream stream, String streamName);
	
}
