package com.wowza.wms.application;

public interface IApplicationInstanceNotify {

	public void onApplicationInstanceCreate(IApplicationInstance paramIApplicationInstance);

	public void onApplicationInstanceDestroy(IApplicationInstance paramIApplicationInstance);
}
