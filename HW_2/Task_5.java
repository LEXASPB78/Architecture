package HW_2;

import java.util.ArrayList;
import java.util.List;

// Интерфейс посредника
interface Mediator {
    void sendMessage(String message, Colleague colleague);

    void addColleague(User user1);
}

// Конкретный посредник
class ChatMediator implements Mediator {
    private List<Colleague> colleagues;

    public ChatMediator() {
        colleagues = new ArrayList<>();
    }

    public void addColleague(Colleague colleague) {
        colleagues.add(colleague);
    }

    @Override
    public void sendMessage(String message, Colleague colleague) {
        for (Colleague c : colleagues) {
            if (c != colleague) {
                c.receiveMessage(message);
            }
        }
    }

    @Override
    public void addColleague(User user1) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addColleague'");
    }
}

// Абстрактный класс Коллеги
abstract class Colleague {
    protected Mediator mediator;

    public Colleague(Mediator mediator) {
        this.mediator = mediator;
    }

    public abstract void sendMessage(String message);

    public abstract void receiveMessage(String message);
}

// Конкретный класс Коллеги
class User extends Colleague {
    private String name;

    public User(String name, Mediator mediator) {
        super(mediator);
        this.name = name;
    }

    @Override
    public void sendMessage(String message) {
        System.out.println(name + " отправляет сообщение: " + message);
        mediator.sendMessage(message, this);
    }

    @Override
    public void receiveMessage(String message) {
        System.out.println(name + " принимает сообщение: " + message);
    }
}

public class Task_5 {
    public static void main(String[] args) {
        Mediator mediator = new ChatMediator();

        User user1 = new User("User 1", mediator);
        User user2 = new User("User 2", mediator);
        User user3 = new User("User 3", mediator);

        mediator.addColleague(user1);
        mediator.addColleague(user2);
        mediator.addColleague(user3);

        user1.sendMessage("Привет, есть ли кто-нибудь онлайн?");
        user2.sendMessage("Да, я здесь.");
        user3.sendMessage("Я тоже онлайн.");

        // Вывод:
        // User 1 отправляет сообщение: Привет, есть ли кто-нибудь онлайн?
        // User 2 принимает сообщение: Привет, есть ли кто-нибудь онлайн?
        // User 3 принимает сообщение: Привет, есть ли кто-нибудь онлайн?
        // User 2 отправляет сообщение: Да, я здесь.
        // User 1 принимает сообщение: Да, я здесь.
        // User 3 принимает сообщение: Да, я здесь.
        // User 3 отправляет сообщение: Я тоже онлайн.
        // User 1 принимает сообщение: Я тоже онлайн.
        // User 2 принимает сообщение: Я тоже онлайн.
    }
}
