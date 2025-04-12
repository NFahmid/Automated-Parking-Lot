import java.util.List;


public interface SlotManager {

    List<Slot> createSlots(int capacity);

    Slot findNearestAvailableSlot();

    Slot getSlotByNumber(int slotNumber);
    

    List<Slot> getAllSlots();
}