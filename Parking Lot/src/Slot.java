public class Slot {
    private int slotNumber;
    private boolean isOccupied;
    private Car parkedCar;

    public Slot(int slotNumber) {
        this.slotNumber = slotNumber;
        this.isOccupied = false;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void assignCar(Car car) {
        this.parkedCar = car;
        this.isOccupied = true;
    }

    public void removeCar() {
        this.parkedCar = null;
        this.isOccupied = false;
    }

    public Car getParkedCar() {
        return parkedCar;
    }

    public int getSlotNumber() {
        return slotNumber;
    }
}