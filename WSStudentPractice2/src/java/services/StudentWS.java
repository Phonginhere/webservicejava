/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.Date;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import models.Student;

/**
 *
 * @author Phong_learning
 */
@WebService(serviceName = "StudentWS")
public class StudentWS {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
     @WebMethod(operationName = "find")
    public Student find(@WebParam(name = "rollNo") String rollNo) {
        EntityManager em = Persistence.createEntityManagerFactory("WSStudentPractice2PU").createEntityManager();
        try{
            Query query = em.createNamedQuery("Student.findByRollNo", Student.class).setParameter("rollNo", Integer.parseInt(rollNo));
            Student student = (Student) query.getSingleResult();
            return student;
        }catch(Exception e){
            return null;
        }
    }
    
     @WebMethod(operationName = "findAll")
    public List<Student> findAll() {
        EntityManager em = Persistence.createEntityManagerFactory("WSStudentPractice2PU").createEntityManager();
        try{
            List<Student> list = em.createNamedQuery("Student.findAll").getResultList();
            return list;
        }catch(Exception e){
            return null;
        }
        
    }
    
    @WebMethod(operationName = "insert")
    public Student insert(@WebParam(name = "fullname") String fullname, 
            @WebParam(name = "gender") String gender, @WebParam(name = "email") String email, @WebParam(name = "birthday") Date birthday) {
        EntityManager em = Persistence.createEntityManagerFactory("WSStudentPractice2PU").createEntityManager();
        try{
            EntityTransaction et = em.getTransaction();
            et.begin();
            Student student = new Student(fullname, Boolean.parseBoolean(gender), email, birthday);
            em.persist(student);
            et.commit();
            return student;
        }catch(Exception e){
            return null;
        }
    }
    
    @WebMethod(operationName = "update")
    public Student update(@WebParam(name = "rollNo") String rollNo,@WebParam(name = "fullname") String fullname, 
            @WebParam(name = "gender") String gender, @WebParam(name = "email") String email, @WebParam(name = "birthday") Date birthday) {
        EntityManager em = Persistence.createEntityManagerFactory("WSStudentPractice2PU").createEntityManager();
        try{
            Query query = em.createNamedQuery("Student.findByRollNo", Student.class).setParameter("rollNo", Integer.parseInt(rollNo));
            Student student = (Student) query.getSingleResult();
            if(student != null){
                EntityTransaction et = em.getTransaction();
                et.begin();
                student.setFullname(fullname != null ? fullname : student.getFullname());
                student.setBirthday(birthday != null ? birthday : student.getBirthday());
                student.setEmail(email != null ? email : student.getEmail());
                student.setGender(Boolean.parseBoolean(gender));
                em.persist(student);
                et.commit();
                return student;
            }
            
        }catch(Exception e){
            return null;
        }
        return null;
    }
    @WebMethod(operationName = "delete")
    public String delete(@WebParam(name = "rollNo") String rollNo) {
         EntityManager em = Persistence.createEntityManagerFactory("WSStudentPractice2PU").createEntityManager();
         Query query = em.createNamedQuery("Student.findByRollNo", Student.class).setParameter("rollNo", Integer.parseInt(rollNo));
         
         try{
             Student student = (Student) query.getSingleResult();
         if(student != null){
             em.getTransaction().begin();
             em.remove(student);
             em.getTransaction().commit();
             return "remove";
         }
         }catch(Exception e){
             return "cannot remove";
         }
        return "cannot remove";
    }
}
