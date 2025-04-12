import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of the ParkingService and SearchService interfaces.
 * This class follows the Dependency Inversion Principle by depending on abstractions.
 */
public class ParkingLotImpl implements ParkingService, SearchService {
    private final SlotManager slotManager;
    private List<Ticket> tickets;
    
    /**
     * Constructor that takes a SlotManager dependency.
     * This follows the Dependency Inversion Principle by depending on an abstraction.
     * 
     * @param slotManager the slot manager to use
     */
    public ParkingLotImpl(SlotManager slotManager) {
        this.slotManager = slotManager;
        this.tickets = new ArrayList<>();
    }
    
    @Override
    public void initialize(int capacity) {
        slotManager.createSlots(capacity);
        tickets = new ArrayList<>();
    }
    
    @Override
    public Ticket parkVehicle(Vehicle vehicle) {
        Slot slot = slotManager.findNearestAvailableSlot();
        if (slot != null) {
            // Now we can use the Vehicle interface directly without casting
            slot.assignVehicle(vehicle);
            Ticket ticket = new Ticket(slot.getSlotNumber(), vehicle);
            tickets.add(ticket);
            return ticket;
        }
        return null; // No available slot found
    }
    
    @Override
    public boolean freeSlot(int slotNumber) {
        Slot slot = slotManager.getSlotByNumber(slotNumber);
        if (slot != null && slot.isOccupied()) {
            // Remove the ticket associated with this slot
            tickets.removeIf(ticket -> ticket.getSlotNumber() == slotNumber);
            slot.removeVehicle();
            return true;
        }
        return false;
    }
    
    @Override
    public void getStatus() {
        System.out.println("Slot No.\tRegistration No.\tColour");
        for (Slot slot : slotManager.getAllSlots()) {
            if (slot.isOccupied()) {
                Vehicle vehicle = slot.getParkedVehicle();
                System.out.println(slot.getSlotNumber() + "\t" + vehicle.getRegistrationNumber() + "\t" + vehicle.getColor());
            }
        }
    }
    
    @Override
    public List<String> findRegistrationNumbersByColor(String color) {
        List<String> result = new ArrayList<>();
        for (Slot slot : slotManager.getAllSlots()) {
            if (slot.isOccupied() && slot.getParkedVehicle().getColor().equalsIgnoreCase(color)) {
                result.add(slot.getParkedVehicle().getRegistrationNumber());
            }
        }
        return result;
    }
    
    @Override
    public List<Integer> findSlotNumbersByColor(String color) {
        List<Integer> result = new ArrayList<>();
        for (Slot slot : slotManager.getAllSlots()) {
            if (slot.isOccupied() && slot.getParkedVehicle().getColor().equalsIgnoreCase(color)) {
                result.add(slot.getSlotNumber());
            }
        }
        return result;
    }
    
    @Override
    public int findSlotByRegistrationNumber(String regNo) {
        for (Slot slot : slotManager.getAllSlots()) {
            if (slot.isOccupied() && slot.getParkedVehicle().getRegistrationNumber().equalsIgnoreCase(regNo)) {
                return slot.getSlotNumber();
            }
        }
        return -1;
    }
}