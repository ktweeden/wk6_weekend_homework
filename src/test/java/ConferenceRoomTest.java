import Guests.Guest;
import Rooms.ConferenceRoom;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ConferenceRoomTest {
    ConferenceRoom room;
    Guest guest;

    @Before
    public void before() {
        this.room = new ConferenceRoom("Lovelace", 50, 10);
        this.guest = new Guest("Kate");
    }

    @Test
    public void hasCapacity() {
        assertEquals(50, room.getCapacity());
    }

    @Test
    public void hasGuestList() {
        assertEquals(0, room.getGuests().size());
    }

    @Test
    public void canAddGuest() {
        room.checkInGuest(guest);
        assertEquals(1, room.getGuests().size());
    }

    @Test
    public void hasName() {
        assertEquals("Lovelace", room.getName());
    }

    @Test
    public void canGetCost() {
        assertEquals(10, room.getCost());
    }

    @Test
    public void canCheckOutGuest() {
        room.checkInGuest(guest);
        assertEquals(1, room.getGuests().size());
        room.checkOutGuest(guest);
        assertEquals(0, room.getGuests().size());
    }

    @Test
    public void doesHaveCapacity() {
        assertEquals(true, room.hasCapacity());
    }
}

