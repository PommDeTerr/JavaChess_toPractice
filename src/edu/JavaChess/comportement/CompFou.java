package edu.JavaChess.comportement;

import java.util.ArrayList;

import edu.JavaChess.main.Coord;
import edu.JavaChess.main.Echiquier;
import edu.JavaChess.piece.*;

public class CompFou extends CompLineaire implements Comportement{

	public CompFou() {
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<Coord> casesPossiblesDans(Echiquier ech, Coord coord, char couleur){
		return casesControlleesDans(ech, coord, couleur);
	}

	public ArrayList<Coord> casesControlleesDans(Echiquier ech, Coord coord, char couleur){
		
		ArrayList<Coord> casesControllees = new ArrayList<Coord>();
		
		//pour tous, traiter les deux cas : pièce de même couleur que soi = prend pas la case
		//piece de couleur différente = prend la case
		//Voir pour supprimer le package comportement
		//Directement implémenter les comportements dans les class de pièces
		
		//Diagonale droite basse
		
		int iterateur = 1;
		
		iterateur = 1;
		Coord tmpCoord = new Coord(coord.getLigne()+iterateur, coord.getColonne()+iterateur);
				
		while(this.testCaseCourante(ech, tmpCoord, couleur, casesControllees)) {
			iterateur++;
			tmpCoord = new Coord(coord.getLigne()+iterateur, coord.getColonne() + iterateur);
				
		}
		
		//Diagonale gauche basse
		
		iterateur = 1;
		tmpCoord = new Coord(coord.getLigne()+iterateur, coord.getColonne()-iterateur);
				
		while(this.testCaseCourante(ech, tmpCoord, couleur, casesControllees)) {
			iterateur++;
			tmpCoord = new Coord(coord.getLigne()+iterateur, coord.getColonne() - iterateur);
				
		}
		
		//diagonale gauche haute
		
		iterateur = 1;
		tmpCoord = new Coord(coord.getLigne()-iterateur, coord.getColonne()-iterateur);
				
		while(this.testCaseCourante(ech, tmpCoord, couleur, casesControllees)) {
			iterateur++;
			tmpCoord = new Coord(coord.getLigne()-iterateur, coord.getColonne() - iterateur);
				
		}
		
		//diagonale droite haute
		
		iterateur = 1;
		tmpCoord = new Coord(coord.getLigne()-iterateur, coord.getColonne()+iterateur);
				
		while(this.testCaseCourante(ech, tmpCoord, couleur, casesControllees)) {
			iterateur++;
			tmpCoord = new Coord(coord.getLigne()-iterateur, coord.getColonne() + iterateur);
		}
		
		return casesControllees;
		
	}
	
	
}
