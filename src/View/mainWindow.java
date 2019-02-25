package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Image;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;
import javax.swing.JToolBar;

import Game.RunGame;

public class mainWindow extends JComponent implements Observer{
	
	JFrame frame;
	JButton undo ;
	JButton surrender;
	JButton pass;
	JSplitPane mainPane;
	JSplitPane greenAndBoard;
	JSplitPane yellowPieces;
	JSplitPane greenPieces;
	RunGame mymodel ;


	public mainWindow(RunGame mymodel) {
		//Setting Buttons
		undo = new JButton("Undo");
		surrender = new JButton("Surrender");
		pass = new JButton("Pass");
		//Setting Model
		this.mymodel = mymodel;
		mymodel.addObserver(this);
		//Setting Frame
		frame = new JFrame("Sword & Sheild");
		frame.setFocusable(true);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1525, 800);
		frame.setLayout(new BorderLayout() );
		//Setting Toolbar
		JToolBar toolbar = new JToolBar();
		toolbar.setLayout(new FlowLayout());
		toolbar.add(undo);
		toolbar.add(surrender);
		toolbar.add(pass);
		frame.add(toolbar, BorderLayout.NORTH);
		SetActions();
		
		//Setting Panes
		 mainPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
	     greenAndBoard = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
	     yellowPieces = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
	     greenPieces = new JSplitPane(JSplitPane.VERTICAL_SPLIT);     
	     frame.add(mainPane, BorderLayout.CENTER);
	     mainPane.setTopComponent(greenAndBoard);
	     mainPane.setBottomComponent(yellowPieces);     
	     greenAndBoard.setTopComponent(greenPieces);
	     
	     greenAndBoard.setBottomComponent(new drawBoard(mymodel));
	     greenPieces.setTopComponent(new drawPieces( mymodel,mymodel.green));
	     yellowPieces.setTopComponent(new drawPieces( mymodel,mymodel.yellow));
	     greenPieces.setBottomComponent(new drawCemetry( mymodel.green));
	     yellowPieces.setBottomComponent(new drawCemetry( mymodel.yellow));
	     
	     greenAndBoard.setSize(800,800);
	     greenPieces.setSize(150,150);
	     yellowPieces.setSize(150,150); 
	     mainPane.setDividerLocation(1100);
         greenAndBoard.setDividerLocation(400);
         greenPieces.setDividerLocation(400);
         yellowPieces.setDividerLocation(400);
	     
		
	}
	
/**
 * Setting the actions for buttons
 */
private void SetActions(){
		
		undo.addActionListener((e) -> mymodel.Undo(1));
		pass.addActionListener(e -> mymodel.Pass(mymodel.Current));
		surrender.addActionListener(e -> {JOptionPane.showMessageDialog(frame, mymodel.Current.getColor() + " Surrendered the game");
		int i = JOptionPane.showConfirmDialog(null, "Do you wan to play again?");
		
	if(i == JOptionPane.YES_OPTION) new Menu();
	frame.dispose();
	
		});	
	}

	@Override
	public void update(Observable o, Object arg) {
		super.repaint();
		greenAndBoard.repaint();
		mainPane.repaint();
		greenPieces.repaint();
		yellowPieces.repaint();
		
	}
	
	
	
	@Override
    public Dimension getPreferredSize() {
        return new Dimension(1600, 800);
    }

}
