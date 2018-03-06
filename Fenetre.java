/**
 *Class représentant la fenetre principale
 *@author Ach-raf IMOROU
 *@version 1.0
 */
 import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.CardLayout;
 
 public class Fenetre extends JFrame{
/**
 * conteneur pricipale
 */
	private JPanel container= new JPanel();
	/**
	 * panneau contenant l'ecran
	 */
	private JPanel screen= new JPanel();
	/**
	 * panneau contenant les nombres
	 */
	private JPanel pan1= new JPanel();
	/**
	 * panneau contenat les operateurs
	 */
	private JPanel pan2= new JPanel();
	/**
	 * le layout manager
	 */
//private BorderLayout BorderLayout= new BorderLayout(); 
	/** 
	 * Tableau contenant les boutton du pan1
	 */
//private ButtonPerso b2= new ButtonPerso();

	/*private ButtonPerso[] b1= {
	new ButtonPerso("1"),
	new ButtonPerso("2"),
	new ButtonPerso("3"),
	new ButtonPerso("4"),
	new ButtonPerso("5"),
	new ButtonPerso("6"),
	new ButtonPerso("7"),
	new ButtonPerso("8"),
	new ButtonPerso("9"),
	new ButtonPerso("0"),
	new ButtonPerso("."),
	new ButtonPerso("=")};*/
	
	
	
	
	
	/**
	 * le label pour l'ecran
	 */
	private JLabel label=new JLabel();
	
	/**
	 *Constructeur de la fenetre 
	 */
	public Fenetre(){
		
		this.setTitle("CALCULATOR");
		this.setSize(400, 500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		/*for(int i=0;i<12;i++)
		pan1.add(b1[i],new CardLayout() );*/
		//pan1.add(b2);
		this.setLayout(new BorderLayout());
		this.getContentPane().add(new ButtonPerso("vie"),java.awt.BorderLayout.CENTER);
		
		this.setVisible(true);
	}
	
	
	
	
	
	
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Fenetre fen=new Fenetre();
		/*private ButtonPerso b2= new ButtonPerso("2");
		private ButtonPerso b3= new ButtonPerso("3");
		private ButtonPerso b4= new ButtonPerso("4");
		private ButtonPerso b5= new ButtonPerso("5");
		private ButtonPerso b6= new ButtonPerso("5");
		private ButtonPerso b7= new ButtonPerso("7");
		private ButtonPerso b8= new ButtonPerso("8");
		private ButtonPerso b9= new ButtonPerso("9");
		private ButtonPerso b10= new ButtonPerso("0");
		private ButtonPerso b11= new ButtonPerso(".");
		private ButtonPerso b12= new ButtonPerso("=");*/
	}

}
