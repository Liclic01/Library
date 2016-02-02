package model.dao.impl;

import model.Author;
import model.Book;
import model.dao.AuthorDAO;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Алексей on 18.12.2015.
 */
public class AuthorDaoImpl implements AuthorDAO
{
private EntityManager em=EntitySingletonManager.getEm();

    public Long getId(Author author)
    {
        return null;
    }

    public Author getAuthorById(Long id)
    {
        return em.find(Author.class,id);
    }

    public void addAuthor(Author author)
    {
        em.getTransaction().begin();
        em.persist(author);
        em.getTransaction().commit();
    }

    public void deleteAuthor(Long id)
    {
        em.getTransaction().begin();
        Author author=em.find(Author.class,id);
        em.remove(author);
        em.getTransaction().commit();
    }
    public List<Book> getBookByAuthor(Long id){
        Author author=em.find(Author.class,id);
        return author.getBooks();
    }

    public List<Author> getAllAuthor(){
        Query query=em.createQuery("Select e FROM Author e");
        return (List<Author>) query.getResultList();
    }
}
