 

import java.sql.*;
import java.util.ArrayList;

public class Modele {
	
	public static Connection dbconnect(){
		Connection connexion = null;
		try {
			 Class.forName("com.mysql.jdbc.Driver") ;
			 connexion = DriverManager.getConnection("jdbc:mysql://localhost/mvc", "root", "");
				
			} catch (ClassNotFoundException e) {
				System.out.println(e);
			} catch (SQLException e) {
				System.out.println(e);
			}
		return connexion;
	 }
	
	
	

	public static  ResultSet getContact() {
		ResultSet rs = null;
		try {
			 
			Statement st = dbconnect().createStatement();
			rs = st.executeQuery("SELECT * FROM contact ORDER BY numero");
		} catch (SQLException e) {
			System.out.println(e);
		}
		
	
		return rs ;
		
	}
	
		public static ResultSet  NbContact() {
			
			ResultSet rs = null;
			
			try {
				//Statement st = dbconnect().createStatement();
				//String sql = ("SELECT count(numero) FROM contact");
				// rs = st.executeQuery (sql) ; 
				PreparedStatement statement = dbconnect().prepareStatement("SELECT * FROM contact where nom = ?");
				statement.setString(1, nom);
				ResultSet res = statement.executeQuery();

				} catch (SQLException e) {
				System.out.println(e);
			}
			
			return rs;
      }
		
		public static int UpdateContact(int numContact){
			
			int rs = 0;
			
			try {
				Statement st = dbconnect().createStatement();
				String sql = ("UPDATE contact set  where numero="+numContact+" ");
				 rs = st.executeUpdate(sql) ; 
	
				
				} catch (SQLException e) {
					System.out.println(e);
			}
			return rs;
      }
		
		public static int DeleteContact(int numContact){
			
			int rs = 0;
			
			try {
				Statement st = dbconnect().createStatement();
				 rs = st.executeUpdate("DELETE FROM contact WHERE numero="+numContact+" ") ; 
	
				
				} catch (SQLException e) {
					System.out.println(e);
			}
			return rs;
      }
		
		public static int InsertContact(String nom,String prenom,String email){
			
			int resultat = 0;
			
			try {
				Statement st = dbconnect().createStatement();
				resultat = st.executeUpdate("INSERT INTO contact (nom,prenom,email) VALUES('"+nom+"','"+prenom+"','"+email+"');");
			    
				} catch (SQLException e) {
				System.out.println(e);
			}
			return resultat;
      }
		
		
		
		
		   public static ArrayList <Contact> lesContact(){
				
				  ArrayList <Contact> lescontact = new ArrayList <Contact>();
					
					try {
						Statement st = dbconnect().createStatement();
						ResultSet rs = st.executeQuery("SELECT * FROM contact ORDER BY numero");
						while (rs.next()) {
							String nom = rs.getString("nom");
							String prenom = rs.getString("prenom");
							String email = rs.getString("email");
							lescontact.add(new Contact(nom,prenom,email,null));
						}
						
						} catch (SQLException e) {
						System.out.println(e);
					}
					return lescontact;
				}
}
