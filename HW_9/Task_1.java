import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
@RequestMapping("/books")
public class BookApiApplication {

    private static Map<Integer, Book> books = new HashMap<>();
    private static int nextId = 1;

    public static void main(String[] args) {
        SpringApplication.run(BookApiApplication.class, args);
    }

    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        book.setId(nextId++);
        books.put(book.getId(), book);
        return new ResponseEntity<>(book, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> bookList = new ArrayList<>(books.values());
        return new ResponseEntity<>(bookList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable int id) {
        if (books.containsKey(id)) {
            Book book = books.get(id);
            return new ResponseEntity<>(book, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable int id, @RequestBody Book updatedBook) {
        if (books.containsKey(id)) {
            updatedBook.setId(id);
            books.put(id, updatedBook);
            return new ResponseEntity<>(updatedBook, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable int id) {
        if (books.containsKey(id)) {
            books.remove(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    static class Book {
        private int id;
        private String title;
        private String author;
        private int year;

        // Constructors, getters, and setters

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }
    }
}

// Пример запросов:

// Добавление новой книги:
// Метод: POST
// URL: /books
// Тело запроса (JSON формат):

{
    "title": "Book Title",
    "author": "Book Author",
    "year": 2022
}

// Получение списка всех книг:
// Метод: GET
// URL: /books
// Получение информации о конкретной книге по ID:
// Метод: GET
// URL: /books/{id}
// Пример: /books/1
// Обновление информации о книге:
// Метод: PUT
// URL: /books/{id}
// Пример: /books/1
// Тело запроса (JSON формат):

{
    "title": "Updated Title",
    "author": "Updated Author",
    "year": 2023
}

// Удаление книги:
// Метод: DELETE
// URL: /books/{id}
// Пример: /books/1