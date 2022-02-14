/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package services;

import java.util.ArrayList;
import java.util.HashMap;
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

    @WebMethod(operationName = "findall")
    public List<Student> findall() {
        EntityManager entityManager = Persistence.createEntityManagerFactory("WSStudentProjectPU").createEntityManager();
        List<Student> students = new ArrayList<Student>();
        try { 
            Query query = entityManager.createNamedQuery("Student.findAll", Student.class);
            students = query.getResultList();
            return students;
        } catch (Exception ex) {
            return students;
        }
    }

    @WebMethod(operationName = "getone")
    public Student getone(@WebParam(name = "rollNo") String rollNo) {
        EntityManager entityManager = Persistence.createEntityManagerFactory("WSStudentProjectPU").createEntityManager();
        HashMap<String, Object> result = new HashMap<>();
        try {
            Query query = entityManager.createNamedQuery("Student.findByRollNo", Student.class);
            //Student student = new Student(rollNo);
            query.setParameter("rollNo", rollNo);
            Student student = (Student) query.getSingleResult();
            if (student != null) {
                return student;
            } else {
                return null;
            }   
        } catch (Exception ex) {
            return null;
        }
    }

    @WebMethod(operationName = "insert")
    public Student insert(@WebParam(name = "rollNo") String rollNo,
            @WebParam(name = "fullname") String fullname,
            @WebParam(name = "gender") String gender,
            @WebParam(name = "birthday") String birthday,
            @WebParam(name = "email") String email) {
        EntityManager entityManager = Persistence.createEntityManagerFactory("WSStudentProjectPU").createEntityManager();
        try {
            EntityTransaction entitytransaction = entityManager.getTransaction();
            entitytransaction.begin();
            Student newstudent = new Student(rollNo, fullname, gender, birthday, email);
            entityManager.persist(newstudent);
            entitytransaction.commit();
            return newstudent;
        } catch (Exception ex) {
            return null;
        }
    }

    @WebMethod(operationName = "update")
    public String update(@WebParam(name = "rollNo") String rollNo,
            @WebParam(name = "fullname") String fullname,
            @WebParam(name = "gender") String gender,
            @WebParam(name = "birthday") String birthday,
            @WebParam(name = "email") String email) {
        EntityManager entityManager = Persistence.createEntityManagerFactory("WSStudentProjectPU").createEntityManager();
        HashMap<String, Object> result = new HashMap<>();
        try {
            Query query = entityManager.createNamedQuery("Student.findByRollNo", Student.class);
            query.setParameter("rollNo", rollNo);
            Student student = (Student) query.getSingleResult();
            if (student != null) {
                EntityTransaction entityTransaction = entityManager.getTransaction();
                entityTransaction.begin();
                student.setFullname(fullname != null ? fullname : student.getFullname());
                student.setGender(gender != null ? gender : student.getGender());
                student.setBirthday(birthday != null ? birthday : student.getBirthday());
                student.setEmail(email != null ? email : student.getEmail());
                entityManager.persist(student);
                entityTransaction.commit();
                return "succes";
            } else {
                return "fail";
            }
        } catch (Exception ex) {
            return "fail";
        }
    }
}
