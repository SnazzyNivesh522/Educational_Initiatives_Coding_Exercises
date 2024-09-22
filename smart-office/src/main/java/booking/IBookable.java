package booking;

import java.time.LocalDateTime;

public interface IBookable {
    void book(LocalDateTime bookingStartTime, int duration);
    void cancelBooking();
    boolean isBooked();
}
