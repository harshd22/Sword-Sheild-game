package Game;
/**
 * @author Harsh
 *
 */
public class Piece implements Cloneable{
	
	private char top ;
	private char bot;
	private char right;
    private	char left;
	private String identifier = " ";
	private int posX;
	private int posY;
	
  public Piece(char top, char left , String identifier , char right , char bot){
		
		this.top = top;
		this.bot = bot;
		this.right = right;
		this.left = left;
		this.identifier = identifier;
	}
  
 
public void rotate(int rotate){
	  if (rotate == 90)	 Rotate90();
	  
	  else if(rotate == 180)	Rotate180();
	  
	  else if(rotate == 270)	Rotate270();
	  
	  else if(rotate == 0 ) ;
  }

/**
 * Clones the Piece
 * 
 * @return
 */
public Piece Clone(){
	Piece p = new Piece(this.getTop() , this.getLeft() , this.getIdentifier() , this.getRight() , this.getBot());
	p.posX = this.posX;
	p.posY = this.posY;
	
	return p;
	
	
	
}
  

private void Rotate90(){
	  
	  char t = top;
	  char b = bot;
	  char l = left;
	  char r = right;
	  
	  if(t == '|') 	right = '-';
	  else right = t;
	  
	  if(r == '-') bot = '|';
	  else bot = r;
	  
	  if(b == '|') left = '-';
	  else left = b;
	  
	  if(l == '-') top = '|';
	  else top = l;
	  
  }
  
  private void Rotate180(){
	  
	  char t = top;
	  char b = bot;
	  char l = left;
	  char r = right;
	  
	  bot = t;
	  top = b;
	  right = l;
	  left = r;
  }
  
  private void Rotate270(){
	  Rotate90();
	  Rotate180();
  }



public char getTop() {
	return top;
}



public char getBot() {
	return bot;
}



public char getRight() {
	return right;
}



public char getLeft() {
	return left;
}



public String getIdentifier() {
	return identifier;
}

public int getPosX() {
	return posX;
}

public int getPosY() {
	return posY;
}

public void setTop(char top) {
	this.top = top;
}

public void setBot(char bot) {
	this.bot = bot;
}

public void setRight(char right) {
	this.right = right;
}

public void setLeft(char left) {
	this.left = left;
}

public void setIdentifier(String identifier) {
	this.identifier = identifier;
}

public void setPosX(int posX) {
	this.posX = posX;
}

public void setPosY(int posY) {
	this.posY = posY;
}




  
  
  

}
