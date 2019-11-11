import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Chat chat = new SimpleChat();
        User user1 = new SimpleUser(chat, "User1");
        User user2 = new SimpleUser(chat, "User2");
        chat.sendMessage("Hello, chat!", user1);
    }
}

interface Chat { // Mediator
    void sendMessage(String msg, User user);
}

interface User {
    void sendMessage(String msg);
    void getMessage(String msg);
}

class SimpleUser implements User {
    Chat chat;
    String name;

    public SimpleUser(Chat chat, String name) {
        this.chat = chat;
        this.name = name;
    }

    @Override
    public void sendMessage(String msg) {
        chat.sendMessage(msg, this);
    }

    @Override
    public void getMessage(String msg) {
        System.out.println("to " + name + ": " + msg);
    }
}

class SimpleChat implements Chat {
    private List<User> users = new ArrayList<>();

    @Override
    public void sendMessage(String msg, User user) {
        for (User usr : users) usr.getMessage(msg);
    }
}
