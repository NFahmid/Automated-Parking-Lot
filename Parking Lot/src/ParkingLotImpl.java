import java.util.ArrayList;
import java.util.List;


public class ParkingLotImpl implements ParkingService, SearchService {
    private final SlotManager slotManager;
    private List<Ticket> tickets;

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
            slot.assignVehicle(vehicle);
            Ticket ticket = new Ticket(slot.getSlotNumber(), vehicle);
            tickets.add(ticket);
            return ticket;
        }
        return null;
    }
    
    @Override
    public boolean freeSlot(int slotNumber) {
        Slot slot = slotManager.getSlotByNumber(slotNumber);
        if (slot != null && slot.isOccupied()) {
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