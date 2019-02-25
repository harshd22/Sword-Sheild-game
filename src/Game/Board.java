package Game;
/**
 * @author Harsh
 *
 */
public class Board implements Cloneable{

	public Piece [][] board;
	private Piece cemetery ;
	private Piece greenSymbol ;
	private Piece yellowSymbol;
	private int size = 10;
	
	/**
	 * Constructs a new Board
	 * 
	 * @param green
	 * @param yellow
	 */
	Board(Player green , Player yellow){
		board = new Piece [size][size];
		cemetery = new Piece('X', 'X', "X", 'X', 'X' );
		yellowSymbol = new Piece(' ', ' ' , yellow.getSymbol() , ' ' , ' ');
		greenSymbol = new Piece(' ' , ' ' , green.getSymbol() , ' ' , ' ');
		
		
		board[1][1] =  greenSymbol;
		board[8][8] = yellowSymbol;
		
		board[0][0] = cemetery;
        board[0][1] = cemetery;
        board[1][0] = cemetery;
        
        board[9][9] = cemetery;
        board[8][9] = cemetery;
        board[9][8] = cemetery;
        	
	}
	
	/**
	 * Returns true if x and y are in bounds else returns false
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public boolean isValid(int x, int y) {
		if ((x == 1 && y == 0) || (x == 0 && y == 0)  || (x >= 10) || (y >= 10)
			|| (x == 9 && y == 9)  || (x == 8 && y == 9) ||
		    (x < 0) || (y < 0) || (x > 9) || (y > 9) || (x==0 && y==1) || (x ==9 && y==8 ) || x==1&& y==1
		    || x==8 && y==8)
		{
			return false;
		}
		return true;
	}
	
	/**
	 * Clones the board
	 * 
	 * @param clone
	 */
	public void Clone( Board clone ){
		
		for(int i = 0 ; i<size ; i++){
			for(int j = 0 ; j<size ; j++){
				
				clone.board[i][j] = this.board[i][j];
				if(this.board[i][j] != null){
				clone.board[i][j].setPosX(this.board[i][j].getPosX())  ;
				clone.board[i][j].setPosY(this.board[i][j].getPosY()) ;
				clone.board[i][j].setBot(this.board[i][j].getBot());
				clone.board[i][j].setTop(this.board[i][j].getTop());
				clone.board[i][j].setRight(this.board[i][j].getRight());
				clone.board[i][j].setLeft(this.board[i][j].getLeft());
				}
			}
		}		
	}
	

	
	
	
}
