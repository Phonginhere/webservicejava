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
        EntityManager entityManager = Persistence.createEntityManagerFactory("WSAppLibraryPU").createEntityManager();
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
//authorName, birthday, address, nickname
        EntityManager entityManager = Persistence.createEntityManagerFactory("WSAppLibraryPU").createEntityManager();
        try {
            EntityTransaction entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            Author author = new Author();
            author.setAuthorName(authorName);
            author.setBirthday(birthday);
            author.setAddress(address);
            author.setNickname(nickname);
            entityManager.persist(author);
            entityTransaction.commit();

            return author;
        } catch (Exception e) {
            return null;
        }
    }
    @WebMethod(operationName = "update")
    public Author update(
            @WebParam(name = "authorId") String authorId,
            @WebParam(name = "authorName") String authorName,
            @WebParam(name = "birthday") Date birthday,
            @WebParam(name = "address") String address,
            @WebParam(name = "nickname") String nickname) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("WSAppLibraryPU");
         EntityManager em = factory.createEntityManager();
         
        //EntityManager entitymanager = Persistence.createEntityManagerFactory("WSLibrary22PU").createEntityManager();
        HashMap<String,Object> result = new HashMap();
        try{
           // Query query = entitymanager.createNamedQuery("Author.findByAuthorId", Author.class);
            //query.setParameter("authorId", authorId);
  
            Author author = em.find(Author.class, Short.parseShort(authorId));
            //Author author = (Author) query.getSingleResult();
            if(author != null){
                EntityTransaction entityTransaction = em.getTransaction();
                entityTransaction.begin();
                author.setAuthorName(authorName != null ? authorName : author.getAuthorName());
                author.setAddress(address == null || address.trim().equals("") ? author.getAddress() : address);
                author.setBirthday(birthday == null ? author.getBirthday() : birthday);
                author.setNickname(nickname == null || nickname.trim().equals("") ? author.getNickname() : nickname);
                em.persist(author);
                entityTransaction.commit();
                return author;
            }
            return null;
        }catch(Exception e) {
            return null;
        }
    }
    @WebMethod(operationName = "delete")
    public String delete(@WebParam(name = "authorId") String authorId) {
        EntityManager entitymanager = Persistence.createEntityManagerFactory("WSAppLibraryPU").createEntityManager();
         //EntityManager em = factory.createEntityManager();
         try{
        Query query = entitymanager.createNamedQuery("Author.findByAuthorId", Author.class);
        //Author std = entitymanager.find(Author.class, authorId);
         query.setParameter("authorId", Short.parseShort(authorId));
         Author author = (Author) query.getSingleResult();
         
         if(author != null){
             EntityTransaction entitytransaction = entitymanager.getTransaction();
             entitytransaction.begin();
             entitymanager.remove(author);
             entitytransaction.commit();
             
         }
             return "Remove";
         }catch(Exception e){
             return "Cannot remove";
         }
    }
}
