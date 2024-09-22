package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import commands.BookRoomCommand;
import commands.CancelRoomCommand;
import config.OfficeConfiguration;
import rooms.ConferenceRoom;

@TestInstance(Lifecycle.PER_CLASS)
class SmartOfficeSystemTest {
	private OfficeConfiguration facility;

	@BeforeAll
	void setup() throws Exception {
		facility = OfficeConfiguration.getInstance();
        facility.configureRooms(3);
	}
	
	@Test
	void testRoomConfiguration() {
		assertEquals(3, facility.getRoomCount());
	}
	 
	@Test
	void testBookRoom() {
		ConferenceRoom room = facility.getRoom(1);
		LocalDateTime bookingStartTime = LocalDateTime.now().plusHours(1);
		BookRoomCommand bookCommand = new BookRoomCommand(room,bookingStartTime, 60);
		bookCommand.execute();
		assertTrue(room.isBooked());
	}
	
	@Test
	void testCancelRoom() {
		ConferenceRoom room = facility.getRoom(1);
		LocalDateTime bookingStartTime = LocalDateTime.now().plusHours(1);
		BookRoomCommand bookRoomCommand = new BookRoomCommand(room, bookingStartTime, 60);
		bookRoomCommand.execute();
		
		CancelRoomCommand cancelRoomCommand = new CancelRoomCommand(room, bookingStartTime);
		cancelRoomCommand.execute();
		assertFalse(room.isBooked());
	}
	
	@Test
	void testSimilarBooking() {
		ConferenceRoom room = facility.getRoom(1);
		LocalDateTime bookingStartTime = LocalDateTime.now().plusHours(1);
		BookRoomCommand bookRoomCommand1 = new BookRoomCommand(room, bookingStartTime, 60);
		bookRoomCommand1.execute();
		
		
		BookRoomCommand bookRoomCommand2 = new BookRoomCommand(room, bookingStartTime, 60);
		assertThrows(IllegalStateException.class, bookRoomCommand2::execute);
		
	}
	
	@Test
	void testOccupancyAndAutoCancel() {
		ConferenceRoom room = facility.getRoom(1);
        LocalDateTime bookingStartTime = LocalDateTime.now().minusMinutes(10);
		BookRoomCommand bookRoomCommand = new BookRoomCommand(room, bookingStartTime, 60);
		bookRoomCommand.execute();
		
		room.setOccupancy(0);
		room.checkOccupancyAndBooking();
		assertFalse(room.isBooked());
	}
	
	@Test
	void testInvalidRoomAccess() {
		assertThrows(IllegalArgumentException.class, ()-> facility.getRoom(4));
	}
	 

}
