public class UseCase3InventorySetup {

    public static void main(String[] args) {

        System.out.println("Hotel Room Inventory Status\n");

        // Create room objects
        Room single = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suite = new SuiteRoom();

        // Create centralized inventory
        RoomInventory inventory = new RoomInventory();

        // Get availability
        int singleAvailable = inventory.getRoomAvailability().get("Single");
        int doubleAvailable = inventory.getRoomAvailability().get("Double");
        int suiteAvailable = inventory.getRoomAvailability().get("Suite");

        // Display details
        System.out.println("Single Room:");
        single.displayRoomDetails();
        System.out.println("Available Rooms: " + singleAvailable + "\n");

        System.out.println("Double Room:");
        doubleRoom.displayRoomDetails();
        System.out.println("Available Rooms: " + doubleAvailable + "\n");

        System.out.println("Suite Room:");
        suite.displayRoomDetails();
        System.out.println("Available Rooms: " + suiteAvailable);
    }
}
