/* Coup.java - TRAINEAU Maxime - 27 F�vrier 2018
 * Contient la classe coup qui correspond � l'association d'une pi�ce et d'un jeu de coordonn�es correspondant � la case d'arriv�e
 * Un coup est g�n�r� par un joueur suivant la chaine de caract�re entr�e par le joueur
 * Il est ensuite valid� par la partie qui pourrait l'utiliser � l'aide d'une m�thode propre � la partie, et supprimer s'il n'est pas possible
 * De fait on suppose que les coups seront toujours utilis�s dans des situations o� ils sont autoris�es.
 */

package edu.JavaChess.main;

import edu.JavaChess.piece.*;

public class Coup {
	
	protected String nom;
	protected Piece piece;
	protected Coord coordCible;

	public Coup() {
		
	}
	
	public Coup(String nom, Piece piece, Coord coordCible) {
		this.nom = nom;
		this.piece = piece;
		this.coordCible = coordCible;
	}

	public Coord getCoordCible() {
		return coordCible;
	}

	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}

	public void setCoordCible(Coord coordCible) {
		this.coordCible = coordCible;
	}

}
