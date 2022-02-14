/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package services;

import java.util.ArrayList;
import java.util.HashMap;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import models.Employee;

/**
 *
 * @author Phong_learning
 */
@WebService(serviceName = "EmployeeWS")
public class EmployeeWS {

    /**
     * This is a sample web service operation
     */
//    @WebMethod(operationName = "hello")
//    public String hello(@WebParam(name = "name") String txt) {
//        return "Hello " + txt + " !";
//    }
//    
    private EntityManager entityManager = Persistence.createEntityManagerFactory("WSAppPU")
                .createEntityManager();
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {        
        return "Hello " + txt + " !";
    }
    
    @WebMethod(operationName = "findAll")
    public java.util.List<Employee> findAll() {
        //HashMap<String, Object> result = new HashMap<>();        
        java.util.List<Employee> employees = new ArrayList<Employee>();
        try {
            Query query = entityManager.createNamedQuery("Employee.findAll", Employee.class);
            employees = query.getResultList();
            return employees;            
        } catch(Exception e) {
            return employees;
        }        
    }
    
    @WebMethod(operationName = "insertEmployee")
    public Employee insertEmployee(
            @WebParam(name = "employeeNo") String employeeNo,
            @WebParam(name = "employeeName") String employeeName,
            @WebParam(name = "placeOfWork") String placeOfWork,
            @WebParam(name = "phoneNo") String phoneNo) {        
        try {
            EntityTransaction entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            Employee newEmployee = new Employee(employeeNo, employeeName, placeOfWork, phoneNo);            
            entityManager.persist(newEmployee);
            entityTransaction.commit();
            return newEmployee;
        } catch(Exception e) {
            return null;
        }        
    }
    @WebMethod(operationName = "updateEmployee")
    public Employee updateEmployee(
            @WebParam(name = "employeeNo") String employeeNo,
            @WebParam(name = "employeeName") String employeeName,
            @WebParam(name = "placeOfWork") String placeOfWork,
            @WebParam(name = "phoneNo") String phoneNo) {
        HashMap<String, Object> result = new HashMap<>();
        try {
            Query query = entityManager.createNamedQuery("Employee.findByEmployeeNo", Employee.class);
            query.setParameter(1, employeeNo);
            Employee employee = (Employee) query.getSingleResult();
            if(employee != null) {                                
                EntityTransaction entityTransaction = entityManager.getTransaction();
                entityTransaction.begin();
                employee.setEmployeeName(employeeName != null ? employeeName : employee.getEmployeeName());
                employee.setPlaceOfWork(placeOfWork != null ? placeOfWork : employee.getPlaceOfWork());
                employee.setPhoneNo(phoneNo != null ? phoneNo : employee.getPhoneNo());                                
                entityManager.persist(employee);
                entityTransaction.commit();            
                return employee;
            } else {
                return null;
            }                             
        } catch(Exception e) {
            return null;   
        }        
    }
    @WebMethod(operationName = "deleteEmployee")
    public int deleteEmployee(
            @WebParam(name = "employeeNo") String employeeNo) {        
        try {
            Query query = entityManager.createNamedQuery("Employee.findByEmployeeNo", Employee.class);
            query.setParameter(1, employeeNo);
            Employee employee = (Employee) query.getSingleResult();            
            if(employee != null) {
                EntityTransaction entityTransaction = entityManager.getTransaction();
                entityTransaction.begin();
                entityManager.remove(employee);
                entityTransaction.commit();                            
            }                                                                        
            return 1;            
        } catch(Exception e) {
            return 0;
        }        
    }
}
