/**
 * 
 */
package com.wowza.wms.module;

import com.wowza.wms.amf.AMFDataList;
import com.wowza.wms.application.IApplicationInstance;
import com.wowza.wms.client.IClient;
import com.wowza.wms.httpstreamer.model.IHTTPStreamerRequestContext;
import com.wowza.wms.httpstreamer.model.IHTTPStreamerSession;
import com.wowza.wms.httpstreamer.mpegdashstreaming.httpstreamer.HTTPStreamerSessionMPEGDash;
import com.wowza.wms.httpstreamer.sanjosestreaming.httpstreamer.HTTPStreamerSessionSanJose;
import com.wowza.wms.request.RequestFunction;
import com.wowza.wms.rtp.model.RTPSession;
import com.wowza.wms.stream.IMediaStream;

/**
 * This is the golden class that you need to extend when you start implementing your custom module for Wowza Streaming Engine.
 * The fully qualified name of this class is what goes into your Application.xml in the Class node of the Module node.
 *
 */
public class ModuleBase {

	/**
	 * This method is invoked by Wowza when your application starts up. 
	 * In practice, this happens when an encoder or a player first connects to your server referring to the name of your application.
	 * You can initialize your module here, loading necessary resources and your module's configuration.
	 * 
	 * @param appInstance a class containing information about the particular application instance that is being started along with any configuration
	 */
	public void onAppStart(IApplicationInstance appInstance) {
	}
	
	/**
	 * This method is invoked by Wowza when your application stops.
	 * This happens when (1) the whole server is shutting down (2) your application is stopped from management interface
	 * @param appInstance
	 */
	public void onAppStop(IApplicationInstance appInstance) {
	}
	
	/**
	 * This method is invoked when a new RTP session is created.
	 * This happens when for example a new stream is published from an IP webcamera to Wowza that uses RTP protocol.
	 * 
	 * @param client an object representing the known details about the client that is connecting
	 */
	public void onRTPSessionCreate(RTPSession client) {
	}
	
	/**
	 * This method is invoked upon every HTTP request that comes in. This means separate invocation for
	 * the m3u8 file, and an other one one for the chunklist file.
	 * 
	 * The passed reqContext has a {@link com.wowza.wms.httpstreamer.model.IHTTPStreamerRequestContext.#getRequestType()} method that you can call and check what happened exactly.
	 * 
	 * @param httpSession an object representing the known details about the session
	 * @param reqContext a context object representing some other details about the call
	 */
	public void onHTTPStreamerRequest(IHTTPStreamerSession httpSession, IHTTPStreamerRequestContext reqContext) {
	}
	
	/**
	 * This method is invoked every time a new San Jose session is created.
	 * 
	 * @param client an object represeting the session with details
	 */
	public void onHTTPSanJoseStreamingSessionCreate(HTTPStreamerSessionSanJose client) {
	}
	
	/**
	 * This method is invoked every time a new MPEG-DASH sessinon is created.
	 * 
	 * @param client an object represeting the session with details
	 */
	public void onHTTPMPEGDashStreamingSessionCreate(HTTPStreamerSessionMPEGDash client) {
	}

	/**
	 * This method is invoked whenever a HTTP session is destroyed. This happens shortly after a HTTP based player stops playing.
	 *
	 * @param httpSession an object represeting the HTTP session that is being destroyed
	 */
	public void onHTTPSessionDestroy(IHTTPStreamerSession httpSession) {
	}
	
	/**
	 * This method is invoked immediately when an RTMP based player (Flash client) closes, e.g. you close the browser tab with the player on it.
	 * <b>Caution: </b> despite the name, it is not invoked if non-RTMP players disconnect!
	 * 
	 * @param client the object represeting the previously connected player with all known details
	 */
	public void onDisconnect(IClient client) {
	}
	
	/**
	 * This method is invoked every time an RTP session is destroyed, e.g. your typical IP webcam stops the stream.
	 * 
	 * @param client the object represeting the session details that is being destroyed
	 */
	public void onRTPSessionDestroy(RTPSession client) {
	}
	
	/**
	 * This method is invoked every time a San Jose session is destroyed.
	 * 
	 * @param client the object represeting the session details that is being destroyed
	 */
	public void onHTTPSanJoseStreamingSessionDestroy(HTTPStreamerSessionSanJose client) {
	}
	
	/**
	 * 
	 * This method is called whenever a new stream is published by an RTMP publiser, e.g. Flash Media Live Encoder or GoCoder.
	 * Usually you want to know the name of the stream. This is the trick:
	 * 
	 * <code>String streamName = params.getString(PARAM1);</code> where <code>PARAM1</code> is a magic number in ModuleBase.
	 *
	 * @param client the object representing the connecting encoder
	 * @param function not sure..
	 * @param params a data object passed by the encoder, this can be used to find out the stream name
	 */
	public void publish(IClient client, RequestFunction function, AMFDataList params) {
	}
	
	/**
	 * This is called upon stream creation. Be careful <code>stream.getName()</code> will return null!
	 * It is the point where you can add your {@link com.wowza.wms.stream.IMediaStreamActionNotify} instance on the stream by calling
	 * {@link com.wowza.wms.stream.IMediaStream.#addClientListener()}
	 * 	@param stream the stream object
	 */
	public void onStreamCreate(IMediaStream stream) {
	}
	
	/**
	 * This is called upon stream destruction.
	 * It is the point where you should detach your {@link com.wowza.wms.stream.IMediaStreamActionNotify} instance,
	 * however it is not clear why it is necessary. If the stream object is not reused,
	 * the listener should be garbage collected anyways..
	 * @param stream the stream object
	 */
	public void onStreamDestroy(IMediaStream stream) {
	}
	
	/**
	 * This method is called when an MPEG-DASH session is destroyed after the client has disconnected
	 * 
	 * @param client the session object
	 */
	public void onHTTPMPEGDashStreamingSessionDestroy(HTTPStreamerSessionMPEGDash client) {
	}
	
	/**
	 * This method is invoked when an RTMP client starts playing a stream. If you need to know the stream name, this is the trick:
	 * 
	 * <code>String streamName = getParamString(params, PARAM1);</code>
	 * 
	 * <b>Caution: </b> despite the name, it is not invoked if non-RTMP players start playing!
	 * 
	 * If you implement this method, make sure that if you want to allow playback, finally you need to call {@link #invokePrevious(Object, IClient, RequestFunction, AMFDataList)}.
	 * 
	 * @param client the object representing the player
	 * @param function not sure..
	 * @param params a data object passed by the encoder, this can be used to find out the stream name
	 */
	public void play(IClient client, RequestFunction function, AMFDataList params) {
	}
	
	/**
	 * This is method can be used to extract data from the {@link com.wowza.wms.amf.AMFDataList} objects that you get in play/connect/publish methods.
	 * There are some constants defined in {@link ModuleBase} that are useful: {@link PARAM1}, {@link PARAM2}, {@link PARAM3}, which map to some other integers.
	 * 
	 *   In {@link #play(IClient, RequestFunction, AMFDataList)} and {@link #publish(IClient, RequestFunction, AMFDataList)}, you can extract the stream name as string with {@link PARAM1}
	 *   
	 * @param paramAMFDataList the object from which you want to extract the data
	 * @param paramInt the identifier of the parameter that you need.
	 * @return the String value of the extracted parameter
	 */
	protected static String getParamString(AMFDataList paramAMFDataList, int paramInt) {
		return null;
	}

	/**
	 * This method passes the control to the next module in the chain of configured modules, allowing each one to act on the lifecycle event.
	 * 
	 * @param paramObject from the examples, it looks like you just need to pass your own module instance, so pass literally {@code this}
	 * @param paramIClient pass on the {@link IClient} instance that you have received in your lifecycle method
	 * @param paramRequestFunction pass on the {@link RequestFunction} instance that you have received in your lifecycle method
	 * @param paramAMFDataList pass on the {@link AMFDataList} instance that you have received in your lifecycle method
	 */
	protected static void invokePrevious(Object paramObject, IClient paramIClient, RequestFunction paramRequestFunction, AMFDataList paramAMFDataList) {
	}
	
	public static final int PARAMMETHODNAME = 0;
	
	/**
	 * In case of {@link #play(IClient, RequestFunction, AMFDataList)} and {@link #publish(IClient, RequestFunction, AMFDataList)} this parameter carries the stream name.
	 */
	public static final int PARAM1 = 3;
	
	public static final int PARAM2 = 4;
	
	public static final int PARAM3 = 5;
}
