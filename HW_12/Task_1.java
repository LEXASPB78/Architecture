/*
### **Задание:**

a. Спроектировать пользовательский интерфейс (web-SPA, native mobile), основные компоненты (подключение робота, 
управление помещениями, расписание работы, сервисное обслуживание робота, история уборок), https://www.figma.com/ 
или https://app.diagrams.net/.

b. Спроектировать доменную модель, в виде текста Домен – атрибуты.

c. Спроектировать сценарии (Use case)(подключение, выбор помещения, программы уборки, настройка расписания, 
просмотр статистики..), в виде Актор – Прецедент (из первой лекции).

d. Спроектировать слой  API Gateway (mobile, web), сформировать REST запросы: GET, POST, PUT, DELETE 
([https://swagger.io](https://swagger.io/)).

* (дополнительно, по желанию) Разработать REST контракты API между компонентами и сгенерировавать (автоматически 
на ресурсе [https://swagger.io](https://swagger.io/)) код на разных языках программирования.

e. Спроектировать компоненты бизнес-логики и связать их API Gateway с применением паттерна BFF 
https://app.diagrams.net/.

f. Определить состав информации для кеширования на уровне приложения пользователя, API Gateway, уровня 
бизнес-логики и уровня репозитория. Список.

g. Спроектировать ER модель (https://www.dbdesigner.net/), запросы в БД и уровень хранения данных (СУБД).
*/

package HW_12;

// Класс для пользовательского интерфейса
public class UserInterface {
    // Метод для подключения робота
    public void connectRobot(String robotId) {
        // Код для подключения робота
    }
    
    // Метод для управления помещением
    public void controlRoom(String roomId, String action) {
        // Код для управления помещением
    }
    
    // Метод для настройки расписания работы
    public void setSchedule(String roomId, String schedule) {
        // Код для настройки расписания работы
    }
    
    // Метод для сервисного обслуживания робота
    public void serviceRobot(String robotId) {
        // Код для сервисного обслуживания робота
    }
    
    // Метод для просмотра истории уборок
    public void viewCleaningHistory() {
        // Код для просмотра истории уборок
    }
}

// Класс для доменной модели
public class DomainModel {
    // Классы для домена
    public class Robot {
        private String id;
        // Дополнительные атрибуты робота

        public Robot(String id) {
            this.id = id;
        }

        // Геттеры и сеттеры для атрибутов робота
    }
    
    // Дополнительные классы для домена
    
    ...
}

// Класс для сценариев
public class UseCases {
    // Классы для акторов и прецедентов
    public class User {
        // Прецеденты пользователя
        public void connectRobot(String robotId) {
            // Код для подключения робота
        }
        
        public void controlRoom(String roomId, String action) {
            // Код для управления помещением
        }
        
        public void setSchedule(String roomId, String schedule) {
            // Ваш код для настройки расписания работы
        }
        
        public void serviceRobot(String robotId) {
            // Код для сервисного обслуживания робота
        }
        
        public void viewCleaningHistory() {
            // Код для просмотра истории уборок
        }
    }
    
    // Дополнительные классы для акторов и прецедентов
    
    ...
}

// Класс для API Gateway
public class ApiGateway {
    // Методы для REST запросов
    public void get(String url) {
        // Код для GET запроса
    }
    
    public void post(String url, String data) {
        // Код для POST запроса
    }
    
    public void put(String url, String data) {
        // Код для PUT запроса
    }
    
    public void delete(String url) {
        // Код для DELETE запроса
    }
}
// Код размечен с использованием markdown.