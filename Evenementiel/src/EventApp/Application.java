package EventApp;
import java.sql.*;

public class Application {

	//Methode d'ouverture
	public void ouvertureConnexion() {
		String url="jdbc:mysql://localhost/formation2?autoReconnect=true&useSSL=false";
		String user="root";
		String pwd="Ioplop88";
		
		Connection cn = null;
		Statement st = null;
		
		//Connexion avec le driver
		try {
			
			//Chargement du driver
			Class.forName("com.mysql.jdbc.Driver");
			//Recuperation de la connexion
			cn = DriverManager.getConnection(url, user, pwd);
			System.out.println("Good");
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}		
	}
	
	
	
	//Methode de fermeture
	public void fermetureConnexion(Connection cn, Statement st) {
		try {
			cn.close();
			st.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		Application test = new Application();
		Connection cn = null;
		Statement st = null;
		
		//Ouverture de la connexion
		test.ouvertureConnexion();
		
		//Date de Corneille au Zenith
		
		//Fermeture de la connexion
		test.fermetureConnexion(cn, st);
				
	}

}
