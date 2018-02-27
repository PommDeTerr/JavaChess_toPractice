package edu.JavaChess.comportement;

import edu.JavaChess.main.*;
import java.util.ArrayList;

public class CompTour extends CompLineaire implements Comportement{

	public CompTour() {
		System.out.println("public CompTour ok");
	}

	public ArrayList<Coord> casesControlleesDans(Echiquier ech, Coord coord, char couleur){
		ArrayList<Coord> casesControllees = new ArrayList<Coord>();
		
		//pour tous, traiter les deux cas : pièce de même couleur que soi = prend pas la case
		//piece de couleur différente = prend la case
		//Voir pour supprimer le package comportement
		//Directement implémenter les comportements dans les class de pièces
		
		//Vertical basse
		
		int iterateur = 1;
		
		iterateur = 1;
		Coord tmpCoord = new Coord(coord.getLigne()+iterateur, coord.getColonne());
				
		while(this.testCaseCourante(ech, tmpCoord, couleur, casesControllees)) {
			iterateur++;
			tmpCoord = new Coord(coord.getLigne()+iterateur, coord.getColonne());
				
		}
		
		//Verticale Haute
		
		iterateur = 1;
		tmpCoord = new Coord(coord.getLigne()-iterateur, coord.getColonne());
				
		while(this.testCaseCourante(ech, tmpCoord, couleur, casesControllees)) {
			iterateur++;
			tmpCoord = new Coord(coord.getLigne()-iterateur, coord.getColonne());
				
		}
		
		//Horizontale Droite
		
		iterateur = 1;
		tmpCoord = new Coord(coord.getLigne(), coord.getColonne()+iterateur);
				
		while(this.testCaseCourante(ech, tmpCoord, couleur, casesControllees)) {
			iterateur++;
			tmpCoord = new Coord(coord.getLigne(), coord.getColonne() + iterateur);
				
		}
		
		//Horizontale Gauche
		
		iterateur = 1;
		tmpCoord = new Coord(coord.getLigne(), coord.getColonne()-iterateur);
				
		while(this.testCaseCourante(ech, tmpCoord, couleur, casesControllees)) {
			iterateur++;
			tmpCoord = new Coord(coord.getLigne(), coord.getColonne() - iterateur);
				
		}
		
		return casesControllees;
		
	}

	public ArrayList<Coord> casesPossiblesDans(Echiquier ech, Coord coord, char couleur) {
		
		return this.casesControlleesDans(ech, coord, couleur);
	}
	
	
}
