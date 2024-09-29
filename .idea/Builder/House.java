package Builder;

public class House {
    private int numRooms;
    private int numFloors;
    private boolean hasPool;
    private boolean hasGarage;

    public House(int numRooms, int numFloors, boolean hasPool, boolean hasGarage) {
        this.numRooms = numRooms;
        this.numFloors = numFloors;
        this.hasPool = hasPool;
        this.hasGarage = hasGarage;
    }

    @Override
    public String toString() {
        return "House [Rooms=" + numRooms + ", Floors=" + numFloors + ", Pool=" + hasPool + ", Garage=" + hasGarage + "]";
    }
}
