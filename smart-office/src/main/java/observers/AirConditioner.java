package observers;

import rooms.ConferenceRoom;
import rooms.IRoom;

public class AirConditioner implements RoomObserver{
	@Override
    public void update(IRoom room) {
        if (room.isOccupied()) {
            System.out.println("Air Conditioner ON in Room " + room.getRoomId());
        } else {
            System.out.println("Air Conditioner OFF in Room " + room.getRoomId());
        }
    }
}


