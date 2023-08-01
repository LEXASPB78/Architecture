public interface Service {
    void doSomething();
}

public class LowLevelService implements Service {
    @Override
    public void doSomething() {
    }
}

public class HighLevelService {
    private Service service;

    public HighLevelService(Service service) {
        this.service = service;
    }

    public void performAction() {
        service.doSomething();
    }
}

public class Main {
    public static void main(String[] args) {
        Service service = new LowLevelService();
        HighLevelService highLevelService = new HighLevelService(service);
        highLevelService.performAction();
    }
}

/* В этом примере принцип инверсии зависимостей (DIP) реализован следующим образом:
Создан интерфейс Service, который определяет метод doSomething().
Создан класс LowLevelService, который реализует интерфейс Service и выполняет низкоуровневые операции.
Создан класс HighLevelService, который принимает объект типа Service через конструктор и выполняет высокоуровневую
 логику, делегируя низкоуровневые операции объекту Service.
В методе Main.main() создается объект LowLevelService, который реализует интерфейс Service, затем создается 
объект HighLevelService, передавая LowLevelService в конструктор, и выполняется действие с помощью HighLevelService.
Таким образом, высокоуровневый модуль HighLevelService зависит только от абстракции Service, а не от конкретной 
реализации, что соответствует принципу инверсии зависимостей (DIP). */