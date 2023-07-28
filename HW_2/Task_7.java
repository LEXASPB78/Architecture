package HW_2;

// Интерфейс состояния
interface State {
    void doAction();
}

// Конкретное состояние 1
class State1 implements State {
    @Override
    public void doAction() {
        System.out.println("State 1 action");
    }
}

// Конкретное состояние 2
class State2 implements State {
    @Override
    public void doAction() {
        System.out.println("State 2 action");
    }
}

// Класс контекста
class Context {
    private State state;

    public Context() {
        this.state = new State1(); // Начальное состояние
    }

    public void setState(State state) {
        this.state = state;
    }

    public void executeStateAction() {
        state.doAction();
    }
}

// Пример использования
public class Task_7 {
    public static void main(String[] args) {
        Context context = new Context();

        // Вызов состояния 1
        context.executeStateAction();

        // Изменение состояния на состояние 2
        context.setState(new State2());

        // Вызов состояния 2
        context.executeStateAction();
    }
}
