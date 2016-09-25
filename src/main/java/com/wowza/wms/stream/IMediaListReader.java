package com.wowza.wms.stream;

import com.wowza.wms.application.IApplicationInstance;
import com.wowza.wms.application.WMSProperties;
import com.wowza.wms.httpstreamer.model.IHTTPStreamerSession;

public interface IMediaListReader {

	void init(IApplicationInstance applicationInstance, com.wowza.wms.stream.IMediaStream stream, 
			String mediaReadType, String basePath, String mediaName, IHTTPStreamerSession session);

	void setMediaReaderItem(MediaReaderItem item);

	void open(String basePath, String name);

	void close();

	boolean isOpen();

	void setProperties(WMSProperties properties);

	String getPath();

	String getMediaExtension();

	com.wowza.wms.medialist.MediaList getMediaList();

	IHTTPStreamerSession getHTTPStreamerSession();

	void setHTTPStreamerSession(IHTTPStreamerSession session);
}
