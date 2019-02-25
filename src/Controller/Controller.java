package Controller;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;

import Game.*;


public class Controller  extends Observable implements KeyListener{
	RunGame myModel;
	Piece selectedPiece;
	
	public Controller( RunGame myModel){
		
		this.myModel = myModel;
		
	}
	
	public void selectPiece(Piece piece){
		selectedPiece = piece;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyChar()) {
	      case KeyEvent.VK_W: myModel.movePieceOnBoard(selectedPiece, "UP", myModel.Current, myModel.board); System.out.println("HH"); return;
	      case KeyEvent.VK_A: myModel.movePieceOnBoard(selectedPiece, "left", myModel.Current, myModel.board); return;
	      case KeyEvent.VK_D: myModel.movePieceOnBoard(selectedPiece, "right", myModel.Current, myModel.board); return;
	      case KeyEvent.VK_S:myModel.movePieceOnBoard(selectedPiece, "down", myModel.Current, myModel.board); return;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}

}
