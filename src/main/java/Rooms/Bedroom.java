package Rooms;

import Guests.Guest;

public class Bedroom extends Room{
    private BedroomType type;
    private int cost;
    private int currentGuestStayLength;

    public Bedroom(BedroomType type) {
        super(type.getCapacity());
        this.type = type;
        this.cost = type.getValue();
        this.currentGuestStayLength = 0;
    }

    public int getCost() {
        return this.cost;
    }

    public BedroomType getType() {
        return this.type;
    }

    public int getCurrentGuestStayLength() {
        return  this.currentGuestStayLength;
    }

    public void checkInGuestForLengthOfTime(Guest guest, int stayLength) {
        this.checkInGuest(guest);
        this.currentGuestStayLength = stayLength;
    }
}
