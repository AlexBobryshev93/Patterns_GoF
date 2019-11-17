public class Main {
    public static void main(String[] args) {
        State letterPrinter = new LetterPrinter();
        State numberPrinter = new NumberPrinter();
        Context context = new Context(letterPrinter);

        context.doAction();
        context.doAction();
        context.doAction();

        context.setState(numberPrinter);
        context.doAction();
        context.doAction();
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

    public Context(State state) {
        this.state = state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void doAction() {
        state.print();
    }
}
