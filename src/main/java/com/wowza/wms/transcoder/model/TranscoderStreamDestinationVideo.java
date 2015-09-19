package com.wowza.wms.transcoder.model;

public class TranscoderStreamDestinationVideo extends TranscoderStreamDestinationBase implements  ITranscoderOverlayProvider, ITranscoderOverlayImages, ITranscoderFrameGrabProvider {

	/**
	 * Set padding around the video. Tha passed array items are interpreted as padding around the left(0), right(1), top(2) and bottom(3) of the video respectively. 
	 * The official example has a bug and it permutes top and right mistakenly.
	 * @param paddings
	 */
	void setPadding(int[] paddings) {
	}
}
