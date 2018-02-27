package edu.JavaChess.comportement;

import java.util.ArrayList;

import edu.JavaChess.main.Coord;
import edu.JavaChess.main.Echiquier;

public class CompRoi implements Comportement{

	public CompRoi() {

	}

	public ArrayList<Coord> casesControlleesDans(Echiquier ech, Coord coord, char couleur) {
		for(int i = -1; i <= 1; i++) {
			for(int j = -1; j <= 1; j++) {
				
			}
		}
		return null;
	}

	public ArrayList<Coord> casesPossiblesDans(Echiquier ech, Coord coord, char couleur) {

		return null;
	}

	
}
