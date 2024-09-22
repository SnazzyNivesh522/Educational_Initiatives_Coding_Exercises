//Singleton Pattern
package config;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import rooms.ConferenceRoom;
import rooms.IRoom;

public class OfficeConfiguration {
    private static OfficeConfiguration instance = null;
    private final Map<Integer, ConferenceRoom> rooms;

    private OfficeConfiguration() {
    	rooms=Collections.synchronizedMap(new HashMap<>());
    }

    public static OfficeConfiguration getInstance() {
        if (instance == null) {
            synchronized (OfficeConfiguration.class) { //synchronized to ensure only one thread can work
                if (instance == null) {
                	try {
                        instance = new OfficeConfiguration();
                    } 
                	catch (RuntimeException e) {
                       throw new IllegalStateException("Failed to initialize OfficeConfiguration", e);
                    }
                }
            }
        }
        return instance;
    }

    public void configureRooms(int count) throws IllegalArgumentException {
    	if (count <= 0) {
    		throw new IllegalArgumentException("Room count must be positive");
    	}
        for (int i = 1; i <= count; i++) {
            rooms.put(i, new ConferenceRoom(i));
        }
    }
    
    public ConferenceRoom getRoom(int roomId) {
    	if(!rooms.containsKey(roomId)) {
    		throw new IllegalArgumentException("Room " + roomId +" does not exist.");
    	}
    	return rooms.get(roomId);
    }
    
    public int getRoomCount() {
    	return rooms.size();
    }
    public Map<Integer, IRoom> getAllRooms() {
        return Collections.unmodifiableMap(new HashMap<>(rooms));
    }
}
