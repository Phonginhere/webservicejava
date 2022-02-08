package controller;

import java.io.IOException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Tblemployee;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }
    
    //@Path("display")
//    @GET
//    @Produces(MediaType.TEXT_PLAIN)
//    public String displayTable(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
//        EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.mycompany_mavenprojecttest2_war_1.0-SNAPSHOTPU");
//        EntityManager em = factory.createEntityManager();
//        
//        Query query = em.createNamedQuery("Tblemployee.findAll", Tblemployee.class);
//        List<Tblemployee> list = query.getResultList();
//
//        for (Tblemployee s : list) {
//            System.out.println(s.getEmployeeName());
//        }
//        request.setAttribute("display", list); // = Viewdata mvc
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/studentList.jsp");
//        dispatcher.forward(request, response);
//        
//        return "display.jsp";
//    }
}
