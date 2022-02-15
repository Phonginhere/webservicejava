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
import models.Author;

/**
 *
 * @author Phong_learning
 */
@WebService(serviceName = "AuthorWebService")
public class AuthorWebService {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    @WebMethod(operationName = "findAll")
    public List<Author> findAll() {
        EntityManager entityManager = Persistence.createEntityManagerFactory("WSLibraryPU").createEntityManager();
        List<Author> authors = new ArrayList<Author>();

        try {
            Query query = entityManager.createNamedQuery("Author.findAll", Author.class);
            authors = query.getResultList();
            return authors;
        } catch (Exception e) {
            return null;
        }
    }

    @WebMethod(operationName = "insert")
    public Author insert(@WebParam(name = "authorName") String authorName,
            @WebParam(name = "birthday") Date birthday,
            @WebParam(name = "address") String address,
            @WebParam(name = "nickname") String nickname) {
        EntityManager entityManager = Persistence.createEntityManagerFactory("WSLibraryPU").createEntityManager();
        try {
            EntityTransaction entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            Author author = new Author(authorName, birthday, address, nickname);
            entityManager.persist(author);
            entityTransaction.commit();

            return author;
        } catch (Exception e) {
            return null;
        }

    }

    @WebMethod(operationName = "update")
    public Author update(@WebParam(name = "authorId") String authorId,
            @WebParam(name = "authorName") String authorName,
            @WebParam(name = "birthday") Date birthday,
            @WebParam(name = "address") String address,
            @WebParam(name = "nickname") String nickname) {
        EntityManager entityManager = Persistence.createEntityManagerFactory("WSLibraryPU").createEntityManager();
        HashMap<String, Object> result = new HashMap();
        try {
            Query query = entityManager.createNamedQuery("Author.findByAuthorId", Author.class);
            query.setParameter("authorId", authorId);
            Author author = (Author) query.getSingleResult();
            if (author != null) {
                EntityTransaction entityTransaction = entityManager.getTransaction();
                entityTransaction.begin();
                author.setAuthorName(authorName);
                author.setBirthday(birthday);
                author.setAddress(address);
                author.setNickname(nickname);
                entityManager.persist(author);
                entityTransaction.commit();
                return author;
            }
        } catch (Exception e) {
            return null;
        }
        return null;
    }

    @WebMethod(operationName = "delete")
    public String delete(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
}
