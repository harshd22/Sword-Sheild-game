package Game;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

import javax.swing.JOptionPane;

/**
 * @author Harsh
 *
 */
public class RunGame extends Observable implements Actions, Observer{
	
	public Player green ;
	public Player yellow ;
	Player playerClone;
	public Board board;
	Board boardClone ;
	DrawGame draw ;
	Scanner s;
	public Player Current;

	
	/**
	 * Constructs a new game.
	 */
	public RunGame() {
		yellow = new Player("Yellow" , "0" );
		green = new Player("Green", "1" );
		board = new Board(green, yellow);
		boardClone = new Board (green , yellow);
		s = new Scanner(System.in);
		draw = new DrawGame();
		addObserver( this);
		Current = yellow;
		playerClone = new Player(Current.getColor() , Current.getSymbol() );
	}
	
	/**
	 * Runs the Game
	 */
	public void Run (){
		draw.Board(board.board , board);
	
		while(1==1){ // Infinite loop as No win condition is added.
		checkStatement( Current , board);
		}
	}


	
	
@Override
public void checkStatement( Player player , Board board) {
		System.out.println(Current.getColor() + "Turn : \n 1.Create \n 2.Pass");
		//takes the user input
		String statement = s.nextLine(); 
		//Splits the input into tokens
		String[] check = statement.split("\\s+");
		
		//if create command
		if(check[0].equalsIgnoreCase("create" )||  check[0].equalsIgnoreCase("1" )){
			try{
			createPiece( player,board);
			SecondStageStatement(player, board , 1);
			}catch(ArrayIndexOutOfBoundsException e){System.out.println("Please type properly");}	
		}
		
		//if Pass , then moves to second stage
		else if(check[0].equalsIgnoreCase("Pass") ||check[0].equalsIgnoreCase("2" ) ){
			SecondStageStatement(player, board , 0);		
		}	
	}


@Override
public void SecondStageStatement (Player player , Board board , int create){
	while( player == Current){
	System.out.println(Current.getColor() + "Turn : \n 1.Move \n 2.Rotate \n 3.Undo \n 4.Pass ");
	//Takes the user input
	String statement = s.nextLine();
	//Splits the input into tokens
	String[] check = statement.split("\\s+");
	
	//If Move or 1 is typed
	if(check[0].equalsIgnoreCase("1") || check[0].equalsIgnoreCase("move")){
		create = 0;
		movePiece(player, board);
	}
	//If Rotate or 2 is typed
	else if(check[0].equalsIgnoreCase("2") || check[0].equalsIgnoreCase("rotate")){
		create = 0;
		Cloner(board, Current );
		rotatePiece(player, board);
	}
	//If Undo or 3 is typed
	else if(check[0].equalsIgnoreCase("3") || check[0].equalsIgnoreCase("Undo")){
		Undo(create);
		draw.Board(board.board , board);
	}
	////If Pass or 4 is types then player is switched
	else if(check[0].equalsIgnoreCase("4") || check[0].equalsIgnoreCase("pass")){		
		Pass(player);
	}
	else continue;
	
	
	}
}


@Override
public void Pass(Player player){
	boardClone = new Board (green , yellow);	
	//Switch the player
	Current = changeTurn(player);
	playerClone = new Player(Current.getColor() , Current.getSymbol() );
}

@Override
public void Undo(int create){
	
	
	boardClone.Clone(board);
	playerClone.Clone(Current);
	
	
	
}


@Override
public void createPiece( Player player ,Board board) {
	//Pre-Condition : If creation space is not empty
	if(board.board[player.createX][player.createY] != null)
	{System.out.println("Cannot create piece,Space is not empty");return;}
	
	//draws the Piece of Player
	draw.drawPiece(player);
	
	System.out.println("Type <letter> <0/90/180/270> to create piece");
	Piece p ;
	//Takes the user input
	String statement = s.nextLine();
	//Splits the input in tokens
	String[] check = statement.split("\\s+");
	
	if(check.length > 2 ) createPiece(player,board); //checks if input contains all the commands or not
	 
	if(!(check[1].matches("0|90|180|270"))){System.out.println("type 0/90/180/270") ; createPiece(player, board);}
	
	if(check[0].matches("[A-z]")){	//if input is correct
		p = player.findPiece(check[0]);	 
		
		if((player.getPiece().contains(p))){//If piece is in the list of Piece
			//Check for orientation and rotate the piece according to that
			p.rotate(Integer.valueOf(check[1])); 
			Cloner(board, Current );		
			AddPieceOnBoard(player , board , p);	
		}
		else {System.out.println("Piece doesnt exist is list");
			createPiece(player,board);
		}
	}
	else
	{System.out.println("type a valid piece");	createPiece(player,board);}
	
	
	draw.Board(board.board , board);	
}	


@Override
public void movePiece( Player player , Board board)  {
		int d;
		Piece piece;
		System.out.println("Type <letter> <up/down/right/left> to move piece");
		//Takes the user input
		String statement = s.nextLine();
		//Splits the input in tokens
		String[] check = statement.split("\\s+");
	
		if(check.length != 2) {return;}
		
		if(!player.IfPieceInGame(check[0])){//If piece is not in game
			System.out.println(check[0] + " is not in game");
			return;
			}
		//checks if input is correct
		if(!(check[0].matches("[A-z]") && check[1].matches("up|down|right|left"))){return;}
		
		Cloner(board, Current );
		d = movePieceOnBoard(player.getPieceInGame(check[0]), check[1], player ,board);
		//checks if termination is normal then draws the board
		if(d==1)
			draw.Board(board.board , board);
	
	}



@Override
public int movePieceOnBoard( Piece piece , String direction ,Player player ,  Board board){
	Move move = new Move();
	//Moves the Piece Up
	if(direction.equalsIgnoreCase("up")){
		return move.MoveUP( piece ,  direction , player ,  board);
	}
	
	//Moves the Piece Down
	else if(direction.equalsIgnoreCase("down")){
		return move.MoveDOWN( piece ,  direction , player ,  board);
	}
	
	//Moves the Piece Right
	else if(direction.equalsIgnoreCase("right")){
		return move.MoveRIGHT( piece ,  direction , player ,  board);
		
	}
	
	//Moves the Piece Left
	else if(direction.equalsIgnoreCase("left")){
		return move.MoveLEFT( piece ,  direction , player ,  board);
	}
	return 1;	
}


@Override
public void rotatePiece( Player player ,Board board){
	Piece piece;
	System.out.println("Type <letter> <0/90/270/360>");
	//Takes the user input
	String statement = s.nextLine();
	//Splits the input in tokens
	String[] check = statement.split("\\s+");
	
	if(check.length != 2) {
		return;
		}
	
	if(!(check[1].matches("0|90|180|270") && check[0].matches("[A-z]"))) {
		return;
	}
	
	if(!player.IfPieceInGame(check[0])){//If piece is not in game
		System.out.println(check[0] + " is not in game");
		return;
	}
		//Rotates the Piece
		player.getPieceInGame(check[0]).rotate(Integer.valueOf(check[1]));
		draw.Board(board.board , board);
}


@Override
public void AddPieceOnBoard(Player player , Board board , Piece p){

	//if Creation space is empty
		if(board.board[player.createX][player.createY] == null){
			board.board[player.createX][player.createY] = p;
			p.setPosX(player.createX)  ;
			p.setPosY(player.createY)  ;
			player.addInGame(p);
			player.getPiece().remove(p);
			}		
		else
			JOptionPane.showMessageDialog(null, "Creation space is not empty");
	}


/**
 * Changes the Current Player
 * 
 * @param player
 * @return
 */
public Player changeTurn(Player player){
	if(player == green){
		return yellow;
	}
	else
		return green;
	
}

public void Cloner(Board board , Player player ){
	
	board.Clone(boardClone);
	player.Clone(playerClone);
	
	
}

@Override
public void update(Observable o, Object arg) {
	
}



}
