/**
 * Classe abstraite représentant un bouton personnalisé
 *  @author Ach-raf IMOROU
 *  @version 1.0
 */
 import java.awt.Color;
 import java.awt.Graphics;
 import javax.swing.JButton;
 public class ButtonPerso extends JButton  {
 /**
	 * 
	 */
	
/**
  *nom du bouton 
  */
	 private String name;
 /**
  *constructeur de la classe
  *@param name
  *         nom du bouton 
  */
	 public ButtonPerso(String name){
	 super(name);
	 this.name = name;
	 }
 @Override
 /**
  *redéfinition de la méthode de dessin d'un boutton
  *@param g objet Graphics 
  */
	public void paintComponent(Graphics g){
	 
		g.drawRoundRect(0, 0, 60, 60,20,20);
		//g.setColor(Color.red);
		
	}

}
