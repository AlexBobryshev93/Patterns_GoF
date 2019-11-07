public class Main {
    public static void main(String[] args) {
        ClientFacade clientFacade = new ClientFacade();
        System.out.println(clientFacade.getUserCode("Alex"));
    }
}

class ClientFacade {
    long getUserCode(String username) {
        // the realization may be very sophisticated
        // the idea is to hide it behind a simple interface (Facade)

        return (long) (Math.random() * 99999999999l);
    }
}
