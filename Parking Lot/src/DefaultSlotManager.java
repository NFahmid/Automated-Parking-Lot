import java.util.ArrayList;
import java.util.List;

/**
 * Default implementation of the SlotManager interface.
 */
public class DefaultSlotManager implements SlotManager {
    private List<Slot> slots;
    
    public DefaultSlotManager() {
        this.slots = new ArrayList<>();
    }
    
    @Override
    public List<Slot> createSlots(int capacity) {
        slots = new ArrayList<>();
        for (int i = 1; i <= capacity; i++) {
            slots.add(new Slot(i));
        }
        return slots;
    }
    
    @Override
    public Slot findNearestAvailableSlot() {
        for (Slot slot : slots) {
            if (!slot.isOccupied()) {
                return slot;
            }
        }
        return null;
    }
    
    @Override
    public Slot getSlotByNumber(int slotNumber) {
        if (slotNumber >= 1 && slotNumber <= slots.size()) {
            return slots.get(slotNumber - 1);
        }
        return null;
    }
    
    @Override
    public List<Slot> getAllSlots() {
        return new ArrayList<>(slots);
    }
}