package HW_2;

// Создаем класс строителя, который предоставляет методы для поэтапного создания объекта
class HouseBuilder {
    // Поля для хранения состояния объекта, который мы строим
    private String walls;
    private String roof;
    private String doors;
    private String windows;
    
    public HouseBuilder setWalls(String walls) {
        this.walls = walls;
        return this;
    }
    
    public HouseBuilder setRoof(String roof) {
        this.roof = roof;
        return this;
    }
    
    public HouseBuilder setDoors(String doors) {
        this.doors = doors;
        return this;
    }
    
    public HouseBuilder setWindows(String windows) {
        this.windows = windows;
        return this;
    }
    
    // Метод, который возвращает готовый объект House
    public House build() {
        return new House(walls, roof, doors, windows);
    }
}

// Класс, который мы будем создавать с помощью строителя
class House {
    private String walls;
    private String roof;
    private String doors;
    private String windows;
    
    public House(String walls, String roof, String doors, String windows) {
        this.walls = walls;
        this.roof = roof;
        this.doors = doors;
        this.windows = windows;
    }
    
    // Геттеры для доступа к полям
    public String getWalls() {
        return walls;
    }
    
    public String getRoof() {
        return roof;
    }
    
    public String getDoors() {
        return doors;
    }
    
    public String getWindows() {
        return windows;
    }
}

public class Task_1 {
    public static void main(String[] args) {
        // Использование паттерна Builder
        House house = new HouseBuilder()
            .setWalls("Brick")
            .setRoof("Tile")
            .setDoors("Wooden")
            .setWindows("Glass")
            .build();
        
        // Выводим информацию о построенном доме
        System.out.println("Walls: " + house.getWalls());
        System.out.println("Roof: " + house.getRoof());
        System.out.println("Doors: " + house.getDoors());
        System.out.println("Windows: " + house.getWindows());
    }
}
