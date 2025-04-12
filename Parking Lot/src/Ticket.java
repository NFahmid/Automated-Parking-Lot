public class Ticket {
    private int slotNumber;
    private Car car;

    public Ticket(int slotNumber, Car car) {
        this.slotNumber = slotNumber;
        this.car = car;
    }

    public int getSlotNumber() {
        return slotNumber;
    }

    public Car getCar() {
        return car;
    }
}