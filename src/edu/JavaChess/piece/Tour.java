package edu.JavaChess.piece;

import java.util.ArrayList;

import edu.JavaChess.comportement.*;
import edu.JavaChess.main.Coord;
import edu.JavaChess.main.Echiquier;

public class Tour extends Piece{

	public Tour(String pNom, char pCouleur){
		super(pNom, pCouleur);
		this.comportement = new CompTour();
		if(pCouleur == 'b') {
			this.symbole = "♖ ";
		}else {
			this.symbole = "♜ ";
		}
		System.out.println("public Tour ok");
	}

	public ArrayList<Coord> casesControlleesDans(Echiquier ech) {
		return comportement.casesControlleesDans(ech, ech.getCoordPiece(this), this.couleur);
	}

	public ArrayList<Coord> casesPossiblesDans(Echiquier ech) {
		
		return comportement.casesPossiblesDans(ech, ech.getCoordPiece(this), this.couleur);
	}
}
