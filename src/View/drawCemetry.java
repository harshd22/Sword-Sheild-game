package View;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JComponent;

import Game.*;

/**
 * Draws the Cemetery
 * @author harsh
 *
 */
public class drawCemetry extends JComponent implements Observer{
	
	Player player;
	drawPieces draw;
	int d;
	int c=0;
	drawCemetry( Player player){	
		this.player = player;
		draw = new drawPieces(new RunGame() , player);
	}
	
	
	@Override
	protected void paintComponent(Graphics gg) {
 		
 		Graphics2D g = (Graphics2D)gg;
 		g.setStroke(new BasicStroke(5));
 		
 		d = Math.min(getWidth(), getHeight())/5;
 		//draws the squares
 		for (int i=0 ; i < 5; i++){
			for (int j=0 ; j<5 ; j++){
				
				if((i+j)%2==0)
					g.setColor(Color.DARK_GRAY);
				else
					g.setColor(Color.WHITE);
				
				g.fillRect(i*d, j*d, d, d);
				g.setColor(Color.black);
				g.drawRect(i*d, j*d, d, d);
				
			}
 		}
 		//check for pieces and draw them
 		for (int i=0 ; i < 5 ; i++){
			for (int j=0 ; j<5 ; j++){
				Piece piece = null;
				try{
				  if(c < player.getCemetery().size()){
                      piece = player.getCemetery().get(c++);
                      
                  }else{
                	  piece = null;
                  }
				  }catch(NullPointerException e){}
				
				if(piece != null){
					draw.drawPiece(g,piece,i,j);
			}
			
		}
	}
 		//creates the cross
 		int max = Math.max(getHeight(),getWidth());
 		g.setColor(Color.RED);
 		g.fillRect(5*d, 0, max, 5*d);
 		g.setStroke(new BasicStroke(20));
 		g.setColor(Color.black);
 		g.drawLine(5*d+d-10, 0, 5*d+d-10, 5*d);
 		g.drawLine(5*d+10, 2*d, 7*d, 2*d);
 		
 }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
