/*
Quite similar to Strategy pattern. But here the State objects themselves can change the context
and it's State object.
In Strategy pattern the Context object knows nothing about
the injected Strategy object. All the Strategy object changes are made from the client code.
 */

public class Main {
    public static void main(String[] args) {
        Context context = new Context();
        context.setState(new NumberPrinter());

        context.doAction();
        context.changeState();
        context.doAction();
        context.changeState();
        context.doAction();
    }
}

interface State {
    void print();
}

class NumberPrinter implements State {
    @Override
    public void print() {
        System.out.println(Character.toString((char) (48 + (Math.random() * 10))));
    }
}

class LetterPrinter implements State {
    @Override
    public void print() {
        System.out.println(Character.toString((char) (65 + (Math.random() * 26))));
    }
}

class Context {
    private State state;

    public void setState(State state) {
        this.state = state;
    }

    public void changeState() {
        if (state instanceof LetterPrinter) state = new NumberPrinter();
        else state = new LetterPrinter();
    }

    public void doAction() {
        for (int i = 0; i < 3; i++) state.print();
    }
}
