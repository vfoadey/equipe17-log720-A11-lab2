package ca.etsmtl.log720.lab2.equipe17_log720_A11_lab2.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.etsmtl.log720.lab2.equipe17_log720_A11_lab2.beans.BanqueDossiers;
import ca.etsmtl.log720.lab2.equipe17_log720_A11_lab2.beans.NoPermisExisteDejaException;

/**
 * Servlet implementation class ajouterDossier
 */
public class ajouterDossier extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ajouterDossier() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("mesError", "doGet");
		this.getServletContext().getRequestDispatcher("/admin/ajouterDossier.jsp")
		.forward(request, response);		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		BanqueDossiers banqueDossier = new BanqueDossiers();
		String nomDossier = request.getParameter("nom_dossier");
		String prenomDossier = request.getParameter("prenom_dossier");
		String noPlaqueDossier = request.getParameter("noPlaque_dossier");
		String noPermisDossier = request.getParameter("noPermis_dossier");
		request.setAttribute("dossiers", banqueDossier.dossiers());

		String mess;
		try {
			mess = banqueDossier.ajouterDossier("user1_id", noPermisDossier,
					nomDossier, prenomDossier, noPlaqueDossier);
			request.setAttribute("dossiers", banqueDossier.dossiers());
			request.setAttribute("message", "Dossier ajouter avec succ�s");
		} catch (Exception ex) {
			request.setAttribute("message", ex.toString());
		}
		
		this.getServletContext().getRequestDispatcher("/admin/ajouterDossier.jsp")
		.forward(request, response);
	}
}
