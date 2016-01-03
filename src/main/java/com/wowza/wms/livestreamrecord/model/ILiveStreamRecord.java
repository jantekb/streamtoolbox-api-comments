package com.wowza.wms.livestreamrecord.model;

import java.util.Map;

import com.wowza.wms.stream.IMediaStream;

@Deprecated
public interface ILiveStreamRecord {

	  int SPLIT_TYPE_NONE = 0;
	  int SPLIT_TYPE_BY_SCHEDULE = 1;
	  int SPLIT_TYPE_BY_SIZE = 2;
	  int SPLIT_TYPE_BY_DURATION = 3;
	  
	  int SPLIT_ON_DISCONTINUITY_DEFAULT = 0;
	  int SPLIT_ON_DISCONTINUITY_ALWAYS = 1;
	  int SPLIT_ON_DISCONTINUITY_NEVER = 2;
	  
	/**
	 * As stated <a href="http://www.wowza.com/forums/content.php?123-How-to-record-live-streams-(HTTPLiveStreamRecord)">in the forum</a>:
	 * Start recording a live stream and indicate if the recording should be split when timecode discontinuities occur.
	 * 
	 * Values for splitting on timecode discountinuities are:
	 * <ul>
	 *   <li>SPLIT_ON_DISCONTINUITY_DEFAULT</li>
	 *   <li>SPLIT_ON_DISCONTINUITY_ALWAYS</li>
	 *   <li>SPLIT_ON_DISCONTINUITY_NEVER</li>
	 * </ul>
	 * @param stream the stream to be recorded
	 * @param filePath the path of the file in which the stream should be recorded
	 * @param append append or overwrite the file if exists
	 * @param extraMetadata ??
	 * @param splitOnTcDiscontinuity 
	 */
	void startRecording(IMediaStream stream, String filePath, boolean append, Map<String, Object> extraMetadata, int splitOnTcDiscontinuity);
	
	void startRecordingSegmentByDuration(IMediaStream stream, String filePath, Map extraMetadata, long duration);
	
	void startRecordingSegmentBySize(IMediaStream stream, String filePath, Map extraMetadata, long size);
	
	void startRecordingSegmentBySchedule(IMediaStream stream, String filePath, Map extraMetadata, String schedule);
	
	void splitRecordingNow();
	
	void setFileVersionDelegate(ILiveStreamRecordFileVersionDelegate delegate);
	
	void getCurrentDuration();
	
	void getCurrentSize();
	
	void stopRecording();
}
