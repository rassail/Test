
public class Contact {
	
	private String nom;
	private String prenom;
	private String email;
	private String commentaire ;
	
	public Contact(String unNom, String unPrenom, String unEmail, String unCommentaire) {
		this.nom = unNom;
		this.prenom = unPrenom;
		this.email = unEmail;
		this.commentaire = unCommentaire;
	}

		/**
		 * @return le nom
		 */
		public String getNom() {
			return this.nom;
		}
	
		/**
		 * @return le prenom
		 */
		public String getPrenom() {
			return this.prenom;
		}
	
		/**
		 * @return l'email
		 */
		public String getEmail() {
			return this.email;
		}
	
		/**
		 * @return le commentaire
		 */
		public String getCommentaire() {
			return this.commentaire;
		}
	
}
