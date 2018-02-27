package edu.JavaChess.main;

import edu.JavaChess.piece.*;

public class main {

	public static void main(String[] args) {
		
		Echiquier test = new Echiquier();
		System.out.println(test);
		
		Piece pionTestBlanc = test.getPieceFromCoord(new Coord(1, 0));
		Piece pionTestNoir = test.getPieceFromCoord(new Coord(6, 7));
		Piece roiNoir = test.getPiece("Ro", 'n');
		
		Piece reineNoire = test.getPiece("Da", 'n');
		Piece fouNoirDroit = test.getPiece("Ff", 'n');
		Piece tourNoirGauche = test.getPiece("Ta", 'n');
		
		System.out.println(pionTestBlanc.toString() + pionTestBlanc.casesControlleesDans(test));
		System.out.println(pionTestNoir.toString() + pionTestNoir.casesControlleesDans(test));
		System.out.println(pionTestBlanc.toString() + pionTestBlanc.casesPossiblesDans(test));
		System.out.println(pionTestNoir.toString() + pionTestNoir.casesPossiblesDans(test));
		
		System.out.println(reineNoire.toString()+reineNoire.casesPossiblesDans(test));
		System.out.println(fouNoirDroit.toString()+fouNoirDroit.casesPossiblesDans(test));
		System.out.println(tourNoirGauche.toString()+tourNoirGauche.casesControlleesDans(test));
		
		System.out.println(test.estEnEchec('n'));
		System.out.println(test.getPiece("Da", 'b').casesControlleesDans(test));
		
		System.out.println(""+test.estEnEchec('n')+roiNoir.casesControlleesDans(test));
		
		Coup coupTest = new Coup("Da", test.getPiece("Da", 'b'), new Coord(3,3));
		
		System.out.println(test.deplacement(coupTest));
		


	}

}
