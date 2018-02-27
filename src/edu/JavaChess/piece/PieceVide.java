package edu.JavaChess.piece;

import java.util.ArrayList;

import edu.JavaChess.comportement.*;
import edu.JavaChess.main.Coord;
import edu.JavaChess.main.Echiquier;

public class PieceVide extends Piece{

	public PieceVide() {
		this.nom = "Vide";
		this.couleur = ' ';
		this.symbole = "  ";
		this.comportement = new CompVide();
	}
	
	public ArrayList<Coord> casesControlleesDans(Echiquier ech) {
		return comportement.casesControlleesDans(ech, ech.getCoordPiece(this));
	}
}
