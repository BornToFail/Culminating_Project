package muzeyen.main;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.LinkedList;

public class Controller {
	
	//private LinkedList<Bullet> b = new LinkedList<Bullet>();
	static ArrayList<Bullet> projectiles = new ArrayList<Bullet>();

	Bullet TempBullet;
	
	Game game;
	
	public Controller(Game game){
		this.game = game;
		
		
	}
	
	public void tick(){
		for (int i = 0; i<projectiles.size(); i++){
			TempBullet = projectiles.get(i);

			//destroys bullet once its off the screen
			if(TempBullet.getY() <0){
				removeBullet(TempBullet);
			}

			TempBullet.tick();
		}
	}

	public void render (Graphics g){
		for (int i = 0; i<projectiles.size(); i++){
			TempBullet = projectiles.get(i);
			
			TempBullet.render(g);
		}
	}
	
	public void addBullet (Bullet block){
		projectiles.add(block);
	}
	public void removeBullet(Bullet block){
		projectiles.remove(block);
	}
	
	
	
}
