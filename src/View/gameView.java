package View;

import Game.*;

public class gameView {
	
	Game.RunGame mymodel ;
	
	gameView(){
		
		mymodel = new RunGame();
		mainWindow mw = new mainWindow(mymodel);
		 
	}

}
