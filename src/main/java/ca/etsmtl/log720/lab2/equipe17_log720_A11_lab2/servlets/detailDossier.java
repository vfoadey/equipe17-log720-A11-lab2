package ca.etsmtl.log720.lab2.equipe17_log720_A11_lab2.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.etsmtl.log720.lab2.equipe17_log720_A11_lab2.beans.BanqueDossiers;
import ca.etsmtl.log720.lab2.equipe17_log720_A11_lab2.beans.BanqueInfractions;
import ca.etsmtl.log720.lab2.equipe17_log720_A11_lab2.beans.Dossier;

/**
 * Servlet implementation class detailDossier
 */
public class detailDossier extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public detailDossier() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		Dossier dossier = BanqueDossiers.getDossier(id);
		request.setAttribute("dossier", dossier);
		request.setAttribute("infractions", BanqueInfractions.getInfractionsForDossier(Integer.toString(dossier.idDossier())));
		request.setAttribute("listbox", BanqueInfractions.Infractions());
		this.getServletContext()
				.getRequestDispatcher("/shared/detailDossier.jsp")
				.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String idDossier =request.getParameter("idDossier");		
		Dossier dossier = BanqueDossiers.getDossier(idDossier);		
		String idInfraction = request.getParameter("idInfraction");
		
		BanqueDossiers.ajouterInfraction(idDossier, idInfraction);
		
		request.setAttribute("dossier", dossier);
		request.setAttribute("infractions", BanqueInfractions.getInfractionsForDossier(Integer.toString(dossier.idDossier())));
		request.setAttribute("listbox", BanqueInfractions.Infractions());
		request.setAttribute("id", dossier.idDossier());
		
		this.getServletContext()
		
		.getRequestDispatcher("/shared/detailDossier.jsp")
		.forward(request, response);
		
	}

}
