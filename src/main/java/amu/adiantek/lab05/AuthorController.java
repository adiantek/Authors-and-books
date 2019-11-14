package amu.adiantek.lab05;

import amu.adiantek.lab05.container.AuthorContainer;
import amu.adiantek.lab05.db.Database;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/author")
public class AuthorController {

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
    public ResponseEntity<AuthorContainer> updateAuthor(@RequestBody AuthorContainer author) {
        if (Database.AUTHOR.updateAuthor(author)) {
            return new ResponseEntity<>(author, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> removeAuthor(@PathVariable("id") long id) {
        boolean success = Database.AUTHOR.removeAuthor(id);
        if (success) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
