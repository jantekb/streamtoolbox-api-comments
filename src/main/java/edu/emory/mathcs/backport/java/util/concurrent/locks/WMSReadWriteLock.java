package edu.emory.mathcs.backport.java.util.concurrent.locks;

public abstract interface WMSReadWriteLock {
	public abstract WMSLock readLock();

	public abstract WMSLock writeLock();
}
