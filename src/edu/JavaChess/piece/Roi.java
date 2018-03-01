package edu.JavaChess.piece;

import java.util.ArrayList;

import edu.JavaChess.comportement.*;
import edu.JavaChess.main.Coord;
import edu.JavaChess.main.Echiquier;

public class Roi extends Piece {

	protected boolean enVerif;
	
	public Roi(String pNom, char pCouleur) {
		super(pNom, pCouleur);
		this.comportement = new CompRoi();
		if(pCouleur == 'b') {
			this.symbole = "♔ ";
		}else {
			this.symbole = "♚ ";
		}
		this.enVerif = false;
	}
	

	public boolean estEnVerif() {
		return enVerif;
	}


	public void setEnVerif(boolean estEnVerif) {
		this.enVerif = estEnVerif;
	}


	public ArrayList<Coord> casesControlleesDans(Echiquier ech) {
		this.enVerif = true;
		ArrayList<Coord> rCasesControllees = new ArrayList<Coord>();
		rCasesControllees = comportement.casesControlleesDans(ech, ech.getCoordPiece(this), this.couleur);
		this.enVerif = false;
		return rCasesControllees;
	}
	
	public ArrayList<Coord> casesPossiblesDans(Echiquier ech){
		this.enVerif = true;
		ArrayList<Coord> rCasesPossibles = new ArrayList<Coord>();
		rCasesPossibles = comportement.casesPossiblesDans(ech, ech.getCoordPiece(this), this.couleur);
		this.enVerif = false;
		return rCasesPossibles;
	}
}
