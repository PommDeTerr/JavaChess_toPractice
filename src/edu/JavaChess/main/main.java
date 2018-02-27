package edu.JavaChess.main;

import edu.JavaChess.piece.*;

public class main {

	public static void main(String[] args) {
		
		Echiquier test = new Echiquier();
		System.out.println(test);
		
		Piece pionTestBlanc = test.getPieceFromCoord(new Coord(1, 0));
		Piece pionTestNoir = test.getPieceFromCoord(new Coord(6, 7));
		
		Piece reineNoire = test.getPiece("Dd", 'n');
		Piece fouNoirDroit = test.getPiece("Ff", 'n');
		Piece tourNoirGauche = test.getPiece("Ta", 'n');
		
		System.out.println(pionTestBlanc.toString() + pionTestBlanc.casesControlleesDans(test));
		System.out.println(pionTestNoir.toString() + pionTestNoir.casesControlleesDans(test));
		System.out.println(pionTestBlanc.toString() + pionTestBlanc.casesPossiblesDans(test));
		System.out.println(pionTestNoir.toString() + pionTestNoir.casesPossiblesDans(test));
		
		System.out.println(reineNoire.toString()+reineNoire.casesPossiblesDans(test));
		System.out.println(fouNoirDroit.toString()+fouNoirDroit.casesPossiblesDans(test));
		System.out.println(tourNoirGauche.toString()+tourNoirGauche.casesControlleesDans(test));

	}

}
