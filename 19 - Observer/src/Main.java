import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Publisher publisher = new Publisher("default");
        Subscriber subscriber1 = new SubscriberImpl();
        Subscriber subscriber2 = new SubscriberImpl();

        subscriber1.subscribe(publisher);
        subscriber2.subscribe(publisher);
        publisher.notifySubscribers();
        System.out.println("Subscriber1:");
        subscriber1.showStatus();
        System.out.println("Subscriber2:");
        subscriber2.showStatus();

        publisher.setState("updated");
        publisher.notifySubscribers();
        System.out.println("Subscriber1:");
        subscriber1.showStatus();
        System.out.println("Subscriber2:");
        subscriber2.showStatus();

        subscriber2.unsubscribe(publisher);
        publisher.setState("back to default");
        publisher.notifySubscribers();
        System.out.println("Subscriber1:");
        subscriber1.showStatus();
        System.out.println("Subscriber2:");
        subscriber2.showStatus();
    }
}

interface Subscriber { // Observer
    void update(Publisher publisher);
    void subscribe(Publisher publisher);
    void unsubscribe(Publisher publisher);
    void showStatus();
}

class SubscriberImpl implements Subscriber {
    private String state;

    @Override
    public void update(Publisher publisher) {
        state = publisher.getState();
    }

    @Override
    public void subscribe(Publisher publisher) {
        publisher.subscribe(this);
    }

    @Override
    public void unsubscribe(Publisher publisher) {
        publisher.unsubscribe(this);
    }

    @Override
    public void showStatus() {
        System.out.println(state);
    }
}
class Publisher {
    private String state;
    private Set<Subscriber> subscribers = new HashSet<>();

    public Publisher(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    void unsubscribe(Subscriber subscriber) {
        for (Subscriber s : subscribers) {
            if (s == subscriber) {
                subscribers.remove(subscriber);
                return;
            }
        }
    }

    void notifySubscribers() {
        for (Subscriber s : subscribers) s.update(this);
    }
}
