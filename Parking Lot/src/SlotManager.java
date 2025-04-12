import java.util.List;

/**
 * Interface for managing parking slots.
 * This follows the Single Responsibility Principle by focusing only on slot management.
 */
public interface SlotManager {
    /**
     * Creates slots with the specified capacity.
     * 
     * @param capacity the number of slots to create
     * @return the list of created slots
     */
    List<Slot> createSlots(int capacity);
    
    /**
     * Finds the nearest available slot.
     * 
     * @return the nearest available slot, or null if none available
     */
    Slot findNearestAvailableSlot();
    
    /**
     * Gets a slot by its number.
     * 
     * @param slotNumber the slot number
     * @return the slot, or null if the slot number is invalid
     */
    Slot getSlotByNumber(int slotNumber);
    
    /**
     * Gets all slots.
     * 
     * @return the list of all slots
     */
    List<Slot> getAllSlots();
}