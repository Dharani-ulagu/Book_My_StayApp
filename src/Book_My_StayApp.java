public class Book_My_StayApp {

    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println("Welcome to Book My Stay");
        System.out.println("=================================\n");

        runUseCase2();
        runUseCase3();
        runUseCase4();
        runUseCase5();
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
    // Use Case 5: Booking Queue (FIFO)
    // -----------------------------
    public static void runUseCase5() {

        System.out.println("Use Case 5: Booking Request Queue\n");

        BookingRequestQueue bookingQueue = new BookingRequestQueue();

        bookingQueue.addRequest(new Reservation("Abhi", "Single"));
        bookingQueue.addRequest(new Reservation("Subha", "Double"));
        bookingQueue.addRequest(new Reservation("Vanmathi", "Suite"));

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
}