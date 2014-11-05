package ca.etsmtl.log720.lab2.equipe17_log720_A11_lab2.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.etsmtl.log720.lab2.equipe17_log720_A11_lab2.beans.BanqueDossiers;
import ca.etsmtl.log720.lab2.equipe17_log720_A11_lab2.beans.Dossier;

/**
 * Servlet implementation class SelectionDossier
 */
public class SelectionDossier extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectionDossier() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BanqueDossiers dossier = new BanqueDossiers();	
		
		request.setAttribute("dossiers", dossier.dossiers());
		
		this.getServletContext().getRequestDispatcher("/SelectionDossier.jsp")
		.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String idDossier = request.getParameter("idDossier");
			System.out.println(idDossier);
		}catch(Exception ex){
			System.out.println("Erreur lors du getPArameter du servlet SelectionDossier");
		}
	}

}
