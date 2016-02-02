package controller;

import model.Book;
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
@RequestMapping("/author/{id}/books/")
public class BooksController {
    private AuthorDaoImpl authorDaoImpl;
    private BookDaoImpl bookDaoImpl;

    @RequestMapping(value = "/author/{id}/book", method = RequestMethod.POST)
    ResponseEntity<?> createBook(@RequestBody Book input, UriComponentsBuilder ucBuilder) {
        bookDaoImpl.addBook(input);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(ucBuilder.path("/author/{id}/books/{id}").buildAndExpand(input.getId()).toUri());
        return new ResponseEntity<Void>(httpHeaders, HttpStatus.CREATED);
    }


    @RequestMapping(value = "/books/{id}", method = RequestMethod.DELETE)
    ResponseEntity<Book> deleteBook(@PathVariable("id") long id) {
        Book book = bookDaoImpl.getBookById(id);
        if (book == null) {
            return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
        }
        bookDaoImpl.deleteBook(id);
        return new ResponseEntity<Book>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/author/{id}", method = RequestMethod.POST)
    ResponseEntity<List<Book>> listAllBook(@PathVariable("id") long id) {
        List<Book> books=authorDaoImpl.getBookByAuthor(id);
        if (books.isEmpty()){
            return new ResponseEntity<List<Book>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Book>>(books,HttpStatus.OK);
    }
}
