package ingressosControllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ingressosModel.SalasDeTeatro;
import ingressosDAO.SalasDeTeatroDAO;

@WebServlet (urlPatterns = {"/listarteatros"})
public class ListarTeatros extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String INSERT_OR_EDIT = "/salasdeteatro.jsp";
    private static final String LIST_USER = "/listadeteatro.jsp";
    private final SalasDeTeatroDAO dao;

    public ListarTeatros() {
        super();
        dao = new SalasDeTeatroDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward="";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")){
            int userId = Integer.parseInt(request.getParameter("nome"));
            dao.deleteSalasDeTeatro(nome);
            forward = LIST_USER;
            request.setAttribute("salasdeteatro", dao.getAllUsers());    
        } else if (action.equalsIgnoreCase("edit")){
            forward = INSERT_OR_EDIT;
            int userId = Integer.parseInt(request.getParameter("nome"));
            User user = dao.getUserByName(nome);
            request.setAttribute("salasdeteatro", salasdeteatro);
        } else if (action.equalsIgnoreCase("listadeteatros")){
            forward = LIST_USER;
            request.setAttribute("salasdeteatro", dao.getAllUsers());
        } else {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        user.setFirstName(request.getParameter("firstName"));
        user.setLastName(request.getParameter("lastName"));
        try {
            Date dob=null;
            String teste = request.getParameter("dob");
            System.out.println(teste);
            if(request.getParameter("dob")!=null){
                dob = new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("dob"));
            }
            else{
                dob = null;
            }
                
            user.setDob(dob);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        user.setEmail(request.getParameter("email"));
        String userid = request.getParameter("userid");
        if(userid == null || userid.isEmpty())
        {
            dao.addUser(user);
        }
        else
        {
            user.setUserid(Integer.parseInt(userid));
            dao.updateUser(user);
        }
        RequestDispatcher view = request.getRequestDispatcher(LIST_USER);
        request.setAttribute("users", dao.getAllUsers());
        view.forward(request, response);
    }
}