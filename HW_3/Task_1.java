// Пример нарушения принципа сегрегации интерфейса

interface AllInOnePrinter {
    void print();
    void scan();
    void fax();
    void copy();
}

class OfficePrinter implements AllInOnePrinter {
    public void print() {
        // реализация печати
    }

    public void scan() {
        // реализация сканирования
    }

    public void fax() {
        // реализация отправки факса
    }

    public void copy() {
        // реализация копирования
    }
}

class HomePrinter implements AllInOnePrinter {
    public void print() {
        // реализация печати
    }

    public void scan() {
        // реализация сканирования
    }

    public void fax() {
        // реализация отправки факса
    }

    public void copy() {
        // реализация копирования
    }
}

// Клиентский код

class Client {
    private AllInOnePrinter printer;

    public Client(AllInOnePrinter printer) {
        this.printer = printer;
    }

    public void printDocument() {
        printer.print();
    }

    public void scanDocument() {
        printer.scan();
    }

    public void sendFax() {
        printer.fax();
    }

    public void makeCopy() {
        printer.copy();
    }
}

// Решение, исправляющее принцип сегрегации интерфейса

interface Printer {
    void print();
}

interface Scanner {
    void scan();
}

interface Fax {
    void fax();
}

interface Copier {
    void copy();
}

interface AllInOnePrinter extends Printer, Scanner, Fax, Copier {
    // нет необходимости переопределять методы, т.к. они уже объявлены и реализованы в соответствующих интерфейсах
}

class OfficePrinter implements Printer, Scanner, Fax, Copier {
    public void print() {
        // реализация печати
    }

    public void scan() {
        // реализация сканирования
    }

    public void fax() {
        // реализация отправки факса
    }

    public void copy() {
        // реализация копирования
    }
}

class HomePrinter implements Printer, Scanner {
    public void print() {
        // реализация печати
    }

    public void scan() {
        // реализация сканирования
    }
}

// Клиентский код

class Client {
    private Printer printer;
    private Scanner scanner;
    private Fax fax;
    private Copier copier;

    public Client(Printer printer) {
        this.printer = printer;
    }

    public Client(Scanner scanner) {
        this.scanner = scanner;
    }

    public Client(Fax fax) {
        this.fax = fax;
    }

    public Client(Copier copier) {
        this.copier = copier;
    }

    public void printDocument() {
        printer.print();
    }

    public void scanDocument() {
        scanner.scan();
    }

    public void sendFax() {
        fax.fax();
    }

    public void makeCopy() {
        copier.copy();
    }
}