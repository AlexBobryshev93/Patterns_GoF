public class Main {
    public static void main(String[] args) {
        Expression isDeveloperExpression = getDeveloperExpression();
        Expression isGermanSpeakerExpression = getLanguageExpression();

        System.out.println("Is a developer: " + isDeveloperExpression.interpret("java core spring"));
        System.out.println("Is a German speaker: " + isGermanSpeakerExpression.interpret("Russian, English"));
    }

    private static Expression getDeveloperExpression() {
        Expression java = new TerminalExpression("Java");
        Expression spring = new TerminalExpression("Spring");

        return new AndExpression(java, spring);
    }

    private static Expression getLanguageExpression() {
        Expression ger1 = new TerminalExpression("German");
        Expression ger2 = new TerminalExpression("Deutsch");

        return new OrExpression(ger1, ger2);
    }
}

interface Expression {
    boolean interpret(String context);
}

class AndExpression implements Expression { // Non-terminal expression
    private Expression expression1;
    private Expression expression2;

    public AndExpression(Expression expression1, Expression expression2) {
        this.expression1 = expression1;
        this.expression2 = expression2;
    }

    @Override
    public boolean interpret(String context) {
        return expression1.interpret(context) && expression2.interpret(context);
    }
}

class OrExpression implements Expression { // Non-terminal expression
    private Expression expression1;
    private Expression expression2;

    public OrExpression(Expression expression1, Expression expression2) {
        this.expression1 = expression1;
        this.expression2 = expression2;
    }

    @Override
    public boolean interpret(String context) {
        return expression1.interpret(context) || expression2.interpret(context);
    }
}

class TerminalExpression implements Expression {
    String data;

    public TerminalExpression(String data) {
        this.data = data;
    }

    @Override
    public boolean interpret(String context) {
        return context.toLowerCase().contains(data.toLowerCase());
    }
}
