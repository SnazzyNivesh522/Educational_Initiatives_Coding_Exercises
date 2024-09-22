package commands;

import java.time.LocalDateTime;

import rooms.ConferenceRoom;

public class BookRoomCommand implements Command {
    private ConferenceRoom room;
    private LocalDateTime bookingStartTime;
    private int duration;

    public BookRoomCommand(ConferenceRoom room, LocalDateTime bookingStarttTime, int duration) {
        this.room = room;
        this.bookingStartTime=bookingStarttTime;
        this.duration = duration;
    }

    @Override
    public void execute() {
    	room.book(this.bookingStartTime, this.duration);
    }
}