/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Phong_learning
 */
@Entity
@Table(name = "tblemployee", catalog = "webserviceexam", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tblemployee.findAll", query = "SELECT t FROM Tblemployee t"),
    @NamedQuery(name = "Tblemployee.findByEmployeeNo", query = "SELECT t FROM Tblemployee t WHERE t.employeeNo = :employeeNo"),
    @NamedQuery(name = "Tblemployee.findByEmployeeName", query = "SELECT t FROM Tblemployee t WHERE t.employeeName = :employeeName"),
    @NamedQuery(name = "Tblemployee.findByPlaceOfWork", query = "SELECT t FROM Tblemployee t WHERE t.placeOfWork = :placeOfWork"),
    @NamedQuery(name = "Tblemployee.findByPhoneNo", query = "SELECT t FROM Tblemployee t WHERE t.phoneNo = :phoneNo")})
public class Tblemployee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "EmployeeNo", nullable = false, length = 20)
    private String employeeNo;
    @Basic(optional = false)
    @Column(name = "EmployeeName", nullable = false, length = 30)
    private String employeeName;
    @Basic(optional = false)
    @Column(name = "PlaceOfWork", nullable = false, length = 30)
    private String placeOfWork;
    @Basic(optional = false)
    @Column(name = "PhoneNo", nullable = false, length = 10)
    private String phoneNo;

    public Tblemployee() {
    }

    public Tblemployee(String employeeNo) {
        this.employeeNo = employeeNo;
    }

    public Tblemployee(String employeeNo, String employeeName, String placeOfWork, String phoneNo) {
        this.employeeNo = employeeNo;
        this.employeeName = employeeName;
        this.placeOfWork = placeOfWork;
        this.phoneNo = phoneNo;
    }

    public String getEmployeeNo() {
        return employeeNo;
    }

    public void setEmployeeNo(String employeeNo) {
        this.employeeNo = employeeNo;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getPlaceOfWork() {
        return placeOfWork;
    }

    public void setPlaceOfWork(String placeOfWork) {
        this.placeOfWork = placeOfWork;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (employeeNo != null ? employeeNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tblemployee)) {
            return false;
        }
        Tblemployee other = (Tblemployee) object;
        if ((this.employeeNo == null && other.employeeNo != null) || (this.employeeNo != null && !this.employeeNo.equals(other.employeeNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Tblemployee[ employeeNo=" + employeeNo + " ]";
    }
    
}
