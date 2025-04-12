import java.util.List;


public interface ParkingService {
    void initialize(int capacity);

    Ticket parkVehicle(Vehicle vehicle);

    boolean freeSlot(int slotNumber);
}