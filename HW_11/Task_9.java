// Используйте возможности инструмента Swagger для автоматической генерации документации на основе вашей спецификации. Документация должна быть понятной и информативной.
// Тестирование:

package HW_11;

@RestController
@RequestMapping("/api")
public class UserController {
    
    @Autowired
    private UserRepository userRepository;
    
    @GetMapping("/users")
    @ApiOperation(value = "Get all users", notes = "Returns a list of all users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    
    @GetMapping("/users/{id}")
    @ApiOperation(value = "Get user by ID", notes = "Returns a user with the specified ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved user"),
            @ApiResponse(code = 404, message = "User not found")
    })
    public ResponseEntity<User> getUserById(
            @ApiParam(value = "ID of the user", required = true) @PathVariable Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @PostMapping("/users")
    @ApiOperation(value = "Create new user", notes = "Creates a new user")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "User created successfully"),
            @ApiResponse(code = 400, message = "Invalid user details")
    })
    public ResponseEntity<User> createUser(
            @ApiParam(value = "User object", required = true) @RequestBody User user) {
        User createdUser = userRepository.save(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }
    
    @PutMapping("/users/{id}")
    @ApiOperation(value = "Update user", notes = "Updates an existing user with the specified ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "User updated successfully"),
            @ApiResponse(code = 400, message = "Invalid user details"),
            @ApiResponse(code = 404, message = "User not found")
    })
    public ResponseEntity<User> updateUser(
            @ApiParam(value = "ID of the user", required = true) @PathVariable Long id,
            @ApiParam(value = "Updated user object", required = true) @RequestBody User user) {
        Optional<User> existingUser = userRepository.findById(id);
        if (existingUser.isPresent()) {
            user.setId(id);
            User updatedUser = userRepository.save(user);
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @DeleteMapping("/users/{id}")
    @ApiOperation(value = "Delete user", notes = "Deletes a user with the specified ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "User deleted successfully"),
            @ApiResponse(code = 404, message = "User not found")
    })
    public ResponseEntity<Void> deleteUser(
            @ApiParam(value = "ID of the user", required = true) @PathVariable Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            userRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

/*
Описание API
GET /api/users
Возвращает список всех пользователей.

GET /api/users/{id}
Возвращает пользователя с указанным ID.

Параметры
id - ID пользователя (тип: Long, обязательный параметр)
POST /api/users
Создает нового пользователя.

Тело запроса
Объект пользователя в формате JSON.

Пример тела запроса
{
    "firstName": "John",
    "lastName": "Doe",
    "email": "john.doe@example.com"
}
PUT /api/users/{id}
Обновляет существующего пользователя с указанным ID.

Параметры
id - ID пользователя (тип: Long, обязательный параметр)
Тело запроса
Обновленный объект пользователя в формате JSON.

Пример тела запроса
{
    "firstName": "Jane",
    "lastName": "Doe",
    "email": "jane.doe@example.com"
}
DELETE /api/users/{id}
Удаляет пользователя с указанным ID.

Параметры
id - ID пользователя (тип: Long, обязательный параметр)
*/