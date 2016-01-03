package com.wowza.wms.server;

import com.wowza.wms.module.ModuleBase;

/**
 * This is an apparently undocumented class in the API that you can use to get notified about server-level lifecycle events, similar to {@link ModuleBase}. 
 * This is basically an adapter-like implementation of {@link IServerNotify3} which allows you to override only those lifecycle methods that you actually need, 
 * while the others are implemented without any side effect.
 * 
 * The way to register your server level listener is adding them to <code>conf/Server.xml</code> under the <code>ServerListerners</code> tag. The official documentation
 * of {@link IServerNotify3} mentions that the order of method calls is:
 *  <ol>
 *  <li>constructor</li>
 *  <li>onServerConfigLoaded</li>
 *  <li>onServerCreate</li>
 *  <li>onServerInit</li>
 *  </ol>
 *  The destroy call order is:
 *  <ol>
 *  <li>onServerShutdownStart</li>
 *  <li>onServerShutdownComplete</li>
 *  <li>exit</li>
 *  </ol>
 */
public abstract class ServerNotifyBase implements IServerNotify3 {

}
