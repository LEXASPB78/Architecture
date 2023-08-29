// Для каждого эндпоинта, определите HTTP-методы, которые он поддерживает (GET, POST, PUT, DELETE).
// Опишите запросы:

package HW_11;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@SpringBootApplication
public class DemoApplication {
    private Map<Integer, String> data = new HashMap<>();
    private AtomicInteger idCounter = new AtomicInteger(1);

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @GetMapping("/data/{id}")
    public ResponseEntity<String> getDataById(@PathVariable("id") int id) {
        if (data.containsKey(id)) {
            return ResponseEntity.ok(data.get(id));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Data not found");
        }
    }

    @PostMapping("/data")
    public ResponseEntity<Integer> createData(@RequestBody String content) {
        int id = idCounter.getAndIncrement();
        data.put(id, content);
        return ResponseEntity.ok(id);
    }

    @PutMapping("/data/{id}")
    public ResponseEntity<String> updateDataById(@PathVariable("id") int id, @RequestBody String content) {
        if (data.containsKey(id)) {
            data.put(id, content);
            return ResponseEntity.ok("Data updated successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Data not found");
        }
    }

    @DeleteMapping("/data/{id}")
    public ResponseEntity<String> deleteDataById(@PathVariable("id") int id) {
        if (data.containsKey(id)) {
            data.remove(id);
            return ResponseEntity.ok("Data deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Data not found");
        }
    }
}

// Endpoint /data/{id}
// GET: Получение данных по указанному id
// PUT: Обновление данных по указанному id
// DELETE: Удаление данных по указанному id
// Endpoint /data
// POST: Создание новых данных