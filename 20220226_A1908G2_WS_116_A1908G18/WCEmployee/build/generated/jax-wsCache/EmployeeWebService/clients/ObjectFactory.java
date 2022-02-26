
package clients;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the clients package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _DeletingResponse_QNAME = new QName("http://services/", "deletingResponse");
    private final static QName _Hello_QNAME = new QName("http://services/", "hello");
    private final static QName _GettingAllResponse_QNAME = new QName("http://services/", "gettingAllResponse");
    private final static QName _GettingAll_QNAME = new QName("http://services/", "gettingAll");
    private final static QName _Employee_QNAME = new QName("http://services/", "employee");
    private final static QName _Deleting_QNAME = new QName("http://services/", "deleting");
    private final static QName _AddingResponse_QNAME = new QName("http://services/", "addingResponse");
    private final static QName _HelloResponse_QNAME = new QName("http://services/", "helloResponse");
    private final static QName _Adding_QNAME = new QName("http://services/", "adding");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: clients
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddingResponse }
     * 
     */
    public AddingResponse createAddingResponse() {
        return new AddingResponse();
    }

    /**
     * Create an instance of {@link Deleting }
     * 
     */
    public Deleting createDeleting() {
        return new Deleting();
    }

    /**
     * Create an instance of {@link HelloResponse }
     * 
     */
    public HelloResponse createHelloResponse() {
        return new HelloResponse();
    }

    /**
     * Create an instance of {@link Adding }
     * 
     */
    public Adding createAdding() {
        return new Adding();
    }

    /**
     * Create an instance of {@link GettingAllResponse }
     * 
     */
    public GettingAllResponse createGettingAllResponse() {
        return new GettingAllResponse();
    }

    /**
     * Create an instance of {@link DeletingResponse }
     * 
     */
    public DeletingResponse createDeletingResponse() {
        return new DeletingResponse();
    }

    /**
     * Create an instance of {@link Hello }
     * 
     */
    public Hello createHello() {
        return new Hello();
    }

    /**
     * Create an instance of {@link Employee }
     * 
     */
    public Employee createEmployee() {
        return new Employee();
    }

    /**
     * Create an instance of {@link GettingAll }
     * 
     */
    public GettingAll createGettingAll() {
        return new GettingAll();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeletingResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "deletingResponse")
    public JAXBElement<DeletingResponse> createDeletingResponse(DeletingResponse value) {
        return new JAXBElement<DeletingResponse>(_DeletingResponse_QNAME, DeletingResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Hello }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "hello")
    public JAXBElement<Hello> createHello(Hello value) {
        return new JAXBElement<Hello>(_Hello_QNAME, Hello.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GettingAllResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "gettingAllResponse")
    public JAXBElement<GettingAllResponse> createGettingAllResponse(GettingAllResponse value) {
        return new JAXBElement<GettingAllResponse>(_GettingAllResponse_QNAME, GettingAllResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GettingAll }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "gettingAll")
    public JAXBElement<GettingAll> createGettingAll(GettingAll value) {
        return new JAXBElement<GettingAll>(_GettingAll_QNAME, GettingAll.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Employee }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "employee")
    public JAXBElement<Employee> createEmployee(Employee value) {
        return new JAXBElement<Employee>(_Employee_QNAME, Employee.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Deleting }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "deleting")
    public JAXBElement<Deleting> createDeleting(Deleting value) {
        return new JAXBElement<Deleting>(_Deleting_QNAME, Deleting.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddingResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "addingResponse")
    public JAXBElement<AddingResponse> createAddingResponse(AddingResponse value) {
        return new JAXBElement<AddingResponse>(_AddingResponse_QNAME, AddingResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HelloResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "helloResponse")
    public JAXBElement<HelloResponse> createHelloResponse(HelloResponse value) {
        return new JAXBElement<HelloResponse>(_HelloResponse_QNAME, HelloResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Adding }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "adding")
    public JAXBElement<Adding> createAdding(Adding value) {
        return new JAXBElement<Adding>(_Adding_QNAME, Adding.class, null, value);
    }

}
