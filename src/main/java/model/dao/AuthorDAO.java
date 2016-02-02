package model.dao;

import model.Author;
import model.Book;

import java.util.List;

/**
 * Created by Алексей on 18.12.2015.
 */
public interface AuthorDAO
{
    Long getId (Author author);
    Author getAuthorById (Long id);
    void addAuthor (Author author);
    void deleteAuthor (Long id);

}
