package com.wowza.wms.application;

import java.io.File;
import java.util.List;
import java.util.Map;

import com.wowza.util.IOPerformanceCounter;
import com.wowza.wms.client.ConnectionCounter;
import com.wowza.wms.client.ConnectionCounterSimple;
import com.wowza.wms.client.IClient;
import com.wowza.wms.client.IClientNotify;
import com.wowza.wms.dvr.DvrApplicationContext;
import com.wowza.wms.dvr.IDvrStreamManager;
import com.wowza.wms.httpstreamer.model.IHTTPSessionNotify;
import com.wowza.wms.httpstreamer.model.IHTTPStreamerApplicationContext;
import com.wowza.wms.httpstreamer.model.IHTTPStreamerSession;
import com.wowza.wms.mediacache.model.MediaCacheSourceFilter;
import com.wowza.wms.mediacaster.IMediaCasterNotify;
import com.wowza.wms.mediacaster.IMediaCasterNotify2;
import com.wowza.wms.mediacaster.IMediaCasterValidateMediaCaster;
import com.wowza.wms.mediacaster.MediaCasterStreamMap;
import com.wowza.wms.module.IModuleNotify;
import com.wowza.wms.module.ModuleFunctions;
import com.wowza.wms.module.ModuleList;
import com.wowza.wms.pushpublish.model.IPushPublishSession;
import com.wowza.wms.pushpublish.model.IPushPublishSessionNotify;
import com.wowza.wms.rtp.model.IRTPSessionNotify;
import com.wowza.wms.rtp.model.RTPSession;
import com.wowza.wms.sharedobject.ISharedObjectNotify;
import com.wowza.wms.sharedobject.ISharedObjects;
import com.wowza.wms.stream.IMediaListProvider;
import com.wowza.wms.stream.IMediaReader;
import com.wowza.wms.stream.IMediaReaderActionNotify;
import com.wowza.wms.stream.IMediaStream;
import com.wowza.wms.stream.IMediaStreamFileMapper;
import com.wowza.wms.stream.IMediaStreamNameAliasProvider;
import com.wowza.wms.stream.IMediaStreamNotify;
import com.wowza.wms.stream.IMediaWriterActionNotify;
import com.wowza.wms.stream.MediaStreamMap;
import com.wowza.wms.stream.livedvr.IDvrStreamManagerActionNotify;
import com.wowza.wms.stream.livedvr.ILiveStreamDvrRecorder;
import com.wowza.wms.stream.livedvr.ILiveStreamDvrRecorderActionNotify;
import com.wowza.wms.stream.livedvr.ILiveStreamDvrRecorderControl;
import com.wowza.wms.stream.livepacketizer.ILiveStreamPacketizer;
import com.wowza.wms.stream.livepacketizer.ILiveStreamPacketizerActionNotify;
import com.wowza.wms.stream.livepacketizer.ILiveStreamPacketizerControl;
import com.wowza.wms.stream.livetranscoder.ILiveStreamTranscoder;
import com.wowza.wms.stream.livetranscoder.ILiveStreamTranscoderControl;
import com.wowza.wms.stream.livetranscoder.ILiveStreamTranscoderNotify;
import com.wowza.wms.stream.livetranscoder.LiveStreamTranscoderApplicationContext;
import com.wowza.wms.stream.publish.Publisher;
import com.wowza.wms.vhost.IVHost;

import edu.emory.mathcs.backport.java.util.concurrent.locks.WMSReadWriteLock;

/**
 * A runtime instance of a Wowza application created dynamically. By default each application will have a default instance called <code>_definst_</code>.
 * Using this interface, you can get the name of your application as well as the instance name. This is the door to access to the configuration properties in the Application.xml. 
 *
 */
public interface IApplicationInstance {

	/**
	 * Attach an instence of @see com.wowza.wms.client.IClientNotify to this application instance, which can be used to get notified when a new client is connected, disconnected, accepted or rejected.
	 * Be careful, this only works for RTMP (Flash) clients.
	 * 
	 * @param clientListener listener instance to add
	 */
	public void addClientListener(IClientNotify clientListener);

	public void addDvrRecorderListener(ILiveStreamDvrRecorderActionNotify paramILiveStreamDvrRecorderActionNotify);

	public void addDvrStreamManagerListener(IDvrStreamManagerActionNotify paramIDvrStreamManagerActionNotify);

	public void addHTTPListener(IHTTPSessionNotify paramIHTTPSessionNotify);

	public void addHTTPStreamerSession(IHTTPStreamerSession paramIHTTPStreamerSession);

	public void addLiveStreamPacketizerListener(ILiveStreamPacketizerActionNotify paramILiveStreamPacketizerActionNotify);

	public void addLiveStreamTranscoderListener(ILiveStreamTranscoderNotify paramILiveStreamTranscoderNotify);

	public void addMediaCasterListener(IMediaCasterNotify paramIMediaCasterNotify);

	public void addMediaCasterListener(IMediaCasterNotify2 paramIMediaCasterNotify2);

	public void addMediaReaderListener(IMediaReaderActionNotify paramIMediaReaderActionNotify);

	public void addMediaStreamListener(IMediaStreamNotify paramIMediaStreamNotify);

	public void addMediaWriterListener(IMediaWriterActionNotify paramIMediaWriterActionNotify);

	public void addModuleListener(IModuleNotify paramIModuleNotify);

	public void addPlayStreamByName(IMediaStream paramIMediaStream, String paramString);

	public void addPublisher(Publisher paramPublisher);

	public void addPushPublishSession(IMediaStream paramIMediaStream, IPushPublishSession paramIPushPublishSession);

	public void addPushPublishSessionListener(IPushPublishSessionNotify paramIPushPublishSessionNotify);

	public void addRTPIncomingDatagramPortAll();

	public void addRTPIncomingDatagramPortRange(int paramInt1, int paramInt2);

	public void addRTPListener(IRTPSessionNotify paramIRTPSessionNotify);

	public void addRTPSession(RTPSession paramRTPSession);

	public void addSharedObjectListener(ISharedObjectNotify paramISharedObjectNotify, boolean paramBoolean);

	public void broadcastMsg(List<IClient> paramList, String paramString);

	public void broadcastMsg(List<IClient> paramList, String paramString, Object[] paramArrayOfObject);

	public void broadcastMsg(String paramString, Object[] paramArrayOfObject);

	public boolean containsDvrRecorder(String paramString);

	public boolean containsHTTPStreamer(String paramString);

	public boolean containsLiveStreamPacketizer(String paramString);

	public boolean containsLiveStreamTranscoder(String paramString);

	public String decodeStorageDir(String paramString);

	public String[] getAllowDomains();

	/**
	 * This method allows you to navigate one level upwards and access the properties of the actual application that this interface is an instance of.
	 * @return the IApplication that this is an instance of
	 */
	public IApplication getApplication();

	public int getApplicationInstanceTouchTimeout();

	public int getApplicationTimeout();

	public IClient getClient(int paramInt);

	public IClient getClientById(int paramInt);

	public int getClientCount();

	public int getClientCountTotal();

	public int getClientIdleFrequency();

	public List<IClient> getClients();

	public WMSReadWriteLock getClientsLockObj();

	public ConnectionCounter getConnectionCounter();

	public ConnectionCounterSimple getConnectionCounter(int paramInt);

	public String getContextStr();

	public String getDateStarted();

	public DvrApplicationContext getDvrApplicationContext();

	public WMSProperties getDvrProperties();

	public String getDvrRecorderList();

	public IHTTPStreamerApplicationContext getHTTPStreamerApplicationContext(String paramString, boolean paramBoolean);

	public String getHTTPStreamerList();

	public WMSProperties getHTTPStreamerProperties();

	public int getHTTPStreamerSessionCount();

	public int getHTTPStreamerSessionCount(int paramInt);

	public int getHTTPStreamerSessionCount(int paramInt, String paramString);

	public int getHTTPStreamerSessionCount(String paramString);

	public Map<String, Integer> getHTTPStreamerSessionCountsByName(int paramInt);

	public List<IHTTPStreamerSession> getHTTPStreamerSessions();

	public List<IHTTPStreamerSession> getHTTPStreamerSessions(int paramInt);

	public List<IHTTPStreamerSession> getHTTPStreamerSessions(int paramInt, String paramString);

	public List<IHTTPStreamerSession> getHTTPStreamerSessions(String paramString);

	public IOPerformanceCounter getIOPerformanceCounter();

	public IOPerformanceCounter getIOPerformanceCounter(int paramInt);

	public long getLastTouchTime();

	public ILiveStreamDvrRecorderControl getLiveStreamDvrRecorderControl();

	public ILiveStreamPacketizerControl getLiveStreamPacketizerControl();

	public String getLiveStreamPacketizerList();

	public WMSProperties getLiveStreamPacketizerProperties();

	public ILiveStreamTranscoderControl getLiveStreamTranscoderControl();

	public String getLiveStreamTranscoderList();

	public WMSProperties getManagerProperties();

	public int getMaximumPendingReadBytes();

	public int getMaximumPendingWriteBytes();

	public int getMaximumSetBufferTime();

	public int getMaxStorageDirDepth();

	public List<MediaCacheSourceFilter> getMediaCacheFilters();

	public WMSProperties getMediaCasterProperties();

	public int getMediacasterRTPRTSPRTPTransportMode();

	public MediaCasterStreamMap getMediaCasterStreams();

	public IMediaCasterValidateMediaCaster getMediaCasterValidator();

	public IMediaListProvider getMediaListProvider();

	public int getMediaReaderContentType(String paramString);

	public WMSProperties getMediaReaderProperties();

	public WMSProperties getMediaWriterProperties();

	public ModuleFunctions getModFunctions();

	public Object getModuleInstance(String paramString);

	public ModuleList getModuleList();

	/**
	 * The name of the application instance, which is by default {@code _definst_}.
	 * @return name of the application instance
	 */
	public String getName();

	public int getPingTimeout();

	public int getPlayStreamCount(String paramString);

	public Map<String, Integer> getPlayStreamCountsByName();

	public List<IMediaStream> getPlayStreamsByName(String paramString);

	/**
	 * Returns the properties of the application instance, that you can configure in the <code>Application.xml</code> file's Properties section.
	 * @return the application instance level properties
	 */
	public WMSProperties getProperties();

	public boolean[] getProtocolUsage();

	public void getProtocolUsage(boolean[] paramArrayOfBoolean);

	public int getPublisherCount();

	public List<Publisher> getPublishers();

	public List<String> getPublishStreamNames();

	public int getPushPublishSessionCount();

	public List<IPushPublishSession> getPushPublishSessions();

	public List<IPushPublishSession> getPushPublishSessions(IMediaStream paramIMediaStream);

	public String getRepeaterOriginUrl();

	public String getRepeaterQueryString();

	public String getRsoStorageDir();

	public String getRsoStoragePath();

	public int getRTPAVSyncMethod();

	public int getRTPIdleFrequency();

	public int getRTPMaxRTCPWaitTime();

	public String getRTPPlayAuthenticationMethod();

	public WMSProperties getRTPProperties();

	public String getRTPPublishAuthenticationMethod();

	public int getRTPSessionCount();

	public int getRTPSessionCount(String paramString);

	public Map<String, Integer> getRTPSessionCountsByName();

	public List<RTPSession> getRTPSessions();

	public List<RTPSession> getRTPSessions(String paramString);

	public String getRTSPBindIpAddress();

	public String getRTSPConnectionAddressType();

	public String getRTSPConnectionIpAddress();

	public int getRTSPMaximumPendingWriteBytes();

	public String getRTSPOriginAddressType();

	public String getRTSPOriginIpAddress();

	public int getRTSPSessionTimeout();

	public String getSharedObjectReadAccess();

	public ISharedObjects getSharedObjects();

	public ISharedObjects getSharedObjects(boolean paramBoolean);

	public String getSharedObjectWriteAccess();

	public String getStreamAudioSampleAccess();

	public int getStreamCount();

	public IMediaStreamFileMapper getStreamFileMapper();

	public String getStreamKeyDir();

	public String getStreamKeyPath();

	public IMediaStreamNameAliasProvider getStreamNameAliasProvider();

	public WMSProperties getStreamProperties();

	public String getStreamReadAccess();

	public WMSProperties getStreamRecorderProperties();

	public MediaStreamMap getStreams();

	public String getStreamStorageDir();

	public String getStreamStoragePath();

	public String getStreamType();

	public String getStreamVideoSampleAccess();

	public String getStreamWriteAccess();

	public WMSProperties getTimedTextProperties();

	public String getTimeRunning();

	public double getTimeRunningSeconds();

	public LiveStreamTranscoderApplicationContext getTranscoderApplicationContext();

	public WMSProperties getTranscoderProperties();

	public int getValidationFrequency();

	public IVHost getVHost();

	public String getVODTimedTextProviderList();

	public List<String> getVODTimedTextProviderSet();

	public void incClientCountTotal();

	public boolean isAcceptConnection();

	public boolean isDebugAppTimeout();

	public boolean isMediaCacheSourceAllowed(String paramString);

	public boolean isRTPIncomingDatagramPortValid(int paramInt);

	public boolean isValidateFMLEConnections();

	public void notifyDvrStreamManagerCreate(IDvrStreamManager paramIDvrStreamManager, String paramString);

	public void notifyDvrStreamManagerDestroy(IDvrStreamManager paramIDvrStreamManager);

	public void notifyDvrStreamManagerInit(IDvrStreamManager paramIDvrStreamManager);

	public void notifyHTTPSessionCreate(IHTTPStreamerSession paramIHTTPStreamerSession);

	public void notifyHTTPSessionDestroy(IHTTPStreamerSession paramIHTTPStreamerSession);

	public void notifyLiveStreamDvrRecorderCreate(ILiveStreamDvrRecorder paramILiveStreamDvrRecorder, String paramString);

	public void notifyLiveStreamDvrRecorderDestroy(ILiveStreamDvrRecorder paramILiveStreamDvrRecorder);

	public void notifyLiveStreamDvrRecorderInit(ILiveStreamDvrRecorder paramILiveStreamDvrRecorder, String paramString);

	public void notifyLiveStreamPacketizerCreate(ILiveStreamPacketizer paramILiveStreamPacketizer, String paramString);

	public void notifyLiveStreamPacketizerDestroy(ILiveStreamPacketizer paramILiveStreamPacketizer);

	public void notifyLiveStreamPacketizerInit(ILiveStreamPacketizer paramILiveStreamPacketizer, String paramString);

	public void notifyLiveStreamTranscoderCreate(ILiveStreamTranscoder paramILiveStreamTranscoder, IMediaStream paramIMediaStream);

	public void notifyLiveStreamTranscoderDestroy(ILiveStreamTranscoder paramILiveStreamTranscoder, IMediaStream paramIMediaStream);

	public void notifyLiveStreamTranscoderInit(ILiveStreamTranscoder paramILiveStreamTranscoder, IMediaStream paramIMediaStream);

	public void notifyMediaReaderClose(IMediaReader paramIMediaReader, IMediaStream paramIMediaStream);

	public void notifyMediaReaderCreate(IMediaReader paramIMediaReader);

	public void notifyMediaReaderExtractMetaData(IMediaReader paramIMediaReader, IMediaStream paramIMediaStream);

	public void notifyMediaReaderInit(IMediaReader paramIMediaReader, IMediaStream paramIMediaStream);

	public void notifyMediaReaderOpen(IMediaReader paramIMediaReader, IMediaStream paramIMediaStream);

	public void notifyMediaWriterOnFLVAddMetadata(IMediaStream paramIMediaStream, Map<String, Object> paramMap);

	public void notifyMediaWriterOnWriteComplete(IMediaStream paramIMediaStream, File paramFile);

	public void notifyPushPublishSessionCreate(String paramString, IMediaStream paramIMediaStream,
			IPushPublishSession paramIPushPublishSession);

	public void notifyPushPublishSessionDestroy(String paramString, IMediaStream paramIMediaStream,
			IPushPublishSession paramIPushPublishSession);

	public void notifyRTPSessionCreate(RTPSession paramRTPSession);

	public void notifyRTPSessionDestroy(RTPSession paramRTPSession);

	public void parseAllowDomains(String paramString);

	public String readAppInstConfig(String paramString);

	public void registerPlayRTPSession(RTPSession paramRTPSession);

	/**
	 * This can be used to remove the listener that you have previously added using @{see {@link #addClientListener(IClientNotify)}
	 *  
	 * @param clientListener listener object to be removed
	 */
	public void removeClientListener(IClientNotify clientListener);

	public void removeDvrRecorderListener(ILiveStreamDvrRecorderActionNotify paramILiveStreamDvrRecorderActionNotify);

	public void removeDvrStreamManagerListener(IDvrStreamManagerActionNotify paramIDvrStreamManagerActionNotify);

	public void removeHTTPListener(IHTTPSessionNotify paramIHTTPSessionNotify);

	public void removeHTTPStreamerSession(IHTTPStreamerSession paramIHTTPStreamerSession);

	public void removeLiveStreamPacketizerListener(ILiveStreamPacketizerActionNotify paramILiveStreamPacketizerActionNotify);

	public void removeLiveStreamTranscoderListener(ILiveStreamTranscoderNotify paramILiveStreamTranscoderNotify);

	public void removeMediaCasterListener(IMediaCasterNotify paramIMediaCasterNotify);

	public void removeMediaReaderListener(IMediaReaderActionNotify paramIMediaReaderActionNotify);

	public void removeMediaStreamListener(IMediaStreamNotify paramIMediaStreamNotify);

	public void removeMediaWriterListener(IMediaWriterActionNotify paramIMediaWriterActionNotify);

	public void removeModuleListener(IModuleNotify paramIModuleNotify);

	public void removePlayStreamByName(IMediaStream paramIMediaStream);

	public void removePublisher(Publisher paramPublisher);

	public void removePushPublishSession(IMediaStream paramIMediaStream, IPushPublishSession paramIPushPublishSession);

	public void removePushPublishSessionListener(IPushPublishSessionNotify paramIPushPublishSessionNotify);

	public void removePushPublishSessions(IMediaStream paramIMediaStream);

	public void removeRTPListener(IRTPSessionNotify paramIRTPSessionNotify);

	public void removeRTPSession(RTPSession paramRTPSession);

	public void removeSharedObjectListener(ISharedObjectNotify paramISharedObjectNotify, boolean paramBoolean);

	public boolean resetMediaCasterStream(String paramString);

	public boolean resetMediaCasterStream(String paramString1, String paramString2);

	public void setAcceptConnection(boolean paramBoolean);

	public void setAllowDomains(String[] paramArrayOfString);

	public void setApplicationInstanceTouchTimeout(int paramInt);

	public void setApplicationTimeout(int paramInt);

	public void setClientIdleFrequency(int paramInt);

	public void setDebugAppTimeout(boolean paramBoolean);

	public void setDvrRecorderList(String paramString);

	public void setHTTPStreamerList(String paramString);

	public void setLiveStreamDvrRecorderControl(ILiveStreamDvrRecorderControl paramILiveStreamDvrRecorderControl);

	public void setLiveStreamPacketizerControl(ILiveStreamPacketizerControl paramILiveStreamPacketizerControl);

	public void setLiveStreamPacketizerList(String paramString);

	public void setLiveStreamTranscoderControl(ILiveStreamTranscoderControl paramILiveStreamTranscoderControl);

	public void setLiveStreamTranscoderList(String paramString);

	public void setMaximumPendingReadBytes(int paramInt);

	public void setMaximumPendingWriteBytes(int paramInt);

	public void setMaximumSetBufferTime(int paramInt);

	public void setMaxStorageDirDepth(int paramInt);

	public void setMediacasterRTPRTSPRTPTransportMode(int paramInt);

	public void setMediaCasterValidator(IMediaCasterValidateMediaCaster paramIMediaCasterValidateMediaCaster);

	/**
	 * Sets a custom media list provider for this application instance that will catch all requests to streams with the amlst: prefix (for API based MediaList).
	 * This allows you to programmatically define the streams in a stream name group with all relevant parameters. For further information and example check out:
	 * https://www.wowza.com/forums/content.php?330-How-to-use-Java-API-calls-to-resolve-SMIL-file-requests
	 *   
	 * @param paramIMediaListProvider your custom media list provider implementation
	 */
	public void setMediaListProvider(IMediaListProvider paramIMediaListProvider);

	public void setName(String paramString);

	public void setPingTimeout(int paramInt);

	public void setRepeaterOriginUrl(String paramString);

	public void setRepeaterQueryString(String paramString);

	public void setRsoStorageDir(String paramString);

	public void setRTPAVSyncMethod(int paramInt);

	public void setRTPIdleFrequency(int paramInt);

	public void setRTPMaxRTCPWaitTime(int paramInt);

	public void setRTPPlayAuthenticationMethod(String paramString);

	public void setRTPPublishAuthenticationMethod(String paramString);

	public void setRTSPBindIpAddress(String paramString);

	public void setRTSPConnectionAddressType(String paramString);

	public void setRTSPConnectionIpAddress(String paramString);

	public void setRTSPMaximumPendingWriteBytes(int paramInt);

	public void setRTSPOriginAddressType(String paramString);

	public void setRTSPOriginIpAddress(String paramString);

	public void setRTSPSessionTimeout(int paramInt);

	public void setSharedObjectReadAccess(String paramString);

	public void setSharedObjectWriteAccess(String paramString);

	public void setStreamAudioSampleAccess(String paramString);

	public void setStreamFileMapper(IMediaStreamFileMapper paramIMediaStreamFileMapper);

	public void setStreamKeyDir(String paramString);

	public void setStreamNameAliasProvider(IMediaStreamNameAliasProvider paramIMediaStreamNameAliasProvider);

	public void setStreamReadAccess(String paramString);

	public void setStreamStorageDir(String paramString);

	public void setStreamType(String paramString);

	public void setStreamVideoSampleAccess(String paramString);

	public void setStreamWriteAccess(String paramString);

	public void setValidateFMLEConnections(boolean paramBoolean);

	public void setValidationFrequency(int paramInt);

	public void setVODTimedTextProviderList(String paramString);

	public void shutdown(boolean paramBoolean1, boolean paramBoolean2);

	/**
	 * Shut down a particular RTMP client. (Not any other!)
	 * @param paramIClient the client that you want to shut down
	 */
	public void shutdownClient(IClient paramIClient);

	/**
	 * Start a stream with the given name. You need to have a stream file that contains the URL to the stream (RTSP URL, SHOUTcast URL, full RTMP URL),
	 * and streamName has to match the name of that file, e.g. football.stream.
	 * 
	 * See this forum thread for some more details: http://www.wowza.com/forums/content.php?166-Sample-code-to-use-MediaCaster-API-to-start-stop-a-stream
	 * 
	 * @param streamName name of the stream to start
	 * @param mediaCasterType type of the stream, one of these magic Strings: rtp,shoutcast,liverepeater, etc
	 * @return true if the stream could be started, false otherwise
	 */
	public boolean startMediaCasterStream(String streamName, String mediaCasterType);

	/**
	 * Start a stream with the given name. You need to have a stream file that contains the URL to the stream (RTSP URL, SHOUTcast URL, full RTMP URL),
	 * and streamName has to match the name of that file, e.g. football.stream.
	 * 
	 * See this forum thread for some more details: http://www.wowza.com/forums/content.php?166-Sample-code-to-use-MediaCaster-API-to-start-stop-a-stream
	 * 
	 * @param streamName name of the stream to start
	 * @param streamExt stream extension according to official docs, but not sure what they mean. Do you know?
	 * @param mediaCasterType type of the stream, one of these magic Strings: rtp,shoutcast,liverepeater, etc
	 * @return true if the stream could be started, false otherwise
	 */
	public boolean startMediaCasterStream(String streamName, String streamExt, String mediaCasterType);

	/**
	 * This can be used to stop a particular stream.
	 * 
	 * See this forum thread for some more details: http://www.wowza.com/forums/content.php?166-Sample-code-to-use-MediaCaster-API-to-start-stop-a-stream
	 * 
	 * @param streamName name of the stream to stop
	 */
	public void stopMediaCasterStream(String streamName);

	public void touch();

	public boolean writeAppInstConfig(String paramString1, String paramString2);
	
	/**
	 * Returns true if the stream type for the particular application instance is a live stream type.
	 * @since 4.1.2
	 * @return true if the stream type is live
	 */
	public boolean isLive();
}
