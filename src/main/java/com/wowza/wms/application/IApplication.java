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

	/**
	 * Returns the full absolute path to the Application.xml file which contains all the configuration
	 * @return path to Application.xml
	 */
	public String getConfigPath();

	public IApplicationInstance getAppInstance(String paramString);

	public boolean isAppInstanceLoaded(String paramString);

	/**
	 * Returns the logical name of the application, as set in the configuration
	 * @return
	 */
	public String getName();

	public void setName(String name);

	/**
	 * Returns the reference to the @see {@link IVHost} in which this application lives
	 * @return reference to the surrounding VHost
	 */
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

	/**
	 * The list of application instance names that exist. By default the instance <code>_definst_</code> is instantiated for each running application.
	 * @return list of application instance names
	 */
	public List<String> getAppInstanceNames();

	public void removeAppInstance(IApplicationInstance paramIApplicationInstance);

	public void shutdownAppInstance(String paramString);

	/**
	 * This returns the whole content of the Application.xml file, just as if you read it from the file itself. 
	 * There is a parameter which seems to be unused, no matter what you pass in you get the same output. The returned
	 * string contains new lines and even the comments are there.
	 * 
	 * @param apparentlyUnusedParam no idea, you can pass in anything, even <code>null</code>
	 * @return the content of the Application.xml file for this application
	 */
	public String readAppConfig(String apparentlyUnusedParam);

	/**
	 * According to <a href="http://www.wowza.com/forums/showthread.php?39410-how-to-use-writeAppConfig">this forum post</a> this does not write anything to the disk.
	 * 
	 * @param applicationName
	 * @param data
	 * @return
	 */
	public boolean writeAppConfig(String applicationName, String data);

	public void getProtocolUsage(boolean[] paramArrayOfBoolean);

	public boolean isRunning();
}
