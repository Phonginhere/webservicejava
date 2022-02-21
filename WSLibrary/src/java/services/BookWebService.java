/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
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
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
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
        EntityManager entityManager = Persistence.createEntityManagerFactory("WSLibraryPU").createEntityManager();
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
    public Book insert(@WebParam(name = "id") String id,
            @WebParam(name = "bookName") String bookName,
            @WebParam(name = "price") String price,
            @WebParam(name = "deliveredDate") Date deliveredDate,
            @WebParam(name = "nickname") String nickname,
            @WebParam(name = "factory") String factory,
            @WebParam(name = "authorId") String authorId) {
        EntityManager entityManager = Persistence.createEntityManagerFactory("WSLibraryPU").createEntityManager();
        try {
            EntityTransaction entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            Book book = new Book(Short.parseShort(id), bookName, Float.parseFloat(price) , deliveredDate, nickname, factory, Short.parseShort(authorId));
            entityManager.persist(book);
            entityTransaction.commit();

            return book;
        } catch (Exception e) {
            return null;
        }

    }

    @WebMethod(operationName = "update")
    public Book update(@WebParam(name = "id") String id,
            @WebParam(name = "bookName") String bookName,
            @WebParam(name = "price") String price,
            @WebParam(name = "deliveredDate") Date deliveredDate,
            @WebParam(name = "nickname") String nickname,
            @WebParam(name = "factory") String factory,
            @WebParam(name = "authorId") String authorId) {
        EntityManager entityManager = Persistence.createEntityManagerFactory("WSLibraryPU").createEntityManager();
        HashMap<String, Object> result = new HashMap();
        try {
            Query query = entityManager.createNamedQuery("Book.findById", Book.class);
            query.setParameter("id", id);
            Book books = (Book) query.getSingleResult();
            if (books != null) {
                EntityTransaction entityTransaction = entityManager.getTransaction();
                entityTransaction.begin();
                books.setBookName(bookName);
                books.setDeliveredDate(deliveredDate);
                books.setFactory(factory);
                books.setNickname(nickname);
                books.setPrice(Float.parseFloat(price));
                books.setAuthorId(Short.parseShort(authorId));
                entityManager.persist(books);
                entityTransaction.commit();
                return books;
            }
        } catch (Exception e) {
            return null;
        }
        return null;
    }

    @WebMethod(operationName = "delete")
    public int delete(@WebParam(name = "id") String id) {
        EntityManager entitymanager = Persistence.createEntityManagerFactory("WSLibraryPU").createEntityManager();
            try{
                Query query = entitymanager.createNamedQuery("Book.findById", Book.class);
                query.setParameter("id", id);
                Book book = (Book) query.getSingleResult();
                if(book !=null){
                    EntityTransaction entityTransaction = entitymanager.getTransaction();
                    entityTransaction.begin();
                    entitymanager.remove(book);
                    entityTransaction.commit();
                }
                return 1;
            }catch(Exception e){
                return 0;
            }
    }
}
