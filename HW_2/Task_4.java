package HW_2;

import java.util.ArrayList;
import java.util.List;

// Интерфейс итератора
interface Iterator {
    boolean hasNext();
    Object next();
}

// Класс, реализующий итератор для списка
class ListIterator implements Iterator {
    private List<Object> list;
    private int currentIndex;

    public ListIterator(List<Object> list) {
        this.list = list;
        this.currentIndex = 0;
    }

    public boolean hasNext() {
        return currentIndex < list.size();
    }

    public Object next() {
        if (this.hasNext()) {
            Object nextItem = list.get(currentIndex);
            currentIndex++;
            return nextItem;
        }
        return null;
    }
}

// Пример использования итератора
public class Task_4 {
    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");

        Iterator iterator = new ListIterator(list);

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
