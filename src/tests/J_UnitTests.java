
package tests;
import Game.*;
import org.junit.Test;

/**
 * @author Harsh
 *
 */
public class J_UnitTests {

	/**
	 * Tests if green can create its Piece on its creation square
	 */
	@Test
	public void GreenCreatePiece_Test(){
		
		RunGame game = new RunGame();
		
		game.AddPieceOnBoard(game.green,game.board ,game.green.findPiece("a"));
		assert game.board.board[game.green.createX][game.green.createY] != null;
		
	}
	
	/**
	 * Tests if yellow can create its Piece on its creation square
	 */
	@Test
	public void YellowCreatePiece_Test(){
		
		RunGame game = new RunGame();
		
		game.AddPieceOnBoard(game.yellow,game.board ,game.yellow.findPiece("a"));
		assert game.board.board[game.yellow.createX][game.yellow.createY] != null;
		
	}
	
	
	/**
	 * Tests if Correct Piece is created
	 */
	@Test
	public void CreateCorrectPiece_Test(){
		
		RunGame game = new RunGame();
		Piece p = game.green.findPiece("a");
		game.AddPieceOnBoard(game.green,game.board ,p);
		
		assert game.board.board[game.green.createX][game.green.createY].getIdentifier() == p.getIdentifier();
		
	}
	/**
	 * If player can move the Piece up
	 */
	@Test
	public void moveUpTest(){
		
		RunGame game = new RunGame();
		
		game.AddPieceOnBoard(game.Current,game.board ,game.Current.findPiece("a"));
		game.movePieceOnBoard(game.Current.getPieceInGame("a"), "UP", game.Current, game.board);
		assert game.board.board[game.Current.createX-1][game.Current.createY] != null;
	}

	/**
	 * If player can move the Piece down.
	 */
	@Test
	public void moveDownTest(){
		
		RunGame game = new RunGame();
		
		game.AddPieceOnBoard(game.Current,game.board ,game.Current.findPiece("a"));
		game.movePieceOnBoard(game.Current.getPieceInGame("a"), "down", game.Current, game.board);
		assert game.board.board[game.Current.createX+1][game.Current.createY] != null;
	}

	/**
	 * If player can move the Piece left
	 */
	@Test
	public void moveLeftTest(){
		
		RunGame game = new RunGame();
		
		game.AddPieceOnBoard(game.Current,game.board ,game.Current.findPiece("a"));
		game.movePieceOnBoard(game.Current.getPieceInGame("a"), "left", game.Current, game.board);
		game.board.board[game.Current.createX][game.Current.createY-1].getIdentifier();
		assert game.board.board[game.Current.createX][game.Current.createY-1] != null;
	}

	/**
	 * If player can move the Piece right
	 */
	@Test
	public void moveRightTest(){
		
		RunGame game = new RunGame();
		
		game.AddPieceOnBoard(game.Current,game.board ,game.Current.findPiece("a"));
		game.movePieceOnBoard(game.Current.getPieceInGame("a"), "right", game.Current, game.board);
		assert game.board.board[game.Current.createX][game.Current.createY+1]  != null;
	}

	/**
	 * If player can rotate the Piece in 0 degrees
	 */
	
	@Test
	public void Rotate0Test(){
		
		RunGame game = new RunGame();
		Piece piece = game.Current.findPiece("a");
		piece.rotate(0); 
		assert piece.getRight() == '#';
		
	}
	
	/**
	 * If player can rotate the Piece in 90 degrees
	 */
	
	@Test
	public void Rotate90Test(){
		
		RunGame game = new RunGame();
		Piece piece = game.Current.findPiece("a");
		piece.rotate(90); 
		assert piece.getBot() == '#';
		
	}
	
	/**
	 *
	 * If player can rotate the Piece in 180 degrees
	 */
	
	@Test
	public void Rotate180Test(){
		
		RunGame game = new RunGame();
		Piece piece = game.Current.findPiece("a");
		piece.rotate(180); 
		assert piece.getLeft() == '#';
		
	}
	/**
	 * If player can rotate the Piece in 270 degrees
	 */
	@Test
	public void Rotate270Test(){
		
		RunGame game = new RunGame();
		Piece piece = game.Current.findPiece("a");
		piece.rotate(270); 
		assert piece.getTop() == '#';
		
	}
	/**
	 * If there is a piece already on creation spot
	 */
	@Test
	public void InvalidCreatePiece1_IfAlreadyOnCreationSpot(){
		RunGame game = new RunGame();
		Piece p = game.Current.findPiece("a");
		Piece pp = game.Current.findPiece("b");
		game.AddPieceOnBoard(game.Current,game.board , p);
		game.AddPieceOnBoard(game.Current,game.board , pp);
		
		assert game.Current.IfPieceInGame(p.getIdentifier());
		assert !game.Current.IfPieceInGame(pp.getIdentifier());
		
	}
	
	/**
	 * If the piece is already in game
	 */
	
	@Test
	public void InvalidCreatePiece2_IfPieceAlreadyCreated(){
		RunGame game = new RunGame();
		
		game.AddPieceOnBoard(game.Current,game.board , game.Current.findPiece("a"));
		
		Piece p =  game.Current.findPiece("a");
		
		assert p==null;		
	}
	
	/**
	 * Piece dies when moves in cemetery
	 */
	
	@Test
	public void MovePieceToCemetry(){
		RunGame game = new RunGame();
		
		game.AddPieceOnBoard(game.Current,game.board , game.Current.findPiece("a"));
		
		game.movePieceOnBoard(game.Current.getPieceInGame("a"), "right", game.Current, game.board);
		game.movePieceOnBoard(game.Current.getPieceInGame("a"), "right", game.Current, game.board);
		game.movePieceOnBoard(game.Current.getPieceInGame("a"), "down", game.Current, game.board);
		
		assert game.Current.getPieceInGame("a") == null;		
	}
	
	/**
	 * 
	 * Piece dies when move out of bounds
	 */
	@Test
	public void MovePieceOutOfBounds(){
		RunGame game = new RunGame();
		
		game.AddPieceOnBoard(game.Current,game.board , game.Current.findPiece("a"));
		
		game.movePieceOnBoard(game.Current.getPieceInGame("a"), "down", game.Current, game.board);
		game.movePieceOnBoard(game.Current.getPieceInGame("a"), "down", game.Current, game.board);
		game.movePieceOnBoard(game.Current.getPieceInGame("a"), "down", game.Current, game.board);
		
		assert game.Current.getPieceInGame("a") == null;		
	}
	
	/**
	 * 
	 * If player tries to move Piece which is not in game
	 * 
	 */
	
	@Test
	public void InvalidMove_PieceNotInGame(){
		RunGame game = new RunGame();
		
		
		try{
		game.movePieceOnBoard(game.Current.getPieceInGame("a"), "up", game.Current, game.board);
		}catch(NullPointerException e){}
		
		assert game.Current.getPieceInGame("a") == null;		
	}
	
	/**
	 * 
	 * If player tries to move Piece on Yellow face
	 * 
	 */
	
	@Test
	public void InvalidMove_CannotMoveOnYellowFace(){
		RunGame game = new RunGame();
		int FacePosX = 8;
		int FacePosY = 8;
		
		game.AddPieceOnBoard(game.yellow,game.board , game.yellow.findPiece("a"));
		game.movePieceOnBoard(game.yellow.getPieceInGame("a"), "right", game.yellow, game.board);
		game.movePieceOnBoard(game.yellow.getPieceInGame("a"), "down", game.yellow, game.board);
		
		
		assert 
				game.yellow.getPieceInGame("a").getPosY() == FacePosY &&
						game.yellow.getPieceInGame("a").getPosX() == FacePosX-1 ;		
	}
	
	/**
	 * 
	 * If player tries to move Piece on green face
	 * 
	 */
	
	@Test
	public void InvalidMove_CannotMoveOnGreenFace(){
		RunGame game = new RunGame();
		int FacePosX = 1;
		int FacePosY = 1;
		
		game.AddPieceOnBoard(game.green,game.board , game.green.findPiece("a"));
		game.movePieceOnBoard(game.green.getPieceInGame("a"), "up", game.green, game.board);
		game.movePieceOnBoard(game.green.getPieceInGame("a"), "left", game.green, game.board);
		System.out.println(game.green.getPieceInGame("a").getPosY());
		
		assert  
				game.green.getPieceInGame("a").getPosX() == FacePosX &&
						game.green.getPieceInGame("a").getPosY() == FacePosY+1 ;		
	}
	
	/**
	 * Checks if pass switches the player
	 * 
	 */
	
	@Test
	public void Pass(){
		RunGame game = new RunGame();
		
		Player player = game.Current;
		game.Pass(game.Current);
		
		assert player != game.Current;		
	}
	/**
	 * Checks if undo can delete the created piece on board
	 * 
	 */
	
	@Test
	public void Undo1(){
		RunGame game = new RunGame();
		game.AddPieceOnBoard(game.Current,game.board , game.Current.findPiece("a"));
		
		assert game.board.board[game.Current.createX][game.Current.createY] != null;		
		game.Undo(0);		
		assert game.board.board[game.Current.createX][game.Current.createY] == null;
		
	}
	/**
	 * Checks if undo can replace the moved piece
	 * 
	 */
	
	@Test
	public void Undo2(){
		RunGame game = new RunGame();
		game.AddPieceOnBoard(game.Current,game.board , game.Current.findPiece("a"));
		game.movePieceOnBoard(game.Current.getPieceInGame("a") , "UP", game.Current , game.board);
			
		game.Undo(0);		
		assert game.board.board[game.Current.createX][game.Current.createY] == null;
		
	}
	/**
	 * If player tries to rotate piece which is not in game
	 */
	@Test
	public void InvalidRotate_IfPieceNotInGame(){
		
		RunGame game = new RunGame();
		Piece piece = null;
		try{
		piece = game.Current.getPieceInGame("a");
		piece.rotate(0); 
		}catch (NullPointerException e) {}
		
		assert piece == null;
		
	}
	
	
	
}
