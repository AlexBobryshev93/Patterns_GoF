public class Main {
    public static void main(String[] args) {
        MessageHandler messageHandler = new UpperCaseHandler(
                new ExclamationHandler(
                        new PrinterHandler(null)));
        messageHandler.handle("hi there");
    }
}

abstract class MessageHandler {
    MessageHandler nextHandler;

    public MessageHandler(MessageHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    abstract void handle(String msg);
}

class UpperCaseHandler extends MessageHandler {
    public UpperCaseHandler(MessageHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    void handle(String msg) {
        nextHandler.handle(msg.toUpperCase());
    }
}

class ExclamationHandler extends MessageHandler {
    public ExclamationHandler(MessageHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    void handle(String msg) {
        nextHandler.handle(msg + "!!!");
    }
}
class PrinterHandler extends MessageHandler{
    public PrinterHandler(MessageHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    void handle(String msg) {
        System.out.println(msg);
    }
}
