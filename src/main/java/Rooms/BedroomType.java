package Rooms;

public enum BedroomType {
    DOUBLE(2, 20),
    SINGLE(1, 10),
    TWIN(2, 15),
    FAMILY(4, 30),
    SUITE(4, 50);

    private int value;
    private int capacity;

    BedroomType(int capacity, int value) {
        this.value = value;
        this.capacity = capacity;
    }

    public int getValue() {
        return this.value;
    }

    public int getCapacity() {
        return capacity;
    }
}
