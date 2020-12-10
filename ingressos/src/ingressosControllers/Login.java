package ingressosControllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ingressosDAO.SitesDeVendasDAO;
import ingressosModel.SitesDeVenda;


@WebServlet(urlPatterns = "/login")
public class Login extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter writer = resp.getWriter();
		
		String email = req.getParameter("email");
		String senha = req.getParameter("senha");
		
		SitesDeVenda sitesdevenda = new SitesDeVendasDAO().buscaPorEmailESenha(email, senha);
		
		if(sitesdevenda == null) {
			writer.println("<html><body>Usuario ou senha inválida</body></html>");
		}else {
			
			//guarda a sessão(código) do usuario no servidor 
			HttpSession session = req.getSession();
			session.setAttribute("sitesdevenda.logado", sitesdevenda);
			

			
			writer.println("<html><body>Usuario logado: "+ sitesdevenda.getEmail() +" </body></html>");
		}
			
	}

}
