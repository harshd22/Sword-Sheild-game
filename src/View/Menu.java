package View;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;


/**
 * Class for the starting point of game
 * @author harsh
 *
 */
public class Menu  {
	
	JFrame menu;
	JButton exit;
	JButton start;
	JButton info;
	
	/**
	 * Setting the JFrame for menu.
	 */
	Menu(){
		menu = new JFrame("Sword & Sheild");
		start = new JButton("Start Game");
		info = new JButton("INFO");
		exit = new JButton("Exit");
		menu.setLocation(500, 500);
		
		menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		FlowLayout layout = new FlowLayout();
		menu.setSize(350, 300);
		menu.setLayout(layout);
		SetActions();
		layout.setHgap(1000);
		layout.setVgap(50);
		
		menu.add(start);
		menu.add(info);
		menu.add(exit);	
	
		menu.setResizable(false);
		menu.setVisible(true);
		
	}
	
	/**
	 * This method sets the actions for buttons
	 */
	private void SetActions(){
		
		start.addActionListener((e) -> StartGame());
		exit.addActionListener(e -> System.exit(0));
		info.addActionListener(e -> 
								JOptionPane.showMessageDialog(menu, "Sword & Sheild Game \n @Author - Harsh"));	
	}
	
	
	/**
	 * For the button to start game
	 */
	void StartGame(){
		menu.dispose();
		new gameView();
		
	}

	


	

}
