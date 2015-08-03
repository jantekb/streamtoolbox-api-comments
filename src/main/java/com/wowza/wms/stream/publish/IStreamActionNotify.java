package com.wowza.wms.stream.publish;

/**
 * This callback interface can be attached to instances of {@link Stream}, so that you get notified of transitions in the playlist.
 * An example on its actual usage can be studied in the sources of ServerListenerStreamPublisher in the official Wowza Module Collection.
 * 
 */
public interface IStreamActionNotify {

	/**
	 * Called whenever a new item is started in the playlist of the stream
	 * 
	 * @param stream the stream instance on which the transtion takes place
	 * @param playlistItem the playlist item that is being started
	 */
	void onPlaylistItemStart(Stream stream, PlaylistItem playlistItem);

	/**
	 * Called whenever a new item is stopped in the playlist of the stream
	 * 
	 * @param stream the stream instance on which the transtion takes place
	 * @param playlistItem the playlist item that is being stopped
	 */
	void onPlaylistItemStop(Stream stream, PlaylistItem playlistItem);
	
}
