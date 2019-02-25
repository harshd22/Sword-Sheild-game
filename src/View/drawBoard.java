package View;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.annotation.Resources;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComponent;

import Controller.Controller;
import Game.Piece;
import Game.RunGame;

public class drawBoard extends JComponent implements Observer, MouseListener{
	
	RunGame myModel;
	Image img;
	int d;
	Graphics2D g;
	Piece movePiece;
	Controller controller;
	boolean selected;
	
	drawBoard(RunGame myModel){
		myModel.addObserver(this);
		
		addMouseListener(this);
		this.myModel = myModel;
		controller = new Controller(myModel);
		this.addKeyListener(new Controller(myModel));
		
	}
	
	@Override
	protected void paintComponent(Graphics gg) {
		
		g = (Graphics2D)gg;
		d = Math.min(getWidth(), getHeight())/10;
				
		//draws the squares
		for (int i=0 ; i < 10 ; i++){
			for (int j=0 ; j<10 ; j++){
				
				if((i+j)%2==0)
					g.setColor(Color.WHITE);
				else
					g.setColor(Color.darkGray);
				
				if(!myModel.board.isValid(i, j))
					g.setColor(Color.LIGHT_GRAY);
				
				
				g.drawRect(i*d, j*d, d, d);
				g.fillRect(i*d, j*d, d, d);
				
			}
		}	
		//draws the faces and draws pieces on board
		for (int i=0 ; i < 10 ; i++){
			for (int j=0 ; j<10 ; j++){
			Piece p = myModel.board.board[i][j];
				if (p != null){
					if(i == 1 && j == 1)	
						g.drawImage(getImg("green.jpg"), d*i, d*j, d, d , this);
					else if(i == 8 && j==8)
						g.drawImage(getImg("yellow.jpg"), d*i, d*j, d, d , this);
					if(myModel.board.isValid(i, j)){
						
						checkPiece(p , g ,i ,j);
					}
				}
			}
		}
		
		if(selected == true){
			g.setColor(Color.GREEN);
			g.drawRect(movePiece.getPosX()*d, movePiece.getPosY()*d, d, d);
		}
		
	}
	
	
	
	/**
	 * 
	 * This method checks the piees on board and draws them.
	 * 
	 * @param piece
	 * @param g
	 * @param i
	 * @param j
	 */
	private void checkPiece(Piece piece, Graphics2D g , int i, int j) {
		char c = piece.getIdentifier().charAt(0);
		if (Character.isUpperCase(c)){
			g.setColor(Color.GREEN);
			g.fillOval(i*d+5, j*d+5, d-10, d-10);
		}
		else if(Character.isLowerCase(c)){
			g.setColor(Color.YELLOW);
			g.fillOval(i*d+5, j*d+5, d-10, d-10);
		}
		g.setStroke(new BasicStroke(6));
		g.setColor(Color.RED);
		
		if(piece.getTop() == '|'){
			g.drawLine(j*d+d/2, i*d+d/2, j*d+d/2, i*d+5);
		}
		else if(piece.getTop() == '#'){
			g.drawLine(j*d+3, i*d+3, j*d+d-3, i*d+3);
		}
		if(piece.getBot() == '|'){
			g.drawLine(j*d+d/2, i*d+d/2, j*d+d/2, i*d+d-3);
		}
		else if(piece.getBot() == '#'){
			g.drawLine(j*d+3, i*d+d-3, j*d+d-2, i*d+d-3);
		}
		if(piece.getRight() == '-'){
			g.drawLine(j*d+d/2, i*d+d/2, j*d+d-5, i*d+d/2);
		}
		else if(piece.getRight() == '#'){
			g.drawLine(j*d+d-3, i*d+3, j*d+d-3, i*d+d-3);
		}
		if(piece.getLeft() == '-'){
			g.drawLine(j*d+d/2, i*d+d/2, j*d+3, i*d+d/2);
		}
		else if(piece.getLeft() == '#'){
			g.drawLine(j*d+3, i*d+3, j*d+3, i*d+d-3);
		}
		
		
		
	}

	@Override
	public void update(Observable o, Object arg) {
	repaint();
	
		
	}
	
	/**
	 * Method to return the face images
	 * 
	 * @param name
	 * @return
	 */
	private Image getImg(String name){
		try{
			img = ImageIO.read(this.getClass().getResource(name));
			}catch(IOException e){throw new Error(e);}
		
		return img;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		selected = false;
		//checks for the clicks on board and selects the piece selected
		for(int i = 0; i<10;i++){
			for(int j=0; j<10 ; j++){
				if((e.getX() > i*d && e.getX() < i*d+d) && 
						(e.getY() > j*d && e.getY() < j*d+d) ){
							if(myModel.board.board[i][j]!=null && myModel.board.isValid(i, j)){
								//moving piece doesnt work :( controller for this not set.
								movePiece = myModel.board.board[i][j];
								selected = true;
								controller.selectPiece(movePiece);								
						}				
					}	
				}
			}
		
		repaint();
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}


