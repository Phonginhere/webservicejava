/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package services;

import java.util.Date;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
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
        @WebMethod(operationName = "insert")
    public String insert( @WebParam(name = "authorName") String authorName,
            @WebParam(name = "birthday") Date birthday,
            @WebParam(name = "address") String address,
            @WebParam(name = "nickname") String nickname) {
       
//authorName, birthday, address, nickname
        EntityManager entityManager = Persistence.createEntityManagerFactory("WSLibraryPU").createEntityManager();
        try {
            EntityTransaction entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            Author author = new Author();
            entityManager.persist(author);
            entityTransaction.commit();

            return author;
        } catch (Exception e) {
            return null;
        }
//           return ""; 
    }
}
