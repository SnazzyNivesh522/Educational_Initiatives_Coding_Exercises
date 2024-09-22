package rooms;

import observers.RoomObserver;

public interface IRoom {
    int getRoomId();
    void setOccupancy(int count);
    int getOccupancy();
    boolean isOccupied();
    void setOccupied(boolean occupied);
    void addObserver(RoomObserver observer);
    void removeObserver(RoomObserver observer);
}
