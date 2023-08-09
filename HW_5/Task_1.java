package HW_5;

// Класс модели данных
public class User {
    private String name;
    private int age;
    
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    // Геттеры и сеттеры
}

// Интерфейс DAO
public interface UserDao {
    void addUser(User user);
    void updateUser(User user);
    void deleteUser(User user);
    User getUser(String name);
}

// Реализация DAO для работы с базой данных
public class UserDaoImpl implements UserDao {
    @Override
    public void addUser(User user) {
        // Логика добавления пользователя в базу данных
    }
    
    @Override
    public void updateUser(User user) {
        // Логика обновления информации о пользователе в базе данных
    }
    
    @Override
    public void deleteUser(User user) {
        // Логика удаления пользователя из базы данных
    }
    
    @Override
    public User getUser(String name) {
        // Логика получения пользователя из базы данных
        return null;
    }
}

// Пример использования
public class Task_1 {
    public static void main(String[] args) {
        UserDao userDao = (UserDao) new UserDaoImpl();
        
        User user1 = new User("John", 25);
        ((HW_5.UserDao) userDao).addUser(user1);
        
        User user2 = ((HW_5.UserDao) userDao).getUser("John");
        user2.setAge(30);
        ((HW_5.UserDao) userDao).updateUser(user2);
        
        ((HW_5.UserDao) userDao).deleteUser(user2);
    }
}

// Диаграмма компонент UML паттерна DAO:

@startuml
interface UserDao {
    + addUser(user: User): void
    + updateUser(user: User): void
    + deleteUser(user: User): void
    + getUser(name: String): User
}

class UserDaoImpl {
    + addUser(user: User): void
    + updateUser(user: User): void
    + deleteUser(user: User): void
    + getUser(name: String): User
}

UserDao <-- UserDaoImpl
@enduml
