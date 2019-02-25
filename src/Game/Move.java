package Game;
/**
 * @author Harsh
 *
 */
public class Move {
	
	
	
	
	/**
	 * Moves the piece UP
	 * 
	 * @param piece
	 * @param direction
	 * @param player
	 * @param board
	 * @return
	 */
	public int MoveUP( Piece piece , String direction ,Player player ,  Board board){
		
		//If Piece goes out of bounds
		if(!board.isValid(piece.getPosX()-1, piece.getPosY())){ 
			board.board[piece.getPosX()][piece.getPosY()] = null;
			System.out.println(piece.getIdentifier() + " is Dead");
			player.getCemetery().add(piece);
			player.getInGame().remove(piece);
			return 0;			
		}else if(piece.getPosX()-1 == 8 && piece.getPosY() == 8 || 
				piece.getPosX()-1 == 1 && piece.getPosY() == 1)
		{ // If piece tries to move on Face
		System.out.println("Cannot Move piece on face");
		return 0;	
		}else if(board.board[piece.getPosX()-1][piece.getPosY()] == null){
			//If the space is empty
			board.board[piece.getPosX()-1][piece.getPosY()] = board.board[piece.getPosX()][piece.getPosY()];
			board.board[piece.getPosX()][piece.getPosY()] = null;
			piece.setPosX(piece.getPosX()-1)  ;		
			
		}else if(board.board[piece.getPosX()-1][piece.getPosY()] != null){
			//if Piece has another piece on up
			MoveUP(board.board[piece.getPosX()-1][piece.getPosY()], direction, player, board);
			board.board[piece.getPosX()-1][piece.getPosY()] = board.board[piece.getPosX()][piece.getPosY()];
			board.board[piece.getPosX()][piece.getPosY()] = null;
			piece.setPosX(piece.getPosX()-1)  ;
		}
		return 1;
		
	}
	/**
	 * Moves the piece DOWN
	 * 
	 * @param piece
	 * @param direction
	 * @param player
	 * @param board
	 * @return
	 */
	
	public int MoveDOWN( Piece piece , String direction ,Player player ,  Board board){
		//If Piece goes out of bounds
				if(!board.isValid(piece.getPosX()+1, piece.getPosY())){
					board.board[piece.getPosX()][piece.getPosY()] = null;
					System.out.println(piece.getIdentifier() + " is Dead");
					player.getInGame().remove(piece);
					return 0;
					
				}
				else if(piece.getPosX()+1 == 8 && piece.getPosY() == 8 ||
						piece.getPosX()+1 == 1 && piece.getPosY() == 1)
				{// If piece tries to move on Face
					System.out.println("Cannot Move piece on face"); 
					return 0;	
					}
					else if(board.board[piece.getPosX()+1][piece.getPosY()] == null){
						//If the space is empty
						board.board[piece.getPosX()+1][piece.getPosY()] = board.board[piece.getPosX()][piece.getPosY()];
						board.board[piece.getPosX()][piece.getPosY()] = null;
						piece.setPosX(piece.getPosX()+1)  ;
						
					}
					else if(board.board[piece.getPosX()+1][piece.getPosY()] != null){
						//if Piece has another piece on Down
						MoveDOWN(board.board[piece.getPosX()+1][piece.getPosY()], direction, player, board);
						board.board[piece.getPosX()+1][piece.getPosY()] = board.board[piece.getPosX()][piece.getPosY()];
						board.board[piece.getPosX()][piece.getPosY()] = null;
						piece.setPosX( piece.getPosX()+1) ;
					}
				return 1;
		
	}
	/**
	 * Moves the piece RIGHT
	 * 
	 * @param piece
	 * @param direction
	 * @param player
	 * @param board
	 * @return
	 */
	public int MoveRIGHT( Piece piece , String direction ,Player player ,  Board board){
		//If Piece goes out of bounds
				if(!board.isValid(piece.getPosX(), piece.getPosY()+1)){
					board.board[piece.getPosX()][piece.getPosY()] = null;
					System.out.println(piece.getIdentifier() + " is Dead");
					player.getInGame().remove(piece);
					return 0;
				}
				else if(piece.getPosX() == 8 && piece.getPosY()+1 == 8 ||
						piece.getPosX() == 1 && piece.getPosY()+1 == 1)
				{// If piece tries to move on Face
					System.out.println("Cannot Move piece on face"); 
					return 0;	
					}
					else if(board.board[piece.getPosX()][piece.getPosY()+1] == null){
						//If the space is empty
						board.board[piece.getPosX()][piece.getPosY()+1] = board.board[piece.getPosX()][piece.getPosY()];
						board.board[piece.getPosX()][piece.getPosY()] = null;
						piece.setPosY( piece.getPosY() + 1) ;
					}
					else if(board.board[piece.getPosX()][piece.getPosY()+1] != null){
						//if Piece has another piece on Right
						MoveRIGHT(board.board[piece.getPosX()][piece.getPosY()+1], direction, player, board);
						board.board[piece.getPosX()-1][piece.getPosY()] = board.board[piece.getPosX()][piece.getPosY()];
						board.board[piece.getPosX()][piece.getPosY()] = null;
						piece.setPosY(piece.getPosY()+1)  ;
					}
				return 1;
		
	}
	/**
	 * Moves the piece LEFT
	 * 
	 * @param piece
	 * @param direction
	 * @param player
	 * @param board
	 * @return
	 */
	public int MoveLEFT( Piece piece , String direction ,Player player ,  Board board){
		//If Piece goes out of bounds
				if(!board.isValid(piece.getPosX(), piece.getPosY()-1)){
					board.board[piece.getPosX()][piece.getPosY()] = null;
					System.out.println(piece.getIdentifier() + " is Dead");
					player.getInGame().remove(piece);
					return 0;
				}
				else if(piece.getPosX() == 8 && piece.getPosY()-1 == 8 || 
						piece.getPosX() == 1 && piece.getPosY()-1 == 1)
				{// If piece tries to move on Face
					System.out.println("Cannot Move piece on face"); 
					return 0;	
					}
					else if(board.board[piece.getPosX()][piece.getPosY()-1] == null){//If the space is empty
						board.board[piece.getPosX()][piece.getPosY()-1] = board.board[piece.getPosX()][piece.getPosY()];
						board.board[piece.getPosX()][piece.getPosY()] = null;
						piece.setPosY( piece.getPosY() - 1) ;
					}
					else if(board.board[piece.getPosX()][piece.getPosY()-1] != null){
						//if Piece has another piece on Left
						MoveLEFT(board.board[piece.getPosX()][piece.getPosY()-1], direction, player, board);
						board.board[piece.getPosX()][piece.getPosY()-1] = board.board[piece.getPosX()][piece.getPosY()];
						board.board[piece.getPosX()][piece.getPosY()] = null;
						piece.setPosY(piece.getPosY()-1) ;
					}
				
				return 1;		
		
		
	}
	

}
