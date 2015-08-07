package com.wowza.wms.amf;

import java.io.IOException;
import java.nio.ByteBuffer;

public class AMFData {
	
	/**
	 * 
	 */
	public AMFData() {
		
	}
	
	/**
	 * 
	 * @return
	 */
	public int getType() {
		return 0;
	}
	
	/**
	 * 
	 * @param paramInt
	 */
	public void setType(int paramInt) {
		
	}

	/**
	 * 
	 * @param paramByteBuffer
	 * @param paramInt
	 * @return
	 */
	public static boolean testNextByte(ByteBuffer paramByteBuffer, int paramInt) {
		return false;
	}
	
	/**
	 * 
	 * @param paramByteBuffer
	 * @return
	 */
	public static int peekByte(ByteBuffer paramByteBuffer) {
		return 0;
	}
	
	/**
	 * 
	 * @param paramByteBuffer
	 * @return
	 */
	public static int skipByte(ByteBuffer paramByteBuffer) { 
		return 0;
	}
	
	/**
	 * 
	 * @param paramByteBuffer
	 * @param paramAMFDataContextDeserialize
	 * @return
	 */
	public static boolean isObjStart(ByteBuffer paramByteBuffer,
			AMFDataContextDeserialize paramAMFDataContextDeserialize) {
		return false;
	}
	
	/**
	 * 
	 * @param paramByteBuffer
	 * @param paramAMFDataContextDeserialize
	 * @return
	 */
	public static boolean isAMF3Start(ByteBuffer paramByteBuffer, AMFDataContextDeserialize paramAMFDataContextDeserialize) {
		return false;
	}
	
	/**
	 * 
	 * @param paramByteBuffer
	 * @param paramAMFDataContextDeserialize
	 * @return
	 */
	public static boolean isArrayStart(ByteBuffer paramByteBuffer, AMFDataContextDeserialize paramAMFDataContextDeserialize) {
		return false;
	}
	
	/**
	 * 
	 * @param paramByteBuffer
	 * @param paramAMFDataContextDeserialize
	 * @return
	 */
	public static boolean isMixedArrayStart(ByteBuffer paramByteBuffer,
			AMFDataContextDeserialize paramAMFDataContextDeserialize) {
		return false;
	}
	
	/**
	 * 
	 * @param paramByteBuffer
	 * @param paramAMFDataContextDeserialize
	 * @return
	 */
	public static boolean isObjEnd(ByteBuffer paramByteBuffer, AMFDataContextDeserialize paramAMFDataContextDeserialize){
		return false;
	}
	/**
	 * 
	 * @param paramByteBuffer
	 * @param paramAMFDataContextDeserialize
	 * @return
	 */
	public static boolean isByteArrayStart(ByteBuffer paramByteBuffer, AMFDataContextDeserialize paramAMFDataContextDeserialize) {
		return false;
	}
	  
	/**
	 * 
	 * @param paramByteBuffer
	 * @param paramAMFDataContextDeserialize
	 * @return
	 */
	public static AMFData getReference(ByteBuffer paramByteBuffer, AMFDataContextDeserialize paramAMFDataContextDeserialize) {
		return null;
	}
	  
	/**
	 *   
	 * @param paramByteBuffer
	 * @param paramAMFDataContextDeserialize
	 * @return
	 * @throws IOException
	 */
	public static AMFData deserializeInnerObject(ByteBuffer paramByteBuffer, AMFDataContextDeserialize paramAMFDataContextDeserialize) throws IOException {
		return null;
	}
	
	
	public static AMFDataContextSerialize createContextSerialize() {
		return null;
	}
	
	
	public static AMFDataContextSerialize createContextSerialize(int paramInt) {
		return null;
	}
	
	
	public static AMFDataContextDeserialize createContextDeserialize() {
		return null;
	}
	
	
	public static AMFDataContextDeserialize createContextDeserialize(int paramInt) {
		return null;
	}
	
	
	public static boolean triggerAMF3Switch(AMFData paramAMFData) {
		return false;
	}
	  
}
	
