package HW_2;

// Создаем абстрактный класс, представляющий элемент цепочки
abstract class BaseHandler {
    private BaseHandler nextHandler; // следующий обработчик в цепочке
    
    public void setNextHandler(BaseHandler nextHandler) {
        this.nextHandler = nextHandler;
    }
    
    public void processRequest(Request request) {
        if (canHandle(request)) {
            handle(request);
        } else if (nextHandler != null) {
            nextHandler.processRequest(request);
        } else {
            System.out.println("Ни один обработчик не может обработать данную заявку!");
        }
    }
    
    // метод для проверки, может ли текущий обработчик обработать заявку
    protected abstract boolean canHandle(Request request);
    
    // метод для обработки заявки
    protected abstract void handle(Request request);
}

// Конкретная реализация обработчика
class ConcreteHandlerA extends BaseHandler {
    protected boolean canHandle(Request request) {
        return request.getType().equals("A");
    }
    
    protected void handle(Request request) {
        System.out.println("Запрос типа A обработан!");
    }
}

// Конкретная реализация обработчика
class ConcreteHandlerB extends BaseHandler {
    protected boolean canHandle(Request request) {
        return request.getType().equals("B");
    }
    
    protected void handle(Request request) {
        System.out.println("Запрос типа B обработан!");
    }
}

// Конкретная реализация обработчика
class ConcreteHandlerC extends BaseHandler {
    protected boolean canHandle(Request request) {
        return request.getType().equals("C");
    }
    
    protected void handle(Request request) {
        System.out.println("Запрос типа C обработан!");
    }
}

// Класс представляющий заявку, которую нужно обработать
class Request {
    private String type;
    
    public Request(String type) {
        this.type = type;
    }
    
    public String getType() {
        return type;
    }
}

// Использование паттерна цепочка обязанностей
public class Task_2 {
    public static void main(String[] args) {
        BaseHandler handlerA = new ConcreteHandlerA();
        BaseHandler handlerB = new ConcreteHandlerB();
        BaseHandler handlerC = new ConcreteHandlerC();
        
        handlerA.setNextHandler(handlerB);
        handlerB.setNextHandler(handlerC);
        
        Request request1 = new Request("A");
        handlerA.processRequest(request1);
        
        Request request2 = new Request("B");
        handlerA.processRequest(request2);
        
        Request request3 = new Request("C");
        handlerA.processRequest(request3);
        
        Request request4 = new Request("D");
        handlerA.processRequest(request4);
    }
}