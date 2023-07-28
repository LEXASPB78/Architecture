package HW_2;

// Создаем класс Task_6, который будет хранить внутреннее состояние и создавать снимок (мементо)
public class Task_6 {
    private String state;

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public Memento save() {
        return new Memento(state);
    }

    public void restore(Memento memento) {
        state = memento.getState();
    }
}

// Создаем класс Memento, который будет представлять снимок внутреннего состояния
public class Memento {
    private final String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}

// Создаем класс Caretaker, который будет хранить снимок состояния и предоставлять его по запросу
public class Caretaker {
    private Memento memento;

    public void saveMemento(Memento memento) {
        this.memento = memento;
    }

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}

// Пример использования паттерна Памятка
public class MementoPatternExample {
    public static void main(String[] args) {
        // Создаем объект Originator
        Task_6 originator = new Task_6();
        originator.setState("State1");

        // Создаем объект Caretaker
        Caretaker caretaker = new Caretaker();

        // Сохраняем состояние в Originator и получаем снимок
        caretaker.saveMemento(originator.save());

        // Меняем состояние объекта Originator
        originator.setState("State2");

        // Восстанавливаем сохраненное состояние с использованием снимка из Caretaker
        originator.restore(caretaker.getMemento());
    }
}


/* Реализация паттерна Памятка (Memento) в Java. В данном примере используется несколько классов: 
Originator (Создатель) хранит внутреннее состояние и создает снимок (мементо). Memento (Снимок) представляет 
снимок внутреннего состояния. Caretaker (Попечитель) хранит снимок состояния и предоставляет его по запросу.

В примере создается объект Originator, устанавливается начальное состояние и сохраняется снимок в объекте 
Caretaker. Затем состояние меняется и с использованием снимка из Caretaker восстанавливается сохраненное состояние. */