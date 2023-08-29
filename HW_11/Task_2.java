// Спроектировать слой  API Gateway (mobile, web), сформировать REST запросы: GET, POST, PUT, DELETE.
// Предположим, у вас есть простой API для управления списком пользователей. Вам нужно описать запрос типа GET, 
// который вернет список всех пользователей.

package HW_11;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @GetMapping
    public List<User> getAllUsers() {
        // Код для получения списка всех пользователей из базы данных или другого источника данных
        List<User> users = userService.getAllUsers();
        return users;
    }
}

// Класс, представляющий модель пользователя
public class User {
    private String id;
    private String name;
    // Другие поля пользователя и их геттеры/сеттеры
    
    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }
}

/* В данном примере создается класс UserController, который обрабатывает запросы, связанные со списком пользователей.
Аннотация @RestController указывает, что данный класс будет обрабатывать REST-запросы. Аннотация 
@RequestMapping("/api/users") указывает URL-путь, по которому можно получить доступ к API.

Метод getAllUsers() обрабатывает GET-запрос, возвращая список всех пользователей. В данном примере предполагается,
 что существует сервис userService, который содержит логику получения списка пользователей из базы данных или 
 другого источника данных.

Также приведен класс User, который представляет модель пользователя и содержит необходимые поля (в данном примере 
только id и name). Этот класс может быть расширен другими полями, в зависимости от требований вашей системы. */