package Game;
import java.awt.List;
import java.util.ArrayList;

/**
 * @author Harsh
 *
 */
public class Player implements Cloneable{

	private String color;
	private String symbol;
	private char pieceID;
	private ArrayList<Piece> pieces;
	private ArrayList<Piece> cemetery;
	private ArrayList<Piece> inGame;
	public int createX;
	public int createY;
	
	
	
	/**
	 * Constructs a new Player with its color , symbol , and creation indexes.
	 * 
	 * @param color
	 * @param symbol
	 * @param createX
	 * @param createY
	 */
	public Player(String color , String symbol ){
		assert (symbol.contains("0") || symbol.contains("1"));
		pieces = new ArrayList<Piece>();
		inGame = new ArrayList<>();
		cemetery = new ArrayList<>();
		this.color = color;
		this.symbol = symbol;
		
		
		if(symbol.contains("0")){
			pieceID = 'a';
			createX = 7;
			createY = 7;
		}
		else
			{pieceID = 'A';
			createX = 2;
			createY = 2;
			}
		
		generatePiece();
	}
	
	/**
	 * Clones the Player
	 * 
	 * @param player
	 */
	public void Clone(Player player){
		
		player.inGame.clear();
		for(int i = 0 ; i < inGame.size() ; i++)
			player.inGame.add(this.inGame.get(i).Clone());
		player.pieces.clear();
		for(int i = 0 ; i < pieces.size() ; i++)
			player.pieces.add(this.pieces.get(i).Clone());
		
	}
	
	/**
	 * Finds the Piece in the List of Piece of player
	 * 
	 * @param Id
	 * @return
	 */
	public Piece findPiece (String Id){
		for(Piece p: pieces) {	
			if(p.getIdentifier().equalsIgnoreCase(Id)){
				return p;
		}
	}
		return null;
 }
	
	
	
	
	
	
	/**
	 * This generates the Piece of player
	 * 
	 */
	private void generatePiece(){
		pieces.add(new Piece('|','-',Character.toString(pieceID),'#','|'));
		pieces.add(new Piece('|','-',Character.toString(++pieceID),' ','|'));
		pieces.add(new Piece('#','#',Character.toString(++pieceID) ,'#','#'));
		pieces.add(new Piece('|',' ',Character.toString(++pieceID) ,' ','#'));
		pieces.add(new Piece(' ',' ',Character.toString(++pieceID) ,' ',' '));
		pieces.add(new Piece('|','-',Character.toString(++pieceID) ,'#','#'));
		pieces.add(new Piece('|','-',Character.toString(++pieceID) ,'-','|'));
		pieces.add(new Piece('|','#',Character.toString(++pieceID) ,' ','#'));	
		pieces.add(new Piece(' ',' ',Character.toString(++pieceID) ,' ','#'));
		pieces.add(new Piece('|','#',Character.toString(++pieceID) ,'#','|'));
		pieces.add(new Piece('|','-',Character.toString(++pieceID) ,'#',' '));
		pieces.add(new Piece('|',' ',Character.toString(++pieceID) ,' ',' '));
		pieces.add(new Piece('|',' ',Character.toString(++pieceID) ,'#','#'));	
		pieces.add(new Piece(' ','#',Character.toString(++pieceID) ,' ','#'));		
		pieces.add(new Piece('|','#',Character.toString(++pieceID) ,' ','|'));
		pieces.add(new Piece('|','#',Character.toString(++pieceID) ,'-',' '));
		pieces.add(new Piece('|','#',Character.toString(++pieceID) ,' ',' '));
		pieces.add(new Piece('|','#',Character.toString(++pieceID) ,'#',' '));		
		pieces.add(new Piece('#',' ',Character.toString(++pieceID) ,' ','#'));	
		pieces.add(new Piece(' ','-',Character.toString(++pieceID) ,'-',' '));
		pieces.add(new Piece('|',' ',Character.toString(++pieceID) ,'-',' '));
		pieces.add(new Piece(' ',' ',Character.toString(++pieceID) ,'-','#'));
		pieces.add(new Piece('#','#',Character.toString(++pieceID) ,'-','#'));
		pieces.add(new Piece('#','#',Character.toString(++pieceID) ,' ','#'));
	}
	
	/**
	 * 
	 * Returns true if Piece is in game  and false if not
	 * 
	 * 
	 * @param Id
	 * @return
	 */
	public boolean IfPieceInGame(String Id) {
		for(Piece p : inGame){
			if(p.getIdentifier().equalsIgnoreCase(Id)) return true;
		}
		return false;
	}

	/**
	 * Returns the Piece in the game by the Id passed into method
	 * 
	 * @param Id
	 * @return
	 */
	public Piece getPieceInGame(String Id){
		for(Piece p : inGame){
			if(p.getIdentifier().equalsIgnoreCase(Id)) return p;
		}
		return null;
		
	}
	
	

	public String getSymbol() {
		return symbol;
	}

	public char getpieceID() {
		return pieceID;
	}

	public ArrayList<Piece> getPiece() {
		return pieces;
	}

	public ArrayList<Piece> getInGame() {
		return inGame;
	}

	public void addInGame(Piece p) {
		inGame.add(p);
	}

	public String getColor() {
		return color;
	}

	public ArrayList<Piece> getCemetery() {
		return cemetery;
	}

	

	
	
	
	
}
