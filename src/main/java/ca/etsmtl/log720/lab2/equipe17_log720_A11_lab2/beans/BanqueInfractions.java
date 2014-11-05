package ca.etsmtl.log720.lab2.equipe17_log720_A11_lab2.beans;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class BanqueInfractions {

	private DataSource ds = null;
	private Connection conn = null;
	private Statement stmt = null;
	private String queryString;

	public List<Infraction> Infractions(){
			//select *
			InitialContext ic;
			List<Infraction> lstInfraction = new ArrayList<Infraction>();
			try {
				ic = new InitialContext();
			queryString = "SELECT * FROM Infractions";
			ds = (DataSource) ic
					.lookup("java:/comp/env/jdbc/equipe17-log720-A11-lab2"); // JNDI
			conn = ds.getConnection();
			ResultSet rs = stmt.executeQuery(queryString);
			
			while (rs.next()) {
				int idInfraction = rs.getInt(1);
				String description = rs.getString(2);			
				int niveau = rs.getInt(3);

				Infraction infraction = new Infraction(idInfraction, description, niveau);
				lstInfraction.add(infraction);
			}
			} catch (Exception e) {
				e.printStackTrace();
			}			
			return lstInfraction;		
	}
	
	public void ajouterInfraction(Infraction inf) {
		try {
			String queryString = "INSERT INTO INFRACTIONS"
					+ "(DESCRIPTION, NIVEAU)" + "values ('"
					+ inf.description() + "'," + inf.niveau()
					+ ")";
			InitialContext ic = new InitialContext();;
			ds = (DataSource) ic
					.lookup("java:/comp/env/jdbc/equipe17-log720-A11-lab2"); // JNDI
			conn = ds.getConnection();
			Statement stmt = this.conn.createStatement();
			stmt.execute(queryString);
		} catch (Exception ex) {

		}
	}

	public void ajouterInfraction(String description, int niveau) {
		try {
			String queryString = "INSERT INTO INFRACTIONS"
					+ "(IDINFRACTION,DESCRIPTION, NIVEAU)" + "values (15,'"
					+ description + "'," + niveau
					+ ")";
			InitialContext ic = new InitialContext();;
			ds = (DataSource) ic
					.lookup("java:/comp/env/jdbc/equipe17-log720-A11-lab2"); // JNDI
			conn = ds.getConnection();
			Statement stmt = this.conn.createStatement();
			stmt.execute(queryString);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

}
