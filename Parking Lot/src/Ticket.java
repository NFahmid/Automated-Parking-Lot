
public class Ticket {
    private int slotNumber;
    private Vehicle vehicle;


    public Ticket(int slotNumber, Vehicle vehicle) {
        this.slotNumber = slotNumber;
        this.vehicle = vehicle;
    }

    @Deprecated
    public Ticket(int slotNumber, Car car) {
        this(slotNumber, (Vehicle) car);
    }

    public int getSlotNumber() {
        return slotNumber;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    @Deprecated
    public Car getCar() {
        return (Car) vehicle;
    }
}