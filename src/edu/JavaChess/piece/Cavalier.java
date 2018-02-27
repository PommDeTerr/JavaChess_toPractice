/*Cavalier.java - TRAINEAU Maxime - 24 Février 2018
 * Spécification d'une pièce en cavalier
 */

package edu.JavaChess.piece;

import edu.JavaChess.comportement.*;
import edu.JavaChess.main.*;
import java.util.ArrayList;

public class Cavalier extends Piece {

	//Suivant le nom et la couleur, on ajoute le symbole est le comportement CompCavalier au futur cavalier.
	public Cavalier(String pNom, char pCouleur) {
		super(pNom, pCouleur);
		this.comportement = new CompCavalier();
		if(pCouleur == 'b') {
			this.symbole = "♘ ";
		}else {
			this.symbole = "♞ ";
		}
	}
	
	//Association des méthodes de comportement de la pièce à celle dudit comportement affecté à la construction
	public ArrayList<Coord> casesControlleesDans(Echiquier ech) {
		return comportement.casesControlleesDans(ech, ech.getCoordPiece(this), this.couleur);
	}
	
	public ArrayList<Coord> casesPossiblesDans(Echiquier ech){
		return comportement.casesPossiblesDans(ech,  ech.getCoordPiece(this), this.couleur);
	}
}
