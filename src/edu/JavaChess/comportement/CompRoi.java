package edu.JavaChess.comportement;

import java.util.ArrayList;

import edu.JavaChess.main.Coord;
import edu.JavaChess.main.Coup;
import edu.JavaChess.main.Echiquier;

public class CompRoi implements Comportement{

	public CompRoi() {

	}

	public ArrayList<Coord> casesControlleesDans(Echiquier ech, Coord coord, char couleur) {
		ArrayList<Coord> casesControllees = new ArrayList<Coord>();
		
		for(int i = -1; i <= 1; i++) {
			for(int j = -1; j <= 1; j++) {
				Coord tmpCoord = new Coord(coord.getLigne()+i, coord.getColonne()+j);
				//TODO Traitement des diff�rentes cases :
				//-V�rifier qu'elle est libre ou poss�dant une pi�ce de l'autre couleur
				//-G�n�rer l'�chiquier tmpEch avec ech.deplacement(new Coup(ech.getPiece("Ro", couleur), tmpCoord)
				//-V�rifier que le roi n'est pas en �chec sur cette case tmpEch.estEnEchec(couleur)
				//Ajouter ou non la case � casesControllees suivant les tests pr�c�dents.
				if(!(i == 0 && j == 0) && tmpCoord.getColonne() >= 0 && tmpCoord.getLigne() >= 0 && tmpCoord.getColonne() <= 7 && tmpCoord.getLigne() <= 7) {
					if(ech.getPieceFromCoord(tmpCoord).getCouleur() != couleur) {
						Echiquier tmpEch = ech.deplacement(new Coup("testRoi", ech.getPiece("Ro", couleur), tmpCoord));
						if(!tmpEch.estEnEchec(couleur)) {
							casesControllees.add(tmpCoord);
						}
					}
				}
			}
		}
		return casesControllees;
	}

	public ArrayList<Coord> casesPossiblesDans(Echiquier ech, Coord coord, char couleur) {

		return this.casesControlleesDans(ech, coord, couleur);
	}

	
}
