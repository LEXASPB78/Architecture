/* Для каждого метода опишите, какие параметры (если есть) должны быть переданы в запросе, а также форматы данных 
запроса и ответа.
Пример запроса:
__
Предоставьте пример запроса для каждого метода, чтобы пользователи могли понять, как правильно формировать запросы.
Форматы данных:
__
Укажите, какой формат данных (обычно JSON) используется для передачи данных между клиентами и API Gateway.
Генерируйте документацию: */

package HW_11;

/**
 * Класс, содержащий методы для работы с API Gateway.
 */
public class ApiGatewayService {

    /**
     * Метод для выполнения GET-запроса к API Gateway.
     * @param url адрес API Gateway
     * @param headers заголовки запроса; может быть null, если заголовки не требуются
     * @return ответ от API Gateway
     */
    public String sendGetRequest(String url, Map<String, String> headers) {
        // реализация метода
    }

    /**
     * Метод для выполнения POST-запроса к API Gateway.
     * @param url адрес API Gateway
     * @param body тело запроса; может быть null, если тело не требуется
     * @param headers заголовки запроса; может быть null, если заголовки не требуются
     * @return ответ от API Gateway
     */
    public String sendPostRequest(String url, String body, Map<String, String> headers) {
        // реализация метода
    }

    /**
     * Метод для выполнения PUT-запроса к API Gateway.
     * @param url адрес API Gateway
     * @param body тело запроса; может быть null, если тело не требуется
     * @param headers заголовки запроса; может быть null, если заголовки не требуются
     * @return ответ от API Gateway
     */
    public String sendPutRequest(String url, String body, Map<String, String> headers) {
        // реализация метода
    }

    /**
     * Метод для выполнения DELETE-запроса к API Gateway.
     * @param url адрес API Gateway
     * @param headers заголовки запроса; может быть null, если заголовки не требуются
     * @return ответ от API Gateway
     */
    public String sendDeleteRequest(String url, Map<String, String> headers) {
        // реализация метода
    }
}
Примеры запросов для всех методов могут выглядеть следующим образом:

GET-запрос:

ApiGatewayService apiGatewayService = new ApiGatewayService();
String url = "https://api.example.com/users";
Map<String, String> headers = new HashMap<>();
headers.put("Authorization", "Bearer token123");
String response = apiGatewayService.sendGetRequest(url, headers);
POST-запрос:

ApiGatewayService apiGatewayService = new ApiGatewayService();
String url = "https://api.example.com/users";
String body = "{\"name\": \"John Smith\", \"email\": \"john@example.com\"}";
Map<String, String> headers = new HashMap<>();
headers.put("Authorization", "Bearer token123");
String response = apiGatewayService.sendPostRequest(url, body, headers);
PUT-запрос:

ApiGatewayService apiGatewayService = new ApiGatewayService();
String url = "https://api.example.com/users/123";
String body = "{\"name\": \"John Smith\", \"email\": \"john@example.com\"}";
Map<String, String> headers = new HashMap<>();
headers.put("Authorization", "Bearer token123");
String response = apiGatewayService.sendPutRequest(url, body, headers);
DELETE-запрос:

ApiGatewayService apiGatewayService = new ApiGatewayService();
String url = "https://api.example.com/users/123";
Map<String, String> headers = new HashMap<>();
headers.put("Authorization", "Bearer token123");
String response = apiGatewayService.sendDeleteRequest(url, headers);
Формат данных, который обычно используется для передачи данных между клиентами и API Gateway, может быть JSON.