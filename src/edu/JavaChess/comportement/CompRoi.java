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
				//TODO Traitement des différentes cases :
				/*TODO Revoir complêtement la fonction en ne considérant non pas la création d'un nouvel échiquier (ce qui ne sera plus
				 * possible) mais en modifiant juste temporairement la valeur de Coord pour le roi dans ech.coordPiece, suivi du test
				 * d'échec.
				 * A la fin du traitement, réaffecter la Coord initale du roi.
				 */
				if(!(i == 0 && j == 0) && tmpCoord.getColonne() >= 0 && tmpCoord.getLigne() >= 0 && tmpCoord.getColonne() <= 7 && tmpCoord.getLigne() <= 7) {
					if(ech.getPieceFromCoord(tmpCoord).getCouleur() != couleur) {
						//XXX TODO Pour que la méthode fonctionne dans tous les cas il ne faut juste que les coordonnées du roi soient 
						//modifiées il faut que l'intégralité du coup soit joué (dont les prises) mais donc mémorisé pour être annulé 
						//à la fin de la méthode.
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
