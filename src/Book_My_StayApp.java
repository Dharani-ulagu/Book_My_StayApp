public class Book_My_StayApp {

    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println("Welcome to Book My Stay");
        System.out.println("=================================\n");

        runUseCase2();
        runUseCase3();
        runUseCase4();
        runUseCase5();
        runUseCase6();
    }

    // -----------------------------
    // Use Case 2: Room Initialization
    // -----------------------------
    public static void runUseCase2() {

        System.out.println("Use Case 2: Room Initialization\n");

        Room single = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suite = new SuiteRoom();

        single.displayRoomDetails();
        System.out.println();

        doubleRoom.displayRoomDetails();
        System.out.println();

        suite.displayRoomDetails();
        System.out.println();
    }

    // -----------------------------
    // Use Case 3: Inventory
    // -----------------------------
    public static void runUseCase3() {

        System.out.println("Use Case 3: Room Inventory\n");

        RoomInventory inventory = new RoomInventory();

        System.out.println(inventory.getRoomAvailability());
        System.out.println();
    }

    // -----------------------------
    // Use Case 4: Room Search
    // -----------------------------
    public static void runUseCase4() {

        System.out.println("Use Case 4: Room Search\n");

        Room single = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suite = new SuiteRoom();

        RoomInventory inventory = new RoomInventory();

        RoomSearchService searchService = new RoomSearchService();

        searchService.searchAvailableRooms(
                inventory,
                single,
                doubleRoom,
                suite
        );

        System.out.println();
    }

    // -----------------------------
    // Use Case 5: Booking Request Queue
    // -----------------------------
    public static void runUseCase5() {

        System.out.println("Use Case 5: Booking Request Queue\n");

        BookingRequestQueue bookingQueue = new BookingRequestQueue();

        Reservation r1 = new Reservation("Abhi", "Single");
        Reservation r2 = new Reservation("Subha", "Double");
        Reservation r3 = new Reservation("Vanmathi", "Suite");

        bookingQueue.addRequest(r1);
        bookingQueue.addRequest(r2);
        bookingQueue.addRequest(r3);

        while (bookingQueue.hasPendingRequests()) {

            Reservation request = bookingQueue.getNextRequest();

            System.out.println(
                    "Processing booking for Guest: "
                            + request.getGuestName()
                            + ", Room Type: "
                            + request.getRoomType()
            );
        }

        System.out.println();
    }
    public static void runUseCase6() {

        System.out.println("\nUse Case 6: Room Allocation Processing");

        RoomInventory inventory = new RoomInventory();

        BookingRequestQueue bookingQueue = new BookingRequestQueue();

        bookingQueue.addRequest(new Reservation("Abhi", "Single"));
        bookingQueue.addRequest(new Reservation("Subha", "Single"));
        bookingQueue.addRequest(new Reservation("Vanmathi", "Suite"));

        RoomAllocationService allocationService = new RoomAllocationService();

        while (bookingQueue.hasPendingRequests()) {

            Reservation reservation = bookingQueue.getNextRequest();

            allocationService.allocateRoom(reservation, inventory);
        }
    }
}