package Game;

/**
 * @author Harsh
 *
 */
public class DrawGame {
	
	/**
	 * 
	 * This method draws the board
	 * 
	 * @param draw
	 * @param board
	 */
	public void Board(Piece[][] draw,Board board){

	 for(int i = 0; i < draw.length; i++){
	     for(int j = 0; j < draw[0].length ; j++) {
	         System.out.print("+");
	         System.out.print("---");
	     }
	     System.out.println("+");

	     for(int j = 0; j < draw[0].length; j++){
	         Piece p = draw[i][j];
	         System.out.print("| ");
	         
	         if(p != null){ // if board has a piece
	             System.out.print(p.getTop());
	             System.out.print(" ");
	          }   
	         else
	             System.out.print("  ");
	            
	        }
	        System.out.println("|");

	        for(int j = 0; j < draw[0].length; j++){
	            Piece p = draw[i][j];
	            System.out.print("|");
	            
	            if(p != null){
	                System.out.print(p.getLeft());
	                System.out.print(p.getIdentifier());
	                System.out.print(p.getRight());
	            }
	            
	           else{ // if board is null
	                System.out.print("   ");
	            }
	        }

	        System.out.println("|");

	        for(int j = 0; j < draw[0].length; j++){
	            Piece p = draw[i][j];
	            System.out.print("| ");
	            
	            if(p != null) {	
	            	System.out.print(p.getBot());
	            }
	           else {
	        	   System.out.print(" ");
	           }
       
	            System.out.print(" ");
	        }
	        System.out.println("|");
	    }


	    for(int i = 0; i < draw[0].length; i++) {
	        System.out.print("+");
	        System.out.print("---");
	    }
	    System.out.println("+");

	}
	
	
	
	/**
	 * This method draws the Piece of the player
	 * @param player
	 */
	public void drawPiece(Player player){
		String color = "";
		int x = 0;
		int index = 0;
		
		if(player.getSymbol().equals("0"))
			color = "Yellow";
		else if(player.getSymbol().equals("1"))
			color = "Green";
		
		
		System.out.println(color + " Piece = ");
	for(int i = 0 ; i< 5 ; i++){	
		x = index;
		for(int j = 0; j < 5; j++) {
            System.out.print("+");
            System.out.print("---");
        }
        System.out.println("+");
        
        for(int j = 0 ; j<5 ; j++ , x++){
        	System.out.print("|");
        	if(x < player.getPiece().size()){
        		System.out.print(" " + player.getPiece().get(x).getTop() + " ");
        	}
        	else System.out.print("   ");  	
        }
        x = index;
        System.out.println("|");
        
        for(int j = 0 ; j < 5 ; j++ , x++){
        	System.out.print("|");
        	if(x < player.getPiece().size()){
        		System.out.print(     				
        		player.getPiece().get(x).getLeft() + 
        		player.getPiece().get(x).getIdentifier() + 
        		player.getPiece().get(x).getRight());
        	}
        	else System.out.print("   ");  	
        }
        x = index;
        System.out.println("|");
        
        for(int j = 0 ; j<5 ; j++ , x++){
        	System.out.print("|");
        	if(x < player.getPiece().size()){
        		System.out.print(" " + player.getPiece().get(x).getBot() + " ");
        	}
        	else System.out.print("   ");  	
        }
        index = x;
        System.out.println("|");
        
  
	}
  }


}
