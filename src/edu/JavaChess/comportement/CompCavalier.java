package edu.JavaChess.comportement;

import java.util.ArrayList;
import edu.JavaChess.main.*;

public class CompCavalier implements Comportement{

	public CompCavalier() {
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<Coord> casesControlleesDans(Echiquier ech, Coord coord, char couleur){
		
		int ligne = coord.getLigne();
		int colonne = coord.getColonne();
		
		ArrayList<Coord> casesControllees = new ArrayList<Coord>();
		
		for(int diff = -2; diff <= 2; diff+=4) {
			for(int dec = -1; dec <=1; dec+=2) {
				
				Coord tmpCase = new Coord(ligne + diff, colonne + dec);
				Coord tmpCaseBis = new Coord(ligne + dec,  colonne + diff);
				
				if(tmpCase.getColonne() >=0 && tmpCase.getLigne() >=0 && tmpCase.getColonne() <=7 && tmpCase.getLigne() <=7 && ech.getPieceFromCoord(tmpCase).getCouleur() != couleur) {
					casesControllees.add(tmpCase);
				}
				if(tmpCaseBis.getColonne() >=0 && tmpCaseBis.getLigne() >=0 && tmpCaseBis.getColonne() <=7 && tmpCaseBis.getLigne() <=7 && ech.getPieceFromCoord(tmpCase).getCouleur() != couleur) {
					casesControllees.add(tmpCaseBis);
				}
			}
		}
		return casesControllees;
	}
	
	public ArrayList<Coord> casesPossiblesDans(Echiquier ech, Coord coord, char couleur){
		return casesControlleesDans(ech, coord, couleur);
	}

}
