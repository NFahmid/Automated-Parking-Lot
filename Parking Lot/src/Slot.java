
public class Slot {
    private int slotNumber;
    private boolean isOccupied;
    private Vehicle parkedVehicle;

    public Slot(int slotNumber) {
        this.slotNumber = slotNumber;
        this.isOccupied = false;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void assignVehicle(Vehicle vehicle) {
        this.parkedVehicle = vehicle;
        this.isOccupied = true;
    }

    @Deprecated
    public void assignCar(Car car) {
        assignVehicle(car);
    }
    public void removeVehicle() {
        this.parkedVehicle = null;
        this.isOccupied = false;
    }

    @Deprecated
    public void removeCar() {
        removeVehicle();
    }

    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }

    @Deprecated
    public Car getParkedCar() {
        return (Car) parkedVehicle;
    }

    public int getSlotNumber() {
        return slotNumber;
    }
}