package HW_2;

/**
 * Интерфейс стратегии, определяющий метод для выполнения некоторого действия.
 */
interface Strategy {
    void execute();
}

/**
 * Конкретная стратегия, выполняющая действие A.
 */
class ConcreteStrategyA implements Strategy {
    @Override
    public void execute() {
        System.out.println("Executing strategy A");
    }
}

/**
 * Конкретная стратегия, выполняющая действие B.
 */
class ConcreteStrategyB implements Strategy {
    @Override
    public void execute() {
        System.out.println("Executing strategy B");
    }
}

/**
 * Контекст, использующий стратегии.
 */
class Context {
    private Strategy strategy;

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void executeStrategy() {
        if (strategy != null) {
            strategy.execute();
        }
    }
}

public class Task_8 {
    public static void main(String[] args) {
        // Создаем контекст
        Context context = new Context();

        // Устанавливаем стратегию A
        context.setStrategy(new ConcreteStrategyA());
        // Выполняем стратегию A
        context.executeStrategy(); // Вывод: Executing strategy A

        // Устанавливаем стратегию B
        context.setStrategy(new ConcreteStrategyB());
        // Выполняем стратегию B
        context.executeStrategy(); // Вывод: Executing strategy B
    }
}
