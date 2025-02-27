import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class TicketBookingSystem {
    private static final int TOTAL_SEATS = 10;
    private boolean[] seats = new boolean[TOTAL_SEATS];
    private Lock lock = new ReentrantLock();

    public void bookSeat(String customer, int seatNumber) {
        lock.lock();
        try {
            if (seatNumber < 0 || seatNumber >= TOTAL_SEATS) {
                System.out.println(customer + " - Invalid seat number.");
                return;
            }
            if (!seats[seatNumber]) {
                seats[seatNumber] = true;
                System.out.println(customer + " successfully booked seat " + seatNumber);
            } else {
                System.out.println(customer + " - Seat " + seatNumber + " is already booked.");
            }
        } finally {
            lock.unlock();
        }
    }
}

class CustomerThread extends Thread {
    private TicketBookingSystem bookingSystem;
    private String customerName;
    private int seatNumber;

    public CustomerThread(TicketBookingSystem bookingSystem, String customerName, int seatNumber, int priority) {
        this.bookingSystem = bookingSystem;
        this.customerName = customerName;
        this.seatNumber = seatNumber;
        setPriority(priority);
    }

    @Override
    public void run() {
        bookingSystem.bookSeat(customerName, seatNumber);
    }
}


