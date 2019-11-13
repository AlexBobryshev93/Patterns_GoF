import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Originator originator = new Originator("default");
        Caretaker caretaker = new Caretaker(originator);
        System.out.println(originator.getState());

        originator.setState(Character.toString((char) (Math.random() * 128)));
        caretaker.save();
        System.out.println(originator.getState());

        originator.setState(Character.toString((char) (Math.random() * 128)));
        System.out.println(originator.getState());
        caretaker.rollback();
        System.out.println(originator.getState());
    }
}

class Originator {
    private String state;

    public Originator(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Memento save() {
        return new Memento(state);
    }

    public void restore(Memento memento) {
        state = memento.state;
    }

    class Memento {
        private final Originator originator;
        private final String state;

        public Memento(String state) {
            originator = Originator.this;
            this.state = state;
        }
    }
}

class Caretaker {
    private Originator originator;
    private List<Originator.Memento> history = new ArrayList<>();

    public Caretaker(Originator originator) {
        this.originator = originator;
        history.add(originator.save());
    }

    public void save() {
        history.add(originator.save());
    }

    public void rollback() {
        originator.restore(history.get(history.size() - 1));
        history.remove(history.get(history.size() - 1));
    }
}

