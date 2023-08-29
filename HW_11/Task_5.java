// Если используете Swagger, создайте новую спецификацию (или проект) для вашего API Gateway.
// Определите эндпоинты:

package HW_11;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ApiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }

    @RequestMapping("/")
    public String home() {
        return "Welcome to the API Gateway!";
    }

    @GetMapping("/endpoint1")
    public String endpoint1() {
        return "This is endpoint 1";
    }

    @GetMapping("/endpoint2")
    public String endpoint2() {
        return "This is endpoint 2";
    }

}

// Теперь можно использовать Swagger, чтобы создать спецификацию для API Gateway. 
// Нужно создать файл swagger-config.yml и добавить следующий код:

swagger: '2.0'
info:
  title: API Gateway
  description: API Gateway
  version: 1.0.0
paths:
  /endpoint1:
    get:
      summary: Get Endpoint 1
      description: Get endpoint 1
      responses:
        '200':
          description: Successful response
          schema:
            type: string
  /endpoint2:
    get:
      summary: Get Endpoint 2
      description: Get endpoint 2
      responses:
        '200':
          description: Successful response
          schema:
            type: string

// Теперь можно использовать спецификацию Swagger для документирования API Gateway.