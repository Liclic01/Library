package controller;

import model.Author;
import model.dao.impl.AuthorDaoImpl;
import model.dao.impl.BookDaoImpl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

/**
 * Created by Алексей on 30.01.2016.
 */
@RestController
public class AuthorsController {
    private AuthorDaoImpl authorDaoImpl;
    private BookDaoImpl bookDaoImpl;

    @RequestMapping(value = "/author/", method = RequestMethod.POST)
    ResponseEntity<?> createAuthor(@RequestBody Author input, UriComponentsBuilder ucBuilder) {
        authorDaoImpl.addAuthor(input);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(ucBuilder.path("/author/{id}").buildAndExpand(input.getId()).toUri());
        return new ResponseEntity<Void>(httpHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/author/{id}", method = RequestMethod.DELETE)
    ResponseEntity<Author> deleteAuthor(@PathVariable("id") long id) {
        Author author = authorDaoImpl.getAuthorById(id);
        if (author == null) {
            return new ResponseEntity<Author>(HttpStatus.NOT_FOUND);
        }
        authorDaoImpl.deleteAuthor(id);
        return new ResponseEntity<Author>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/author/", method = RequestMethod.POST)
    ResponseEntity<List<Author>> listAllAuthor() {
        List<Author> authors = authorDaoImpl.getAllAuthor();
        if (authors.isEmpty()) {
            return new ResponseEntity<List<Author>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Author>>(authors, HttpStatus.OK);
    }
}
