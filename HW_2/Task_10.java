package HW_2;

// Интерфейс посетителя, определяющий методы для каждого элемента
interface Visitor {
    void visit(Element1 element1);
    void visit(Element2 element2);
    void visit(Element3 element3);
}

// Интерфейс элемента, определяющий метод accept для принятия посетителя
interface Element {
    void accept(Visitor visitor);
}

// Реализация первого элемента
class Element1 implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

// Реализация второго элемента
class Element2 implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

// Реализация третьего элемента
class Element3 implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

// Реализация первого посетителя
class Visitor1 implements Visitor {
    @Override
    public void visit(Element1 element1) {
        System.out.println("Visitor1 visited Element1");
    }

    @Override
    public void visit(Element2 element2) {
        System.out.println("Visitor1 visited Element2");
    }

    @Override
    public void visit(Element3 element3) {
        System.out.println("Visitor1 visited Element3");
    }
}

// Реализация второго посетителя
class Visitor2 implements Visitor {
    @Override
    public void visit(Element1 element1) {
        System.out.println("Visitor2 visited Element1");
    }

    @Override
    public void visit(Element2 element2) {
        System.out.println("Visitor2 visited Element2");
    }

    @Override
    public void visit(Element3 element3) {
        System.out.println("Visitor2 visited Element3");
    }
}

// Главный класс, выполняющий программу
public class Task_10 {
    public static void main(String[] args) {
        Element[] elements = {new Element1(), new Element2(), new Element3()};
        Visitor[] visitors = {new Visitor1(), new Visitor2()};

        // Выполняем итерации по каждому посетителю и принимаем каждый элемент
        for (Visitor visitor : visitors) {
            for (Element element : elements) {
                element.accept(visitor);
            }
        }
    }
}
