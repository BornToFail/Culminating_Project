package muzeyen.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

//calls class whenever user presses a key
public class KeyInput extends KeyAdapter {
	
	Game game;
	
	//placed hear instead of player class so key strokes can be used even if the player isn't available (e.g menu)
	public KeyInput(Game game){
		this.game = game;
			
	}
	public void keyPressed(KeyEvent e){
		game.keyPressed(e); //goes to keyPressed method in game class
	}
	
	public void keyReleased(KeyEvent e){
		game.keyReleased(e); //goes to keyReleased method in game class
	}
	
	

}
