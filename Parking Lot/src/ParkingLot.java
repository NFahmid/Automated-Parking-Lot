import java.util.*;

public class ParkingLot {
    private List<Slot> slots;

    public void initialize(int n) {
        slots = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            slots.add(new Slot(i));
        }
    }

    public int parkCar(Car car) {
        for (Slot slot : slots) {
            if (!slot.isOccupied()) {
                slot.assignCar(car);
                return slot.getSlotNumber();
            }
        }
        return -1; 
    }

    public boolean leaveSlot(int slotNumber) {
        if (slotNumber >= 1 && slotNumber <= slots.size()) {
            Slot slot = slots.get(slotNumber - 1);
            if (slot.isOccupied()) {
                slot.removeCar();
                return true;
            }
        }
        return false;
    }

    public void getStatus() {
        System.out.println("Slot No.\tRegistration No.\tColour");
        for (Slot slot : slots) {
            if (slot.isOccupied()) {
                Car car = slot.getParkedCar();
                System.out.println(slot.getSlotNumber() + "\t" + car.getRegistrationNumber() + "\t" + car.getColor());
            }
        }
    }

    public List<String> findRegNumbersByColor(String color) {
        List<String> result = new ArrayList<>();
        for (Slot slot : slots) {
            if (slot.isOccupied() && slot.getParkedCar().getColor().equalsIgnoreCase(color)) {
                result.add(slot.getParkedCar().getRegistrationNumber());
            }
        }
        return result;
    }

    public List<Integer> findSlotNumbersByColor(String color) {
        List<Integer> result = new ArrayList<>();
        for (Slot slot : slots) {
            if (slot.isOccupied() && slot.getParkedCar().getColor().equalsIgnoreCase(color)) {
                result.add(slot.getSlotNumber());
            }
        }
        return result;
    }

    public int findSlotByRegNumber(String regNo) {
        for (Slot slot : slots) {
            if (slot.isOccupied() && slot.getParkedCar().getRegistrationNumber().equalsIgnoreCase(regNo)) {
                return slot.getSlotNumber();
            }
        }
        return -1;
    }
}
