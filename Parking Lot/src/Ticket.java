/**
 * Represents a parking ticket issued when a vehicle is parked.
 * Updated to follow Liskov Substitution Principle by using Vehicle interface instead of Car class.
 */
public class Ticket {
    private int slotNumber;
    private Vehicle vehicle;

    /**
     * Creates a new ticket for a parked vehicle.
     * 
     * @param slotNumber the slot number where the vehicle is parked
     * @param vehicle the parked vehicle
     */
    public Ticket(int slotNumber, Vehicle vehicle) {
        this.slotNumber = slotNumber;
        this.vehicle = vehicle;
    }
    
    /**
     * Creates a new ticket for a parked car (legacy constructor for backward compatibility).
     * 
     * @param slotNumber the slot number where the car is parked
     * @param car the parked car
     * @deprecated Use Ticket(int, Vehicle) instead
     */
    @Deprecated
    public Ticket(int slotNumber, Car car) {
        this(slotNumber, (Vehicle) car);
    }

    public int getSlotNumber() {
        return slotNumber;
    }

    /**
     * Gets the parked vehicle.
     * 
     * @return the parked vehicle
     */
    public Vehicle getVehicle() {
        return vehicle;
    }
    
    /**
     * Gets the parked car (legacy method for backward compatibility).
     * 
     * @return the parked car
     * @deprecated Use getVehicle instead
     */
    @Deprecated
    public Car getCar() {
        return (Car) vehicle;
    }
}