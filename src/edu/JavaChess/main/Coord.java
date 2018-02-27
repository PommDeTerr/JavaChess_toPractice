/*Coord.java - TRAINEAU Maxime - 24 Février 2018
 * Contient la class Coord permettant de générer des jeux de coordonnées (ligne,colonne) pour une Piece sur un plateau d'un Echiquier
 */
package edu.JavaChess.main;

public class Coord {
	
	protected int ligne;
	protected int colonne;
	
	public Coord(int x, int y) {
		this.ligne = x;
		this.colonne = y;
	}
	public int getLigne() {
		return ligne;
	}
	public void setLigne(int ligne) {
		this.ligne = ligne;
	}
	public int getColonne() {
		return colonne;
	}
	public void setColonne(int colonne) {
		this.colonne = colonne;
	}
	
	public String toString() {
		return "(l="+this.ligne+",c="+this.colonne+")";
	}
	

}
