package ca.etsmtl.log720.lab2.equipe17_log720_A11_lab2.servlets;

import java.io.IOException;

import javax.naming.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

import javax.sql.*;

import org.postgresql.ds.PGConnectionPoolDataSource;
import org.postgresql.ds.PGPoolingDataSource;

/**
 * Servlet implementation class Connexion
 */
public class Connexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Connexion() {
        super();
        // TODO Auto-generated constructor stub
    }
    
   
    DataSource ds = null;
    
    Connection conn = null;
    String URL_ERROR_CONNEXION_PAGE = "/errorConnexionPage.jsp";
    String URL_WELCOM_PAGE = "/welcomePage.jsp";

    public void init() throws ServletException {
      try {
        InitialContext ic = new InitialContext();  // JNDI initial context
        ds = (DataSource) ic.lookup("java:/comp/env/jdbc/equipe17-log720-A11-lab2"); // JNDI lookup
        conn = ds.getConnection();  // database connection through data source
      }
      catch (SQLException se) {
        throw new ServletException(se);
      }
      catch (NamingException ne) {
        throw new ServletException(ne);
      }
    }


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String identifiant = request.getParameter("identifiant");
		String motdepasse = request.getParameter("motdepasse");
		String queryString = "SELECT * FROM UTILISATEURS";
		
		try{
			Statement stmt = conn.createStatement();
			ResultSet  rs = stmt.executeQuery(queryString);
			
			while(rs.next()){
				
				
			}
			
			if(rs.next()){
				this.getServletContext().getRequestDispatcher(URL_ERROR_CONNEXION_PAGE).forward(request, response);
				
				
				if(motdepasse != rs.getString("password")){
					//envoyer vers la page erroorConnexionPage.jsp
					this.getServletContext().getRequestDispatcher(URL_ERROR_CONNEXION_PAGE).forward(request, response);
				}
				else{
					//Envoyer vers la page de accueil.jsp
					this.getServletContext().getRequestDispatcher(URL_WELCOM_PAGE).forward(request, response);
					}
			}
		}
		catch (SQLException se) {      
		}
	
	
	}

}
