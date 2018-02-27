/* Coup.java - TRAINEAU Maxime - 27 Février 2018
 * Contient la classe coup qui correspond à l'association d'une pièce et d'un jeu de coordonnées correspondant à la case d'arrivée
 * Un coup est généré par un joueur suivant la chaine de caractère entrée par le joueur
 * Il est ensuite validé par la partie qui pourrait l'utiliser à l'aide d'une méthode propre à la partie, et supprimer s'il n'est pas possible
 * De fait on suppose que les coups seront toujours utilisés dans des situations où ils sont autorisées.
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
