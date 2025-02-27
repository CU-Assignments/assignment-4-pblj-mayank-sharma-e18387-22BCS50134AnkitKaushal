public class TicketBookingDemo {
    public static void main(String[] args) {
        TicketBookingSystem bookingSystem = new TicketBookingSystem();

        Thread vip1 = new CustomerThread(bookingSystem, "VIP1", 2, Thread.MAX_PRIORITY);
        Thread vip2 = new CustomerThread(bookingSystem, "VIP2", 3, Thread.MAX_PRIORITY);
        Thread regular1 = new CustomerThread(bookingSystem, "Regular1", 2, Thread.NORM_PRIORITY);
        Thread regular2 = new CustomerThread(bookingSystem, "Regular2", 4, Thread.NORM_PRIORITY);

        vip1.start();
        vip2.start();
        regular1.start();
        regular2.start();
    }
}
