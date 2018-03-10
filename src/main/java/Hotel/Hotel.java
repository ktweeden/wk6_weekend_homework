package Hotel;

import Guests.Guest;
import Rooms.Bedroom;
import Rooms.BedroomType;
import Rooms.ConferenceRoom;
import Rooms.DiningRoom;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Hotel {
    private ArrayList<Bedroom> bedrooms;
    private ArrayList<ConferenceRoom> conferenceRooms;
    private ArrayList<DiningRoom> diningRooms;
    private String name;

    public Hotel(String name) {
        this.bedrooms = new ArrayList<>();
        this.conferenceRooms = new ArrayList<>();
        this.diningRooms = new ArrayList<>();
        this.name = name;
    }

    public ArrayList<Bedroom> getBedrooms() {
        return bedrooms;
    }

    public String getName() {
        return name;
    }

    public ArrayList<ConferenceRoom> getConferenceRooms() {
        return conferenceRooms;
    }

    public ArrayList<DiningRoom> getDiningRooms() {
        return diningRooms;
    }

    public void addBedroom(BedroomType type) {
        Bedroom bedroom = new Bedroom(type);
        this.bedrooms.add(bedroom);
    }


    public Bedroom findVacancy(BedroomType type) {
        Bedroom vacantRoom = null;
        for (Bedroom room : this.bedrooms) {
            if (room.getType() == type && room.hasCapacity()) {
                return vacantRoom = room;
            }
        }
        return vacantRoom;
    }

    public void checkInGuest(Guest guest, BedroomType type) {
        Bedroom vacantRoom = findVacancy(type);
        if (vacantRoom != null) {
            vacantRoom.checkInGuest(guest);
        }
    }

    public ArrayList<Guest> guestsInRoom(Bedroom bedroom) {
        return bedroom.getGuests();
    }

    public ArrayList<Bedroom> findAllVacantBedrooms() {
        ArrayList<Bedroom> vacantRooms = new ArrayList<>();
        for (Bedroom room : this.bedrooms) {
            if (room.hasCapacity()) {
                vacantRooms.add(room);
            }
        }
        return vacantRooms;
    }

    public ArrayList<Bedroom> findVacantBedroomsByType(BedroomType type) {
        ArrayList<Bedroom> vacantRooms = new ArrayList<>();
        for (Bedroom room : this.bedrooms) {
            if (room.getType() == type && room.hasCapacity()) {
                vacantRooms.add(room);
            }
        }
        return vacantRooms;
    }
}
