package model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Алексей on 18.12.2015.
 */
@Entity
public class Author
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surName;
    private String CountryOfBirth;
    @OneToMany(mappedBy ="author")
    private List<Book> books;

    public Author(Long id, String name, String surName, String countryOfBirth, List<Book> books)
    {
        this.id = id;
        this.name = name;
        this.surName = surName;
        CountryOfBirth = countryOfBirth;
        this.books = books;
    }

    public List<Book> getBooks()
    {
        return books;
    }

    public void setBooks(List<Book> books)
    {
        this.books = books;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getSurName()
    {
        return surName;
    }

    public void setSurName(String surName)
    {
        this.surName = surName;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getCountryOfBirth()
    {
        return CountryOfBirth;
    }

    public void setCountryOfBirth(String countryOfBirth)
    {
        CountryOfBirth = countryOfBirth;
    }
}
