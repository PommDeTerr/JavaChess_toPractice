package edu.JavaChess.comportement;

import java.util.ArrayList;
import edu.JavaChess.main.*;
import edu.JavaChess.piece.*;

public class CompPion implements Comportement{

	public CompPion() {
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<Coord> casesControlleesDans(Echiquier ech, Coord coord, char couleur){
		ArrayList<Coord> rCasesControllees = new ArrayList<Coord>();
		int decalage = (couleur == 'b')? 1:-1;
		for(int diff = -1; diff<=1; diff+=2) {
			Coord tmpCoord = new Coord(coord.getLigne()+decalage, coord.getColonne()+diff);
			if(tmpCoord.getColonne() <= 7 && tmpCoord.getColonne()>=0) {
				if(ech.getPieceFromCoord(tmpCoord) == new PieceVide() || ech.getPieceFromCoord(tmpCoord).getCouleur() != couleur) {
					rCasesControllees.add(tmpCoord);
				}
			}
		}
		return rCasesControllees;
	}
	
	public ArrayList<Coord> casesPossiblesDans(Echiquier ech, Coord coord, char couleur){
		ArrayList<Coord> rCasesPossibles = new ArrayList<Coord>();
		int decalage = (couleur == 'b')? 1:-1;
		
		//Cases juste devant le pion
		Coord tmpCoord = new Coord(coord.getLigne()+decalage, coord.getColonne());
		if(ech.getPieceFromCoord(tmpCoord).getNom() == "Vide") {
			rCasesPossibles.add(tmpCoord);
			
			//Deuxième case devant le pion, si le pion est a sa position initiale
			tmpCoord = new Coord(coord.getLigne()+2*decalage, coord.getColonne());
			if((coord.getLigne() == 1 || coord.getLigne() == 6) && ech.getPieceFromCoord(tmpCoord).getNom() == "Vide") {
				rCasesPossibles.add(tmpCoord);
			}
		}
		return rCasesPossibles;
	}

}
