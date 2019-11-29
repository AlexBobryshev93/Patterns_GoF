import java.util.ArrayList;
import java.util.List;

/*
This pattern is used when it's better to handle the
data and events in some intermediate class
 */
public class Main {
    public static void main(String[] args) {
        Chat chat = new SimpleChat();
        User user1 = new SimpleUser(chat, "User1");
        User user2 = new SimpleUser(chat, "User2");
        user1.sendMessage("Hello, chat!");
    }
}

interface Chat { // Mediator
    void sendMessage(String msg, User user);
    void addUser(User user);
}

interface User {
    void sendMessage(String msg);
    void getMessage(String msg);
}

class SimpleUser implements User {
    Chat chat;
    String name;

    public SimpleUser(Chat chat, String name) {
        chat.addUser(this);
        this.chat = chat;
        this.name = name;
    }

    @Override
    public void sendMessage(String msg) {
        System.out.println(this.name + " says");
        chat.sendMessage(msg, this);
    }

    @Override
    public void getMessage(String msg) {
        System.out.println("to " + this.name + ": " + msg);
    }
}

class SimpleChat implements Chat {
    private List<User> users = new ArrayList<>();

    @Override
    public void sendMessage(String msg, User user) {
        for (User usr : users) {
            if (user != usr) usr.getMessage(msg);
        }
    }

    @Override
    public void addUser(User user) {
        users.add(user);
    }
}
