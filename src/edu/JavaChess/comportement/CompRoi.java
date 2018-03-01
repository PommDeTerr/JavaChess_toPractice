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
		Coord initiales = new Coord(coord.getLigne(), coord.getColonne());
		for(int i = -1; i <= 1; i++) {
			for(int j = -1; j <= 1; j++) {
				Coord tmpCoord = new Coord(coord.getLigne()+i, coord.getColonne()+j);
				//TODO Traitement des diff�rentes cases :
				/*TODO Revoir compl�tement la fonction en ne consid�rant non pas la cr�ation d'un nouvel �chiquier (ce qui ne sera plus
				 * possible) mais en modifiant juste temporairement la valeur de Coord pour le roi dans ech.coordPiece, suivi du test
				 * d'�chec.
				 * A la fin du traitement, r�affecter la Coord initale du roi.
				 */
				if(!(i == 0 && j == 0) && tmpCoord.getColonne() >= 0 && tmpCoord.getLigne() >= 0 && tmpCoord.getColonne() <= 7 && tmpCoord.getLigne() <= 7) {
					if(ech.getPieceFromCoord(tmpCoord).getCouleur() != couleur) {
						//XXX TODO Pour que la m�thode fonctionne dans tous les cas il ne faut juste que les coordonn�es du roi soient 
						//modifi�es il faut que l'int�gralit� du coup soit jou� (dont les prises) mais donc m�moris� pour �tre annul� 
						//� la fin de la m�thode.
						ech.setCoordOfPiece(ech.getPiece("Ro", couleur), tmpCoord);
						if(!ech.estEnEchec(couleur)) {
							casesControllees.add(tmpCoord);
						}
					}
				}
			}
		}
		ech.setCoordOfPiece(ech.getPiece("Ro", couleur), initiales);
		return casesControllees;
	}

	public ArrayList<Coord> casesPossiblesDans(Echiquier ech, Coord coord, char couleur) {

		return this.casesControlleesDans(ech, coord, couleur);
	}

	
}
