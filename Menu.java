import javax.swing.*;



import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Menu extends JFrame implements ActionListener{

	

	private JPanel panel;
	private JPanel panel2;

	private JMenuBar menu;
	
	private JLabel lbl;
	
	JMenu menuIn;
	JMenu menuCon;
	JMenu menuQuit;
		
	JMenuItem InsertC;
	JMenuItem ConsultC;
	JMenuItem Quit;
	
	
	
	
	/*private JButton btn1;
	private JButton btn2;
	private JButton btn3;*/
	
	
	public Menu(){
		
		
		this.setTitle("Menu");
		this.setSize(400,200);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		panel = new JPanel(new BorderLayout());
		panel2 = new JPanel (new BorderLayout());
	
		
		/*btn1 = new JButton("Inserer");
		btn2 = new JButton("Consulter");
		btn3 = new JButton("Quitter");*/
		
	     
		menu = new JMenuBar();
		
		lbl = new JLabel("Hello", JLabel.CENTER);
	
		menuIn = new JMenu("Inserer");
		InsertC = new JMenuItem("Inserer un contact");
		
		menuCon = new JMenu ("Consulter");
		ConsultC = new JMenuItem("Consulter la liste des contacts");
		 
		menuQuit = new JMenu ("Quitter");
		Quit = new JMenuItem ("Quitter");
		
		 
		
		
		/*panel.add(btn1, BorderLayout.WEST);
		panel.add(btn2, BorderLayout.CENTER);
		panel.add(btn3, BorderLayout.EAST);*/
		panel.add(menu, BorderLayout.NORTH);
		panel2.add(lbl, BorderLayout.CENTER);
		menu.add(menuIn);
		menu.add(menuCon);
		menu.add(menuQuit);
		
		menuIn.add(InsertC);
		menuCon.add(ConsultC);
		menuQuit.add(Quit);
		
		this.getContentPane().add(panel);
		panel.add(panel2);
		
	
		
		/*btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);*/
		InsertC.addActionListener(new insert());
		ConsultC.addActionListener(new Consult());
		Quit.addActionListener(new Exit());
		
		this.setVisible(true);
		
	}
	
	

	
	class Exit implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource() == Quit)
				System.exit(0);
			
		}
	
	}
	

	class Consult implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource() == ConsultC){
				
				FenetreClient c = new FenetreClient();
				
				dispose();	
			}
		}
	
	}
	class insert implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource() == InsertC){
				
				Inserer i = new Inserer();
				
				dispose();	
			}
		}
	
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
