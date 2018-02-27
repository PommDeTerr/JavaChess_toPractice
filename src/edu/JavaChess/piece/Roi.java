package edu.JavaChess.piece;

import java.util.ArrayList;

import edu.JavaChess.comportement.*;
import edu.JavaChess.main.Coord;
import edu.JavaChess.main.Echiquier;

public class Roi extends Piece {

	public Roi(String pNom, char pCouleur) {
		super(pNom, pCouleur);
		this.comportement = new CompRoi();
		if(pCouleur == 'b') {
			this.symbole = "♔ ";
		}else {
			this.symbole = "♚ ";
		}
	}

	public ArrayList<Coord> casesControlleesDans(Echiquier ech) {
		return comportement.casesControlleesDans(ech, ech.getCoordPiece(this));
	}
}
