package com.wowza.wms.stream;

/**
 * This is the first generation callback interface that you can use to listen on events that occure on a media stream.
 * New methods could not have been added to this interface without breaking existing modules (and there was no Java 8),
 * so this interface has been extended several times see its children:
 * 
 * <ul>
 *   <li>{@see IMediaStreamActionNotify2}
 * </ul>
 *
 */
public interface IMediaStreamActionNotify {

	/**
	 * Called when the player pauses the stream.
	 * 
	 * @param stream stream name
	 * @param isPause true if pause
	 * @param location
	 */
	void onPause(IMediaStream stream, boolean isPause, double location);
	
	void onPlay(IMediaStream stream, String streamName, double playStart, double playLen, int playReset);
	
	void onPublish(IMediaStream stream, String streamName, boolean isRecord, boolean isAppend);
	
	void onSeek(IMediaStream stream, double location);
	
	void onStop(IMediaStream stream);
	
	void onUnPublish(IMediaStream stream, String streamName, boolean isRecord, boolean isAppend);
}
