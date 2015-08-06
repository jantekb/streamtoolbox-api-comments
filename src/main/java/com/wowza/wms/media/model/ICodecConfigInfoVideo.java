package com.wowza.wms.media.model;

public interface ICodecConfigInfoVideo {

	/**
	 * Returns the frame width
	 * @return frame width in pixels
	 */
	int getFrameWidth();

	/**
	 * Returns the frame height
	 * @return frame height in pixels
	 */
	int getFrameHeight();

	/**
	 * Returns the display width
	 * @return the display width in pixels
	 */
	int getDisplayWidth();

	/**
	 * Returns the display height
	 * @return the display height in pixels
	 */
	int getDisplayHeight();

	int getProfile();

	int getLevel();

	/**
	 * Returns the frame rate (fps)
	 * @return frame rate per second
	 */
	double getFrameRate();

	int getCodec();

	int getNALUnitLen();
}