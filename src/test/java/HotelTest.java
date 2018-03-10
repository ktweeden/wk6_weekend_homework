import Guests.Guest;
import Rooms.Bedroom;
import Rooms.BedroomType;
import org.junit.Before;
import Hotel.Hotel;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HotelTest {

    Hotel hotel;
    Guest guest;
    @Before
    public void before() {
        hotel = new Hotel("The Grand");
        guest = new Guest("Kate");
    }

    @Test
    public void hasBedrooms() {
        assertEquals(0, hotel.getBedrooms().size());
    }

    @Test
    public void hasConferenceRooms() {
        assertEquals(0, hotel.getConferenceRooms().size());
    }

    @Test
    public void hasDiningRooms() {
        assertEquals(0, hotel.getDiningRooms().size());
    }

    @Test
    public void hasName() {
        assertEquals("The Grand", hotel.getName());
    }

    @Test
    public void canAddBedroom() {
        hotel.addBedroom(BedroomType.DOUBLE);
        assertEquals(1, hotel.getBedrooms().size());
    }

    @Test
    public void canFindVacancy(){
        hotel.addBedroom(BedroomType.DOUBLE);
        Bedroom vacantRoom = hotel.findVacancy(BedroomType.DOUBLE);
        assertEquals(hotel.getBedrooms().get(0), vacantRoom);
    }

    @Test
    public void canFindFirstVacantRoom() {
        hotel.addBedroom(BedroomType.DOUBLE);
        hotel.addBedroom(BedroomType.DOUBLE);
        Bedroom vacantRoom = hotel.findVacancy(BedroomType.DOUBLE);
        assertEquals(hotel.getBedrooms().get(0), vacantRoom);
    }

    @Test
    public void canFindRightTypeOfVacantRoom() {
        hotel.addBedroom(BedroomType.SINGLE);
        hotel.addBedroom(BedroomType.DOUBLE);
        Bedroom vacantRoom = hotel.findVacancy(BedroomType.DOUBLE);
        assertEquals(hotel.getBedrooms().get(1), vacantRoom);
    }

    @Test
    public void guestCanCheckIntoBedroom() {
        hotel.addBedroom(BedroomType.DOUBLE);
        hotel.checkInGuest(guest, BedroomType.DOUBLE);
        assertEquals(hotel.getBedrooms().get(0).getGuests().get(0), guest);
    }

    @Test
    public void canFindGuestsInRoom() {
        hotel.addBedroom(BedroomType.DOUBLE);
        hotel.checkInGuest(guest, BedroomType.DOUBLE);
        assertEquals(guest, hotel.guestsInRoom(hotel.getBedrooms().get(0)).get(0));
    }

    @Test
    public void canFindAllVacantRooms() {
        hotel.addBedroom(BedroomType.DOUBLE);
        hotel.addBedroom(BedroomType.DOUBLE);
        hotel.checkInGuest(guest, BedroomType.DOUBLE);
        hotel.checkInGuest(guest, BedroomType.DOUBLE);
        assertEquals(hotel.getBedrooms().get(1), hotel.findAllVacantBedrooms().get(0));
    }

    @Test
    public void canFindVacantRoomsByType() {
        hotel.addBedroom(BedroomType.DOUBLE);
        hotel.addBedroom(BedroomType.SINGLE);
        hotel.addBedroom(BedroomType.DOUBLE);
        hotel.checkInGuest(guest, BedroomType.DOUBLE);
        hotel.checkInGuest(guest, BedroomType.DOUBLE);
        assertEquals(hotel.getBedrooms().get(1), hotel.findVacantBedroomsByType(BedroomType.SINGLE).get(0));
    }
}
