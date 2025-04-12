import java.util.List;

/**
 * Interface defining the core operations of a parking service.
 * This follows the Single Responsibility Principle by focusing only on parking operations.
 * It also enables the Open/Closed Principle by allowing different implementations.
 */
public interface ParkingService {
    /**
     * Initializes the parking lot with the specified number of slots.
     * 
     * @param capacity the number of parking slots to create
     */
    void initialize(int capacity);
    
    /**
     * Parks a vehicle in the nearest available slot.
     * 
     * @param vehicle the vehicle to park
     * @return a ticket if successful, null if no slots available
     */
    Ticket parkVehicle(Vehicle vehicle);
    
    /**
     * Frees up a parking slot.
     * 
     * @param slotNumber the slot number to free
     * @return true if successful, false if the slot was already empty or invalid
     */
    boolean freeSlot(int slotNumber);
}