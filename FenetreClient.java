import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class FenetreClient extends JFrame implements ActionListener {

	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	
	private JMenuBar bar;
	private JMenu menu;
	private JMenuItem ItemQuitter;
	private JMenuItem ItemConsulter;
	private JMenuItem itmInsert;
	
	private JLabel lblNom;
	private JTextField jtfNom;
	private JLabel lblPrenom;
	private JTextField jtfPrenom;
	private JLabel lblMail;
	private JTextField jtfMail;
	
	private TitledBorder titreBord;
	
	private JButton btnAjouter;
	private JButton btnSupprimer;
	private JComboBox listSup;
	private Object[][] donnees;
	private JTable tableau;
	private JScrollPane scroll;

	public FenetreClient() {
		this.setTitle("Client");

		this.setSize(500, 320);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel1 = new JPanel();
		panel2 = new JPanel(new GridLayout(4, 2));
		panel3 = new JPanel();

	

		lblNom = new JLabel("Nom : ");
		jtfNom = new JTextField();

		lblPrenom = new JLabel("Prenom : ");
		jtfPrenom = new JTextField();

		lblMail = new JLabel("Mail : ");
		jtfMail = new JTextField();

		btnAjouter = new JButton("Ajouter");
		btnSupprimer = new JButton("Supprimer");
		
		/*RECUPERER LES NUMEROS EST LES AJOUTE DANS UNE LISTE DEROULANTE*/
		listSup = new JComboBox<String>();
		listSup.addItem("");
		for(int i=0; i<Modele.lesContact().size(); i++){
			
			listSup.addItem(Modele.lesContact().get(i).getNom());
		}
			

		
		
		/*-------------------------------------------------------------*/
		
		bar = new JMenuBar();
		menu = new JMenu("Client");
		ItemQuitter = new JMenuItem("Quitter");
		itmInsert = new JMenuItem("Inserer");
		ItemConsulter = new JMenuItem("Consulter les clients");
		titreBord = new TitledBorder("INSERT");
		panel2.setBorder(titreBord);

		/*---------CREATION  DU TABLEAU---------*/
		String [] entetes = { "Nom", "Prenom", "Mail"};
	
			                         //Lignes - 3 Colones
		donnees = new Object[Modele.lesContact().size()][3];
		tableau = new JTable(donnees, entetes);
		scroll = new JScrollPane(tableau);
		scroll.setPreferredSize(new Dimension(400,200));
		
		/**/
		for (int i = 0; i < Modele.lesContact().size() ; i++) {
			
			Contact contact = Modele.lesContact().get(i);

			donnees[i][0] = contact.getNom();
			donnees[i][1] = contact.getPrenom();
			donnees[i][2] = contact.getEmail();
		}
	
		
		/*AJOUT DU TABLEAU ET DU BOUTON SUPPRIMER DANS PANEL3*/
		panel3.add(scroll);
		panel3.add(listSup);
		panel3.add(btnSupprimer);
	
		
		/*AJOUT DU MENU*/
		menu.add(itmInsert);
		menu.add(ItemConsulter);
		menu.add(ItemQuitter);
		bar.add(menu);
		
		/*AJOUT DU MENU DANS LA FENETRE*/
		this.setJMenuBar(bar);

		// AJOUT DESC COMPOSANTS DANS PANEL2
		panel2.add(lblNom);
		panel2.add(jtfNom);
		panel2.add(lblPrenom);
		panel2.add(jtfPrenom);
		panel2.add(lblMail);
		panel2.add(jtfMail);
		panel2.add(btnAjouter);

		/**/
		itmInsert.addActionListener(this);
		btnAjouter.addActionListener(new ActionBtnAjouter());
		ItemQuitter.addActionListener(new ActionQuitter());
		ItemConsulter.addActionListener(new ActionConsulter());
		btnSupprimer.addActionListener(new ActionSupprimerContact());
		this.getContentPane().add(panel1);

		this.setVisible(true);
	}
	
	
	class ActionSupprimerContact implements ActionListener{
	
		@Override
		public void actionPerformed(ActionEvent e) {
			int num = listSup.getSelectedIndex();
			System.out.println(Modele.DeleteContact(num));
			
			//System.out.println(listSup.getSelectedIndex());
		}
		
	}
	class ActionConsulter implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == ItemConsulter) {
				
				
				setContentPane(panel3);
				setVisible(true);
			}

		}
	}

	class ActionQuitter implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == ItemQuitter) {
				System.exit(0);
			}

		}
	}

	class ActionBtnAjouter implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnAjouter) {
				Modele.InsertContact(jtfNom.getText(), jtfPrenom.getText(),jtfMail.getText());
				
			}

		}
	}
	
/**
 * Action sur l'item itmInsert pour afficher le panel2
 */
	@Override
	public void actionPerformed(ActionEvent e) {
		this.setContentPane(panel2);
		
		this.setVisible(true);
	}
}
