
package clients;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebService(name = "EmployeeWebService", targetNamespace = "http://services/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface EmployeeWebService {


    /**
     * 
     * @param name
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "hello", targetNamespace = "http://services/", className = "clients.Hello")
    @ResponseWrapper(localName = "helloResponse", targetNamespace = "http://services/", className = "clients.HelloResponse")
    @Action(input = "http://services/EmployeeWebService/helloRequest", output = "http://services/EmployeeWebService/helloResponse")
    public String hello(
        @WebParam(name = "name", targetNamespace = "")
        String name);

    /**
     * 
     * @param employeeName
     * @param placeOfWork
     * @param employeeNo
     * @param phoneNo
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "adding", targetNamespace = "http://services/", className = "clients.Adding")
    @ResponseWrapper(localName = "addingResponse", targetNamespace = "http://services/", className = "clients.AddingResponse")
    @Action(input = "http://services/EmployeeWebService/addingRequest", output = "http://services/EmployeeWebService/addingResponse")
    public String adding(
        @WebParam(name = "employeeNo", targetNamespace = "")
        String employeeNo,
        @WebParam(name = "employeeName", targetNamespace = "")
        String employeeName,
        @WebParam(name = "placeOfWork", targetNamespace = "")
        String placeOfWork,
        @WebParam(name = "phoneNo", targetNamespace = "")
        String phoneNo);

    /**
     * 
     * @param name
     * @return
     *     returns java.util.List<clients.Employee>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "gettingAll", targetNamespace = "http://services/", className = "clients.GettingAll")
    @ResponseWrapper(localName = "gettingAllResponse", targetNamespace = "http://services/", className = "clients.GettingAllResponse")
    @Action(input = "http://services/EmployeeWebService/gettingAllRequest", output = "http://services/EmployeeWebService/gettingAllResponse")
    public List<Employee> gettingAll(
        @WebParam(name = "name", targetNamespace = "")
        String name);

    /**
     * 
     * @param employeeNo
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "deleting", targetNamespace = "http://services/", className = "clients.Deleting")
    @ResponseWrapper(localName = "deletingResponse", targetNamespace = "http://services/", className = "clients.DeletingResponse")
    @Action(input = "http://services/EmployeeWebService/deletingRequest", output = "http://services/EmployeeWebService/deletingResponse")
    public int deleting(
        @WebParam(name = "employeeNo", targetNamespace = "")
        String employeeNo);

}
