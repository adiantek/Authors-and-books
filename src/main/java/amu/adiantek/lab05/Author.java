package amu.adiantek.lab05;

import amu.adiantek.lab05.container.AuthorContainer;
import amu.adiantek.lab05.db.Database;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/author")
public class Author {

    @PostMapping
    public AuthorContainer createAuthor(@RequestBody AuthorContainer author) {
        Database.AUTHOR.addAuthor(author);
        return author;
    }

    @GetMapping("{id}")
    public ResponseEntity<AuthorContainer> getAuthor(@PathVariable("id") long id) {
        AuthorContainer author = Database.AUTHOR.getAuthor(id);
        if (author == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(author, HttpStatus.OK);
    }

    @PutMapping
    public AuthorContainer updateAuthor(@RequestBody AuthorContainer author) {
        Database.AUTHOR.updateAuthor(author);
        return author;
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable("id") long id) {
        boolean success = Database.AUTHOR.deleteAuthor(id);
        if (success) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
