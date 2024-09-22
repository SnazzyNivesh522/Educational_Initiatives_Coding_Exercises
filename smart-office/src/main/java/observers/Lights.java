package observers;

import rooms.ConferenceRoom;
import rooms.IRoom;

public class Lights implements RoomObserver {
	@Override
    public void update(IRoom room) {
        if (room.isOccupied()) {
            System.out.println("Lights ON in Room " + room.getRoomId());
        } else {
            System.out.println("Lights OFF in Room " + room.getRoomId());
        }
    }
}