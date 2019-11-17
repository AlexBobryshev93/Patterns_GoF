/*
Quite similar to State pattern. But here the Context object knows nothing about
the injected Strategy object. All the changes go from the client code.
In State pattern the State objects themselves can change the context
 */

public class Main {
    public static void main(String[] args) {
        Strategy letterPrinter = new LetterPrinter();
        Strategy numberPrinter = new NumberPrinter();
        Context context = new Context(letterPrinter);

        context.doAction();
        context.doAction();
        context.doAction();

        context.setStrategy(numberPrinter);
        context.doAction();
        context.doAction();
        context.doAction();
    }
}

interface Strategy {
    void print();
}

class NumberPrinter implements Strategy {
    @Override
    public void print() {
        System.out.println(Character.toString((char) (48 + (Math.random() * 10))));
    }
}

class LetterPrinter implements Strategy {
    @Override
    public void print() {
        System.out.println(Character.toString((char) (65 + (Math.random() * 26))));
    }
}

class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void doAction() {
        strategy.print();
    }
}

