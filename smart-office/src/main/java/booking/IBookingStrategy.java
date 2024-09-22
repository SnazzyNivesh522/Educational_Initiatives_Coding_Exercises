package booking;

import java.time.LocalDateTime;

public interface IBookingStrategy {
    boolean canBook(LocalDateTime bookingStrartTime, int duration);
    void addBooking(LocalDateTime bookingStartTime, int duration);
    void removeBooking(LocalDateTime bookingStartTime);
    void clearBookings();
}
