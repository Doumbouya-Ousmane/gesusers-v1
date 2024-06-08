package servlets;

import java.io.IOException;

import beans.Utilisateurs;
import dao.UtilisateursDao;
import forms.AddUserForm;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/add")
public class AddUser extends HttpServlet{
	
	public static final String VUE_AJOUT_UTILISATEUR = "/WEB-INF/ajouterUtilisateur.jsp";
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(VUE_AJOUT_UTILISATEUR);
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		AddUserForm form = new AddUserForm(request);
		
		if (form.ajouter()) {
			
			response.sendRedirect("list");
		}
		else {
			
			request.setAttribute("status", form.getStatus());
			request.setAttribute("statusMessage", form.getStatusMessage());
			request.setAttribute("utilisateurs", form.getUtilisateur());
			request.setAttribute("erreurs", form.getErreurs());
			
			getServletContext().getRequestDispatcher(VUE_AJOUT_UTILISATEUR).forward(request, response);
			
		}
		
		
	}
}
