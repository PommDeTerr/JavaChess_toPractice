/*Piece.java - TRAINEAU Maxime - 24 Février 2018
 * Contient la classe abstraite mère Piece permettant d'établir toutes les pièces.
 */

/*Correspondance Pièce-nom ( ci = lettre de la colonne sur laquelle se trouve la pièce au démarrage de la partie)
 * {{Tour ci A, Cavalier ci B, Fou ci C, Reine ci D, Roi ci E, Fou ci F, Cavalier ci G, Tour ci H},
 * 	{Ta 	  , Cb 			 , Fc	   , Dd		   , Re		 , Ff	   , Cg			  , Th 		 }}
 * Les pions suivent la même logique, d'où le nom général : Px, où x = [a-h]
*/

package edu.JavaChess.piece;

import edu.JavaChess.comportement.*;
import edu.JavaChess.main.*;
import java.util.ArrayList;

public abstract class Piece {
	
	protected String nom;
	protected char couleur;
	protected String symbole;
	protected Comportement comportement;

	
	//Partie de la construction commune à toutes les pièces
	public Piece(String pNom, char pCouleur) {
		this.nom = pNom;
		this.couleur = pCouleur;
		System.out.println("public Piece ok");
	}
	
	//Seule la pièce vide peut se construire sans paramètres initiaux
	public Piece() {
		
	}
	
	public String toString() {
		return this.symbole;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public char getCouleur() {
		return this.couleur;
	}
	
	//Méthode des comportements de la pièce, dépend du comportement associée à la pièce:
	
	//Rôle : Détermine la liste des cases controllées par une pièce dans un échiquier donné, ie les cases par lesquelles les pièces 
	//adverses sont mises en échec (ne prend pas la case de la pièce appelante, mais prend celle des pièces menacées)
	//TODO Tester le cas des pièces prises
	public abstract ArrayList<Coord> casesControlleesDans(Echiquier echiquier);
	
	//Rôle : Détermine la liste des cases sur lesquelles la pièce appelante peut aller dans un échiquier donné (ne prend pas la case de
	//la pièce appelante, mais prend celle des pièces menacées)
	//TODO Tester le cas des pièces prises
	public abstract ArrayList<Coord> casesPossiblesDans(Echiquier echiquier);
	
	//INFO : Il n'existe aucune différence de sortie entre ces deux méthodes pour la majorité des pièces. Seuls les pions, du fait de
	//leur comportement particulier possèdent des résultats différents d'une méthode à l'autre.
	
}
