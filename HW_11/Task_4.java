// Определите, какие функции будет выполнять ваш API Gateway. Например, это может быть маршрутизация запросов 
// от мобильных устройств и веб-клиентов к соответствующим микросервисам.

package HW_11;

import java.util.HashMap;
import java.util.Map;

public class ApiGateway {
    private Map<String, Microservice> routes;

    public ApiGateway() {
        routes = new HashMap<>();
    }

    public void addRoute(String path, Microservice microservice) {
        routes.put(path, microservice);
    }

    public Response handleRequest(Request request) {
        String path = request.getPath();
        
        if (!routes.containsKey(path)) {
            return new Response(404, "Not found");
        }
        
        Microservice microservice = routes.get(path);
        return microservice.processRequest(request.getData());
    }
}