// rooms/ConferenceRoom.java
package rooms;

import booking.BookingStrategy;
import booking.IBookable;
import booking.IBookingStrategy;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class ConferenceRoom extends AbstractRoom implements IBookable{
    private IBookingStrategy bookingStrategy;
	private boolean isOccupied;
	private LocalDateTime currentBookingStart;
    private int currentBookingDuration;

    public ConferenceRoom(int roomId) {
    	super(roomId);
    	this.isOccupied=false;
        this.bookingStrategy = new BookingStrategy();
    }

    @Override
    public void setOccupancy(int count) {
    	super.setOccupancy(count);
    	boolean nowOccupied = count > 0;
    	if (this.isOccupied != nowOccupied) {
    		this.isOccupied = nowOccupied;
    		if (nowOccupied) {
    			System.out.println("Room " + getRoomId() + " is now occupied.");
    		} else {
    			System.out.println("Room " + getRoomId() + " is now unoccupied.");
    			if (isBooked()) {
    				checkAndCancelBooking();
    			}
    		}
    	}
    }

    @Override
    public void book(LocalDateTime bookingStartTime, int duration) {
        if (bookingStrategy.canBook(bookingStartTime, duration)) {
            bookingStrategy.addBooking(bookingStartTime, duration);
            this.currentBookingStart = bookingStartTime;
            this.currentBookingDuration = duration;
            System.out.println("Room " + getRoomId() + " booked from " + bookingStartTime + " for " + duration + " minutes.");
        } else {
            throw new IllegalStateException("Room " + getRoomId() + " cannot be booked at this time due to conflict.");
        }
    }

    @Override
    public void cancelBooking() {
        if (isBooked()) {
            bookingStrategy.removeBooking(currentBookingStart);
            System.out.println("Booking cancelled for Room " + getRoomId());
            this.currentBookingStart = null;
            this.currentBookingDuration = 0;
        } 
        else {
            System.out.println("No active booking to cancel for Room " + getRoomId());
        }
    }

    @Override
    public boolean isBooked() {
        LocalDateTime now = LocalDateTime.now();
        return ((BookingStrategy) bookingStrategy).getAllBookings().containsKey(now);
    }

    private void checkAndCancelBooking() {
        LocalDateTime now = LocalDateTime.now();
        ((BookingStrategy) bookingStrategy).getAllBookings().forEach((startTime, duration) -> {
            if (now.isAfter(startTime) && now.isBefore(startTime.plusMinutes(duration))) {
                long minutesSinceStart = ChronoUnit.MINUTES.between(startTime, now);
                if (!isOccupied && minutesSinceStart > 5) {
                    System.out.println("Room " + getRoomId() + " has been unoccupied for more than 5 minutes. Cancelling booking.");
                    bookingStrategy.removeBooking(startTime);
                }
            }
        });
    }
    
    public void checkOccupancyAndBooking() {
        if (isBooked() && !isOccupied) {
            checkAndCancelBooking();
        }
    }
    
    public String getBookingsInfo() {
        StringBuilder info = new StringBuilder("Bookings for Room " + getRoomId() + ":\n");
        ((BookingStrategy) bookingStrategy).getAllBookings().forEach((startTime, duration) -> {
            info.append("From: ").append(startTime).append(", Duration: ").append(duration).append(" minutes\n");
        });
        return info.toString();
    }

	@Override
	public void setOccupied(boolean occupied) {
		this.isOccupied=occupied;
		
	}
}
