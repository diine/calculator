/**
 *Class représentant la fenetre principale
 *@author Ach-raf IMOROU
 *@version 1.0
 */
 import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
 
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
	 *  layout manager de pan1
	 */
	GridLayout grid1= new GridLayout(4,3);
	/**
	 *  layout manager de pan2
	 */
	GridLayout grid2= new GridLayout(5,1);
	/**
	 *police d'affichage à l'ecran 
	 */
	Font police = new Font("Arial",Font.BOLD,18);
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
	private JLabel label=new JLabel("0");
	/**
	 *nombre 
	 */
	private double nombre=0, nombre1=0,nombre2=0;
	private String resultat="0",resultat1="0",resultat2="0";
	private boolean ope=false, add=false, sou=false, mul=false, div=false;
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
		
		//mise à jour de la police
		label.setFont(police);
		
		
		//positionnement du resultat à gauche de l'ecran
		screen.add(label, BorderLayout.EAST);
		
		//ajout des composant au JPanel principale
		container.add(screen, BorderLayout.NORTH);
		container.add(pan1, BorderLayout.CENTER);
		container.add(pan2, BorderLayout.EAST);
		//affichage des boutons selectionnes on affiche pas = d'ou la limite du tableau à 11
		for(int i=0;i<11;i++)
			tableau1[i].addActionListener(new ViewButton());
		
		//mise à 0 de la machine
		tableau2[0].addActionListener(new ViewButton());
		
		for(int i=1;i<=4;i++)
			tableau2[i].addActionListener(new Operation());
		
		tableau1[11].addActionListener(new Resultat());
		
		this.setContentPane(container);
		this.setVisible(true);
	}
	
	
	
	
	
	
	private class ViewButton implements ActionListener{
		
		
		public void actionPerformed(ActionEvent arg0){
		
		if(ope==false){
			for(int i=0;i<9;i++){	
				if(arg0.getSource()==tableau1[i] && nombre1!=0 && !dotIs(resultat1)){//prends pas en compte les nombres a virgule
					resultat1+=(i+1);
					nombre1=nombre1*10 +(i+1);//warning nombre1*=10+i+1 fait d'abord l'operatio de droite et ensuite nombre1* le result
					label.setText(resultat1.substring(1, resultat1.length())); //permet de ne pas afficher le 0 initial de resultat
		}
				if(arg0.getSource()==tableau1[i] && nombre1!=0 && dotIs(resultat1)){//prends en compte les nombres a virgule
					resultat1+=(i+1);
					nombre1+=0.1*(i+1);
					label.setText(resultat1.substring(1, resultat1.length()));
				}
				if(arg0.getSource()==tableau1[i] && nombre1==0 && !dotIs(resultat1)){//prends en compte les nombre a virgule
					resultat1+=(i+1);
					nombre1+=i+1;
					label.setText(resultat1.substring(1, resultat1.length()));
		}
				if(arg0.getSource()==tableau1[i] && nombre1==0 && dotIs(resultat1)){//prends en compte les nombre a virgule
					resultat1+=(i+1);
					nombre1+=0.1*(i+1);
					label.setText(resultat1.substring(1, resultat1.length()));}	
		}
		}
		else{
			for(int i=0;i<9;i++){	
				if(arg0.getSource()==tableau1[i] && nombre2!=0 && !dotIs(resultat2)){
					resultat2+=(i+1);
					nombre2=nombre2*10 +(i+1); 
					label.setText(resultat2.substring(1, resultat2.length()));
		}
				if(arg0.getSource()==tableau1[i] && nombre1!=0 && dotIs(resultat2)){//prends en compte les nombres a virgule
					resultat2+=(i+1);
					nombre2+=0.1*(i+1);
					label.setText(resultat2.substring(1, resultat2.length()));
				}
				if(arg0.getSource()==tableau1[i] && nombre2==0 && !dotIs(resultat2) ){
					resultat2+=(i+1);
					nombre2+=(i+1);
					label.setText(resultat2.substring(1, resultat2.length()));
		}
				if(arg0.getSource()==tableau1[i] && nombre2==0 && dotIs(resultat2) ){
					resultat2+=(i+1);
					nombre2+=0.1*(i+1);
					label.setText(resultat2.substring(1, resultat2.length()));}
		}
			
		}
			
		
		if(arg0.getSource()==tableau1[9] && ope==false){
			resultat1+="0";
			nombre1*=10;	
			label.setText(resultat1.substring(1, resultat1.length()));
		}
		if(arg0.getSource()==tableau1[9] && ope==true){
			resultat2+="0";
			nombre2*=10;	
			label.setText(resultat2.substring(1, resultat2.length()));
			
		}
		//evite l'insertion de plusieurs points successifs mais ya un pb
		if(arg0.getSource()==tableau1[10] && !dotIs(resultat1) && ope==false ){ 
			resultat1+=".";
			nombre1=nombre1*1.0;	
			label.setText(resultat1.substring(1, resultat1.length()));
		}
		
		if(arg0.getSource()==tableau1[10] && dotIs(resultat1) && ope==false ){ //gere l'affichage de plusieurs . qui est impossible
			nombre1*=1.0;	
			label.setText(resultat1.substring(1, resultat1.length()));
		}
		
		if(arg0.getSource()==tableau1[10] && !dotIs(resultat2) && ope==true ){ 
			resultat2+=".";
			nombre2=nombre2*1.0;	
			label.setText(resultat2.substring(1, resultat2.length()));
		}
		if(arg0.getSource()==tableau1[10] && dotIs(resultat2) && ope==true ){ 
			nombre2=nombre2*1.0;	
			label.setText(resultat2.substring(1, resultat2.length()));
		}
			
		if(arg0.getSource()==tableau2[0] ){
			resultat1="0";
			resultat2="0";
			nombre1=0;
			nombre2=0;
			label.setText(resultat1);
		}
		
		}
	}
	
	private static boolean dotIs(String arg){
		
		int n=0;
		n=arg.indexOf('.');
		if(n!=-1)
		return  true;
		else return false;
	}

	private class Operation implements ActionListener{
		
		public void actionPerformed(ActionEvent arg0){
			
			if(arg0.getSource()==tableau2[1]){
				add=true;
				ope=true;	
			}
			if(arg0.getSource()==tableau2[2]){
				sou=true;
				ope=true;	
		}
			if(arg0.getSource()==tableau2[3]){
				mul=true;
				ope=true;	
		}
			if(arg0.getSource()==tableau2[4]){
				div=true;
				ope=true;	
		}
			
		}
	}
	
		private class Resultat implements ActionListener{
		
		public void actionPerformed(ActionEvent arg0){
			if(arg0.getSource()==tableau1[11] && add==true){
				
				nombre1+=nombre2;
				nombre2=0;
				add=false;
				ope=false;
				resultat1=""+nombre1;
				label.setText(resultat1); //afficher le resultat
				//resultat1="0";
				resultat2="0";
				
				
			}
			if(arg0.getSource()==tableau1[11] && sou==true){
				
				nombre1-=nombre2;
				nombre2=0;
				sou=false;
				ope=false;
				resultat1=""+nombre1;
				label.setText(resultat1); //afficher le resultat
				//resultat1="0";
				resultat2="0";
				
			}
			if(arg0.getSource()==tableau1[11] && mul==true){
	
				nombre1*=nombre2;
				nombre2=0;
				mul=false;
				ope=false;
				resultat1=""+nombre1;
				label.setText(resultat1);
				resultat2="0";
				
	
}
			if(arg0.getSource()==tableau1[11] && div==true){
				try{
				nombre1=nombre1/nombre2;
				}catch(ArithmeticException e){
					label.setText("error");
				}
				nombre2=0;
				div=false;
				ope=false;
				resultat1=""+nombre1;
				label.setText(resultat1);
				resultat2="0";
				
				
	
}
}}
		
 }
 
 