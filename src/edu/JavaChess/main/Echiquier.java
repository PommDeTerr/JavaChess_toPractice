/*Echiquier.java - TRAINEAU Maxime - 24 F�vrier 2018
 * Contient la classe Echiquier g�n�rant des �chiquiers compos� d'un plateau, de tableaux des pi�ces prises, et d'une correspondance entre pi�ce et coordonn�es
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
	
	//Tableau associatif rattachant chaque pi�ce � ses coordonn�es sur le plateau (Coord = -1 si la pi�ce est prise)
	protected Hashtable<Piece, Coord> coordPiece;
	
	//Constructeur d'un �chiquier vierge : Toutes les pi�ces sont aussi cr��es ici, associ�es imm�diatement � un jeu de coordonn�es coorespondant
	//� leur place initiale sur l'�chiquier, et finalement plac�es dans le plateau � l'aide de ces coordonn�es.
	public Echiquier() {
		
		coordPiece = new Hashtable<Piece, Coord>();
		
		//Cr�ation des pi�ces, association � leurs coordonn�es initiales
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
		
		//Insertion dans le plateau des pi�ces pr�alablement cr��es, en fonction de leurs coordonn�es 
		Enumeration<Coord> eCoordPieceX = coordPiece.elements();
		Enumeration<Coord> eCoordPieceY = coordPiece.elements();
		Enumeration<Piece> ePiece = coordPiece.keys();
		
		while(ePiece.hasMoreElements()) {
			this.plateau[eCoordPieceX.nextElement().getLigne()][eCoordPieceY.nextElement().getColonne()] = ePiece.nextElement();
		}
	}
	
	
	
	public String toString() {
		
		//TODO Ajouter l'affichage des deux tableaux de prises, pi�ces noires prises en haut, pi�ces blanches prises en bas
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
	
	//R�le : R�cup�re les coordonn�es d'une pi�ce de l'�chiquier
	//Pr�condition : La pi�ce DOIT �tre une pi�ce cr��e � l'initialisation de l'�chiquier (voir m�thode getPiece)
	//TODO Ajouter une exception pour garantir la pr�condition. Condition : le .get renvoie null si pc n'est pas de l'�chiquier
	public Coord getCoordPiece(Piece pc){
		return this.coordPiece.get(pc);
	}
	
	//R�le : Retourne une pi�ce de l'�chiquier connaissant ses coordonn�es
	//Seules les pi�ces pr�sentes sur le plateau peuvent �tre r�cup�r�es
	//Pr�condition : coordonn�es positives
	//TODO Exception
	public Piece getPieceFromCoord(Coord coord) {
		return this.plateau[coord.getLigne()][coord.getColonne()];
	}
	
	//R�le : Retourne la pi�ce de l'�chiquier dont le nom et la couleur corresponde aux param�tres d'entr�es. Si aucune correspondance,
	//renvoie une PieceVide
	//Les m�thodes d'�chiquiers utilisant des pi�ces ont besoin de pi�ces cr��es � l'origine de l'�chiquier, et non cr��es en dehors.
	//Cette m�thode permet de r�cup�rer ces pi�ces de l'�chiquier.
	//Pr�condition : nom appartient aux noms autoris�s (voir dans classe Piece), la couleur ne peut �tre que 'b' ou 'n'
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
	
	
	//R�le : Renvoie Vrai si le roi d'une certaine couleur est �chec et faux sinon
	//Pr�condition : couleur = 'b' ou 'n'
	public boolean estEnEchec(char couleur) {
		Piece roi = this.getPiece("Ro", couleur);
		ArrayList<Coord> casesControllees = new ArrayList<Coord>();
		Enumeration<Piece> e = this.coordPiece.keys();
		while(e.hasMoreElements()) {
			Piece tmpPiece = e.nextElement();
			//Le comportement du roi n'�tant pas encore d�fini, la fonction ne peut fonctionner que si les cases controll�es par le
			//roi adverse ne sont pas analys�es. La condition tmpPiece.getNom() != "Ro" est l� pour �a. En revanche, elle devra �tre
			//supprim�e � long terme.
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
