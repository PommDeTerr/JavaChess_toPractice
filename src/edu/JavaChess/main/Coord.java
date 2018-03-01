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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + colonne;
		result = prime * result + ligne;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coord other = (Coord) obj;
		if (colonne != other.colonne)
			return false;
		if (ligne != other.ligne)
			return false;
		return true;
	}
	
	//Rôle : Vérifie que la Coord appelante se situe sur le plateau
	//TODO Remplacer tous les if du projet utilisant l'expression de retour par cette méthode
	public boolean isInRange() {
		return this.getColonne() >=0 && this.getLigne() >=0 && this.getColonne() <=7 && this.getLigne() <=7;
	}

}
