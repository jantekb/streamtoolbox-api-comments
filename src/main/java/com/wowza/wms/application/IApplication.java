package com.wowza.wms.application;

import java.util.List;

import com.wowza.util.IOPerformanceCounter;
import com.wowza.wms.client.ConnectionCounter;
import com.wowza.wms.client.ConnectionCounterSimple;
import com.wowza.wms.vhost.IVHost;

/**
 * Represents an application defined in Wowza. 
 */
public interface IApplication {

	public void shutdown(boolean paramBoolean);

	public String getApplicationPath();

	public String getConfigPath();

	public IApplicationInstance getAppInstance(String paramString);

	public boolean isAppInstanceLoaded(String paramString);

	public String getName();

	public void setName(String paramString);

	public IVHost getVHost();

	public WMSProperties getProperties();

	public void addApplicationInstanceListener(IApplicationInstanceNotify paramIApplicationInstanceNotify);

	public void removeApplicationInstanceListener(IApplicationInstanceNotify paramIApplicationInstanceNotify);

	public ConnectionCounter getConnectionCounter();

	public ConnectionCounterSimple getConnectionCounter(int paramInt);

	public IOPerformanceCounter getIoPerformanceCounter();

	public IOPerformanceCounter getIoPerformanceCounter(int paramInt);

	public String getDateStarted();

	public String getTimeRunning();

	public double getTimeRunningSeconds();

	public List<String> getAppInstanceNames();

	public void removeAppInstance(IApplicationInstance paramIApplicationInstance);

	public void shutdownAppInstance(String paramString);

	public String readAppConfig(String paramString);

	public boolean writeAppConfig(String paramString1, String paramString2);

	public void getProtocolUsage(boolean[] paramArrayOfBoolean);

	public boolean isRunning();
}
