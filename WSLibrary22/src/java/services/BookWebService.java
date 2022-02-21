/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
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
        EntityManager entityManager = Persistence.createEntityManagerFactory("WSLibrary22PU").createEntityManager();
        List<Book> books = new ArrayList<Book>();

        try {
            Query query = entityManager.createNamedQuery("Book.findAll", Book.class);
            books = query.getResultList();
            return books;
        } catch (Exception e) {
            return null;
        }
    }
    @WebMethod(operationName = "insert")
    public Book insert(@WebParam(name = "bookName") String bookName,
            @WebParam(name = "price") Float price,
            @WebParam(name = "deliveredDate") Date deliveredDate,
            @WebParam(name = "nickname") String nickname,
            @WebParam(name = "factory") String factory,
            @WebParam(name = "authorId") String authorId) {
//authorName, birthday, address, nickname
        EntityManager entityManager = Persistence.createEntityManagerFactory("WSLibrary22PU").createEntityManager();
        try {
            EntityTransaction entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            Book book = new Book();
            book.setBookName(bookName);
            book.setDeliveredDate(deliveredDate);
            book.setFactory(factory);
            book.setId(Short.parseShort(authorId));
            book.setNickname(nickname);
            book.setPrice(price);
            entityManager.persist(book);
            entityTransaction.commit();

            return book;
        } catch (Exception e) {
            return null;
        }
    }
    @WebMethod(operationName = "update")
    public Book update(
            @WebParam(name = "id") String id,
            @WebParam(name = "bookName") String bookName,
            @WebParam(name = "price") Float price,
            @WebParam(name = "deliveredDate") Date deliveredDate,
            @WebParam(name = "nickname") String nickname,
            @WebParam(name = "factory") String factory,
            @WebParam(name = "authorId") String authorId) {
        EntityManager entityManager = Persistence.createEntityManagerFactory("WSLibrary22PU").createEntityManager();
         
        //EntityManager entitymanager = Persistence.createEntityManagerFactory("WSLibrary22PU").createEntityManager();
        HashMap<String,Object> result = new HashMap();
        try{
            Query queryAuthor = entityManager.createNamedQuery("Author.findByAuthorId", Book.class);
            queryAuthor.setParameter("authorId", authorId);
            Author bookAuthorId = (Author) queryAuthor.getSingleResult();
            
            Query query = entityManager.createNamedQuery("Book.findById", Book.class);
            query.setParameter("id", id);
  
            //Book author = em.find(Author.class, Short.parseShort(authorId));
            Book book = (Book) query.getSingleResult();
            if(book != null){
                EntityTransaction entityTransaction = entityManager.getTransaction();
                entityTransaction.begin();
                book.setBookName(bookName != null ? bookName : book.getBookName());
                book.setPrice(price != null ? price : book.getPrice());
                book.setDeliveredDate(deliveredDate != null ? deliveredDate : book.getDeliveredDate());
                book.setNickname(nickname != null ? nickname : book.getNickname());
                book.setFactory(factory != null ? factory: book.getFactory());
                book.setAuthorId(bookAuthorId != null ? bookAuthorId : book.getAuthorId());
                entityManager.persist(book);
                entityTransaction.commit();
                return book;
            }
            return null;
        }catch(Exception e) {
            return null;
        }
    }
    
    @WebMethod(operationName = "delete")
    public String delete(@WebParam(name = "id") String id) {
        EntityManager entitymanager = Persistence.createEntityManagerFactory("WSLibrary22PU").createEntityManager();
         //EntityManager em = factory.createEntityManager();
         try{
        Query query = entitymanager.createNamedQuery("Book.findByAuthorId", Book.class);
         query.setParameter("authorId", Short.parseShort(id));
         Book book = (Book) query.getSingleResult();
         
         if(book != null){
             EntityTransaction entitytransaction = entitymanager.getTransaction();
             entitytransaction.begin();
             entitymanager.remove(book);
             entitytransaction.commit();
             
         }
             return "Remove";
         }catch(Exception e){
             return "Cannot remove";
         }
    }
}
