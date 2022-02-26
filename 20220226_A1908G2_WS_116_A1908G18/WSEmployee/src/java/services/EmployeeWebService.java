/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import models.Employee;

/**
 *
 * @author Phong_learning
 */
@WebService(serviceName = "EmployeeWebService")
public class EmployeeWebService {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    @WebMethod(operationName = "adding")
    public String adding(@WebParam(name = "employeeNo") String employeeNo, @WebParam(name = "employeeName") String employeeName, @WebParam(name = "placeOfWork") String placeOfWork, @WebParam(name = "phoneNo") String phoneNo) {
        EntityManager em = Persistence.createEntityManagerFactory("WSEmployeePU").createEntityManager();
        try {
            if (employeeNo != null && employeeName != null && placeOfWork != null && phoneNo != null) {
                Employee employeeOne = em.find(Employee.class, employeeNo);
                if (employeeOne == null) {
                    em.getTransaction().begin();
                    Employee ep = new Employee(employeeNo, employeeName, placeOfWork, phoneNo);
                    em.persist(ep);
                    em.getTransaction().commit();
                    return "Successful";
                } else {
                    return "Existing Employee, please try one more time later";
                }
            }
        } catch (Exception e) {
            return "Error";
        }
       return "Error";
    }

    @WebMethod(operationName = "deleting")
    public int deleting(@WebParam(name = "employeeNo") String employeeNo) {
        EntityManager em = Persistence.createEntityManagerFactory("WSEmployeePU").createEntityManager();
        Employee employeeOne = em.find(Employee.class, employeeNo);
        if (employeeOne != null) {
            em.getTransaction().begin();
            em.remove(employeeOne);
            em.getTransaction().commit();
            return 1;
        }
        return 0;
    }

    @WebMethod(operationName = "gettingAll")
    public List<Employee> gettingAll() {
        EntityManager em = Persistence.createEntityManagerFactory("WSEmployeePU").createEntityManager();
        List<Employee> employees = em.createNamedQuery("Employee.findAll").getResultList();
        return employees;
    }
}
