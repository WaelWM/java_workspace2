package refined_solution;

import java.util.ArrayList;
import java.util.List;

class Book {
    private String title;
    private int stock;

    public Book(String title, int stock) {
        this.title = title;
        this.stock = stock;
    }

    public String getTitle() {
        return title;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}

// Using the Strategy pattern
interface BookSearcher {
    List<Book> search(String title, List<Book> books);
}

class TitleSearcher implements BookSearcher {
    @Override
    public List<Book> search(String title, List<Book> books) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                result.add(book);
            }
        }
        return result;
    }
}

class Library {
    private List<Book> books;
    private BookSearcher bookSearcher;

    public Library(List<Book> books) {
        this.books = books;
    }

    public void setBookSearcher(BookSearcher bookSearcher) {
        this.bookSearcher = bookSearcher;
    }

    public List<Book> search(String title) {
        if (bookSearcher == null) {
            throw new RuntimeException("BookSearcher is not found");
        }
        List<Book> searchResult = bookSearcher.search(title, books);
        if (searchResult.isEmpty()) {
            return null;
        } else {
            return searchResult;
        }
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void updateStock(String title, int stock) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                book.setStock(stock);
                return;
            }
        }
        throw new RuntimeException("Book not found: " + title);
    }
}

//Using Template Method pattern
abstract class LibraryAdmin {
    public Library library;

    public LibraryAdmin(Library library) {
        this.library = library;
    }

    public void performTask() {
        performAction();
    }

    public abstract void performAction();
}

class AddBookAdmin extends LibraryAdmin {
    private String title;
    private int stock;

    public AddBookAdmin(Library library, String title, int stock) {
        super(library);
        this.title = title;
        this.stock = stock;
    }

    @Override
    public void performAction() {
        Book book = new Book(title, stock);
        library.addBook(book);
        System.out.println("Book added: " + book.getTitle());
    }
}

class UpdateStockAdmin extends LibraryAdmin {
    private String title;
    private int stock;

    public UpdateStockAdmin(Library library, String title, int stock) {
        super(library);
        this.title = title;
        this.stock = stock;
    }

    @Override
    public void performAction() {
        library.updateStock(title, stock);
        System.out.println("Stock updated for: " + title);
    }
}
