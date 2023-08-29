// Используйте инструмент Swagger или другие инструменты для тестирования запросов на вашем API Gateway. 
// Убедитесь, что запросы выполняются корректно.
// Документация и доступность:

package HW_11;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value="API Gateway", description="API Gateway endpoints")
public class GatewayController {

    @GetMapping("/")
    @ApiOperation(value = "API Gateway", response = String.class)
    public ResponseEntity<String> gateway() {
        return ResponseEntity.ok("API Gateway is running");
    }

    @PostMapping("/processData")
    @ApiOperation(value = "Process Data", response = String.class)
    public ResponseEntity<String> processData(@RequestBody String data) {
        // Обработка данных здесь
        return ResponseEntity.ok("Data processed successfully");
    }
}

/*
API Gateway представлен в виде класса GatewayController, который является контроллером Spring и имеет аннотацию 
@RestController. Этот класс содержит два метода:

Метод gateway является GET-запросом по корневому пути ("/"). Он возвращает ответ типа ResponseEntity<String> 
с сообщением "API Gateway is running". Аннотация @ApiOperation указывает Swagger описание метода.
Метод processData является POST-запросом по пути "/processData". Он принимает входные данные в виде строки 
(@RequestBody String data). В этом методе можно обрабатывать данные по заданной логике и возвращает ответ типа 
ResponseEntity<String> с сообщением "Data processed successfully". Опять же, аннотация @ApiOperation используется для описания метода в Swagger.
Можно использовать Swagger или другие инструменты для тестирования этих запросов на API Gateway 
и убедиться, что они выполняются корректно.
*/