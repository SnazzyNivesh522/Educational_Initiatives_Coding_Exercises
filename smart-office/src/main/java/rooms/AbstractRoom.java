package rooms;

import java.util.ArrayList;
import java.util.List;

import observers.RoomObserver;

public abstract class AbstractRoom implements IRoom {
	private int roomId;
    private int occupancy;
    protected List<RoomObserver> observers;
    
    public AbstractRoom(int roomId) {
    	this.roomId=roomId;
    	this.occupancy=0;
    	this.observers=new ArrayList<RoomObserver>();
    }
    
	@Override
	public int getRoomId() {
		return this.roomId;
	}
	
	@Override
    public void addObserver(RoomObserver observer) {
        observers.add(observer);
	}
	
	@Override
    public void removeObserver(RoomObserver observer) {
        observers.remove(observer);
    }
	
	protected void notifyObservers() {
        for (RoomObserver observer : observers) {
            observer.update(this);
        }
    }
	
	@Override
    public void setOccupancy(int count) {
        this.occupancy = count;
        notifyObservers();
    }
	
	@Override
    public int getOccupancy() {
        return this.occupancy;
    }
	
	@Override
    public boolean isOccupied() {
        return this.occupancy > 0;
    }
}
