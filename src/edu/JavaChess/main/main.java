package edu.JavaChess.main;

import edu.JavaChess.piece.*;

public class main {

	public static void main(String[] args) {
		
		Echiquier test = new Echiquier();
		
		Piece roiTest = test.getPiece("Ro", 'n'); 
		if(roiTest.getClass() == new Fou("Ro", 'n').getClass()) {
		System.out.println(roiTest.getClass());
		}
		
	}

}
