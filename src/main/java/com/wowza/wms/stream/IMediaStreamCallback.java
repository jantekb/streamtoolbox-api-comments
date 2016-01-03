package com.wowza.wms.stream;

import com.wowza.wms.amf.AMFDataList;
import com.wowza.wms.request.RequestFunction;

/**
 * Callback that you can register on an {@link IMediaStream} using {@link IMediaStream#addCalbackListener(IMediaStreamCallback)} This one is not mentioned in the official docs, in
 * that they only list registerCallback, registerOnStatus, registerOnPlayStatus methods of {@link IMediaStream}
 */
public interface IMediaStreamCallback {

	void onCallback(IMediaStream stream, RequestFunction requestFunction, AMFDataList dataList);
}
