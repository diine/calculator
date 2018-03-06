 /**
 * Classe abstraite représentant un bouton d'opération 
 * arithmetique personnalisé 
 *  @author Ach-raf IMOROU
 *  @version 1.0
 */
 import java.awt.Color;
import java.awt.Graphics;
/**
 *nom du bouton 
 */
	 

 
 public class ButtonArith extends ButtonPerso{
 
	 /**
	  *constructeur de la classe
	  *@param name
	  *         nom du bouton 
	  */
	 	 public ButtonArith(String name){
	 	 super(name);
	 	 }
 @Override
 /**
  *redéfinition de la méthode de dessin d'un boutton
  *@param g objet Graphics 
  */
	public void paintComponent(Graphics g){
	 
		g.drawRoundRect(0, 0, 30, 30, 5, 5);
		g.setColor(Color.black);
		
	}

}
