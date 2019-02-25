package View;


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Composite;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.Image;
import java.awt.Paint;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.RenderingHints.Key;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ImageObserver;
import java.awt.image.RenderedImage;
import java.awt.image.renderable.RenderableImage;
import java.text.AttributedCharacterIterator;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Game.Piece;
import Game.Player;
import Game.RunGame;



/**
 * This class helps in drawing the Pieces that can be made.
 * @author Harsh
 *
 */
public class drawPieces extends JComponent implements Observer , MouseListener{
	RunGame myModel;
	Player player;
	int c = 0;
	int d;
	int selection;
	Graphics2D g;
 	drawPieces(RunGame myModel, Player player){
		this.myModel = myModel;
		this.player = player;
		addMouseListener(this);
	}
 	
 	@Override
	protected void paintComponent(Graphics gg) {
 		c=0;
 		g = (Graphics2D)gg;
 		g.setStroke(new BasicStroke(5));
 		
 		d = Math.min(getWidth()/5, getHeight()/5);
 		//draws the Squares
 		drawGrid(5,5);
 		
 		for (int i=0 ; i < 5 ; i++){//draws the Pieces
			for (int j=0 ; j<5 ; j++){
				Piece piece;
				  if(c < player.getPiece().size()){  
                      piece = player.getPiece().get(c);
                      ++c;
                  }else{
                	  piece = null;
                  }
				
				if(piece != null){
					drawPiece(g,piece,j , i);
			}
			
		}
	}
 		
 }	
 	/**
 	 * Draws the square grid
 	 * @param x
 	 * @param y
 	 */
 	void drawGrid(int x , int y){
 		for (int i=0 ; i < x; i++){
			for (int j=0 ; j<y ; j++){
				
				if((i+j)%2==0)
					g.setColor(Color.DARK_GRAY);
				else
					g.setColor(Color.WHITE);
				
				g.fillRect(i*d, j*d, d, d);
				g.setColor(Color.black);
				g.drawRect(i*d, j*d, d, d);
				
			}
 		}
 	}
 	
 	/**
 	 * helper for drawing pieces
 	 * @param g
 	 * @param piece
 	 * @param i
 	 * @param j
 	 */
 	void drawPiece(Graphics2D g ,Piece piece , int i , int j){
 		
		
 		g.setStroke(new BasicStroke(5));
		
		if (player.getColor().equalsIgnoreCase("green")){
			g.setColor(Color.GREEN);
		}
		else if(player.getColor().equalsIgnoreCase("yellow")){
			g.setColor(Color.YELLOW);
		}
		g.fillOval(j*d+5, i*d+5, d-10, d-10);
		
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
			g.drawLine(j*d+d-3, i*d-3, j*d+d-3, i*d+d-3);
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

	@Override
	public void mouseClicked(MouseEvent e) {
		c=0;
		Piece piece;
	if(myModel.Current.equals(player)){
		for(int i=0; i < 5 ;i++){
			for(int j =0; j<5 ;j++ ,c++){
				if(c < player.getPiece().size()){
					if((e.getX() > i*d && e.getX() < i*d+d) && 
						(e.getY() > j*d && e.getY() < j*d+d) ){
						if(myModel.board.board[player.createX][player.createY] == null){
						piece = player.getPiece().get(c);					
						panel panel = new panel(piece);
						myModel.AddPieceOnBoard(myModel.Current, myModel.board, piece);	
						super.repaint();
							}
						else 
							JOptionPane.showMessageDialog(null, "Creation spot is not empty");
						}
					}
				}
			}
		}
	
		else
			JOptionPane.showMessageDialog(null, "Its the turn of " + myModel.Current.getColor() + " player");
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
	
	/**
	 * This is a Panel for the Orientations
	 * @author harsh
	 *
	 */
	class panel extends JPanel implements MouseListener{
		Piece p;
		JFrame o;
		panel(Piece p){
			o = new JFrame("Orientations");
			o.setLocation(600, 500);
			o.setSize(d*4+d/3, (d+d/2+10));
			o.setVisible(true);
			o.add(this);
			this.setLayout(new FlowLayout());
			this.p = p;
			this.setVisible(true);
			addMouseListener(this);
		}
		@Override
		protected void paintComponent(Graphics gg) {
			Graphics2D g = (Graphics2D)gg;
			for (int i=0 ; i<4 ; i++){
			g.setColor(Color.WHITE);
				//draws in all possible orientations
				g.fillRect(i*d, 0, d, d);
				g.setColor(Color.black);
				g.drawRect(i*d, 0, d, d);
				if(i>0)
					p.rotate(90);
				drawPiece(g, p, 0, i);
				
			}
			p.rotate(90);
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			int select;
			//takes the input and adds piece on board
			for(int i=0 ; i<4 ; i++){
			if(e.getX() > i*d && e.getX()<i*d+d){
				//rotates the piece in selected orientation
				select = i*90;
				p.rotate(select);
				select = 0;
				o.dispose();
				break;
				}
			}
		}
		
		public void selection(int select){
			
			selection = select;
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
	
	
	

}
