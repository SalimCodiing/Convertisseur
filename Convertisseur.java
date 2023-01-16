import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class Convertisseur extends JFrame implements ActionListener 
{
	private JLabel lbTitre= new JLabel("Mon convertisseur 2023 CFA Insta");
	private JButton btEuro= new JButton("Euro");
	private JButton btDevise= new JButton("Devise");
	private JButton btTaux = new JButton("Taux");
	private JButton btAc= new JButton("AC");
	private JButton btApropos= new JButton("A propos");
	private JButton btQuitter= new JButton("Quitter");
	private JTextField txtMontant= new JTextField();
	
	
	
	private float taux = (float)6.56;
	private String devise = "Francs";
	
	public Convertisseur() {
		this.setTitle("Mon convertisseur 2023");
		this.setBounds(200, 200, 500, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setBackground(new Color(120,29,178));
		this.setResizable(false);
		this.setLayout(null);
		//placements des objets garaphiques
		this.lbTitre.setBounds(150,20, 250, 20);
		this.add(this.lbTitre);
		
		this.btEuro.setBounds(40, 80, 80, 40);
		this.add(this.btEuro);
		
		this.txtMontant.setBounds(150, 80, 80, 40);
		this.add(this.txtMontant);
		
		this.btDevise.setBounds(260, 80, 80, 40);
		this.add(this.btDevise);
		this.btDevise.setText(this.devise);
		
		this.btTaux.setBounds(40, 150, 80, 40);
		this.add(this.btTaux);
		
		this.btAc.setBounds(150, 150, 80, 40);
		this.add(this.btAc);
		
		this.btApropos.setBounds(260, 150, 80, 40);
		this.add(this.btApropos);
		
		this.btQuitter.setBounds(0, 210, 500, 40);
		this.add(this.btQuitter);
		
		// rendre les boutons ecoutables / cliquables
		this.btAc.addActionListener(this);
		this.btEuro.addActionListener(this);
		this.btTaux.addActionListener(this);
		this.btApropos.addActionListener(this);
		this.btDevise.addActionListener(this);
		this.btQuitter.addActionListener(this);
		
		
		//insertion d'une image
		ImageIcon uneImage = new ImageIcon("src/img-monnaie.jpg");
		JLabel lbImage = new JLabel(uneImage);
		lbImage.setBounds(350,80,120,100);
		this.add(lbImage);
		
		
		this.setVisible(true);
	}
	public static void main(String[] args) {
		Convertisseur unConvertisseur = new Convertisseur();

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== this.btAc) {
			this.txtMontant.setText("");
		}else if(e.getSource() == this.btQuitter) {
			 int retour =JOptionPane.showConfirmDialog(this, "Voulez vous quitter l'application",
					 "Quitter l'application",JOptionPane.YES_NO_OPTION);
			 if( retour ==0) {
				 this.dispose();
			 }
			
		}else if(e.getSource()== this.btApropos) {
			JOptionPane.showMessageDialog(this,
					"Logiciel réaliser par la \n"
					+ "classe 250 le 12 janvier 2023\n"
					+"Initiation a la librairie Swing \n"
					+"Tout droits réservés \n");
		}else if(e.getSource() == this.btEuro) {
			float mt = 0;
			try {
				mt = Float.parseFloat(this.txtMontant.getText());
				mt = mt/this.taux;
				this.txtMontant.setText(mt+"");
			}catch(NumberFormatException exp){
				JOptionPane.showMessageDialog(this, "Erreur de saisie  du montant","Erreur", JOptionPane.ERROR_MESSAGE);
				this.txtMontant.setText("");
			}
			
		}else if(e.getSource() == this.btDevise) {
			float mt = 0;
			try {
				mt = Float.parseFloat(this.txtMontant.getText());
				mt = mt*this.taux;
				this.txtMontant.setText(mt+"");
			}catch(NumberFormatException exp){
				JOptionPane.showMessageDialog(this, "Erreur de saisie  du montant","Erreur", JOptionPane.ERROR_MESSAGE);
				this.txtMontant.setText("");
			}
			
		}else if (e.getSource() == this.btTaux) {
			try  {
				this.devise = JOptionPane.showInputDialog("Donner la nouvelle devise");
				this.taux = Float.parseFloat(JOptionPane.showInputDialog("Donner le new taux de cette devise "));
				this.btDevise.setText(this.devise);
			}catch (NumberFormatException exp){
				JOptionPane.showMessageDialog(this, "Erreur de saisie  du taux","Erreur", JOptionPane.ERROR_MESSAGE);
				this.devise ="Francs";
				this.taux = (float) 6.56;
				this.btDevise.setText(this.devise);
			}
			catch (NullPointerException exp){
				JOptionPane.showMessageDialog(this, "Erreur de saisie","Erreur", JOptionPane.ERROR_MESSAGE);
				this.devise ="Francs";
				this.taux = (float) 6.56;
				this.btDevise.setText(this.devise);
			}
			
		}
			
		
	}

}
