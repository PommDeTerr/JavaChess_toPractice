/*Echiquier.java - TRAINEAU Maxime - 24 Février 2018
 * Contient la classe Echiquier générant des échiquiers composé d'un plateau, de tableaux des pièces prises, et d'une correspondance entre pièce et coordonnées
 */

package edu.JavaChess.main;

import edu.JavaChess.piece.*;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Enumeration;

public class Echiquier {

	protected Piece[][] plateau;
	protected Piece[] priseBlanche;
	protected Piece[] priseNoire;
	
	//Tableau associatif rattachant chaque pièce à ses coordonnées sur le plateau (Coord = -1 si la pièce est prise)
	protected Hashtable<Piece, Coord> coordPiece;
	
	//Constructeur d'un échiquier vierge : Toutes les pièces sont aussi créées ici, associées immédiatement à un jeu de coordonnées coorespondant
	//à leur place initiale sur l'échiquier, et finalement placées dans le plateau à l'aide de ces coordonnées.
	public Echiquier() {
		
		coordPiece = new Hashtable<Piece, Coord>();
		
		//Création des pièces, association à leurs coordonnées initiales
		coordPiece.put(new Tour("Th", 'b'),new Coord(0, 7));
		coordPiece.put(new Cavalier("Cg", 'b'), new Coord(0, 6));
		coordPiece.put(new Fou("Ff", 'b'), new Coord(0, 5));
		coordPiece.put(new Roi("Ro", 'b'), new Coord(0, 3));
		coordPiece.put(new Reine("Da", 'b'), new Coord(0, 4));
		coordPiece.put(new Fou("Fc", 'b'), new Coord(0, 2));
		coordPiece.put(new Cavalier("Cb", 'b'), new Coord(0, 1));
		coordPiece.put(new Tour("Ta", 'b'),new Coord(0, 0));
		
		coordPiece.put(new Tour("Th", 'n'),new Coord(7, 7));
		coordPiece.put(new Cavalier("Cg", 'n'), new Coord(7, 6));
		coordPiece.put(new Fou("Ff", 'n'), new Coord(7, 5));
		coordPiece.put(new Roi("Ro", 'n'), new Coord(7, 4));
		coordPiece.put(new Reine("Da", 'n'), new Coord(7, 3));
		coordPiece.put(new Fou("Fc", 'n'), new Coord(7, 2));
		coordPiece.put(new Cavalier("Cb", 'n'), new Coord(7, 1));
		coordPiece.put(new Tour("Ta", 'n'),new Coord(7, 0));
		
		coordPiece.put(new Pion("Ph", 'b'), new Coord(1, 7));
		coordPiece.put(new Pion("Pg", 'b'), new Coord(1, 6));
		coordPiece.put(new Pion("Pf", 'b'), new Coord(1, 5));
		coordPiece.put(new Pion("Pe", 'b'), new Coord(1, 4));
		coordPiece.put(new Pion("Pd", 'b'), new Coord(1, 3));
		coordPiece.put(new Pion("Pc", 'b'), new Coord(1, 2));
		coordPiece.put(new Pion("Pb", 'b'), new Coord(1, 1));
		coordPiece.put(new Pion("Pa", 'b'), new Coord(1, 0));
		
		coordPiece.put(new Pion("Ph", 'n'), new Coord(6, 7));
		coordPiece.put(new Pion("Pg", 'n'), new Coord(6, 6));
		coordPiece.put(new Pion("Pf", 'n'), new Coord(5, 5));
		/*coordPiece.put(new Pion("Pe", 'n'), new Coord(6, 4));
		coordPiece.put(new Pion("Pd", 'n'), new Coord(6, 3));
		coordPiece.put(new Pion("Pc", 'n'), new Coord(6, 2));
		coordPiece.put(new Pion("Pb", 'n'), new Coord(6, 1));
		coordPiece.put(new Pion("Pa", 'n'), new Coord(6, 0));*/
		
		
		
		//Initialisation des espaces de jeu
		this.plateau = new Piece[8][8];
		this.priseBlanche = new Piece[16];
		this.priseNoire = new Piece[16];
		
		//Remplissage initiale du plateau par des PieceVide
		for(int i = 0; i <= 7; i++) {
			for(int j = 0; j <= 7; j++) {
				this.plateau[i][j] = new PieceVide();
			}
		}
		
		//Insertion dans le plateau des pièces préalablement créées, en fonction de leurs coordonnées 
		Enumeration<Coord> eCoordPieceX = coordPiece.elements();
		Enumeration<Coord> eCoordPieceY = coordPiece.elements();
		Enumeration<Piece> ePiece = coordPiece.keys();
		
		while(ePiece.hasMoreElements()) {
			this.plateau[eCoordPieceX.nextElement().getLigne()][eCoordPieceY.nextElement().getColonne()] = ePiece.nextElement();
		}
	}
	
	
	
	public String toString() {
		
		//TODO Ajouter l'affichage des deux tableaux de prises, pièces noires prises en haut, pièces blanches prises en bas
		String stPlateau = "+--+--+--+--+--+--+--+--+\n";
		for(Piece[] pLigne : this.plateau) {
			String stLigne = "|";
			for(Piece pPiece : pLigne) {
				stLigne = stLigne + pPiece+"|";
			}
			stPlateau = stPlateau + stLigne + "\n+--+--+--+--+--+--+--+--+\n";
		}
		
		return stPlateau;
		
	}
	
	//Rôle : Récupère les coordonnées d'une pièce de l'échiquier
	//Précondition : La pièce DOIT être une pièce créée à l'initialisation de l'échiquier (voir méthode getPiece)
	//TODO Ajouter une exception pour garantir la précondition. Condition : le .get renvoie null si pc n'est pas de l'échiquier
	public Coord getCoordPiece(Piece pc){
		return this.coordPiece.get(pc);
	}
	
	//Rôle : Retourne une pièce de l'échiquier connaissant ses coordonnées
	//Seules les pièces présentes sur le plateau peuvent être récupérées
	//Précondition : coordonnées positives
	//TODO Exception
	public Piece getPieceFromCoord(Coord coord) {
		return this.plateau[coord.getLigne()][coord.getColonne()];
	}
	
	//Rôle : Retourne la pièce de l'échiquier dont le nom et la couleur corresponde aux paramètres d'entrées. Si aucune correspondance,
	//renvoie une PieceVide
	//Les méthodes d'échiquiers utilisant des pièces ont besoin de pièces créées à l'origine de l'échiquier, et non créées en dehors.
	//Cette méthode permet de récupérer ces pièces de l'échiquier.
	//Précondition : nom appartient aux noms autorisés (voir dans classe Piece), la couleur ne peut être que 'b' ou 'n'
	//TODO Exception
	public Piece getPiece(String nom, char couleur) {
		
		Enumeration<Piece> e = this.coordPiece.keys();
		
		while(e.hasMoreElements()) {
			Piece tmpPiece = e.nextElement();
			if(tmpPiece.getNom() == nom && tmpPiece.getCouleur() == couleur) {
				return tmpPiece;
			}
		}
		return new PieceVide();
	}
	
	
	//Rôle : Renvoie Vrai si le roi d'une certaine couleur est échec et faux sinon
	//Précondition : couleur = 'b' ou 'n'
	public boolean estEnEchec(char couleur) {
		Piece roi = this.getPiece("Ro", couleur);
		ArrayList<Coord> casesControllees = new ArrayList<Coord>();
		Enumeration<Piece> e = this.coordPiece.keys();
		while(e.hasMoreElements()) {
			Piece tmpPiece = e.nextElement();
			//Le comportement du roi n'étant pas encore défini, la fonction ne peut fonctionner que si les cases controllées par le
			//roi adverse ne sont pas analysées. La condition tmpPiece.getNom() != "Ro" est là pour ça. En revanche, elle devra être
			//supprimée à long terme.
			if(tmpPiece.getCouleur() != couleur && tmpPiece.getNom() != "Ro") {
				casesControllees.addAll(tmpPiece.casesControlleesDans(this));
			}
		}
		Iterator<Coord> i = casesControllees.listIterator();	
		while(i.hasNext()) {
			Coord tmpCoord = i.next();
			if(tmpCoord.equals(this.getCoordPiece(roi))) {
				return true;
			}
		}
		return false;
	}

}
