import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Inserer extends JFrame implements ActionListener{
	
	private JPanel panel;
	
	
	private JLabel nom;
	
	private JTextField zdtn;
	
	
	private JLabel prenom;
	
	private JTextField zdtp;
	
	
	private JLabel mail;
	
	private JTextField zdtm;
	
	private JLabel lbl0;
	
	private JButton btn1;
	

	
	

	public Inserer(){
		
		
		this.setTitle("Inserer");
		this.setSize(400,100);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		
	
		
		panel = new JPanel(new GridLayout(4,2));
		
		btn1 = new JButton("Ajouter");
		
		nom = new JLabel("Nom : ");
		prenom = new JLabel("Prenom : ");
		mail = new JLabel("Mail : ");
		
		zdtn = new JTextField();
		lbl0 = new JLabel();

		zdtp = new JTextField();
		zdtm = new JTextField();
		
		panel.add(nom);
		panel.add(zdtn);
		panel.add(prenom);
		panel.add(zdtp);
		panel.add(mail);
		panel.add(zdtm);
		panel.add(lbl0);
		panel.add(btn1);
		
		
	
		
		
		this.getContentPane().add(panel);
		
	
		btn1.addActionListener(this);
		
		this.setVisible(true);
	}
		public void actionPerformed(ActionEvent e) {
			
			if (e.getSource() == btn1){
				
				Modele.InsertContact(zdtn.getText(),zdtp.getText(), zdtm.getText());
				dispose();
				
				
			}
			}
}
		
	

