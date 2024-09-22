package commands;

import java.time.LocalDateTime;

import rooms.ConferenceRoom;

public class CancelRoomCommand implements Command {
    private ConferenceRoom room;
    private LocalDateTime bookingStartTime;

    public CancelRoomCommand(ConferenceRoom room,LocalDateTime bookingStartTime) {
        this.room = room;
        this.bookingStartTime=bookingStartTime;
    }

    @Override
    public void execute() {
        room.cancelBooking();
    }
}