package domain;

public class Book {
    private String title;
    private String author;
    private double price;

    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
package data;

import domain.Book;

import java.util.ArrayList;
import java.util.List;

public interface BookRepository {
    List<Book> getAllBooks();
    Book getBookByTitle(String title);
    void addBook(Book book);
    void updateBook(Book book);
    void deleteBook(String title);
}

public class InMemoryBookRepository implements BookRepository {
    private List<Book> books;

    public InMemoryBookRepository() {
        this.books = new ArrayList<>();
    }

    @Override
    public List<Book> getAllBooks() {
        return books;
    }

    @Override
    public Book getBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        return null;
    }

    @Override
    public void addBook(Book book) {
        books.add(book);
    }

    @Override
    public void updateBook(Book book) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getTitle().equals(book.getTitle())) {
                books.set(i, book);
                break;
            }
        }
    }

    @Override
    public void deleteBook(String title) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getTitle().equals(title)) {
                books.remove(i);
                break;
            }
        }
    }
}
package presentation;

import domain.Book;
import data.BookRepository;
import data.InMemoryBookRepository;

import java.util.List;

public class Main {
    private BookRepository bookRepository;

    public Main(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public static void main(String[] args) {
        BookRepository bookRepository = new InMemoryBookRepository();
        Main main = new Main(bookRepository);
        main.run();
    }

    public void run() {
        // Добавление книги
        Book book1 = new Book("Title1", "Author1", 9.99);
        bookRepository.addBook(book1);

        // Обновление информации о книге
        Book bookToUpdate = bookRepository.getBookByTitle("Title1");
        bookToUpdate.setAuthor("New Author");
        bookRepository.updateBook(bookToUpdate);

        // Удаление книги
        bookRepository.deleteBook("Title1");

        // Получение списка всех книг
        List<Book> allBooks = bookRepository.getAllBooks();
        for (Book book : allBooks) {
            System.out.println(book.getTitle() + " - " + book.getAuthor() + " - " + book.getPrice());
        }
    }
}