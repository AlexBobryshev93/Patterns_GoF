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

interface Memento {
    String getState();
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
        return new MementoImpl(state);
    }

    public void restore(Memento memento) {
        state = memento.getState();
    }

    private class MementoImpl implements Memento {
        private String state;

        public MementoImpl(String state) {
            this.state = state;
        }

        @Override
        public String getState() {
            return state;
        }
    }
}

class Caretaker {
    private Originator originator;
    private List<Memento> history = new ArrayList<>();

    public Caretaker(Originator originator) {
        this.originator = originator;
    }

    public void doSomething() {
        history.add(originator.save());
        originator.setState(Character.toString((char) (Math.random() * 128)));
    }

    public void unDo() {
        Memento m = history.get(history.size() - 1);
        originator.restore(m);
        history.remove(m);
    }
}

