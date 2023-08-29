// Определите список эндпоинтов (URL-путей), которые будут доступны через ваш API Gateway. Например, /mobile и /web.
// Сформируйте запросы:

import java.util.ArrayList;
import java.util.List;

public class APIGateway {
    private List<String> endpoints;
    
    public APIGateway() {
        endpoints = new ArrayList<>();
    }
    
    public void addEndpoint(String endpoint) {
        endpoints.add(endpoint);
    }
    
    public void removeEndpoint(String endpoint) {
        endpoints.remove(endpoint);
    }
    
    public List<String> getEndpoints() {
        return endpoints;
    }
    
    public static void main(String[] args) {
        APIGateway apiGateway = new APIGateway();
        
        // Добавление эндпоинтов
        apiGateway.addEndpoint("/mobile");
        apiGateway.addEndpoint("/web");
        
        // Удаление эндпоинта
        apiGateway.removeEndpoint("/web");
        
        // Получение списка эндпоинтов
        List<String> endpoints = apiGateway.getEndpoints();
        for (String endpoint : endpoints) {
            System.out.println(endpoint);
        }
    }
}

// Результат:

// /mobile