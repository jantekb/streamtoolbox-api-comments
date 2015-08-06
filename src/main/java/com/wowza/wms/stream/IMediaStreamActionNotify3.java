package com.wowza.wms.stream;

import com.wowza.wms.media.model.MediaCodecInfoAudio;
import com.wowza.wms.media.model.MediaCodecInfoVideo;

/**
 * This is the third generation callback interface that you can use to listen on events that occure on a media stream.
 */
public interface IMediaStreamActionNotify3 extends IMediaStreamActionNotify2 {

	void onCodecInfoVideo(IMediaStream mediaStream, MediaCodecInfoVideo videoCodecInfo);

	void onCodecInfoAudio(IMediaStream mediaStream, MediaCodecInfoAudio audioCodecInfo);
}
