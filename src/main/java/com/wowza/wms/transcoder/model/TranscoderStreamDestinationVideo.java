package com.wowza.wms.transcoder.model;

public class TranscoderStreamDestinationVideo extends TranscoderStreamDestinationBase implements  ITranscoderOverlayProvider, ITranscoderOverlayImages, ITranscoderFrameGrabProvider {

	/**
	 * Set padding around the video. Tha passed array items are interpreted as padding around the left(0), right(1), top(2) and bottom(3) of the video respectively. 
	 * The official example has a bug and it permutes top and right mistakenly.
	 * @param paddings
	 */
	void setPadding(int[] paddings) {
	}
	
	/**
	 * Returns the height defined in the transcoder template for a specific rendition (<code>FrameSize / Height</code> in the xml)
	 * @return the rendition height
	 */
	int getFrameSizeHeight() {
		return 0;
	}
	
	/**
	 * Returns the width defined in the transcoder template for a specific rendition (<code>FrameSize / Width</code> in the xml)
	 * @return the rendition width
	 */
	int getFrameSizeWidth() {
		return 0;
	}
	
	/**
	 * Returns the height determined when the source was decoded
	 * @return the decoded frame height
	 */
	int getFrameHeight() {
		return 0;
	}
	
	/**
	 * Returns the width determined when the source was decoded
	 * @return the decoded frame width
	 */
	int getFrameWidth() {
		return 0;
	}
}
