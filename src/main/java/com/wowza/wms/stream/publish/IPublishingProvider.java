package com.wowza.wms.stream.publish;

/**
 * This interface connects the two classes (PublishingProviderLive and PublishingProviderMediaReader) that can provide video+audio source for a Publisher.
 *
 */
public interface IPublishingProvider {

	/**
	 * Close the stream
	 */
	 void close();
	 
	 /**
	  * Docs say literally "Get to send onMetadata event when stream starts" which I don't understand
	  * @return
	  */
	 boolean isSendOnMetadata(); 
    
	 /**
	  * Call this to start the playback.
	  * Based on this example here https://www.wowza.com/forums/content.php?410-Source-code-for-HTTPProviderMediaList-in-Wowza-Media-Server I think it returns true if there is still  more to be played if it's a VOD stream. 
	  * @param publisher
	  * @return 
	  */
	 boolean play(Publisher publisher);
	 
	 /**
	  * Jump to a timecode in the underlying stream.
	  * @param timecode
	  * @return
	  */
	 boolean seek(long timecode);
	 
	 boolean seek(long timecode, int seekType);
	 
	 /**
	  * Set playback duration in milliseconds
	  * @param duration
	  */
	 void setDuration(long duration);
	 
	 /**
	  * Set the start time as a real-world timestamp
	  * @param realTimeStartTime
	  */
	 void setRealTimeStartTime(long realTimeStartTime);
	 
	 /**
	  * Control the flag whether metadata notifications are sent or not when the stream starts.
	  * @param sendOnMetadata
	  */
	 void setSendOnMetadata(boolean sendOnMetadata); 
     
}
