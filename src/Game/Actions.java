package Game;


/**
 * @author Harsh
 *
 */
public interface Actions {
	
	
	
	/**
	 * Checks the Statement at first stage if player wants to create a Piece 
	 * or Pass.
	 * 
	 * @param player
	 * @param board
	 */
	public void checkStatement( Player player , Board board);
	
	
	/**
	 * Switches the Player.
	 * 
	 * @param player
	 */
	
	public void Pass(Player player);
	
	/**
	 * Undo The previous move.
	 * 
	 * @param create
	 */
	public void Undo(int create);
	
	/**
	 * This method takes User input and finds the Piece by ID and adds it to the board
	 * 
	 * 
	 * @param player
	 * @param board
	 */
	public void createPiece( Player player ,Board board);
	
	/**
	 * Checks the statement for the second stage i.e after creation
	 * 
	 * @param player
	 * @param board
	 * @param create
	 */
	public void SecondStageStatement (Player player , Board board , int create);
	
	
	/**
	 * In this method Piece are added in the board if creation box is empty else 
	 * it Goes to secondStage.
	 * 
	 * @param player
	 * @param board
	 * @param p
	 */
	public void AddPieceOnBoard(Player player , Board board , Piece p);
	
	
	/**
	 * This method takes the User input to Move piece and then move the Piece on board
	 * 
	 * @param player
	 * @param board
	 */
	public void movePiece( Player player , Board board);
	
	
	/**
	 * This method takes the direction as string <up/down/left/right> and moves the Piece
	 * on board according to the direction
	 * 
	 * @param piece
	 * @param direction
	 * @param player
	 * @param board
	 * @return
	 */
	public int movePieceOnBoard( Piece piece , String direction ,Player player ,  Board board);
	
	
	/**
	 * This method takes the user input and and calls the Rotate method in Piece
	 * 
	 * @param player
	 * @param board
	 */
	public void rotatePiece( Player player ,Board board);
	
	

}
