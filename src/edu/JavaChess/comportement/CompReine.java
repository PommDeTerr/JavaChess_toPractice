package edu.JavaChess.comportement;

import java.util.ArrayList;

import edu.JavaChess.main.Coord;
import edu.JavaChess.main.Echiquier;

public class CompReine extends CompLineaire implements Comportement{

	Comportement commeTour;
	Comportement commeFou;
	
	public CompReine() {
		commeTour = new CompTour();
		commeFou = new CompFou();
	}

	public ArrayList<Coord> casesControlleesDans(Echiquier ech, Coord coord, char couleur) {
		ArrayList<Coord> rCasesControllees = new ArrayList<Coord>();
		rCasesControllees.addAll(commeTour.casesControlleesDans(ech, coord, couleur));
		rCasesControllees.addAll(commeFou.casesControlleesDans(ech, coord, couleur));
		return rCasesControllees;
	}

	public ArrayList<Coord> casesPossiblesDans(Echiquier ech, Coord coord, char couleur) {
		return this.casesControlleesDans(ech, coord, couleur);
	}
	
	

}
