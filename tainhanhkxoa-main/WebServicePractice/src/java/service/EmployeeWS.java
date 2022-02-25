/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package service;

import entity.Tblemployee;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Loki Kun
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

    @WebMethod(operationName = "gettingAll")
    public List<Tblemployee> gettingAll() {
        EntityManager em = Persistence.createEntityManagerFactory("WebServicePracticePU").createEntityManager();
        List<Tblemployee> employeeList = em.createNamedQuery("Tblemployee.findAll", Tblemployee.class).getResultList();
        return employeeList;
    }

    @WebMethod(operationName = "deleteEmployee")
    public Integer deleteEmployee(@WebParam(name = "employeeNo") String employeeNo) {
        EntityManager em = Persistence.createEntityManagerFactory("WebServicePracticePU").createEntityManager();
        try {
            Tblemployee employee = em.find(Tblemployee.class, employeeNo);
            if(employee != null){
                em.getTransaction().begin();
                em.remove(employee);
                em.getTransaction().commit();
                return 1;
            }else
                return 0;
            
        } catch (Exception e) {
            System.out.println("" + e.toString());
            return 0;
        }
    }
    
    @WebMethod(operationName = "addEmployee")
    public String addEmployee(
            @WebParam(name = "employeeNo")String employeeNo,
            @WebParam(name = "employeeName")String employeeName,
            @WebParam(name = "placeOfWork")String placeOfWork,
            @WebParam(name = "phoneNo")String phoneNo
            ){
        EntityManager em = Persistence.createEntityManagerFactory("WebServicePracticePU").createEntityManager();
        try{
            Tblemployee employee = em.find(Tblemployee.class, employeeNo);
            if(employee == null){
                Tblemployee tblEmployee = new Tblemployee(employeeNo, employeeName, placeOfWork, phoneNo);
                em.getTransaction().begin();
                em.persist(tblEmployee);
                em.getTransaction().commit();
                return "Add success";
            }else
                return "This employee is existed, please try another!!";
        }catch(Exception e){
            return "Some error: "+e.toString();
        }
    }
    
    @WebMethod(operationName = "updateEmployee")
    public String updateEmployee(
            @WebParam(name = "employeeNo")String employeeNo,
            @WebParam(name = "employeeName")String employeeName,
            @WebParam(name = "placeOfWork")String placeOfWork,
            @WebParam(name = "phoneNo")String phoneNo
            ){
        EntityManager em = Persistence.createEntityManagerFactory("WebServicePracticePU").createEntityManager();
        try{
            Tblemployee employee = em.find(Tblemployee.class, employeeNo);
            if(employee != null){                
                em.getTransaction().begin();
                employee.setEmployeeName(employeeName != null ? employeeName : employee.getEmployeeName());
                employee.setEmployeeNo(employeeNo != null ? employeeNo : employee.getEmployeeNo());
                employee.setPhoneNo(phoneNo != null ? phoneNo : employee.getPhoneNo());
                employee.setPlaceOfWork(placeOfWork != null ? placeOfWork : employee.getPlaceOfWork());
                em.persist(employee);
                em.getTransaction().commit();
                return "Update success";
            }else
                return "This employee does not existed, please try another!!";
        }catch(Exception e){
            return "Some error: "+e.toString();
        }
    }

}
