import Guests.Guest;
import Rooms.DiningRoom;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class DiningRoomTest {
    DiningRoom room;
    Guest guest;

    @Before
    public void before() {
        this.room = new DiningRoom("Escoffier", 30);
        this.guest = new Guest("Jack");
    }

    @Test
    public void hasName() {
        assertEquals("Escoffier", room.getName());
    }

    @Test
    public void hasCapacity() {
        assertEquals(30, room.getCapacity());
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
