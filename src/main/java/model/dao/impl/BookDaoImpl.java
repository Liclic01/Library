package model.dao.impl;

import model.Book;
import model.dao.BookDAO;

import javax.persistence.EntityManager;

/**
 * Created by Алексей on 18.12.2015.
 */
public class BookDaoImpl implements BookDAO
{
    private EntityManager em=EntitySingletonManager.getEm();
    public Long getId(Book book)
    {
        return null;
    }

    public Book getBookById(Long id)
    {
        return em.find(Book.class,id);

    }

    public void addBook(Book book)
    {
        em.getTransaction().begin();
        em.persist(book);
        em.getTransaction().commit();
    }

    public void deleteBook(Long id)
    {
        em.getTransaction().begin();
        Book book=em.find(Book.class,id);
        em.remove(book);
        em.getTransaction().commit();
    }
}
