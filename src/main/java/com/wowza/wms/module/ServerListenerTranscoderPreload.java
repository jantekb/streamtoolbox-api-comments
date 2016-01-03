package com.wowza.wms.module;

import com.wowza.wms.server.ServerNotifyBase;

/**
 * This listener is to preload transcoder libraries on server startup. This can be used to prevent issues where transcoder is slow to load on when used the first time.
 * 
 * @since 4.3.0.02 build 17246
 */
public abstract class ServerListenerTranscoderPreload extends ServerNotifyBase {

	
}
