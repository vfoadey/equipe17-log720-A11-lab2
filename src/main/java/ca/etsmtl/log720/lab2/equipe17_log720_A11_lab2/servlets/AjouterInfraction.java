package ca.etsmtl.log720.lab2.equipe17_log720_A11_lab2.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.etsmtl.log720.lab2.equipe17_log720_A11_lab2.beans.BanqueInfractions;
import ca.etsmtl.log720.lab2.equipe17_log720_A11_lab2.beans.NiveauHorsBornesException;

/**
 * Servlet implementation class AjouterInfraction
 */
public class AjouterInfraction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjouterInfraction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/agent/AjouterInfraction.jsp")
		.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		BanqueInfractions banque = new BanqueInfractions();
		
		try {
			int niveau = Integer.parseInt(request.getParameter("txtNiveau"));
			banque.ajouterInfraction(request.getParameter("txtDescription"), 1);
		} catch (NiveauHorsBornesException e) {			
			e.printStackTrace();
		} catch (Exception ex){
			request.setAttribute("message", ex.getMessage());
			ex.printStackTrace();
		}
		//message
		//request.setAttribute("message","Niveau = " + request.getParameter("txtNiveau") + " et description : " + request.getParameter("txtDescription"));
		
		this.getServletContext().getRequestDispatcher("/agent/AjouterInfraction.jsp")
		.forward(request, response);
		
	}

}
