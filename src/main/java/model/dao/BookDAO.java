package model.dao;

import model.Book;

/**
 * Created by Алексей on 18.12.2015.
 */
public interface BookDAO
{
    Long getId (Book book);
    Book getBookById (Long id);
    void addBook (Book book);
    void deleteBook (Long id);

}
