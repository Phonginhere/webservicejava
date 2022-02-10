/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package services;

import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Tblemployee;

/**
 *
 * @author Phong_learning
 */
@WebService(serviceName = "EmployeeWS")
public class EmployeeWS {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    @WebMethod(operationName = "insert")
    public void insert(String EmployeeNo, String Name, String Placeofwork, String PhoneNo) {
        int i = 0;
        i++;
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("WebApplicationAppPU");
        EntityManager em = factory.createEntityManager();

        Tblemployee te = new Tblemployee();

        te.setEmployeeNo(EmployeeNo);
        te.setEmployeeName(Name);
        te.setPlaceOfWork(Placeofwork);
        te.setPhoneNo(PhoneNo);
        em.getTransaction().begin();
        em.persist(te);
        em.getTransaction().commit();
//        return "Hello " + txt + " !";
    }

    @WebMethod(operationName = "display")
    public void display(HttpServletRequest request, HttpServletResponse response) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("WebApplicationAppPU");
        EntityManager em = factory.createEntityManager();
        Query query = em.createNamedQuery("Tblemployee.findAll", Tblemployee.class);
        List<Tblemployee> list = query.getResultList();
        request.setAttribute("display", list);
        
    }
}
