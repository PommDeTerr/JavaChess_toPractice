package edu.JavaChess.comportement;

import java.util.ArrayList;

import edu.JavaChess.main.Coord;
import edu.JavaChess.main.Echiquier;
import edu.JavaChess.piece.PieceVide;

public abstract class CompLineaire implements Comportement{

	public CompLineaire() {
		// TODO Auto-generated constructor stub
	}

	//Fonction de v�rification de la pr�sence de pi�ce sur les cases analys�es, pour d�terminer les cases controll�es et possibles des pi�ces
	//� d�placement lin�aire (Tour, Fou, Reine)
	protected boolean testCaseCourante(Echiquier ech, Coord tmpCoord, char couleur, ArrayList<Coord> casesControllees) {
		boolean obstacleRencontre = true;
		if(tmpCoord.getColonne() >= 0 && tmpCoord.getColonne() <= 7 && tmpCoord.getLigne() >= 0 && tmpCoord.getLigne() <= 7) {
			if(ech.getPieceFromCoord(tmpCoord).getNom() == "Vide") {
				casesControllees.add(tmpCoord);
				obstacleRencontre = false;
			}else {
				if(ech.getPieceFromCoord(tmpCoord).getCouleur() != couleur) {
					casesControllees.add(tmpCoord);
				}
			}
		}
		return !obstacleRencontre;
	}
}
