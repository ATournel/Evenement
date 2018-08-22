package EventApp;
import java.sql.*;

public class Application {

	//Methode d'ouverture
	public Connection ouvertureConnexion(Statement st) {
		
		Connection cn = null;
		String url="jdbc:mysql://localhost/evenement?autoReconnect=true&useSSL=false";
		String user="root";
		String pwd="Ioplop88";
		
				
		//Connexion avec le driver
		try {
			
			//Chargement du driver
			Class.forName("com.mysql.jdbc.Driver");
			//Recuperation de la connexion
			cn = DriverManager.getConnection(url, user, pwd);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return cn;		
	}
	
	//Date de Corneille au Zenith
	public Statement dateCorneilleZenith(Connection cn) {
		Statement st = null;
		try {
			//Creation d'un statement;
			st = cn.createStatement();
			String sql = "SELECT * FROM evenement.concert "
					+ "INNER JOIN evenement.spectacle ON spectacle.spectacle_id=concert.spectacle_id "
					+ "INNER JOIN evenement.salle ON spectacle.salle_id=salle.salle_id "
					+ "WHERE salle.nom='Zenith' AND spectacle.chanteur='Corneille'";
			//Execution requete
			ResultSet result = st.executeQuery(sql);
			
			String nomChanteur;
			String nomSalle;
			Date dateConc;
			
			while(result.next()) {
				//Recuperer le numero client
				nomChanteur = result.getString("chanteur");
				//Recuperer le nom client
				nomSalle = result.getString("nom");
				//Recuperer la ville client
				dateConc = result.getDate("dateCon");
				
				System.out.println(nomChanteur+" au "+nomSalle+": "+dateConc);
				}			
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		return st;
	}
	
	//Methode de fermeture
	public void fermetureConnexion(Connection cn, Statement st) throws InterruptedException {
		try {
			cn.close();
			st.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		Thread.sleep(1500);
		System.out.println("Deconnexion...");
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		Application test = new Application();
		Connection cn = null;
		Statement st = null;
		
		//Ouverture de la connexion
		cn=test.ouvertureConnexion(st);
		
		//Date de Corneille au Zenith
		st=test.dateCorneilleZenith(cn);
		
		//Fermeture de la connexion
		test.fermetureConnexion(cn, st);
	}

}
