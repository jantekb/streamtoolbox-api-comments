package com.wowza.wms.stream;

public interface IMediaStream {
	
	void addClientListener(IMediaStreamActionNotify paramIMediaStreamActionNotify);

	void addClientListener(IMediaStreamActionNotify2 paramIMediaStreamActionNotify2);

	void addClientListener(IMediaStreamActionNotify3 paramIMediaStreamActionNotify3);

	void removeClientListener(IMediaStreamActionNotify paramIMediaStreamActionNotify);

	void removeClientListener(IMediaStreamActionNotify2 paramIMediaStreamActionNotify2);

	void removeClientListener(IMediaStreamActionNotify3 paramIMediaStreamActionNotify3);


}
