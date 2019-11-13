import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Originator originator = new Originator("default");
        Caretaker caretaker = new Caretaker(originator);
        System.out.println(originator.getState());
        caretaker.doSomething();
        System.out.println(originator.getState());
        caretaker.unDo();
        System.out.println(originator.getState());
    }
}

class Originator {
    private String state;
    private List<Memento> history = new ArrayList<>();

    public Originator(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public List<Memento> getHistory() {
        return history;
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
        private String state;

        public Memento(String state) {
            this.state = state;
        }
    }
}

class Caretaker {
    private Originator originator;

    public Caretaker(Originator originator) {
        this.originator = originator;
    }

    public void doSomething() {
        originator.getHistory().add(originator.save());
        originator.setState(Character.toString((char) (Math.random() * 128)));
    }

    public void unDo() {
        originator.restore(originator.getHistory().get(originator.getHistory().size() - 1));
        originator.getHistory().remove(originator.getHistory().get(originator.getHistory().size() - 1));
    }
}

