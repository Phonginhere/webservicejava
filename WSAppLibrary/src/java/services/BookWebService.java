/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import models.Author;
import models.Book;

/**
 *
 * @author Phong_learning
 */
@WebService(serviceName = "BookWebService")
public class BookWebService {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
     @WebMethod(operationName = "findAll")
    public List<Book> findAll() {
        EntityManager entityManager = Persistence.createEntityManagerFactory("WSAppLibraryPU").createEntityManager();
        List<Book> books = new ArrayList<Book>();

        try {
            Query query = entityManager.createNamedQuery("Book.findAll", Book.class);
            books = query.getResultList();
            return books;
        } catch (Exception e) {
            return null;
        }
    }
    @WebMethod(operationName = "find")
    public Author find(
            @WebParam(name = "authorId") String authorId) {
        EntityManager em = Persistence.createEntityManagerFactory("WSAppLibraryPU").createEntityManager();

        Query query = em.createNamedQuery("Author.findByAuthorId", Author.class).setParameter("authorId", Short.parseShort(authorId));

        Author author = (Author) query.getSingleResult();
        return author;
    }
    @WebMethod(operationName = "findAuthor")
    public Author findAuthor(
            @WebParam(name = "authorId") String authorId) {
        EntityManager em = Persistence.createEntityManagerFactory("WSAppLibraryPU").createEntityManager();

        Query query = em.createNamedQuery("Author.findByAuthorId", Author.class).setParameter("authorId", Short.parseShort(authorId));

        Author author = (Author) query.getSingleResult();
        return author;
    }
  @WebMethod(operationName = "insertBook")
    public Book insertBook(
            @WebParam(name = "bookName") String bookName,
            @WebParam(name = "price") String price,
            @WebParam(name = "deliveredDate") Date deliveredDate,
            @WebParam(name = "factory") String factory,
            @WebParam(name = "nickname") String nickname,
            @WebParam(name = "authorId") String authorId) {
        EntityManager em = Persistence.createEntityManagerFactory("WSAppLibraryPU").createEntityManager();

        try {
            em.getTransaction().begin();
            Book book = new Book();
            book.setBookName(bookName);
            book.setDeliveredDate(deliveredDate);
            book.setFactory(factory);
            book.setNickname(nickname);
            book.setAuthorId(findAuthor(authorId));
            book.setPrice(Float.parseFloat(price));
            em.persist(book);
            em.getTransaction().commit();
            return book;
        } catch (Exception e) {
            return null;
        }
    }
    @WebMethod(operationName = "update")
   public Book updateBook(
            @WebParam(name = "id") String id,
            @WebParam(name = "bookName") String bookName,
            @WebParam(name = "price") String price,
            @WebParam(name = "deliveredDate") Date deliveredDate,
            @WebParam(name = "factory") String factory,
            @WebParam(name = "nickname") String nickname,
            @WebParam(name = "authorId") String authorId) {
        EntityManager em = Persistence.createEntityManagerFactory("WSAppLibraryPU").createEntityManager();

        Query query = em.createNamedQuery("Book.findById", Book.class).setParameter("id", Integer.parseInt(id));
        
        Book book = (Book) query.getSingleResult();
        try {
            em.getTransaction().begin();
            book.setBookName(bookName != null ? bookName : book.getBookName());
            book.setPrice(price != null ? Float.parseFloat(price) : book.getPrice());
            book.setDeliveredDate(deliveredDate != null ? deliveredDate : book.getDeliveredDate());
            book.setFactory(factory != null ? factory : book.getFactory());
            book.setNickname(nickname != null ? nickname : book.getNickname());
            book.setAuthorId(findAuthor(authorId) != null ? findAuthor(authorId) : book.getAuthorId());
            em.persist(book);
            em.getTransaction().commit();
            return book;
        } catch (Exception e) {
            return null;
        }
    }
    
     @WebMethod(operationName = "deleteBook")
    public String deleteBook(@WebParam(name = "id") String id){
        EntityManager em = Persistence.createEntityManagerFactory("WSAppLibraryPU").createEntityManager();
        
        Query query = em.createNamedQuery("Book.findById", Book.class).setParameter("id", Short.parseShort(id));
        
        Book book = (Book) query.getSingleResult();
        if(book != null){
            em.getTransaction().begin();
            em.remove(book);
            em.getTransaction().commit();
            return "remove";
        }else
            return "cannot remove";
    }
}
