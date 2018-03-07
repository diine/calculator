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
 import java.awt.GridLayout;
 
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
	 * le layout manager de pan1
	 */
	GridLayout grid1= new GridLayout(4,3);
	/**
	 * le layout manager de pan2
	 */
	GridLayout grid2= new GridLayout(5,1);
//private BorderLayout BorderLayout= new BorderLayout(); 
	/** 
	 * Tableau contenant les boutton du pan1
	 */
	private JButton[] tableau1= {
	new JButton("1"),new JButton("2"),new JButton("3"),new JButton("4"),
	new JButton("5"),new JButton("6"),new JButton("7"),new JButton("8"),
	new JButton("9"),new JButton("0"),new JButton("."),new JButton("=")};
	/** 
	 * Tableau contenant les boutton du pan2
	 */
	private JButton[] tableau2= {
			new JButton("C"),new JButton("+"),
			new JButton("-"),new JButton("*"),new JButton("/")};
	
	
	/**
	 * le label pour l'ecran
	 */
	private JLabel label=new JLabel("00000");
	
	/**
	 *Constructeur de la fenetre 
	 */
	public Fenetre(){
		
		this.setTitle("CALCULATOR");
		this.setSize(220, 300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		grid1.setHgap(5);
		grid1.setVgap(10);
		
		container.setLayout(new BorderLayout());
		
		//panneau 1
		pan1.setLayout(grid1);
		for(int i=0;i<12;i++)
			pan1.add(tableau1[i]);
		for(int i=0;i<12;i++)
			tableau1[i].setBackground(Color.orange);
		
		//panneau 2
		grid2.setHgap(5);
		grid2.setVgap(8);
		tableau2[0].setBackground(Color.red);
		
		for(int i=1;i<5;i++)
			tableau2[i].setBackground(Color.cyan);
		pan2.setLayout(grid2);
		for(int i=0;i<5;i++)
			pan2.add(tableau2[i]);
		
		screen.setLayout(new BorderLayout());
		
		
		//création de bordure vide pour espacer les composants pan1 pan2 & screen 
		label.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
		pan1.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 5, 5, 5));
		pan2.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 5, 5, 5));
		
		//création de la bordure de lécran
		screen.setBorder(javax.swing.BorderFactory.createLineBorder(Color.black, 2));
		
		//positionnement du resultat à gauche de l'ecran
		screen.add(label, BorderLayout.EAST);
		
		//ajout des composant au JPanel principale
		container.add(screen, BorderLayout.NORTH);
		container.add(pan1, BorderLayout.CENTER);
		container.add(pan2, BorderLayout.EAST);
		

		this.setContentPane(container);
		this.setVisible(true);
	}
	
	

}
