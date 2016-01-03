package com.wowza.wms.stream;

import com.wowza.wms.amf.AMFPacket;

public interface IMediaStream {
	
	int READACCESS = 0;

	int WRITEACCESS = 1;

	int AUDIOSAMPLEACCESS = 2;

	int VIDEOSAMPLEACCESS = 3;

	int PUBLISH_BITRATE_SOURCE_MEASURE = 1;

	int PUBLISH_BITRATE_SOURCE_METADATA = 2;

	int PUBLISH_FRAMERATE_SOURCE_MEASURE = 1;

	int PUBLISH_FRAMERATE_SOURCE_METADATA = 2;
	
	void addClientListener(IMediaStreamActionNotify paramIMediaStreamActionNotify);

	void addClientListener(IMediaStreamActionNotify2 paramIMediaStreamActionNotify2);

	void addClientListener(IMediaStreamActionNotify3 paramIMediaStreamActionNotify3);

	void removeClientListener(IMediaStreamActionNotify paramIMediaStreamActionNotify);

	void removeClientListener(IMediaStreamActionNotify2 paramIMediaStreamActionNotify2);

	void removeClientListener(IMediaStreamActionNotify3 paramIMediaStreamActionNotify3);

	/**
	 * This returns the video framerate from the metadata if available. If not, the measured value is returned.
	 * 
	 * @since 4.3.0.02 build 17246
	 * @return
	 */
	int getPublishFramerateVideo();
	
	/**
	 * This returns the audio framerate from the metadata if available. If not, the measured value is returned.
	 * 
	 * @since 4.3.0.02 build 17246
	 * @return
	 */
	int getPublishFramerateAudio();
	
	/**
	 * This returns the video framerate from the specified source, which can be either {@link #PUBLISH_FRAMERATE_SOURCE_MEASURE} or {@value #PUBLISH_FRAMERATE_SOURCE_METADATA}
	 *  
	 * @param source can be either {@link #PUBLISH_FRAMERATE_SOURCE_MEASURE} or {@value #PUBLISH_FRAMERATE_SOURCE_METADATA}
	 * @since 4.3.0.02 build 17246
	 * @return
	 */
	int getPublishFramerateVideo(int source); // IMediaStream.PUBLISH_FRAMERATE_SOURCE_MEASURE or IMediaStream.
	
	/**
	 * Returns the audio framerate from the specified source, which can be either {@link #PUBLISH_FRAMERATE_SOURCE_MEASURE} or {@value #PUBLISH_FRAMERATE_SOURCE_METADATA}
	 * 
	 * @param source can be either {@link #PUBLISH_FRAMERATE_SOURCE_MEASURE} or {@value #PUBLISH_FRAMERATE_SOURCE_METADATA}
	 * @since 4.3.0.02 build 17246
	 * @return
	 */
	int getPublishFramerateAudio(int source); // IMediaStream.PUBLISH_FRAMERATE_SOURCE_MEASURE or IMediaStream.PUBLISH_FRAMERATE_SOURCE_METADATA
	
	/**
	 * Returns the number of video frames received for an incoming live stream
	 * 
	 * @since 4.3.0.02 build 17246
	 * @return
	 */
	long getPublishFrameCountVideo();
	
	/**
	 * Returns the number of audio frames received for an incoming live stream
	 * 
	 * @since 4.3.0.02 build 17246
	 * @return
	 */
	long getPublishFrameCountAudio();
	
	/**
	 * Returns the number of data frames received for an incoming live stream
	 * 
	 * @since 4.3.0.02 build 17246
	 * @return
	 */
	long getPublishFrameCountData();
	
	/**
	 * Returns the last 10 video GOP sizes/keyframe intervals received for an incoming live stream. The first item is the most recent GOP
	 * 
	 * @since 4.3.0.02 build 17246
	 * @return
	 */
	int[] getPublishKeyFrameIntervalsVideo();
	
	/**
	 * Add an audio config packet. The official documentation says that this is "needed for H.264/AAC playback".
	 * 
	 * @param timecode the timecode where the packet needs to be added
	 * @param packet the packet to be added
	 */
	void addAudioCodecConfigPacket(long timecode, AMFPacket packet);

	/**
	 * Add new data to the current audio packet
	 * @param data the raw data to be added
	 * @param offset the offset of the data
	 * @param size the size of the data
	 */
	void addAudioData(byte[] data, int offset, int size);
	
	/**
	 * Not sure to be honest, never used it
	 * @param extraData
	 */
	void addAudioExtraData(java.util.Map extraData);
	
	/**
	 * Adds a listener that listends to all medatada. Please note that the typo is really there!
	 * 
	 * @param callbackListener listener implementation to be added
	 */
	void addCalbackListener(IMediaStreamCallback callbackListener);
}
