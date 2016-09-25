package com.wowza.wms.stream.publish;

import java.util.List;

public class Playlist {

	/**
	 * Constructor to create a named empty playlist
	 * @param playlistName name of the playlist
	 */
	public Playlist(String playlistName) {
	}

	/**
	 * Append a new item to the end of the playlist.
	 * @param itemName can be a vod video name, eg. <code>mp4:sample.mp4</code> or an existing live stream name in the app <code>myStream</code>.
	 * @param start the starting second, or set to -2 if this is a live stream and you just want to pick it up where it is actually
	 * @param length set to -1 if you want it to play to the end (same for live streams mean as long as it is on)
	 */
	public void addItem(String itemName, int start, int length) {
	}
	
	/**
	 * Get a copy of all added playlist items
	 * @return list of items added to the playlist
	 */
	public List<PlaylistItem> getItems() {
		return null;
	}
	
	/**
	 * Getter for the name of the playlist
	 * @return the name of the playlist as set in the constructor
	 */
	public String getName() {
		return null;
	}
	
	/**
	 * Starts playing out this playlist in the specified stream. 
	 * @param stream
	 * @return not sure
	 */
	public boolean open(Stream stream) {
		return false;
	}

	/**
	 * Removes the n-th item from the playlist
	 * @param index the index of the item to remove
	 */
	public void removeItem(int index) {
	}

	/**
	 * Set to true if you want to restart the playlist after having played out all the items in it.
	 * @param repeat true if you want to repeat the playlist
	 */
	public void setRepeat(boolean repeat) {
	}
}
