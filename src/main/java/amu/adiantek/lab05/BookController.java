package amu.adiantek.lab05;

import amu.adiantek.lab05.container.AuthorContainer;
import amu.adiantek.lab05.container.BookContainer;
import amu.adiantek.lab05.db.Database;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {

    @PostMapping
    public BookContainer createBook(@RequestBody BookContainer book) {
        Database.BOOK.addBook(book);
        return book;
    }

    @GetMapping("{id}")
    public ResponseEntity<BookContainer> getBook(@PathVariable("id") long id) {
        BookContainer book = Database.BOOK.getBook(id);
        if (book == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<BookContainer> updateBook(@RequestBody BookContainer book) {
        if (Database.BOOK.updateBook(book)) {
            return new ResponseEntity<>(book, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> removeBook(@PathVariable("id") long id) {
        boolean success = Database.BOOK.removeBook(id);
        if (success) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
