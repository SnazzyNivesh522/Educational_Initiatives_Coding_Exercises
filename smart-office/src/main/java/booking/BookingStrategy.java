package booking;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class BookingStrategy implements IBookingStrategy {
	public TreeMap<LocalDateTime, Integer> bookings;
	public BookingStrategy() {
		this.bookings=new TreeMap<>(new BookingComparator(this));
	}
	@Override
	public boolean canBook(LocalDateTime bookingStartTime, int duration) {
		if (duration <= 0) {
	        throw new IllegalArgumentException("Invalid booking duration: " + duration);
	    }
		LocalDateTime endTime = bookingStartTime.plusMinutes(duration);

		Map.Entry<LocalDateTime, Integer> floorEntry = bookings.floorEntry(bookingStartTime);
		if (floorEntry != null) {
			LocalDateTime existingEndTime = floorEntry.getKey().plusMinutes(floorEntry.getValue());
			if (existingEndTime.isAfter(bookingStartTime)) {
				return false; 
			}
		}

		Map.Entry<LocalDateTime, Integer> ceilingEntry = bookings.ceilingEntry(bookingStartTime);
		if (ceilingEntry != null && ceilingEntry.getKey().isBefore(endTime)) {
			return false;
		}

		return true; 
	}

	@Override
	public void addBooking(LocalDateTime bookingStartTime, int duration) {
		if (!canBook(bookingStartTime, duration)) {
			throw new IllegalStateException("Cannot book at this time due to conflict with existing booking");
		}
		bookings.put(bookingStartTime, duration);
	}

	@Override
	public void removeBooking(LocalDateTime bookingStartTime) {
		if (!bookings.containsKey(bookingStartTime)) {
			throw new IllegalArgumentException("No booking found at the specified start time");
		}
		bookings.remove(bookingStartTime);
	}

	@Override
	public void clearBookings() {
		bookings.clear();
	}

	public TreeMap<LocalDateTime, Integer> getAllBookings() {
		return new TreeMap<>(bookings); 
	}

	private class BookingComparator implements Comparator<LocalDateTime> {
		private BookingStrategy strategy;

		public BookingComparator(BookingStrategy strategy) {
			this.strategy = strategy;
		}

		@Override
		public int compare(LocalDateTime booking1StartTime, LocalDateTime booking2StartTime) {
			int startTimeComparison = booking1StartTime.compareTo(booking2StartTime);
			if (startTimeComparison != 0) {
				return startTimeComparison;
			}

			Integer booking1Duration = bookings.get(booking1StartTime);
			Integer booking2Duration = bookings.get(booking2StartTime);

			if (booking1Duration == null || booking2Duration == null) {
				throw new IllegalStateException("Missing duration for booking");
			}

			LocalDateTime booking1EndTime = booking1StartTime.plusMinutes(booking1Duration);
			LocalDateTime booking2EndTime = booking2StartTime.plusMinutes(booking2Duration);
			return booking1EndTime.compareTo(booking2EndTime);
		}
	}

}
