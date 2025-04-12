/**
 * Represents a parking slot in the parking lot.
 * This class follows the Single Responsibility Principle by focusing only on slot state management.
 * Updated to follow Liskov Substitution Principle by using Vehicle interface instead of Car class.
 */
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

    /**
     * Assigns a vehicle to this slot.
     * 
     * @param vehicle the vehicle to assign
     */
    public void assignVehicle(Vehicle vehicle) {
        this.parkedVehicle = vehicle;
        this.isOccupied = true;
    }
    
    /**
     * Assigns a car to this slot (legacy method for backward compatibility).
     * 
     * @param car the car to assign
     * @deprecated Use assignVehicle instead
     */
    @Deprecated
    public void assignCar(Car car) {
        assignVehicle(car);
    }

    /**
     * Removes the vehicle from this slot.
     */
    public void removeVehicle() {
        this.parkedVehicle = null;
        this.isOccupied = false;
    }
    
    /**
     * Removes the car from this slot (legacy method for backward compatibility).
     * 
     * @deprecated Use removeVehicle instead
     */
    @Deprecated
    public void removeCar() {
        removeVehicle();
    }

    /**
     * Gets the parked vehicle.
     * 
     * @return the parked vehicle
     */
    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }
    
    /**
     * Gets the parked car (legacy method for backward compatibility).
     * 
     * @return the parked car
     * @deprecated Use getParkedVehicle instead
     */
    @Deprecated
    public Car getParkedCar() {
        return (Car) parkedVehicle;
    }

    public int getSlotNumber() {
        return slotNumber;
    }
}