public class Main {
    public static void main(String[] args) {
        AmericanSocket americanSocket = new AmericanSocketImpl();
        Radio radio = new Radio();
        radio.listen(new SocketAdapter(americanSocket));
    }
}

interface  EuroSocket {
    void getPower();
}

interface AmericanSocket {
    void getPower();
}

class AmericanSocketImpl implements AmericanSocket {
    @Override
    public void getPower() {
        System.out.println("Getting 110 volt");
    }
}

class SocketAdapter implements EuroSocket {
    private AmericanSocket americanSocket;

    public SocketAdapter(AmericanSocket americanSocket) {
        this.americanSocket = americanSocket;
    }

    @Override
    public void getPower() {
        americanSocket.getPower();
    }
}
class Radio {
    public void listen(EuroSocket euroSocket) {
        euroSocket.getPower();
        System.out.println("listening to the radio");
    }
}
