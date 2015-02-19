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
 * A runtime instance of a Wowza application created dynamicall. By default each application will have a default instance called <code>_definst_</code>.
 * Using this interface, you can get the name of your application as well as the instance name. This is the door to access to the configuration properties in the Application.xml. 
 *
 */
public interface IApplicationInstance {

	/**
	 * Shut down a particular RTMP client. (Not any other!)
	 * @param paramIClient the client that you want to shut down
	 */
	public abstract void shutdownClient(IClient paramIClient);

	public abstract void shutdown(boolean paramBoolean1, boolean paramBoolean2);

	/**
	 * This method allows you to navigate one level upwards and access the properties of the actual application that this interface is an instance of.
	 * @return the {@see IApplication} that this is an instance of
	 */
	public abstract IApplication getApplication();

	/**
	 * The name of the application instance, which is by default {@code _definst_}.
	 * @return
	 */
	public abstract String getName();

	public abstract void setName(String paramString);

	public abstract MediaStreamMap getStreams();

	public abstract IVHost getVHost();

	public abstract WMSProperties getProperties();

	public abstract WMSProperties getManagerProperties();

	public abstract String getStreamType();

	public abstract void setStreamType(String paramString);

	public abstract boolean isAcceptConnection();

	public abstract void setAcceptConnection(boolean paramBoolean);

	public abstract int getClientCountTotal();

	public abstract void incClientCountTotal();

	public abstract int getClientCount();

	public abstract IClient getClientById(int paramInt);

	public abstract List<IClient> getClients();

	public abstract IClient getClient(int paramInt);

	public abstract ISharedObjects getSharedObjects();

	public abstract ISharedObjects getSharedObjects(boolean paramBoolean);

	public abstract void addClientListener(IClientNotify paramIClientNotify);

	public abstract void removeClientListener(IClientNotify paramIClientNotify);

	public abstract void addMediaStreamListener(IMediaStreamNotify paramIMediaStreamNotify);

	public abstract void removeMediaStreamListener(IMediaStreamNotify paramIMediaStreamNotify);

	public abstract void addSharedObjectListener(ISharedObjectNotify paramISharedObjectNotify, boolean paramBoolean);

	public abstract void removeSharedObjectListener(ISharedObjectNotify paramISharedObjectNotify, boolean paramBoolean);

	public abstract void addMediaCasterListener(IMediaCasterNotify paramIMediaCasterNotify);

	public abstract void addMediaCasterListener(IMediaCasterNotify2 paramIMediaCasterNotify2);

	public abstract void removeMediaCasterListener(IMediaCasterNotify paramIMediaCasterNotify);

	public abstract ConnectionCounter getConnectionCounter();

	public abstract ConnectionCounterSimple getConnectionCounter(int paramInt);

	public abstract String getDateStarted();

	public abstract String getTimeRunning();

	public abstract double getTimeRunningSeconds();

	public abstract void broadcastMsg(List<IClient> paramList, String paramString);

	public abstract void broadcastMsg(List<IClient> paramList, String paramString, Object[] paramArrayOfObject);

	public abstract void broadcastMsg(String paramString, Object[] paramArrayOfObject);

	public abstract IOPerformanceCounter getIOPerformanceCounter();

	public abstract IOPerformanceCounter getIOPerformanceCounter(int paramInt);

	public abstract void addPlayStreamByName(IMediaStream paramIMediaStream, String paramString);

	public abstract void removePlayStreamByName(IMediaStream paramIMediaStream);

	public abstract Map<String, Integer> getPlayStreamCountsByName();

	public abstract int getPlayStreamCount(String paramString);

	public abstract List<IMediaStream> getPlayStreamsByName(String paramString);

	public abstract MediaCasterStreamMap getMediaCasterStreams();

	public abstract int getStreamCount();

	public abstract ModuleFunctions getModFunctions();

	public abstract void addModuleListener(IModuleNotify paramIModuleNotify);

	public abstract void removeModuleListener(IModuleNotify paramIModuleNotify);

	public abstract ModuleList getModuleList();

	public abstract Object getModuleInstance(String paramString);

	public abstract int getApplicationTimeout();

	public abstract void setApplicationTimeout(int paramInt);

	public abstract int getPingTimeout();

	public abstract void setPingTimeout(int paramInt);

	public abstract int getValidationFrequency();

	public abstract void setValidationFrequency(int paramInt);

	public abstract int getMaximumPendingWriteBytes();

	public abstract void setMaximumPendingWriteBytes(int paramInt);

	public abstract int getMaximumPendingReadBytes();

	public abstract void setMaximumPendingReadBytes(int paramInt);

	public abstract void setMaximumSetBufferTime(int paramInt);

	public abstract int getMaximumSetBufferTime();

	public abstract String getRepeaterOriginUrl();

	public abstract void setRepeaterOriginUrl(String paramString);

	public abstract String getRepeaterQueryString();

	public abstract void setRepeaterQueryString(String paramString);

	public abstract String[] getAllowDomains();

	public abstract void setAllowDomains(String[] paramArrayOfString);

	public abstract void parseAllowDomains(String paramString);

	public abstract int getClientIdleFrequency();

	public abstract void setClientIdleFrequency(int paramInt);

	public abstract int getRTPIdleFrequency();

	public abstract void setRTPIdleFrequency(int paramInt);

	public abstract String getStreamStorageDir();

	public abstract void setStreamStorageDir(String paramString);

	public abstract String getStreamKeyDir();

	public abstract void setStreamKeyDir(String paramString);

	public abstract String getRsoStorageDir();

	public abstract void setRsoStorageDir(String paramString);

	public abstract String getStreamKeyPath();

	public abstract String getStreamStoragePath();

	public abstract String getRsoStoragePath();

	public abstract String getStreamVideoSampleAccess();

	public abstract void setStreamVideoSampleAccess(String paramString);

	public abstract String getStreamAudioSampleAccess();

	public abstract void setStreamAudioSampleAccess(String paramString);

	public abstract String getStreamReadAccess();

	public abstract void setStreamReadAccess(String paramString);

	public abstract String getStreamWriteAccess();

	public abstract void setStreamWriteAccess(String paramString);

	public abstract String getSharedObjectReadAccess();

	public abstract void setSharedObjectReadAccess(String paramString);

	public abstract String getSharedObjectWriteAccess();

	public abstract void setSharedObjectWriteAccess(String paramString);

	public abstract String getRTPPublishAuthenticationMethod();

	public abstract void setRTPPublishAuthenticationMethod(String paramString);

	public abstract String getRTPPlayAuthenticationMethod();

	public abstract void setRTPPlayAuthenticationMethod(String paramString);

	public abstract int getRTPAVSyncMethod();

	public abstract void setRTPAVSyncMethod(int paramInt);

	public abstract int getRTPMaxRTCPWaitTime();

	public abstract void setRTPMaxRTCPWaitTime(int paramInt);

	public abstract List<RTPSession> getRTPSessions(String paramString);

	public abstract List<RTPSession> getRTPSessions();

	public abstract Map<String, Integer> getRTPSessionCountsByName();

	public abstract int getRTPSessionCount(String paramString);

	public abstract int getRTPSessionCount();

	public abstract void addRTPSession(RTPSession paramRTPSession);

	public abstract void registerPlayRTPSession(RTPSession paramRTPSession);

	public abstract void removeRTPSession(RTPSession paramRTPSession);

	public abstract WMSReadWriteLock getClientsLockObj();

	public abstract WMSProperties getStreamProperties();

	public abstract WMSProperties getMediaCasterProperties();

	public abstract WMSProperties getMediaReaderProperties();

	public abstract WMSProperties getMediaWriterProperties();

	public abstract WMSProperties getRTPProperties();

	public abstract WMSProperties getLiveStreamPacketizerProperties();

	public abstract WMSProperties getTranscoderProperties();

	public abstract WMSProperties getHTTPStreamerProperties();

	public abstract int getMaxStorageDirDepth();

	public abstract void setMaxStorageDirDepth(int paramInt);

	public abstract IMediaStreamFileMapper getStreamFileMapper();

	public abstract void setStreamFileMapper(IMediaStreamFileMapper paramIMediaStreamFileMapper);

	public abstract String decodeStorageDir(String paramString);

	public abstract String getLiveStreamPacketizerList();

	public abstract String getHTTPStreamerList();

	public abstract void setLiveStreamPacketizerList(String paramString);

	public abstract void setHTTPStreamerList(String paramString);

	public abstract boolean containsHTTPStreamer(String paramString);

	public abstract boolean containsLiveStreamPacketizer(String paramString);

	public abstract boolean containsDvrRecorder(String paramString);

	public abstract String getVODTimedTextProviderList();

	public abstract void setVODTimedTextProviderList(String paramString);

	public abstract List<String> getVODTimedTextProviderSet();

	public abstract WMSProperties getTimedTextProperties();

	public abstract IMediaStreamNameAliasProvider getStreamNameAliasProvider();

	public abstract void setStreamNameAliasProvider(IMediaStreamNameAliasProvider paramIMediaStreamNameAliasProvider);

	public abstract List<Publisher> getPublishers();

	public abstract int getPublisherCount();

	public abstract void addPublisher(Publisher paramPublisher);

	public abstract void removePublisher(Publisher paramPublisher);

	public abstract List<IHTTPStreamerSession> getHTTPStreamerSessions(int paramInt, String paramString);

	public abstract List<IHTTPStreamerSession> getHTTPStreamerSessions(String paramString);

	public abstract Map<String, Integer> getHTTPStreamerSessionCountsByName(int paramInt);

	public abstract int getHTTPStreamerSessionCount(String paramString);

	public abstract int getHTTPStreamerSessionCount(int paramInt, String paramString);

	public abstract List<IHTTPStreamerSession> getHTTPStreamerSessions();

	public abstract List<IHTTPStreamerSession> getHTTPStreamerSessions(int paramInt);

	public abstract int getHTTPStreamerSessionCount();

	public abstract int getHTTPStreamerSessionCount(int paramInt);

	public abstract void addHTTPStreamerSession(IHTTPStreamerSession paramIHTTPStreamerSession);

	public abstract void removeHTTPStreamerSession(IHTTPStreamerSession paramIHTTPStreamerSession);

	public abstract IHTTPStreamerApplicationContext getHTTPStreamerApplicationContext(String paramString, boolean paramBoolean);

	public abstract void addRTPIncomingDatagramPortRange(int paramInt1, int paramInt2);

	public abstract void addRTPIncomingDatagramPortAll();

	public abstract boolean isRTPIncomingDatagramPortValid(int paramInt);

	public abstract String readAppInstConfig(String paramString);

	public abstract boolean writeAppInstConfig(String paramString1, String paramString2);

	public abstract ILiveStreamPacketizerControl getLiveStreamPacketizerControl();

	public abstract void setLiveStreamPacketizerControl(ILiveStreamPacketizerControl paramILiveStreamPacketizerControl);

	public abstract boolean resetMediaCasterStream(String paramString);

	public abstract boolean resetMediaCasterStream(String paramString1, String paramString2);

	public abstract boolean startMediaCasterStream(String paramString1, String paramString2, String paramString3);

	public abstract boolean startMediaCasterStream(String paramString1, String paramString2);

	public abstract void stopMediaCasterStream(String paramString);

	public abstract String getContextStr();

	public abstract List<String> getPublishStreamNames();

	public abstract void addMediaWriterListener(IMediaWriterActionNotify paramIMediaWriterActionNotify);

	public abstract void removeMediaWriterListener(IMediaWriterActionNotify paramIMediaWriterActionNotify);

	public abstract void notifyMediaWriterOnWriteComplete(IMediaStream paramIMediaStream, File paramFile);

	public abstract void notifyMediaWriterOnFLVAddMetadata(IMediaStream paramIMediaStream, Map<String, Object> paramMap);

	public abstract IMediaCasterValidateMediaCaster getMediaCasterValidator();

	public abstract void setMediaCasterValidator(IMediaCasterValidateMediaCaster paramIMediaCasterValidateMediaCaster);

	public abstract void touch();

	public abstract long getLastTouchTime();

	public abstract int getApplicationInstanceTouchTimeout();

	public abstract void setApplicationInstanceTouchTimeout(int paramInt);

	public abstract int getRTSPSessionTimeout();

	public abstract void setRTSPSessionTimeout(int paramInt);

	public abstract int getRTSPMaximumPendingWriteBytes();

	public abstract void setRTSPMaximumPendingWriteBytes(int paramInt);

	public abstract void addMediaReaderListener(IMediaReaderActionNotify paramIMediaReaderActionNotify);

	public abstract void removeMediaReaderListener(IMediaReaderActionNotify paramIMediaReaderActionNotify);

	public abstract void notifyMediaReaderCreate(IMediaReader paramIMediaReader);

	public abstract void notifyMediaReaderInit(IMediaReader paramIMediaReader, IMediaStream paramIMediaStream);

	public abstract void notifyMediaReaderOpen(IMediaReader paramIMediaReader, IMediaStream paramIMediaStream);

	public abstract void notifyMediaReaderExtractMetaData(IMediaReader paramIMediaReader, IMediaStream paramIMediaStream);

	public abstract void notifyMediaReaderClose(IMediaReader paramIMediaReader, IMediaStream paramIMediaStream);

	public abstract String getRTSPBindIpAddress();

	public abstract void setRTSPBindIpAddress(String paramString);

	public abstract String getRTSPConnectionIpAddress();

	public abstract void setRTSPConnectionIpAddress(String paramString);

	public abstract String getRTSPConnectionAddressType();

	public abstract void setRTSPConnectionAddressType(String paramString);

	public abstract String getRTSPOriginIpAddress();

	public abstract void setRTSPOriginIpAddress(String paramString);

	public abstract String getRTSPOriginAddressType();

	public abstract void setRTSPOriginAddressType(String paramString);

	public abstract void addLiveStreamPacketizerListener(ILiveStreamPacketizerActionNotify paramILiveStreamPacketizerActionNotify);

	public abstract void removeLiveStreamPacketizerListener(ILiveStreamPacketizerActionNotify paramILiveStreamPacketizerActionNotify);

	public abstract void notifyLiveStreamPacketizerCreate(ILiveStreamPacketizer paramILiveStreamPacketizer, String paramString);

	public abstract void notifyLiveStreamPacketizerDestroy(ILiveStreamPacketizer paramILiveStreamPacketizer);

	public abstract void notifyLiveStreamPacketizerInit(ILiveStreamPacketizer paramILiveStreamPacketizer, String paramString);

	public abstract boolean isValidateFMLEConnections();

	public abstract void setValidateFMLEConnections(boolean paramBoolean);

	public abstract void addLiveStreamTranscoderListener(ILiveStreamTranscoderNotify paramILiveStreamTranscoderNotify);

	public abstract void removeLiveStreamTranscoderListener(ILiveStreamTranscoderNotify paramILiveStreamTranscoderNotify);

	public abstract void notifyLiveStreamTranscoderCreate(ILiveStreamTranscoder paramILiveStreamTranscoder, IMediaStream paramIMediaStream);

	public abstract void notifyLiveStreamTranscoderDestroy(ILiveStreamTranscoder paramILiveStreamTranscoder, IMediaStream paramIMediaStream);

	public abstract void notifyLiveStreamTranscoderInit(ILiveStreamTranscoder paramILiveStreamTranscoder, IMediaStream paramIMediaStream);

	public abstract boolean containsLiveStreamTranscoder(String paramString);

	public abstract String getLiveStreamTranscoderList();

	public abstract void setLiveStreamTranscoderList(String paramString);

	public abstract ILiveStreamTranscoderControl getLiveStreamTranscoderControl();

	public abstract void setLiveStreamTranscoderControl(ILiveStreamTranscoderControl paramILiveStreamTranscoderControl);

	public abstract LiveStreamTranscoderApplicationContext getTranscoderApplicationContext();

	public abstract WMSProperties getDvrProperties();

	public abstract DvrApplicationContext getDvrApplicationContext();

	public abstract ILiveStreamDvrRecorderControl getLiveStreamDvrRecorderControl();

	public abstract void setLiveStreamDvrRecorderControl(ILiveStreamDvrRecorderControl paramILiveStreamDvrRecorderControl);

	public abstract String getDvrRecorderList();

	public abstract void setDvrRecorderList(String paramString);

	public abstract void addDvrRecorderListener(ILiveStreamDvrRecorderActionNotify paramILiveStreamDvrRecorderActionNotify);

	public abstract void removeDvrRecorderListener(ILiveStreamDvrRecorderActionNotify paramILiveStreamDvrRecorderActionNotify);

	public abstract void notifyLiveStreamDvrRecorderCreate(ILiveStreamDvrRecorder paramILiveStreamDvrRecorder, String paramString);

	public abstract void notifyLiveStreamDvrRecorderInit(ILiveStreamDvrRecorder paramILiveStreamDvrRecorder, String paramString);

	public abstract void notifyLiveStreamDvrRecorderDestroy(ILiveStreamDvrRecorder paramILiveStreamDvrRecorder);

	public abstract void addDvrStreamManagerListener(IDvrStreamManagerActionNotify paramIDvrStreamManagerActionNotify);

	public abstract void removeDvrStreamManagerListener(IDvrStreamManagerActionNotify paramIDvrStreamManagerActionNotify);

	public abstract void notifyDvrStreamManagerCreate(IDvrStreamManager paramIDvrStreamManager, String paramString);

	public abstract void notifyDvrStreamManagerInit(IDvrStreamManager paramIDvrStreamManager);

	public abstract void notifyDvrStreamManagerDestroy(IDvrStreamManager paramIDvrStreamManager);

	public abstract int getMediaReaderContentType(String paramString);

	public abstract IMediaListProvider getMediaListProvider();

	public abstract void setMediaListProvider(IMediaListProvider paramIMediaListProvider);

	public abstract int getMediacasterRTPRTSPRTPTransportMode();

	public abstract void setMediacasterRTPRTSPRTPTransportMode(int paramInt);

	public abstract boolean[] getProtocolUsage();

	public abstract void getProtocolUsage(boolean[] paramArrayOfBoolean);

	public abstract boolean isDebugAppTimeout();

	public abstract void setDebugAppTimeout(boolean paramBoolean);

	public abstract void addRTPListener(IRTPSessionNotify paramIRTPSessionNotify);

	public abstract void removeRTPListener(IRTPSessionNotify paramIRTPSessionNotify);

	public abstract void notifyRTPSessionCreate(RTPSession paramRTPSession);

	public abstract void notifyRTPSessionDestroy(RTPSession paramRTPSession);

	public abstract void addHTTPListener(IHTTPSessionNotify paramIHTTPSessionNotify);

	public abstract void removeHTTPListener(IHTTPSessionNotify paramIHTTPSessionNotify);

	public abstract void notifyHTTPSessionCreate(IHTTPStreamerSession paramIHTTPStreamerSession);

	public abstract void notifyHTTPSessionDestroy(IHTTPStreamerSession paramIHTTPStreamerSession);

	public abstract List<MediaCacheSourceFilter> getMediaCacheFilters();

	public abstract boolean isMediaCacheSourceAllowed(String paramString);

	public abstract List<IPushPublishSession> getPushPublishSessions(IMediaStream paramIMediaStream);

	public abstract List<IPushPublishSession> getPushPublishSessions();

	public abstract void addPushPublishSession(IMediaStream paramIMediaStream, IPushPublishSession paramIPushPublishSession);

	public abstract void removePushPublishSession(IMediaStream paramIMediaStream, IPushPublishSession paramIPushPublishSession);

	public abstract void removePushPublishSessions(IMediaStream paramIMediaStream);

	public abstract void addPushPublishSessionListener(IPushPublishSessionNotify paramIPushPublishSessionNotify);

	public abstract void removePushPublishSessionListener(IPushPublishSessionNotify paramIPushPublishSessionNotify);

	public abstract void notifyPushPublishSessionCreate(String paramString, IMediaStream paramIMediaStream,
			IPushPublishSession paramIPushPublishSession);

	public abstract void notifyPushPublishSessionDestroy(String paramString, IMediaStream paramIMediaStream,
			IPushPublishSession paramIPushPublishSession);

	public abstract int getPushPublishSessionCount();

	public abstract WMSProperties getStreamRecorderProperties();
	
}
