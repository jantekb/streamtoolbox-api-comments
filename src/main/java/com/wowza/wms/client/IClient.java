package com.wowza.wms.client;

import java.io.File;
import java.util.List;

import com.wowza.util.ElapsedTimer;
import com.wowza.util.IOPerformanceCounter;
import com.wowza.wms.amf.AMFData;
import com.wowza.wms.amf.AMFDataObj;
import com.wowza.wms.amf.AMFObj;
import com.wowza.wms.application.IApplication;
import com.wowza.wms.application.IApplicationInstance;
import com.wowza.wms.application.WMSProperties;
import com.wowza.wms.module.IModuleCallResult;
import com.wowza.wms.module.IModulePingResult;
import com.wowza.wms.protocol.wowz.WOWZSession;
import com.wowza.wms.response.ResponseFunctions;
import com.wowza.wms.rtp.model.RTPStream;
import com.wowza.wms.stream.FastPlaySettings;
import com.wowza.wms.stream.IMediaStream;
import com.wowza.wms.vhost.HostPort;
import com.wowza.wms.vhost.IVHost;

 public interface IClient {

	/**
	 * From the official release notes: "enable removal of the clientid item from the onConnect result for RTMP connections (default is to send clientid)"
	 * @since 4.1.1
	 * @return true if client id sending is on
	 */
	boolean isAcceptConnectionSendClientId();
	
	/**
	 * From the official release notes: "enable removal of the clientid item from the onConnect result for RTMP connections (default is to send clientid)"
	 * @since 4.1.1
	 * @param acceptConnectionSendClientId true if client id sending is switched on
	 */
	void setAcceptConnectionSendClientId(boolean acceptConnectionSendClientId);
	
	/**
	 * 
	 * @return
	 */
	 int getClientId();
	
	/**
	 * 
	 * @return
	 */
	 String getFlashVer();
	
	/**
	 * 
	 * @param paramString
	 */
	void setFlashVer(String paramString);
	
	/**
	 * 
	 * @return
	 */
	IOPerformanceCounter getTotalIOPerformanceCounter();
	
	/**
	 * 
	 * @return
	 */
	IOPerformanceCounter getMediaIOPerformanceCounter();
	
	/**
	 * 
	 * @return
	 */
	IApplicationInstance getAppInstance();

	/**
	 * 
	 * @return
	 */
	IApplication getApplication();
	
	/**
	 * 
	 * @return
	 */
	 List getPlayStreams();
	/**
	 * 
	 * @return
	 */
	 List getPublishStreams();
	/**
	 * 
	 * @return
	 */
	 int getPlayStreamCount();
	/**
	 * 
	 * @return
	 */
	 int getPublishStreamCount();

	/**
	 * 
	 */
	 void shutdownClient();

	/**
	 * 
	 */
	 void touch();

	/**
	 * 
	 * @return
	 */
	 boolean isConnected();

	/**
	 * 
	 * @return
	 */
	 WMSProperties getProperties();

	/**
	 * 
	 * @return
	 */
	 String getStreamType();

	/**
	 * 
	 * @param paramString
	 */
	 void setStreamType(String paramString);

	/**
	 * 
	 * @return
	 */
	 boolean isAcceptConnection();

	/**
	 * 
	 */
	 void acceptConnection();

	/**
	 * 
	 * @param paramString
	 */
	 void acceptConnection(String paramString);

	/**
	 * 
	 * @param paramAMFData
	 */
	 void acceptConnection(AMFData paramAMFData);

	/**
	 * 
	 */
	 void rejectConnection();

	/**
	 * 
	 * @param paramString
	 */
	 void rejectConnection(String paramString);

	/**
	 * 
	 * @param paramAMFData
	 */
	 void rejectConnection(AMFData paramAMFData);

	/**
	 * 
	 * @param paramString1
	 * @param paramString2
	 */
	 void rejectConnection(String paramString1, String paramString2);

	/**
	 * 
	 * @param paramString
	 * @param paramAMFData
	 */
	 void rejectConnection(String paramString, AMFData paramAMFData);

	/**
	 * 
	 * @param paramString
	 */
	 void redirectConnection(String paramString);

	/**
	 * 
	 * @param paramString1
	 * @param paramString2
	 */
	 void redirectConnection(String paramString1, String paramString2);

	/**
	 * 
	 * @param paramString1
	 * @param paramString2
	 * @param paramString3
	 */
	 void redirectConnection(String paramString1, String paramString2, String paramString3);

	/**
	 * 
	 * @param paramString1
	 * @param paramString2
	 * @param paramAMFData
	 */
	 void redirectConnection(String paramString1, String paramString2, AMFData paramAMFData);

	/**
	 * 
	 * @return
	 */
	 IVHost getVHost();

	/**
	 * 
	 * @param paramString
	 * @param paramIModuleCallResult
	 * @param paramArrayOfObject
	 */
	 void call(String paramString, IModuleCallResult paramIModuleCallResult,
			Object[] paramArrayOfObject);

	/**
	 * 
	 * @param paramString
	 */
	 void call(String paramString);

	/**
	 * 
	 * @param paramIModulePingResult
	 * @return
	 */
	 int ping(IModulePingResult paramIModulePingResult);

	/**
	 * 
	 * @return
	 */
	 String getIp();

	/**
	 * 
	 * @return
	 */
	 FastPlaySettings getFastPlaySettings();

	/**
	 * 
	 * @param paramFastPlaySettings
	 */
	 void setFastPlaySettings(FastPlaySettings paramFastPlaySettings);

	/**
	 * 
	 */
	 void clearFastPlaySettings();

	/**
	 * 
	 * @return
	 */
	 ResponseFunctions getRespFunctions();

	/**
	 * 
	 * @return
	 */
	 long getConnectTime();

	/**
	 * 
	 * @return
	 */
	 long getPingRoundTripTime();

	/**
	 * 
	 * @return
	 */
	 String getDateStarted();

	/**
	 * 
	 * @return
	 */
	 String getTimeRunning();

	/**
	 * 
	 * @return
	 */
	 double getTimeRunningSeconds();

	/**
	 * 
	 * @param paramString
	 * @return
	 */
	 File getStreamFile(String paramString);

	/**
	 * 
	 * @param paramString1
	 * @param paramString2
	 * @return
	 */
	 File getStreamFile(String paramString1, String paramString2);

	/**
	 * 
	 * @param paramString1
	 * @param paramString2
	 * @param paramBoolean
	 * @return
	 */
	 File getStreamFile(String paramString1, String paramString2, boolean paramBoolean);

	/**
	 * 
	 * @return
	 */
	 int getBufferTime();

	/**
	 * 
	 * @param paramInt
	 */
	 void setBufferTime(int paramInt);

	/**
	 * 
	 * @param paramInt
	 * @return
	 */
	 AMFObj getResponseAMFObj(int paramInt);

	/**
	 * 
	 * @param paramIMediaStream
	 * @return
	 */
	 AMFObj getRespAMFAudioObj(IMediaStream paramIMediaStream);

	/**
	 * 
	 * @param paramIMediaStream
	 * @return
	 */
	 AMFObj getRespAMFVideoObj(IMediaStream paramIMediaStream);

	/**
	 * 
	 * @param paramIMediaStream
	 * @return
	 */
	 AMFObj getRespAMFDataObj(IMediaStream paramIMediaStream);

	/**
	 * 
	 * @return
	 */
	 String getQueryStr();

	/**
	 * 
	 * @return
	 */
	 String getReferrer();

	/**
	 * 
	 * @return
	 */
	 String getPageUrl();

	/**
	 * 
	 * @return
	 */
	 String getUri();

	/**
	 * 
	 * @return
	 */
	 int getProtocol();

	/**
	 * 
	 * @return
	 */
	 HostPort getServerHostPort();

	/**
	 * 
	 * @return
	 */
	 boolean isSecure();

	/**
	 * 
	 * @return
	 */
	 boolean isSSL();

	/**
	 * 
	 * @return
	 */
	 boolean isEncrypted();

	/**
	 * 
	 * @return
	 */
	 int getIdleFrequency();

	/**
	 * 
	 * @param paramInt
	 */
	 void setIdleFrequency(int paramInt);

	/**
	 * 
	 * @return
	 */
	 String getSharedObjectReadAccess();

	/**
	 * 
	 * @param paramString
	 */
	 void setSharedObjectReadAccess(String paramString);

	/**
	 * 
	 * @return
	 */
	 String getSharedObjectWriteAccess();

	/**
	 * 
	 * @param paramString
	 */
	 void setSharedObjectWriteAccess(String paramString);

	/**
	 * 
	 * @return
	 */
	 String getStreamVideoSampleAccess();

	/**
	 * 
	 * @param paramString
	 */
	 void setStreamVideoSampleAccess(String paramString);

	/**
	 * 
	 * @return
	 */
	 String getStreamAudioSampleAccess();

	/**
	 * 
	 * @param paramString
	 */
	 void setStreamAudioSampleAccess(String paramString);

	/**
	 * 
	 * @return
	 */
	 String getStreamReadAccess();

	/**
	 * 
	 * @param paramString
	 */
	 void setStreamReadAccess(String paramString);

	/**
	 * 
	 * @return
	 */
	 String getStreamWriteAccess();

	/**
	 * 
	 * @param paramString
	 */
	 void setStreamWriteAccess(String paramString);

	/**
	 * 
	 * @return
	 */
	 ClientWriteListener getWriteListener();

	/**
	 * 
	 * @param paramString
	 * @param paramAMFDataObj
	 */
	 void addAcceptConnectionAttribute(String paramString, AMFDataObj paramAMFDataObj);

	/**
	 * 
	 * @param paramString1
	 * @param paramString2
	 */
	 void addAcceptConnectionAttribute(String paramString1, String paramString2);

	/**
	 * 
	 * @return
	 */
	 String getRepeaterOriginUrl();

	/**
	 * 
	 * @param paramString
	 */
	 void setRepeaterOriginUrl(String paramString);

	/**
	 * 
	 * @return
	 */
	 long getLastValidateTime();

	/**
	 * 
	 * @param paramLong
	 */
	 void setLastValidateTime(long paramLong);

	/**
	 * 
	 * @return
	 */
	 int getPingTimeout();

	/**
	 * 
	 * @return
	 */
	 boolean isLiveRepeater();

	/**
	 * 
	 * @return
	 */
	 boolean isFlashVersionH264Capable();

	/**
	 * 
	 * @return
	 */
	 boolean isFlashVersion90115();

	/**
	 * 
	 * @return
	 */
	 boolean isFlashVersion10();

	/**
	 * 
	 * @return
	 */
	 boolean isFlashMediaLiveEncoder();

	/**
	 * 
	 * @param paramArrayOfInt
	 * @return
	 */
	 int testFlashVersion(int[] paramArrayOfInt);

	/**
	 * 
	 * @return
	 */
	 boolean isObjectEncodingAMF3();

	/**
	 * 
	 * @return
	 */
	 boolean isObjectEncodingAMF0();

	/**
	 * 
	 * @param paramInt
	 */
	 void setObjectEncoding(int paramInt);

	/**
	 * 
	 * @return
	 */
	 int getObjectEncoding();

	/**
	 * 
	 * @param paramAMFData
	 */
	 void setAcceptConnectionObj(AMFData paramAMFData);

	/**
	 * 
	 * @param paramString
	 */
	 void setAcceptConnectionDescription(String paramString);

	/**
	 * 
	 * @param paramAMFDataObj
	 */
	 void setAcceptConnectionExObj(AMFDataObj paramAMFDataObj);

	/**
	 * 
	 * @return
	 */
	 RTPStream getRTPStream();

	/**
	 * 
	 * @param paramBoolean
	 */
	 void setAcceptConnection(boolean paramBoolean);

	/**
	 * 
	 * @param paramBoolean
	 */
	 void setShutdownClient(boolean paramBoolean);

	/**
	 * 
	 * @param paramIVHost
	 */
	 void reparentClient(IVHost paramIVHost);

	/**
	 * 
	 * @return
	 */
	 int getMaximumSetBufferTime();

	/**
	 * 
	 * @return
	 */
	 int getMaximumPendingWriteBytes();

	/**
	 * 
	 * @return
	 */
	 String getLiveStreamPacketizerList();

	/**
	 * 
	 * @param paramString
	 */
	 void setLiveStreamPacketizerList(String paramString);

	/**
	 * 
	 * @return
	 */
	 String getLiveStreamTranscoderList();

	/**
	 * 
	 * @param paramString
	 */
	 void setLiveStreamTranscoderList(String paramString);

	/**
	 * 
	 * @return
	 */
	 ElapsedTimer getElapsedTime();

	/**
	 * 
	 * @return
	 */
	 int getLiveRepeaterCapabilities();

	/**
	 * 
	 * @param paramInt
	 */
	 void setLiveRepeaterCapabilities(int paramInt);

	/**
	 * 
	 * @param paramString
	 */
	 void fcSubscribe(String paramString);

	/**
	 * 
	 * @param paramString1
	 * @param paramString2
	 */
	 void fcSubscribe(String paramString1, String paramString2);

	/**
	 * 
	 */
	 void fcUnSubscribeAll();

	/**
	 * 
	 * @param paramString
	 */
	 void fcUnSubscribe(String paramString);

	/**
	 * 
	 * @return
	 */
	 boolean isValidateFMLEConnections();

	/**
	 * 
	 * @param paramBoolean
	 */
	 void setValidateFMLEConnections(boolean paramBoolean);

	/**
	 * 
	 */
	 void setThreadContext();

	/**
	 * 
	 * @return
	 */
	 WOWZSession getWowzSession();
	
	/**
	 * 
	 * @param paramWOWZSession
	 */
	 void setWowzSession(WOWZSession paramWOWZSession);
	
	/**
	 * 
	 * @return
	 */
	 boolean isSendCloseOnRejectConnection();
	
	/**
	 * 
	 * @param paramBoolean
	 */
	 void setSendCloseOnRejectConnection(boolean paramBoolean);

}
