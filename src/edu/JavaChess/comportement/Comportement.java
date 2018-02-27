package edu.JavaChess.comportement;

import java.util.ArrayList;
import edu.JavaChess.main.*;

public interface Comportement {
	
	public abstract ArrayList<Coord> casesControlleesDans(Echiquier ech, Coord coord, char couleur);
	
	public abstract ArrayList<Coord> casesPossiblesDans(Echiquier ech, Coord coord, char couleur);
	
}
